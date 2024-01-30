import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Database {
    private static final String DB_URL = "jdbc:mysql://localhost:3306/ngpdb";
    private static final String DB_USERNAME = "root";
    private static final String DB_PASSWORD = "";
    private static final String DB_DRIVER = "com.mysql.cj.jdbc.Driver";

    private String name, number, leaveType, startDate, endDate, numberOfDays, reason;

    public Database(String name, String number, String leaveType, String startDate,
                    String endDate, String numberOfDays, String reason) {
        this.name = name;
        this.number = number;
        this.leaveType = leaveType;
        this.startDate = startDate;
        this.endDate = endDate;
        this.numberOfDays = numberOfDays;
        this.reason = reason;
    }

    private boolean isLeaveAvailable(Connection con) throws SQLException {
        String availabilityQuery = "SELECT remaining_leave_days FROM employee_leave WHERE name = ?";
        try (PreparedStatement availabilityStmt = con.prepareStatement(availabilityQuery)) {
            availabilityStmt.setString(1, name);

            try (ResultSet resultSet = availabilityStmt.executeQuery()) {
                if (resultSet.next()) {
                    int remainingLeaveDays = resultSet.getInt("remaining_leave_days");
                    int requestedDays = Integer.parseInt(numberOfDays);

                    return remainingLeaveDays >= requestedDays;
                }
            }
        }
        return false; // Return false in case of an error
    }

    private void updateRemainingLeaveDays(Connection con, int remainingLeaveDays) throws SQLException {
        String updateLeaveDaysSql = "UPDATE employee_leave SET remaining_leave_days = ? WHERE name = ?";
        try (PreparedStatement updateLeaveDaysStmt = con.prepareStatement(updateLeaveDaysSql)) {
            updateLeaveDaysStmt.setInt(1, remainingLeaveDays);
            updateLeaveDaysStmt.setString(2, name);

            updateLeaveDaysStmt.executeUpdate();
        }
    }

    public void storeLeaveDetails() {
        try (Connection con = DriverManager.getConnection(DB_URL, DB_USERNAME, DB_PASSWORD)) {
            Class.forName(DB_DRIVER);

            // Check leave availability in the database
            if (isLeaveAvailable(con)) {
                // Update the remaining leave days
                int remainingLeaveDays = getRemainingLeaveDays(con);
                remainingLeaveDays -= Integer.parseInt(numberOfDays);
                updateRemainingLeaveDays(con, remainingLeaveDays);

                // Insert leave details into the leave_details table
                String sql = "INSERT INTO leave_details (name, phone, leave_type, start_date, end_date, number_of_days, reason) VALUES (?, ?, ?, ?, ?, ?, ?)";
                try (PreparedStatement pstmt = con.prepareStatement(sql)) {
                    pstmt.setString(1, name);
                    pstmt.setString(2, number);
                    pstmt.setString(3, leaveType);
                    pstmt.setString(4, startDate);
                    pstmt.setString(5, endDate);
                    pstmt.setString(6, numberOfDays);
                    pstmt.setString(7, reason);

                    pstmt.executeUpdate();
                }
            }
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }

    private int getRemainingLeaveDays(Connection con) throws SQLException {
        String remainingLeaveQuery = "SELECT remaining_leave_days FROM employee_leave WHERE name = ?";
        try (PreparedStatement remainingLeaveStmt = con.prepareStatement(remainingLeaveQuery)) {
            remainingLeaveStmt.setString(1, name);

            try (ResultSet resultSet = remainingLeaveStmt.executeQuery()) {
                if (resultSet.next()) {
                    return resultSet.getInt("remaining_leave_days");
                }
            }
        }
        return -1; // Return -1 in case of an error
    }
}