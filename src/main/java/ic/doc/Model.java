package ic.doc;

import java.util.Arrays;
import java.util.Stack;

public class Model {
  private final View view;

  private final Stack<Integer> stack = new Stack<Integer>();

  public Model (View view) {
    this.view = view;
  }

  public void push (int item) {
    stack.push(item);
    view.update(this);
  }

  private int pop () {
    return stack.pop();
  }

  public String stackToString() {
    StringBuilder stringBuilder = new StringBuilder();
    for (int elem : stack.stream().toList()) {
      stringBuilder.append(elem).append(" ");
    }
    return stringBuilder.toString();
  }

  public void clear() {
    stack.clear();
    view.update(this);
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
