package ic.doc;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class RPCgui {

  private final View view = new View(new Controller());
  private final Model expressionCalc = new Model(view);

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
    new RPCgui();
  }

}
