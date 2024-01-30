import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/LeaveServlet")
public class LeaveServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    public LeaveServlet() {
        super();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.getWriter().append("").append(request.getContextPath());
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String name = request.getParameter("name");
        String phone = request.getParameter("phone");

        // Retrieve leave-related information
        String leaveType = request.getParameter("leaveType");
        String startDate = request.getParameter("startDate");
        String endDate = request.getParameter("endDate");
        String numberOfDays = request.getParameter("numberOfDays");
        String reason = request.getParameter("reason");

        // Store leave details in the database
        Database obj = new Database(name, phone, leaveType, startDate, endDate, numberOfDays, reason);
        obj.storeLeaveDetails();

        // Redirect to a success page or another appropriate page
        response.sendRedirect("success.jsp?name="+name); // Change this to the appropriate success page
    }
}