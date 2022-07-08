import java.util.ArrayList;
import java.util.List;

public class AccountRepository {
  private final List<Account> accountRepository;

  public AccountRepository() {
    accountRepository = new ArrayList<>(
        List.of(
            new Account("352-0528-2645-53", 5000),
            new Account("179-20-155318", 8000)
        )
    );
  }

  public Account find(String identifier) {
    return accountRepository.stream()
        .filter(account -> account.identifier().equals(identifier))
        .findFirst()
        .orElse(null);
  }
}
