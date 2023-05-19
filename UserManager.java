import java.util.HashMap;
import java.util.Map;

public class UserManager {
    private Map<String, User> users;

    public UserManager() {
        users = new HashMap<>();
    }

    public void addUser(User user) {
        users.put(user.getUsername(), user);
    }

    public void updateUser(User user) {
        if (users.containsKey(user.getUsername())) {
            users.put(user.getUsername(), user);
        }
    }

    public void removeUser(String username) {
        users.remove(username);
    }

    public boolean containsUser(String username) {
        return users.containsKey(username);
    }

    public User getUser(String username) {
        return users.get(username);
    }

    public boolean authenticate(String username, String password) {
        User user = users.get(username);
        return user != null && user.getPassword().equals(password);
    }
}
