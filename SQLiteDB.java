package lesson2;

import java.sql.*;

public class SQLiteDB {
    static Connection connection = null;
    final String JDBC_NAME = "org.sqlite.JDBC";
    final String DB_NAME = "jdbc:sqlite:sqlite.db";
    final String TABLE_NAME = "users";

    public static void main(String[] args) {

        new SQLiteDB();
    }

    SQLiteDB() {
        getConnection();
        createTable();
        add("Vasya", "qwe");
        add("Ivan", "rty");
        list();
        add("Petya", "asd");
        update("Ivan", "zxc");
        list();
        delete("Vasya");
        list();
        closeConnection();
    }

    void createTable() {
        try (Statement stmt = connection.createStatement()) {
            stmt.executeUpdate(
                    "DROP TABLE IF EXISTS " + TABLE_NAME + ";" +
                            "CREATE TABLE " + TABLE_NAME +
                            "(login  CHAR(6) PRIMARY KEY NOT NULL," +
                            " passwd CHAR(6) NOT NULL);"
            );
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    void add(String login, String passwd) {
        try (Statement stmt = connection.createStatement()) {
            stmt.executeUpdate("INSERT INTO " + TABLE_NAME +
                    " (login, passwd) " +
                    " VALUES ('" + login + "', '" + passwd + "');"
            );
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    void delete(String login) {
        try (Statement stmt = connection.createStatement()) {
            stmt.executeUpdate("DELETE FROM " + TABLE_NAME +
                    " where LOGIN='" + login + "';"
            );
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    void update(String login, String passwd) {
        try (PreparedStatement ps = connection.prepareStatement(
                "UPDATE " + TABLE_NAME + " set PASSWD=? where LOGIN=?;")) {
            ps.setString(1, passwd);
            ps.setString(2, login);
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    void list() {
        try (Statement stmt = connection.createStatement();
             ResultSet rs = stmt.executeQuery("SELECT * FROM " + TABLE_NAME + ";")) {
            while (rs.next())
                System.out.println(rs.getString("login") + "\t" +
                        rs.getString("passwd"));
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    Connection getConnection() {
        if (connection == null)
            try {
                Class.forName(JDBC_NAME);
                connection = DriverManager.getConnection(DB_NAME);
            } catch (Exception e) {
                e.printStackTrace();
            }
        return connection;
    }

    void closeConnection() {
        if (connection != null)
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
    }
}