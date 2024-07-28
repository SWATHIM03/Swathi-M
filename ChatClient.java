package ei_project;
import java.util.List;
public interface ChatClient {
    void receiveMessage(String message);
    void updateUserList(List<String> users);
}

