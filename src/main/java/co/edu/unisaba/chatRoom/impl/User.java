package co.edu.unisaba.chatRoom.impl;

import co.edu.unisaba.chatRoom.ICommunicator;
import co.edu.unisaba.chatRoom.IMessageHandler;

public record User(String name, IMessageHandler chatRoom) implements ICommunicator {

    @Override
    public void receiveMessage(String sender, String message) {
        System.out.println(String.format("%s receives from %s: '%s'%n",this.name, sender, message));
    }

    public void sendMessageToAll(String message) {
        System.out.println(String.format("%s sends to all users: %s%n", this.name, message));
        chatRoom.sendMessageToAll(this.name, message);
    }

    public void sendMessageToUser(String receiver, String message) {
        System.out.println(String.format("%s sends to %s: %s%n", this.name, receiver, message));
        chatRoom.sendMessageToUser(this.name, receiver, message);
    }

    @Override
    public String getName() {
        return this.name;
    }
}
