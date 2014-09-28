import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Calculator implements ActionListener {
  JFrame frame;
  JLabel equal;
  JTextField first;
  JTextField second;
  JLabel mode;
  JLabel result;
  JButton add;
  JButton sub;
  JButton mul;
  JButton div;
  JButton ok;
  Calculator() {
    frame = new JFrame("Caculartor");
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.setLayout(new GridLayout(2, 5, 10, 10));       //create grid
    first = new JTextField();
    second = new JTextField();
    first.setBorder(BorderFactory.createLineBorder(Color.blue));   //set text line color
    second.setBorder(BorderFactory.createLineBorder(Color.blue));
    result = new JLabel();
    mode = new JLabel();
    equal = new JLabel("=");
    first.setHorizontalAlignment(JTextField.CENTER);
    second.setHorizontalAlignment(JTextField.CENTER);
    mode.setHorizontalAlignment(JLabel.CENTER);
    equal.setHorizontalAlignment(JLabel.CENTER);
    result.setHorizontalAlignment(JLabel.CENTER);

    add=new JButton("+");
    sub=new JButton("-");
    mul=new JButton("*");
    div=new JButton("/");
    ok=new JButton("OK");

    Font f = new Font("TimesRoman", Font.BOLD, 20);     //set font
    add.setFont(f);
    sub.setFont(f);
    mul.setFont(f);
    div.setFont(f);
    mode.setFont(f);
    equal.setFont(f);

    frame.add(first);
    frame.add(mode);
    frame.add(second);
    frame.add(equal);
    frame.add(result);
    frame.add(add);
    frame.add(sub);
    frame.add(mul);
    frame.add(div);
    frame.add(ok);

    add.addActionListener(this);
    sub.addActionListener(this);
    mul.addActionListener(this);
    div.addActionListener(this);
    ok.addActionListener(this);

    frame.setSize(380,150);
    frame.setVisible(true);
  }
  public void actionPerformed(ActionEvent e) {

    if (e.getActionCommand().equals("+")){
      mode.setText("+");
    }
    else if (e.getActionCommand().equals("-")) {
      mode.setText("-");
    }
    else if (e.getActionCommand().equals("*")) {
      mode.setText("*");
    }
    else if (e.getActionCommand().equals("/")) {
      mode.setText("/");
    }
    else if (e.getActionCommand().equals("OK")) {
      double a, b;
      if (first.getText().trim().equals("") || second.getText().trim().equals(""))  {       //text is null, it's error
          result.setText("error");
      }
      else {
        a = Double.parseDouble(first.getText());            //change text to double
        b = Double.parseDouble(second.getText());
        if (mode.getText().equals("+")) {
          result.setText(a+b+"");                       // double to text
        }
        else if (mode.getText().equals("-")) {
          result.setText(Double.toString(a-b));         // doubel to text
        }
        else if (mode.getText().equals("*")) {
          result.setText(Double.toString(a*b));
        }
        else if (mode.getText().equals("/")) {
          if (b != 0) {
            result.setText(Double.toString(a/b));
          }
          else {
            result.setText("error");
          }
        }
      }
    }
  }
  public static void main(String[] args) {
    Calculator c = new Calculator();
  }
}
