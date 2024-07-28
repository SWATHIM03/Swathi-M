package ei_project;
import java.util.List;
public class User implements ChatClient {
    private String username;
    private ChatRoom currentRoom;

    public User(String username) {
        this.username = username;
    }

    public String getUsername() {
        return username;
    }

    public void joinRoom(String roomId) {
        if (currentRoom != null) {
            leaveRoom();
        }
        ChatRoomManager manager = ChatRoomManager.getInstance();
        ChatRoom chatRoom = manager.getChatRoom(roomId);
        if (chatRoom == null) {
            chatRoom = manager.createChatRoom(roomId);
        }
        currentRoom = chatRoom;
        chatRoom.addUser(username);
        updateUserList(chatRoom.getActiveUsers());
    }

    public void leaveRoom() {
        if (currentRoom != null) {
            currentRoom.removeUser(username);
            currentRoom = null;
        }
    }

    public void sendMessage(String message) {
        if (currentRoom != null) {
            currentRoom.addMessage(username, message);
            for (String user : currentRoom.getActiveUsers()) {
                // Assuming a method to send a message to the user
                // This could be implemented with WebSockets or similar technologies
                ChatClient client = ChatApplication.getClient(user);
                if (client != null) {
                    client.receiveMessage("[" + username + "]: " + message);
                }
            }
        }
    }

    @Override
    public void receiveMessage(String message) {
        System.out.println(message);
    }

    @Override
    public void updateUserList(List<String> users) {
        System.out.println("Active users: " + String.join(", ", users));
    }
}

