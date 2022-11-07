package web.service;

import web.model.User;

import java.util.List;

public interface UserService {

    void addUser(User user);

    void removeUserById(Long id);

    List<User> getAllUser();

    User getUserById(Long id);
}
