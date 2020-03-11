import java.sql.*;

public class Main {
    private static DbOperations dbOperations;
    public static void main(String args[])
    {
        // create a new connection from MySQLJDBCUtil
        try (Connection conn = MySQLJDBCUtil.getConnection()) {

            // print out a message
            System.out.println(String.format("Connected to database %s "
                    + "successfully.", conn.getCatalog()));
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        dbOperations = new DbOperations();
        dbOperations.select();

    }

}
