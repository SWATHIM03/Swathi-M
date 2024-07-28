package ei_project;
import java.util.*;

public class ChatApplication {
    private static Map<String, ChatClient> clients = new HashMap<>();

    public static void main(String[] args) {
        User alice = new User("Alice");
        User bob = new User("Bob");
        User charlie = new User("Charlie");

        registerClient(alice);
        registerClient(bob);
        registerClient(charlie);

        alice.joinRoom("Room123");
        bob.joinRoom("Room123");
        charlie.joinRoom("Room123");

        alice.sendMessage("Hello, everyone!");
        bob.sendMessage("How's it going?");
        charlie.sendMessage("Goodbye!");

        alice.leaveRoom();
        bob.leaveRoom();
        charlie.leaveRoom();
    }

    public static void registerClient(ChatClient client) {
        if (client instanceof User) {
            User user = (User) client;
            clients.put(user.getUsername(), client);
        }
    }

    public static ChatClient getClient(String username) {
        return clients.get(username);
    }
}
