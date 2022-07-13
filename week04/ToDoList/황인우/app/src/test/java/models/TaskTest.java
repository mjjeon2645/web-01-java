package models;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TaskTest {
  @Test
  void creation() {
    Task task = new Task("레이시티 같은 오픈 월드 레이싱 게임의" +
        " 게임플레이 월드를 구성하는 요소들에 뭐가 있을지 파악하기");
  }

  @Test
  void text() {
    Task task = new Task("포켓몬스터 게임 디렉터 되기");

    assertEquals("포켓몬스터 게임 디렉터 되기", task.text());
  }

  @Test
  void setStatusDone() {
    Task task = new Task("자바 척척석사 되기");
    task.setStatusDone();

    assertEquals("DONE", task.status());
  }

  @Test
  void setStatusToDo() {
    Task task = new Task("토익 800점 넘겨서 졸업요건 맞추기");
    task.setStatusDone();
    task.setStatusToDo();

    assertEquals("TO_DO", task.status());
  }

  @Test
  void setStatusDeleted() {
    Task task = new Task("반나절 쉬면서 심신 다잡기");
    task.setStatusDeleted();

    assertEquals("DELETED", task.status());
  }
}
