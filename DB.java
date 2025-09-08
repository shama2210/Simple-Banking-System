import java.sql.*;

public class DB {
    public static Connection getCon() throws Exception {
        Class.forName("com.mysql.cj.jdbc.Driver");
        return DriverManager.getConnection("jdbc:mysql://localhost:3306/bank", "root", "your_db_password");
    }
}
