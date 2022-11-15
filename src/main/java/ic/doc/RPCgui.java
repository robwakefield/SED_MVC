package ic.doc;

import javax.swing.*;

public class RPCgui {
  private void display() {
    JFrame frame = new JFrame("Reverse Polish Calculator");
    frame.setSize(350, 200);

    JPanel panel = new JPanel();

    final JTextField txtField = new JTextField(10);

    for (int i = 1; i < 5; i++) {
      JButton button = new JButton(String.valueOf(i));
      int finalI = i;
      button.addActionListener(e -> txtField.setText(String.valueOf(finalI)));
      panel.add(button);
    }
    JButton addButton = new JButton("+");
    addButton.addActionListener(e -> txtField.setText("+"));
    panel.add(addButton);
    JButton subButton = new JButton("-");
    subButton.addActionListener(e -> txtField.setText("-"));
    panel.add(subButton);

    panel.add(txtField);

    JButton clearButton = new JButton("Clear");
    clearButton.addActionListener(e -> txtField.setText(""));
    panel.add(clearButton);

    frame.getContentPane().add(panel);
    frame.setVisible(true);
  }

  public static void main(String[] args) {
    new RPCgui().display();
  }

}
