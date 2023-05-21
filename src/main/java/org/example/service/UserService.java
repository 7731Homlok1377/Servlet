package org.example.service;

import org.example.dao.UserDao;
import org.example.models.User;

public class UserService {
    /*
    private final UserDB userRepository;

    public UserService(UserDB userRepository){
        this.userRepository = userRepository;
    }
    public UserService(){
        this.userRepository = new UserDB();
    }
    public void addUser(String login, String email, String password) {
        if (login != null && login != "" && email != null && email != "" && password != null && password != "") {
            User user = new User(login, email, password);
            if (userRepository.save(user)) return;
        }
        throw new IllegalArgumentException();
    }

    public boolean validUser(String login, String password) {
        User user = userRepository.getUser(login);
        return user != null && user.getPassword().equals(password);
    }
    */
    private final UserDao userDao;

    public UserService(UserDao dao){
        this.userDao = dao;
    }
    public UserService(){
        this.userDao = new UserDao();
    }
    public void addUser(String login, String email, String password) {
        if (login != null && login != "" && email != null && email != "" && password != null && password != "") {
            User user = new User(login, email, password);
            if (userDao.save(user)) return;
        }
        throw new IllegalArgumentException();
    }

    public boolean validUser(String login, String password) {
        User user = userDao.getUser(login);
        return user != null && user.getPassword().equals(password);
    }
}