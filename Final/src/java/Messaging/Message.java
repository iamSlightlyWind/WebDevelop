package Messaging;

public class Message {
    public int senderID;
    public String message;

    public Message(String senderID, String message, int currentUser) {
        this.message = message;
        this.senderID = senderID.equals(currentUser + "") ? 1 : 0;
    }

    public int getSenderID() {
        return senderID;
    }

    public String getMessage() {
        return message;
    }
    
}
