import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class Register { 
		String dbUrl="jdbc:mysql://localhost:3306/ngpdb";
	    String dbUname="root";
	    String dbPassword="";
	    String dbDriver="com.mysql.cj.jdbc.Driver";
	    String name,pass,email,phone;
	  Register(String name,String pass,String email,String phone){
		  this.name=name;    
		  this.pass=pass;
		  this.email=email;
		  this.phone=phone;
	  }
      void store(){
    	  Connection con = null;
	   		try {
				Class.forName(dbDriver);  //class not found exception
				con = DriverManager.getConnection(dbUrl,dbUname,dbPassword);   //sql Exception
				String sql = "insert into student_table(name,password,email,phone_no)"
						+ "values('"+name+"','"+pass+"','"+email+"','"+phone+"')";
				Statement s = con.createStatement();
				s.execute(sql);
			   	con.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
      }
}
