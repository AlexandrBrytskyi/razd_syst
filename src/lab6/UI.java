package lab6;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * User: huyti
 * Date: 24.10.2015
 */
public class UI extends JFrame {
    private JTextField aField;
    private JTextField bField;
    private JTextField nField;
    private JTextField threadField;
    private JButton countButton;
    private JLabel labelA;
    private JLabel labelB;
    private JLabel labelN;
    private JLabel labelThreads;
    private JLabel resLabel;
    private JLabel timeLabel;
    private JPanel mainPanel;

    IntegralCounterController controller;

    public UI() throws HeadlessException {
        super("Integral multithread counter");
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setSize(new Dimension(700, 200));
        setVisible(true);
        add(mainPanel);
        countButton.addActionListener(countButtonListener);
    }

    private ActionListener countButtonListener = new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            controller = new IntegralCounterController(
                    Double.valueOf(aField.getText()),
                    Double.valueOf(bField.getText()),
                    Integer.valueOf(nField.getText()),
                    Integer.valueOf(threadField.getText())
            );
            resLabel.setText("Result is " + controller.count());
            timeLabel.setText("Time is " + controller.getTime());
        }
    };

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new UI();
            }
        });
    }


}
