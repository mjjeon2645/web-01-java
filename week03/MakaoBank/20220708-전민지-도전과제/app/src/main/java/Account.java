import java.util.ArrayList;
import java.util.List;

public class Account {
  private String myIdentifier = "123-456-7890";
  private String theOtherIdentifier = "345-678-9012";

  private long myAmount = 3000;
  private long theOtherAmount = 1000;

  private List<String> myTransactions = new ArrayList<>();
  private List<String> theOtherTransactions = new ArrayList<>();

  public String myIdentifier() {
    return myIdentifier;
  }

  public String theOtherIdentifier() {
    return theOtherIdentifier;
  }

  public long myAmount() {
    return myAmount;
  }

  public long theOtherAmount() {
    return theOtherAmount;
  }

  public List<String> myTransactions() {
    return new ArrayList<>(myTransactions);
  }

  public List<String> theOtherTransactions() {
    return new ArrayList<>(theOtherTransactions);
  }

  public void transferToTheOther(long amountToTheOther) {
    this.theOtherAmount += amountToTheOther;
    this.myAmount -= amountToTheOther;

    myTransactions.add("송금: " + amountToTheOther + "원");
    theOtherTransactions.add("입금: " + amountToTheOther + "원");
  }

  public void transferToMe(long amountToMe) {
    this.theOtherAmount -= amountToMe;
    this.myAmount += amountToMe;

    myTransactions.add("입금: " + amountToMe + "원");
    theOtherTransactions.add("송금: " + amountToMe + "원");
  }
}
