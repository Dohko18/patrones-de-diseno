package co.edu.unisaba.chatRoom;

import co.edu.unisaba.chatRoom.impl.ChatRoomHandler;
import co.edu.unisaba.chatRoom.impl.User;


public class Main {
    public static void main(String[] args) {
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
    }
}
