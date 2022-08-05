package repositories;

import models.User;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class UserRepository {
  private Map<String, User> users;

  public UserRepository() throws FileNotFoundException {
    users = load();
  }

  public Map<String, User> load() throws FileNotFoundException {
    Map<String, User> users = new HashMap<>();

    File file = new File("usersdata.csv");

    Scanner scanner = new Scanner(file);

    while (scanner.hasNextLine()) {
      String line = scanner.nextLine();

      User user = parse(line);

      users.put(user.id(), user);
    }
    return users;
  }

  public void save(Map<String, User> users) throws IOException {
    FileWriter fileWriter = new FileWriter("usersdata.csv");

    for (User user : users.values()) {
      String line = user.toCsvRow();
      fileWriter.write(line + "\n");
    }
    fileWriter.close();
  }

  public User parse(String line) {
    String[] words = line.split(",");
    return new User(words[0], words[1], words[2], words[3]);
  }

  public User find(String id) {
    return users.get(id);
  }

  public void add(User user) throws IOException {
    users.put(user.id(), user);
    save(users);
  }
}
