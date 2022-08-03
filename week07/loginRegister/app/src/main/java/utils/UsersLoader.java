package utils;

import models.User;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class UsersLoader {
  public List<User> load() throws FileNotFoundException {
    List<User> users = new ArrayList<>();

    File file = new File("userdata.csv");

    Scanner scanner = new Scanner(file);

    while(scanner.hasNextLine()) {
      String line = scanner.nextLine();

      User user = parse(line);

      users.add(user);
    }

    return users;
  }

  public User parse(String line) {
    String[] words = line.split(",");
    return new User(words[0], words[1], words[2], words[3]);
  }
}
