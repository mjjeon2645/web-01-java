import java.util.ArrayList;
import java.util.List;

public class Account {
  private String identifierOfMine = "123-456-7890";
  private String identifierOfOthers = "345-678-9012";

  private long amountOfMine = 3000;
  private long amountOfOthers = 1000;

  private List<String> transactionsOfMine = new ArrayList<>();
  private List<String> transactionsOfOthers = new ArrayList<>();

  public String identifierOfMine() {
    return identifierOfMine;
  }

  public String identifierOfOthers() {
    return identifierOfOthers;
  }

  public long amountOfMine() {
    return amountOfMine;
  }

  public long amountOfOthers() {
    return amountOfOthers;
  }

  public List<String> transactionsOfMine() {
    return new ArrayList<>(transactionsOfMine);
  }

  public List<String> transactionsOfOthers() {
    return new ArrayList<>(transactionsOfOthers);
  }

  public void transferToOthers(long amountToOthers) {
    this.amountOfOthers += amountToOthers;
    this.amountOfMine -= amountToOthers;

    transactionsOfMine.add("송금: " + amountToOthers + "원");
    transactionsOfOthers.add("입금: " + amountToOthers + "원");
  }

  public void transferToMe(long amountToMe) {
    this.amountOfOthers -= amountToMe;
    this.amountOfMine += amountToMe;

    transactionsOfMine.add("입금: " + amountToMe + "원");
    transactionsOfOthers.add("송금: " + amountToMe + "원");
  }
}
