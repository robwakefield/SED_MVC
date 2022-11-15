package ic.doc;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ReversePolishGui {

  private final Updatable view = new View(new Controller());
  private final Model expressionCalc = new Model();

  public ReversePolishGui() {
    expressionCalc.addObserver(view);
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
    new ReversePolishGui();
  }

}
