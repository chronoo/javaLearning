package basic;

import java.sql.*;
import java.util.*;

/**
 * DBClient - Выполняет простейший заброс к базе данных на MySQL
 */
public class DBClient {

    public static void main(String[] args) {
        try {
            printRawDataFromMySQLAdvanced();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void printRawDataFromMySQLAdvanced() throws SQLException {
        Connection connection = null;
        try {
            connection = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/world?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC",
                    "root", "root");
            Statement stmt = connection.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM country ORDER BY Population DESC LIMIT 10");
            List<Map<String, Object>> result = resultSetToList(rs);
            stmt.close();

            for (Map<String, Object> item : result) {
                System.out.println(String.format("%-20s%20d", item.get("Name"), item.get("Population")));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (connection != null) {
                connection.close();
            }
        }
    }

    /**
     * Convert the ResultSet to a List of Maps, where each Map represents a row with
     * columnNames and columValues
     * 
     * @param rs
     * @return
     * @throws SQLException
     */
    private static List<Map<String, Object>> resultSetToList(ResultSet rs) throws SQLException {
        ResultSetMetaData md = rs.getMetaData();
        int columns = md.getColumnCount();
        List<Map<String, Object>> rows = new ArrayList<Map<String, Object>>();
        while (rs.next()){
            Map<String, Object> row = new HashMap<String, Object>(columns);
            for(int i = 1; i <= columns; ++i){
                row.put(md.getColumnName(i), rs.getObject(i));
            }
            rows.add(row);
        }
        return rows;
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