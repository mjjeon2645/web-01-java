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
}
