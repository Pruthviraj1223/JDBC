import java.sql.*;
import java.util.Arrays;

public class jdbcConn {
    public static void main(String[] args)  {

        try {

            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/Employee", "root", "password");


            Statement stmt = con.createStatement();
            ResultSet result = stmt.executeQuery("select * from emp1");
            while(result.next()){
                System.out.println("id = " + result.getInt(2) + "  name = " + result.getString(2) + "  age = " + result.getInt(4));
            }
            System.out.println("================");
            ResultSet result2 = stmt.executeQuery("select * from emp2");

            while(result2.next()){
                System.out.println("dept_id = " + result2.getInt(1) + "  dept_name = " + result2.getString(2) + "  salary = " + result2.getInt(3));
            }
            System.out.println("===================== INNER JOIN");

            ResultSet result3 = stmt.executeQuery("select emp1.id,emp1.name,emp2.dept_id,emp2.dept_name from emp1 JOIN emp2 ON emp1.id=emp2.dept_id");
            while(result3.next()){
                System.out.println("dept_id = " + result3.getInt(1) + "  name = " + result3.getString(2));
            }
            System.out.println("===================== RIGHT JOIN");

            ResultSet result4 = stmt.executeQuery("select emp1.id,emp1.name,emp2.dept_id,emp2.dept_name from emp1 RIGHT JOIN emp2 ON emp1.id=emp2.dept_id");
            while(result4.next()){
                System.out.println("id = " + result4.getInt(1) + "  name = " + result4.getString(2) + "  dept_id = " +result4.getInt(3) + "  dept_name = " + result4.getString(4));
            }
//
            System.out.println("===================== LEFT JOIN");

            ResultSet result5 = stmt.executeQuery("select emp1.id,emp1.name,emp2.dept_id,emp2.dept_name from emp1 LEFT JOIN emp2 ON emp1.id=emp2.dept_id");
            while(result5.next()){
                System.out.println("id = " + result5.getInt(1) + "  name = " + result5.getString(2) + "  dept_id = " +result5.getInt(3) + "  dept_name = " + result5.getString(4));
            }


            con.close();
        }catch(Exception e){ System.out.println(e);}

    }

}
