package ic.doc;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Model {
  private final List<Updatable> views = new ArrayList<Updatable>();
  private final Stack<Integer> stack = new Stack<Integer>();

  public void addObserver(Updatable view) {
    views.add(view);
  }

  private void notifyObservers() {
    for (Updatable view : views) {
      view.update(this);
    }
  }

  public void push(int item) {
    stack.push(item);
    notifyObservers();
  }

  public String stackToString() {
    StringBuilder stringBuilder = new StringBuilder();
    for (int elem : stack.stream().toList()) {
      stringBuilder.append(elem).append(" ");
    }
    return stringBuilder.toString().strip();
  }

  public void clear() {
    stack.clear();
    notifyObservers();
  }

  public void add() {
    if (stack.size() < 2) {
      return;
    }
    int a = stack.pop();
    int b = stack.pop();
    push(a + b);
  }

  public void sub() {
    if (stack.size() < 2) {
      return;
    }
    int a = stack.pop();
    int b = stack.pop();
    push(a - b);
  }
}
