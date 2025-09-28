package co.edu.unisabana.chatRoom.impl;

import co.edu.unisabana.chatRoom.ICommunicator;
import co.edu.unisabana.chatRoom.IMessageHandler;
import java.util.logging.Logger;
import java.util.logging.Level;

public record User(String name, IMessageHandler chatRoom) implements ICommunicator {
    
    private static final Logger logger = Logger.getLogger(User.class.getName());

    public User {
        if (name == null || name.trim().isEmpty()) {
            throw new IllegalArgumentException("User name cannot be null or empty");
        }
        if (chatRoom == null) {
            throw new IllegalArgumentException("ChatRoom cannot be null");
        }
    }

    @Override
    public void receiveMessage(String sender, String message) {
        if (sender == null || message == null) {
            logger.warning("Received null sender or message");
            return;
        }
        String sanitizedSender = sanitizeInput(sender);
        String sanitizedMessage = sanitizeInput(message);
        logger.info(String.format("%s receives from %s: '%s'", sanitizeInput(this.name), sanitizedSender, sanitizedMessage));
    }

    public void sendMessageToAll(String message) {
        if (message == null || message.trim().isEmpty()) {
            throw new IllegalArgumentException("Message cannot be null or empty");
        }
        String sanitizedMessage = sanitizeInput(message);
        logger.info(String.format("%s sends to all users: %s", sanitizeInput(this.name), sanitizedMessage));
        chatRoom.sendMessageToAll(this.name, message);
    }

    public void sendMessageToUser(String receiver, String message) {
        if (receiver == null || receiver.trim().isEmpty()) {
            throw new IllegalArgumentException("Receiver cannot be null or empty");
        }
        if (message == null || message.trim().isEmpty()) {
            throw new IllegalArgumentException("Message cannot be null or empty");
        }
        String sanitizedReceiver = sanitizeInput(receiver);
        String sanitizedMessage = sanitizeInput(message);
        logger.info(String.format("%s sends to %s: %s", sanitizeInput(this.name), sanitizedReceiver, sanitizedMessage));
        chatRoom.sendMessageToUser(this.name, receiver, message);
    }
    
    private String sanitizeInput(String input) {
        if (input == null) return "null";
        return input.replaceAll("[\r\n\t]", "_").replaceAll("[{Cntrl}]", "");
    }

    @Override
    public String getName() {
        return this.name;
    }
}
