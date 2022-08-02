package pages;

import models.Task;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class TasksPageGeneratorTest {
  @Test
  void html() {
    List<Task> tasks = new ArrayList<>();
    PageGenerator pageGenerator = new TasksPageGenerator(tasks);

    String html = pageGenerator.html();

    assertTrue(html.contains("<h1>Todo List"), "메인 제목 문제" + html);
    assertTrue(html.contains("할 일: "), "서브 제목 문제" + html);
    assertTrue(html.contains("<input type"), "입력필드 문제" + html);
    assertTrue(html.contains("<button type"), "등록 버튼 문제" + html);
  }

  @Test
  void showTasks() {
    List<Task> tasks = List.of (
        new Task("TIL 쓰기", "PROCESSING"),
        new Task("빨래 널기", "PROCESSING"),
        new Task("코딩도장 풀기", "PROCESSING")
        );

    PageGenerator pageGenerator = new TasksPageGenerator(tasks);

    String html = pageGenerator.html();

    assertTrue(html.contains("<li>TIL 쓰기"), "태스크 1 문제" + html);
    assertTrue(html.contains("<li>빨래 널기"), "태스크 2 문제" + html);
    assertTrue(html.contains("<li>코딩도장 풀기"), "태스크 3 문제" +html);
  }
}
