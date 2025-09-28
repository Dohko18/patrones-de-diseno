package co.edu.unisabana.chatRoom;

import co.edu.unisabana.chatRoom.impl.ChatRoomHandler;
import co.edu.unisabana.chatRoom.impl.User;
import java.util.logging.Logger;

public class Main {
    private static final Logger logger = Logger.getLogger(Main.class.getName());
    
    public static void main(String[] args) {
        try {
            IMessageHandler chatRoom = new ChatRoomHandler();
            User peter = new User("Peter", chatRoom);
            User sophia = new User("Sophia", chatRoom);
            User charles = new User("Charles", chatRoom);
            User alice = new User("Alice", chatRoom);

            chatRoom.addUser(peter);
            chatRoom.addUser(sophia);
            chatRoom.addUser(charles);
            chatRoom.addUser(alice);

            peter.sendMessageToAll("Hello everybody!");
            sophia.sendMessageToUser("Peter", "Hi Peter, How are you?");
            charles.sendMessageToAll("Hello Peter and Sophia, nice to meet you!");
            chatRoom.removeUser("Alice");
            charles.sendMessageToUser("Alice", "Hey Alice are you in the chatRoom?");
            
        } catch (IllegalArgumentException e) {
            logger.severe("Invalid argument: " + e.getMessage());
        } catch (Exception e) {
            logger.severe("Unexpected error: " + e.getMessage());
        }
    }
}
