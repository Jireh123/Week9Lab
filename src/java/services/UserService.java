package services;

import dataaccess.RoleDB;
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
            int roleID) throws Exception {
        User user = new User(email, fname, lname, pass);
        RoleDB roleDB = new RoleDB();
        Role role = roleDB.getRole(roleID);
        user.setRole(role);

        UserDB userDB = new UserDB();
        userDB.insertUser(user);
    }

    public void updateUser(String email, String fname, String lname, String pass,
            int roleID) throws Exception {
        UserDB userDB = new UserDB();
        User user = userDB.getUser(email);
        user.setFirstName(fname);
        user.setLastName(lname);
        user.setPassword(pass);
        
        RoleDB roleDB = new RoleDB();
        Role role = roleDB.getRole(roleID);
        user.setRole(role);
        
        userDB.updateUser(user);
    }

    public void deleteUser(String email) throws Exception {
        UserDB userDB = new UserDB();
        User user = userDB.getUser(email);
        userDB.deleteUser(user);
    }

    public boolean isNotEmpty(String email, String firstname, String lastname, String password) {
        if (email == null || email.equals("") || firstname == null || firstname.equals("") || lastname == null || lastname.equals("") || password == null || password.equals("")) {
            return false;
        }
        return true;
    }

}
