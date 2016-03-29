package sem2.lab2;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class AppletExt extends JApplet {
    private JButton button1;
    private JButton button2;
    private JButton button3;
    private JButton button4;
    private JButton button5;
    private JPanel mainPanel;


    @Override
    public void init() {
        super.init();
        setSize(new Dimension(550, 30));
        button1.setText("Press me");
        button1.addActionListener(buttonsListener);
        button2.addActionListener(buttonsListener);
        button3.addActionListener(buttonsListener);
        button4.addActionListener(buttonsListener);
        button5.addActionListener(buttonsListener);
        add(mainPanel);
        setVisible(true);
    }

    private ActionListener buttonsListener = new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            if (e.getSource().equals(button1) && !((JButton) e.getSource()).getText().equals("")) {
                button2.setText("Press Me");
                button1.setText("");
            }
            if (e.getSource().equals(button2) && !((JButton) e.getSource()).getText().equals("")) {
                button3.setText("Press Me");
                button2.setText("");
            }
            if (e.getSource().equals(button3) && !((JButton) e.getSource()).getText().equals("")) {
                button4.setText("Press Me");
                button3.setText("");
            }
            if (e.getSource().equals(button4) && !((JButton) e.getSource()).getText().equals("")) {
                button5.setText("Press Me");
                button4.setText("");
            }
            if (e.getSource().equals(button5) && !((JButton) e.getSource()).getText().equals("")) {
                button1.setText("Press Me");
                button5.setText("");
            }
        }
    };

    public static void main(String[] args) {
        new AppletExt();
    }
}
