import java.sql.*;

public class BankOps {
    public static User login(int acc_no, int pin) {
        try (Connection con = DB.getCon()) {
            String sql = "SELECT * FROM users WHERE acc_no = ? AND pin = ?";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, acc_no);
            ps.setInt(2, pin);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                double balance = rs.getDouble("balance");
                return new User(acc_no, pin, balance);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public static void deposit(int acc_no, double amount) {
        try (Connection con = DB.getCon()) {
            String sql = "UPDATE users SET balance = balance + ? WHERE acc_no = ?";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setDouble(1, amount);
            ps.setInt(2, acc_no);
            ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void withdraw(int accno, double amount) {
        try (Connection con = DB.getCon()) {
            String sql = "UPDATE users SET balance = balance - ? WHERE accno = ?";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setDouble(1, amount);
            ps.setInt(2, accno);
            ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
