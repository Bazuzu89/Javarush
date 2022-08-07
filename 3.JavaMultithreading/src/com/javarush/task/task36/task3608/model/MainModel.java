package com.javarush.task.task36.task3608.model;
import com.javarush.task.task36.task3608.bean.User;
import com.javarush.task.task36.task3608.model.service.UserService;
import com.javarush.task.task36.task3608.model.service.UserServiceImpl;

import java.util.LinkedList;
import java.util.List;

public class MainModel implements Model {
    private ModelData modelData = new ModelData();
    private UserService userService = new UserServiceImpl();

    public void loadUsers() {
        modelData.setUsers(getAllUsers());
        modelData.setUsers(userService.getUsersBetweenLevels(1, 100));
        modelData.setDisplayDeletedUserList(false);
    }

    public ModelData getModelData() {
        return this.modelData;
    }

    public void loadDeletedUsers() {
        List<User> users = userService.getAllDeletedUsers();
        modelData.setUsers(users);
        modelData.setDisplayDeletedUserList(true);
    }

    public void loadUserById(long userId) {
        modelData.setUsers(getAllUsers());
        modelData.setActiveUser(userService.getUsersById(userId));
    }

    public void deleteUserById(long id) {

        userService.deleteUser(id);
        modelData.setUsers(getAllUsers());
    }

    private List<User> getAllUsers() {
        List<User> listUser = userService.filterOnlyActiveUsers(userService.getUsersBetweenLevels(1, 100));
        return listUser;
    }

    public void changeUserData(String name, long id, int level) {
        userService.createOrUpdateUser(name,id,level);
        modelData.setUsers(getAllUsers());
    }
}
