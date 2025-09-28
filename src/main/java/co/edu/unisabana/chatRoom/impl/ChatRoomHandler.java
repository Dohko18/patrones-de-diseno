package co.edu.unisabana.chatRoom.impl;

import co.edu.unisabana.chatRoom.ICommunicator;
import co.edu.unisabana.chatRoom.IMessageHandler;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import java.util.logging.Logger;

public class ChatRoomHandler implements IMessageHandler {

    private static final Logger logger = Logger.getLogger(ChatRoomHandler.class.getName());
    private final Map<String, ICommunicator> users = new HashMap<>();

    @Override
    public void sendMessageToUser(String sender, String receiver, String message) {
        if (sender == null || sender.trim().isEmpty()) {
            throw new IllegalArgumentException("Sender cannot be null or empty");
        }
        if (receiver == null || receiver.trim().isEmpty()) {
            throw new IllegalArgumentException("Receiver cannot be null or empty");
        }
        if (message == null || message.trim().isEmpty()) {
            throw new IllegalArgumentException("Message cannot be null or empty");
        }
        
        Optional<ICommunicator> user = Optional.ofNullable(users.get(receiver));
        user.ifPresentOrElse(
            u -> u.receiveMessage(sender, message), 
            () -> logger.warning(String.format("No user with name: %s", sanitizeInput(receiver)))
        );
    }

    @Override
    public void sendMessageToAll(String sender, String message) {
        if (sender == null || sender.trim().isEmpty()) {
            throw new IllegalArgumentException("Sender cannot be null or empty");
        }
        if (message == null || message.trim().isEmpty()) {
            throw new IllegalArgumentException("Message cannot be null or empty");
        }
        
        users.values().stream()
                .filter(user -> !user.getName().equals(sender))
                .forEach(user -> user.receiveMessage(sender, message));
    }

    @Override
    public void addUser(ICommunicator user) {
        if (user == null) {
            throw new IllegalArgumentException("User cannot be null");
        }
        if (user.getName() == null || user.getName().trim().isEmpty()) {
            throw new IllegalArgumentException("User name cannot be null or empty");
        }
        
        users.putIfAbsent(user.getName(), user);
        logger.info(String.format("User %s added to chat room", sanitizeInput(user.getName())));
    }

    @Override
    public void removeUser(String userName) {
        if (userName == null || userName.trim().isEmpty()) {
            throw new IllegalArgumentException("User name cannot be null or empty");
        }
        
        ICommunicator removedUser = users.remove(userName);
        if (removedUser != null) {
            logger.info(String.format("User %s removed from chat room", sanitizeInput(userName)));
        } else {
            logger.warning(String.format("Attempted to remove non-existent user: %s", sanitizeInput(userName)));
        }
    }
    
    private String sanitizeInput(String input) {
        if (input == null) return "null";
        return input.replaceAll("[\r\n\t]", "_").replaceAll("[\p{Cntrl}]", "");
    }

}
