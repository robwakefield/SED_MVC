package ic.doc;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class RPCgui {

  private final View view = new View(new Controller());
  private final Model expressionCalc = new Model();

  private RPCgui (boolean withView) {
    if (withView) {
      expressionCalc.addObserver(view);
    }
  }

  static RPCgui withView() {
    return new RPCgui(true);
  }

  static RPCgui withoutView() {
    return new RPCgui(false);
  }

  class Controller implements ActionListener {
    @Override
    public void actionPerformed(ActionEvent e) {
      String label = e.getActionCommand();
      switch (label) {
        case "Clear" -> expressionCalc.clear();
        case "+" -> expressionCalc.add();
        case "-" -> expressionCalc.sub();
        default -> expressionCalc.push(Integer.parseInt(label));
      }
    }
  }

  public static void main(String[] args) {
    RPCgui.withView();
  }

}
