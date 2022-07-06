package models;

import java.util.ArrayList;
import java.util.List;
// 콘솔에서도 확인을 할 수 있어야 한다.
public class Task {
  private String task;

  public void send(String task) {
    this.task = task;
  }

  public String task() {
    return task;
  }
}
