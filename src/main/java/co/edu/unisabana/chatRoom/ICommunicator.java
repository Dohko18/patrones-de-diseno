package co.edu.unisabana.chatRoom;

/**
 * @author Ing. Darwin Esneider Rodriguez Ladino
 * @version Id: <b>task-first</b> 27/09/2025, 10:53 p. m.
 * @email daroxx47@hotmail.com
 **/
public interface ICommunicator {
    void receiveMessage(String sender, String message);
    String getName();
}
