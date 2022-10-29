package services;

import dataaccess.UserDB;
import java.util.List;
import models.Role;
import models.User;

/**
 *
 * @author Jireh
 */
public class UserService {

    public List<User> getAllUsers() throws Exception {
        UserDB userDB = new UserDB();
        List<User> users = userDB.getAllUsers();
        return users;
    }

    public User getUser(String email) throws Exception {
        UserDB userDB = new UserDB();
        User user = userDB.getUser(email);
        return user;
    }

    public void insertUser(String email, String fname, String lname, String pass,
            Role role) throws Exception {
        UserDB userDB = new UserDB();
        User user = new User(email, fname, lname, pass, role);
        userDB.insertUser(user);
    }
    
    public void updateUser(String email, String fname, String lname, String pass,
            Role role) throws Exception {
        UserDB userDB = new UserDB();
        User user = new User(email, fname, lname, pass, role);
        userDB.updateUser(user);
    }
    
    public void deleteNote(String email) throws Exception {
        UserDB userDB = new UserDB();
        User user = new User();
        user.setEmail(email);
        userDB.deleteUser(user);
    }
}
