package basic;

import java.sql.*;

/**
 * DBClient
 */
public class DBClient {

    public static void main(String[] args) throws SQLException {
        printRawDataFromMySQL();
    }

    /**
     * Печать результата прямого запроса к БД (на основе соответсвующей статьи Вики)
     * @throws SQLException
     */
    public static void printRawDataFromMySQL() throws SQLException {
        Connection connection = null;
        try {
            connection = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/world?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC",
                    "root", "root");
            Statement stmt = connection.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM country ORDER BY Population DESC LIMIT 100");

            while (rs.next()) {
                System.out.println(rs.getRow() + ". " + rs.getString("Name") + "\t" + rs.getInt("Population"));
            }
            
            stmt.close();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (connection != null) {
                connection.close();
            }
        }
    }
}