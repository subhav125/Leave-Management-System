import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class Login {
	String dbUrl="jdbc:mysql://localhost:3306/ngpdb";
    String dbUname="root";
    String dbPassword="";
    String dbDriver="com.mysql.cj.jdbc.Driver";
    String name,pass;
    Login(String name,String pass){
    	this.name=name;
    	this.pass=pass;
    }
    boolean store() {
    	Connection con = null;
   		try {
			Class.forName(dbDriver);  //class not found exception
			con = DriverManager.getConnection(dbUrl,dbUname,dbPassword);   //sql Exception
			String sql = "select * from student_table where name='"+name+"' and password='"+pass+"'";	
			Statement s = con.createStatement();
			ResultSet rs=s.executeQuery(sql);
			if(rs.next()) {
				con.close();
				return true;
			}
			else {
				con.close();
				return false;
			}
			
		} catch (Exception e){
			e.printStackTrace();
		}
   		return false;
    }
    

}