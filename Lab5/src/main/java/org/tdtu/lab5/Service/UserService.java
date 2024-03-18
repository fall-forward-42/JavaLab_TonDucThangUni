package org.tdtu.lab5.Service;


import org.tdtu.lab5.DAO.UserDAO;

public class UserService {

    private UserDAO userDAO;

    public UserService() {
        // Assume UserDAO is initialized properly here
    }

    public boolean authenticate(String username, String password) {
        User user = userDAO.findByUsername(username);
        return user != null && user.getPassword().equals(password);
    }

    public boolean register(User user) {
        if (userDAO.findByUsername(user.getUsername()) == null) {
            userDAO.save(user);
            return true;
        }
        return false;
    }
}
