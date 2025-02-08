package com.webapp.java_auth.services;

import com.webapp.java_auth.dao.UserDAO;
import com.webapp.java_auth.models.User;
import org.mindrot.jbcrypt.BCrypt;

public class UserService {
    private final UserDAO userDAO = new UserDAO();

    public boolean registerUser(String fullName, String email, String password){
        if(userDAO.getUserByEmail(email) != null){
            return false;
        }
        String hashedPassword = BCrypt.hashpw(password, BCrypt.gensalt());
        User newUser = new User(fullName, email, hashedPassword);

        userDAO.saveUser(newUser);

        return true;
    }

    public boolean authenticateUser(String email, String password){
        User user = userDAO.getUserByEmail(email);
        return user != null && BCrypt.checkpw(password, user.getPassword());
    }
}
