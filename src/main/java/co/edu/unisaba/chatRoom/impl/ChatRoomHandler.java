package co.edu.unisaba.chatRoom.impl;

import co.edu.unisaba.chatRoom.ICommunicator;
import co.edu.unisaba.chatRoom.IMessageHandler;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public class ChatRoomHandler implements IMessageHandler {

    private final Map<String, ICommunicator> users = new HashMap<>();

    @Override
    public void sendMessageToUser(String sender, String receiver, String message) {
        Optional<ICommunicator> user = Optional.ofNullable(users.get(receiver));
        user.ifPresentOrElse(u -> u.receiveMessage(sender, message), () -> System.out.println("No user with name: " + receiver));
    }

    @Override
    public void sendMessageToAll(String sender, String message) {
        users.values().stream()
                .filter(user -> !user.getName().equals(sender))
                .forEach(user -> user.receiveMessage(sender, message));
    }

    @Override
    public void addUser(ICommunicator user) {
        users.putIfAbsent(user.getName(), user);
    }

    @Override
    public void removeUser(String userName) {
        users.remove(userName);
    }

}
