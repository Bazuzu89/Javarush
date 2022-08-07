package com.javarush.task.task30.task3008.client;

public class ClientGuiController extends Client {
    private ClientGuiModel model = new ClientGuiModel();
    private ClientGuiView view = new ClientGuiView(this);


    public class GuiSocketThread extends Client.SocketThread {
        public void processIncomingMessage(String message) {
            model.setNewMessage(message);
            view.refreshMessages();
        }

        public void informAboutAddingNewUser(String userName) {
            model.addUser(userName);
            view.refreshUsers();
        }

        public void informAboutDeletingNewUser(String userName) {
            model.deleteUser(userName);
            view.refreshUsers();
        }

        public void notifyConnectionStatusChanged(boolean clientConnected) {
            view.notifyConnectionStatusChanged(clientConnected);
        }
    }

    protected SocketThread getSocketThread() {
        return new GuiSocketThread();
    }

    public void run() {
        getSocketThread().run();
    }

    public String getServerAddress() {
        return view.getServerAddress();
    }

    public int getServerPort() {
        return view.getServerPort();
    }

    public String getUserName() {
        return view.getUserName();
    }

    public ClientGuiModel getModel() {
        return model;
    }


    public static void main(String[] args) {
        ClientGuiController clientGuiController = new ClientGuiController();
        clientGuiController.run();
    }
}
