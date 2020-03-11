import java.sql.*;

public class DbOperations {
    public void select()
    {

        String sql = "select * from student";

        try (Connection conn = MySQLJDBCUtil.getConnection();
             Statement stmt  = conn.createStatement();
             ResultSet rs    = stmt.executeQuery(sql)) {

            // loop through the result set
            while (rs.next()) {
                System.out.println(rs.getInt("roll_no") + "\t" +
                        rs.getString("name")  + "\t" +
                        rs.getString("address"));

            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }
    public void update()
    {
        String sqlUpdate = "UPDATE candidates "
                + "SET last_name = ? "
                + "WHERE id = ?";

        try (Connection conn = MySQLJDBCUtil.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sqlUpdate)) {

            // prepare data for update
            String lastName = "William";
            int id = 100;
            pstmt.setString(1, lastName);
            pstmt.setInt(2, id);

            int rowAffected = pstmt.executeUpdate();
            System.out.println(String.format("Row affected %d", rowAffected));

            // reuse the prepared statement
            lastName = "Grohe";
            id = 101;
            pstmt.setString(1, lastName);
            pstmt.setInt(2, id);

            rowAffected = pstmt.executeUpdate();
            System.out.println(String.format("Row affected %d", rowAffected));

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }

}
