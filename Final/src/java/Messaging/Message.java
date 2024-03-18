package Messaging;

public class Message {
    public String senderID, message;

    public Message(String senderID, String message) {
        this.senderID = senderID;
        this.message = message;
    }

    public String getSenderID() {
        return senderID;
    }

    public String getMessage() {
        return message;
    }
    
}
