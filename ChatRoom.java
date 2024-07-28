package ei_project;
import java.util.*;

public class ChatRoom {
    private String roomId;
    private List<String> messages;
    private List<String> activeUsers;

    public ChatRoom(String roomId) {
        this.roomId = roomId;
        this.messages = new ArrayList<>();
        this.activeUsers = new ArrayList<>();
    }

    public String getRoomId() {
        return roomId;
    }

    public List<String> getMessages() {
        return messages;
    }

    public void addMessage(String username, String message) {
        messages.add("[" + username + "]: " + message);
    }

    public List<String> getActiveUsers() {
        return activeUsers;
    }

    public void addUser(String username) {
        activeUsers.add(username);
    }

    public void removeUser(String username) {
        activeUsers.remove(username);
    }
}
