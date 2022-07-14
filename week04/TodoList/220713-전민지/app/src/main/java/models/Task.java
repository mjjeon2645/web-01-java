package models;

// TODO. task에 대한 정의
// TODO. task의 상태값 바꿔주기?

import java.time.LocalDateTime;

public class Task {
  private final static String[] STATETYPES = {"ADDED", "DONE", "DELETED"};
  private String taskTitle;
  private String creationTime;
  private String state;

  public Task(String taskTitle, String creationTime) {

    this.taskTitle = taskTitle;
    this.creationTime = creationTime;
    this.state = STATETYPES[0];
  }
}
