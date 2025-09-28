package co.edu.unisabana.chatRoom;

public interface IMessageHandler {
    void sendMessageToUser(String sender, String receiver, String message);
    void sendMessageToAll(String sender, String message);
    void addUser(ICommunicator user);
    void removeUser(String userName);
}
