package pl.coderslab;

import pl.coderslab.DAO.UserDao;
import pl.coderslab.entity.User;

import java.sql.SQLException;
import java.util.Iterator;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<User> userList = null;
        try {
            userList = UserDao.createListOfUsers();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        Iterator<User> itr = userList.listIterator();
        while (itr.hasNext()) {
            User user = itr.next();
            System.out.println(user.getUsername() + " ");
        }
    }
}
