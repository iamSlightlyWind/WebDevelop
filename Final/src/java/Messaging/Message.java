package Messaging;

public class Message {
    public int senderID;
    public String message, time;

    public Message(String senderID, String message, int currentUser, String time) {
        this.message = message;
        this.senderID = senderID.equals(currentUser + "") ? 1 : 0;
        this.time = time;
    }

    public int getSenderID() {
        return senderID;
    }

    public String getMessage() {
        return message;
    }

    public String getTime() {
        return time;
    }
    
}
