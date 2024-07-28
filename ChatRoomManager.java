package ei_project;
import java.util.*;

public class ChatRoomManager {
    private static ChatRoomManager instance;
    private Map<String, ChatRoom> chatRooms;

    private ChatRoomManager() {
        chatRooms = new HashMap<>();
    }

    public static ChatRoomManager getInstance() {
        if (instance == null) {
            instance = new ChatRoomManager();
        }
        return instance;
    }

    public ChatRoom getChatRoom(String roomId) {
        return chatRooms.get(roomId);
    }

    public ChatRoom createChatRoom(String roomId) {
        ChatRoom chatRoom = new ChatRoom(roomId);
        chatRooms.put(roomId, chatRoom);
        return chatRoom;
    }
}

