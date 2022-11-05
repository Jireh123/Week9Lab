package services;

import dataaccess.RoleDB;
import java.util.List;
import models.Role;

/**
 *
 * @author Jireh
 */
public class RoleService {

    public List<Role> getAllRoles() throws Exception {
        RoleDB roleDB = new RoleDB();
        List<Role> roles = roleDB.getAllRoles();
        return roles;
    }

    public int getRoleID(String roleName) {
        if (roleName.equals("system admin")) {
            return 1;
        } else {
            return 2;
        }
    }
}
