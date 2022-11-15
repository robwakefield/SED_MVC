package ic.doc;

import javax.swing.*;

public class RPCgui {
  private void display() {
    JFrame frame = new JFrame("Reverse Polish Calculator");
    frame.setSize(300, 200);

    JPanel panel = new JPanel();
    for (int i = 1; i < 5; i++) {
      panel.add(new JButton(String.valueOf(i)));
    }
    panel.add(new JButton("+"));
    panel.add(new JButton("-"));
    panel.add(new JTextField(10));

    frame.getContentPane().add(panel);
    frame.setVisible(true);
  }

  public static void main(String[] args) {
    new RPCgui().display();
  }

}
