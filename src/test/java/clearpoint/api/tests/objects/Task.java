package clearpoint.api.tests.objects;

public class Task {
  int id;
  String title;
  String body;

  public Task (final String taskTitle, final String taskBody) {
    this.title = taskTitle;
    this.body = taskBody;
  }

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public String getTitle() {
    return title;
  }

  public void setTitle(String title) {
    this.title = title;
  }

  public String getBody() {
    return body;
  }

  public void setBody(String body) {
    this.body = body;
  }
}
