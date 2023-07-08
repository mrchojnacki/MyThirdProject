package pl.coderslab.DAO;

import org.mindrot.jbcrypt.BCrypt;
import pl.coderslab.DbUtil;
import pl.coderslab.entity.User;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class UserDao {
    public static void addUserToDatabase(User user) {
        try (Connection conn = DbUtil.connection2()) {
            PreparedStatement preStmt = conn.prepareStatement(ADD_QUERY);
            preStmt.setString(1, user.getEmail());
            preStmt.setString(2, user.getUsername());
            preStmt.setString(3, hashPassword(user.getPassword()));
            preStmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public static String hashPassword(String password) {
        return BCrypt.hashpw(password, BCrypt.gensalt());
    }
    public static ResultSet resultFindAllUsers() {
        ResultSet rs = null;
        try (Connection conn = DbUtil.connection()) {
            Statement stmt = conn.createStatement();
            rs = stmt.executeQuery(FIND_ALL_QUERY);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return rs;
    }

    public static List<User> createListOfUsers() throws SQLException {
        List<User> userList = new ArrayList<User>();
        try (Connection conn = DbUtil.connection2()) {
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(FIND_ALL_QUERY);
            while (rs.next()) {
                User user = new User();
                user.setId(rs.getInt("id"));
                user.setEmail(rs.getString("email"));
                user.setUsername(rs.getString("username"));
                user.setPassword(rs.getString("password"));
                userList.add(user);
            }
            return userList;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static void updateUserInDatabase(User user) {
        try (Connection conn = DbUtil.connection()) {
            PreparedStatement preStmtName = conn.prepareStatement(UPDATE_QUERY_SET +
                     "username" + UPDATE_QUERY_WHERE + "id" + END_QUERY);
            PreparedStatement preStmtEmail = conn.prepareStatement(UPDATE_QUERY_SET +
                    "email" + UPDATE_QUERY_WHERE + "id" + END_QUERY);
            preStmtName.setString(1, user.getUsername());
            preStmtName.setInt(2, user.getId());
            preStmtName.executeUpdate();
            preStmtEmail.setString(1, user.getEmail());
            preStmtEmail.setInt(2, user.getId());
            preStmtEmail.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public static void deleteUserFromDatabase(User user) {
        try (Connection conn = DbUtil.connection2()) {
            Statement stat = conn.createStatement();
            stat.executeUpdate(DELETE_QUERY + "id = " + String.valueOf(user.getId()));
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


/*    public static void deleteUserFromDatabase(Scanner scanner) {
        System.out.println("You will remove a User from database");
        String searchedColumn = DbUtil.chooseColumnToSearchUser(scanner);
        String searchedValueString = DbUtil.chooseValueUser(searchedColumn, scanner);
        int searchedValueInt = 0;

        try (Connection conn = DbUtil.connection()) {
            PreparedStatement preStmt = conn.prepareStatement(DELETE_QUERY + searchedColumn + END_QUERY);
            if (searchedColumn.equals("id")) {
                searchedValueInt = Integer.parseInt(searchedValueString);
                preStmt.setInt(1, searchedValueInt);
            } else {
                preStmt.setString(1, searchedValueString);
            }
            preStmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }*/


    public static final String ADD_QUERY = "INSERT INTO users (email, username, password) " +
            "                               VALUES (?, ?, ?);";
    public static final String READ_QUERY_ID = "SELECT * FROM users WHERE id = ?;";
    public static final String READ_QUERY_EMAIL = "SELECT * FROM users WHERE email = ?;";
    public static final String READ_QUERY_USERNAME = "SELECT * FROM users WHERE username = ?;";
    public static final String READ_QUERY = "SELECT * FROM users WHERE ";
    public static final String UPDATE_QUERY_SET = "UPDATE users SET ";
    public static final String UPDATE_QUERY_WHERE = " = ? WHERE ";

    public static final String DELETE_QUERY = "DELETE FROM users WHERE ";
    public static final String END_QUERY = " = ?;";
    public static final String FIND_ALL_QUERY = "SELECT * FROM users;";
    public static final String DELETE_ALL_QUERY = "DELETE FROM users;";
}