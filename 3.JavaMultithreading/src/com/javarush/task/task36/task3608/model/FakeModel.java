package com.javarush.task.task36.task3608.model;
import com.javarush.task.task36.task3608.bean.User;
import java.util.List;
import java.util.LinkedList;

public class FakeModel implements Model {
    private ModelData modelData = new ModelData();
    public ModelData getModelData() {
        return modelData;
    }

    public void loadUsers() {
        List<User> newUsers = new LinkedList<User>();
        newUsers.add(new User("Dennis", 1, 99));
        newUsers.add(new User("Anton", 2, 12));
        modelData.setUsers(newUsers);
    }

    @Override
    public void loadDeletedUsers() {
        throw new UnsupportedOperationException();
    }

    public void loadUserById(long userId) {
        throw new UnsupportedOperationException();
    }

    public void deleteUserById(long id) {
        throw new UnsupportedOperationException();
    }

    public void changeUserData(String name, long id, int level) {
        throw new UnsupportedOperationException();
    }
}
