package ic.doc;

import javax.swing.JTextField;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JButton;
import java.awt.event.ActionListener;

public class View implements Updatable {

  private final JTextField txtField = new JTextField(10);

  public View(ActionListener controller) {
    JFrame frame = new JFrame("Reverse Polish Calculator");
    frame.setSize(350, 200);

    JPanel panel = new JPanel();

    for (int i = 1; i < 5; i++) {
      JButton button = new JButton(String.valueOf(i));
      button.addActionListener(controller);
      panel.add(button);
    }
    JButton addButton = new JButton("+");
    addButton.addActionListener(controller);
    panel.add(addButton);
    JButton subButton = new JButton("-");
    subButton.addActionListener(controller);
    panel.add(subButton);

    panel.add(txtField);

    JButton clearButton = new JButton("Clear");
    clearButton.addActionListener(controller);
    panel.add(clearButton);

    frame.getContentPane().add(panel);
    frame.setVisible(true);
  }

  @Override
  public void update(Model model) {
    txtField.setText(model.stackToString());
  }
}
