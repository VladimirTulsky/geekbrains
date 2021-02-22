package lesson2;

import java.sql.*;

public class DBServices {
    static String getNickNameQuery = "select nickname from users where login = LOGIN and password = PASS";
    final static String TABLE_NAME = "users";

    private static Connection connection;
    private static Statement statement;

    static void getNickName(String login, String password) throws Exception {
        try{
            ResultSet resultSet = statement.executeQuery(getNickNameQuery.replace("LOGIN", login).replace("PASS", password));
            String nickname = resultSet.getString("nickname");
            System.out.println(nickname);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    static void changeNickName(String nickname, String login) throws Exception {
        String curNickName = trimNullCheck(nickname);
        String curlogin = trimNullCheck(login);
        try (PreparedStatement ps = connection.prepareStatement(
                "UPDATE " + TABLE_NAME + " set NICKNAME=? where LOGIN=?;")) {
            ps.setString(1, curNickName);
            ps.setString(2, curlogin);
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static String trimNullCheck(String parameter) throws Exception {
        if(parameter.trim() == null) {
            throw new Exception("Некорректное имя");
        }
        return parameter.trim();
    }

    public static void setConnection() throws ClassNotFoundException, SQLException {
        Class.forName("org.sqlite.JDBC");
        connection = DriverManager.getConnection("jdbc:sqlite:TEST1.s2db");
    }

    public static void createDb() throws SQLException {
            try (Statement stmt = connection.createStatement()) {
                stmt.executeUpdate(
                        "DROP TABLE IF EXISTS " + TABLE_NAME + ";" +
                                "CREATE TABLE " + TABLE_NAME +
                                "(login  CHAR(6) PRIMARY KEY NOT NULL," +
                                " password CHAR(6) NOT NULL," +
                                " nickname CHAR(6) NOT NULL);"
                );
            } catch (SQLException e) {
                e.printStackTrace();
            }
    }

    static void add(String login, String password, String nickname) {
        try (Statement stmt = connection.createStatement()) {
            stmt.executeUpdate("INSERT INTO " + TABLE_NAME +
                    " (login, password, nickname) " +
                    " VALUES ('" + login + "', '" + password + "', '" + nickname + "');"
            );
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


    static void list() {
        try (Statement stmt = connection.createStatement();
             ResultSet rs = stmt.executeQuery("SELECT * FROM " + TABLE_NAME + ";")) {
            while (rs.next())
                System.out.println(rs.getString("login") + "\t" +
                        rs.getString("password") + "\t" +
                        rs.getString("nickname"));
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    static void closeConnection() {
        if (connection != null)
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
    }

    public static void main(String[] args) throws Exception {
        setConnection();
        createDb();
        add("qwe", "qwe", "qwe");
        add("asd", "asd", "asd");
        changeNickName("zxc", "asd");
        list();
        closeConnection();
    }
}
