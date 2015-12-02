package lab4;

import lab3.Lab3;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.NumberFormat;

/**
 * Created with IntelliJ IDEA.
 * User: huyti
 * Date: 26.09.15
 * Time: 15:58
 * To change this template use File | Settings | File Templates.
 */
public class UserInterface extends JFrame {
    JLabel label1;
    JLabel label2;
    JLabel label3;
    JTextField xMinField;
    JTextField xMaxField;
    JTextField aTextField;
    JTable list;
    JLabel infoField;
    JButton countSteps;
    JButton generateArrays;
    JButton findMin;
    JButton findMax;
    JButton findSum;
    JButton findAverage;
    JPanel listAndInfoPanel;
    JScrollPane s2;
    JButton sumDodatn;
    JButton exit;

    Lab3 lab3 = new Lab3();

    public UserInterface() {
        super();

        setTitle("Lab. Work 4 by Brytskyi");
        setSize(new Dimension(800, 500));
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());
        JPanel textFieldpanel = new JPanel(new GridLayout(3, 3));
        label1 = new JLabel("Enter minX here");
        label2 = new JLabel("Enter maxX here");
        label3 = new JLabel("Set a here");
        xMinField = new JTextField();
        xMaxField = new JTextField();
        aTextField = new JTextField();
        JButton buttonMinX = new JButton("Set Min X");
        JButton buttonMaxX = new JButton("Set Max X");
        JButton buttonParamA = new JButton("Set param. A");
        buttonMinX.setActionCommand("min");
        buttonMaxX.setActionCommand("max");
        buttonParamA.setActionCommand("a");

        textFieldpanel.add(label1);
        textFieldpanel.add(label2);
        textFieldpanel.add(label3);
        textFieldpanel.add(xMinField);
        textFieldpanel.add(xMaxField);
        textFieldpanel.add(aTextField);
        textFieldpanel.add(buttonMinX);
        textFieldpanel.add(buttonMaxX);
        textFieldpanel.add(buttonParamA);
        xMinField.addActionListener(lis1);
        buttonMinX.addActionListener(lis1);
        buttonMaxX.addActionListener(lis1);
        buttonParamA.addActionListener(lis1);

        xMinField.setHorizontalAlignment(SwingConstants.CENTER);
        xMaxField.setHorizontalAlignment(SwingConstants.CENTER);
        aTextField.setHorizontalAlignment(SwingConstants.CENTER);
        label3.setHorizontalAlignment(SwingConstants.CENTER);
        label2.setHorizontalAlignment(SwingConstants.CENTER);
        label1.setHorizontalAlignment(SwingConstants.CENTER);


        listAndInfoPanel = new JPanel(new GridLayout(1, 2));
        infoField = new JLabel("          Here is info");
        JScrollPane sss = new JScrollPane(infoField);
        listAndInfoPanel.add(sss);
        s2 = new JScrollPane();
        listAndInfoPanel.add(s2);

        countSteps = new JButton("Count Steps");
        generateArrays = new JButton("Generate arrays");
        findMin = new JButton("Find Min Y");
        findMax = new JButton("Find Max Y");
        findSum = new JButton("Find Sum min/max");
        findAverage = new JButton("Find sum vid");
        sumDodatn = new JButton("Find sum dodatnih");
        exit = new JButton("Close");
        JPanel buttonPanel = new JPanel(new GridLayout(2, 6));
        buttonPanel.add(countSteps);
        buttonPanel.add(generateArrays);
        buttonPanel.add(findMin);
        buttonPanel.add(findMax);
        buttonPanel.add(findSum);
        buttonPanel.add(findAverage);
        buttonPanel.add(sumDodatn);
        buttonPanel.add(exit);
        countSteps.addActionListener(lis2);
        generateArrays.addActionListener(lis2);
        findMin.addActionListener(lis2);
        findMax.addActionListener(lis2);
        findSum.addActionListener(lis2);
        findAverage.addActionListener(lis2);
        sumDodatn.addActionListener(lis2);
        exit.addActionListener(lis2);


        textFieldpanel.setBorder(BorderFactory.createEtchedBorder(Color.BLUE, Color.BLACK));
        listAndInfoPanel.setBackground(Color.LIGHT_GRAY);
        listAndInfoPanel.setBorder(BorderFactory.createLoweredSoftBevelBorder());
        buttonPanel.setBorder(BorderFactory.createRaisedBevelBorder());

        add(textFieldpanel, BorderLayout.NORTH);
        add(listAndInfoPanel, BorderLayout.CENTER);
        add(buttonPanel, BorderLayout.SOUTH);
        setVisible(true);
    }

    ActionListener lis1 = new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            if (e.getActionCommand().equals("min")) {
                lab3.setxMin(Double.valueOf(xMinField.getText()));
                label1.setText("Change X min here");
                infoField.setText("<html>          Info is here  <br>");
            }
            if (e.getActionCommand().equals("max")) {
                lab3.setxMax(Double.valueOf(xMaxField.getText()));
                label2.setText("Change X max here");
                infoField.setText("<html>          Info is here  <br>");
            }
            if (e.getActionCommand().equals("a")) {
                lab3.setA(Double.valueOf(aTextField.getText()));
                label3.setText("Change par. A here");
                infoField.setText("<html>          Info is here <br>");
            }
        }
    };

    ActionListener lis2 = new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            if (e.getSource().equals(countSteps)) {
                updateInfo("Amount of steps = " + lab3.findAmountOfshag());
            }
            if (e.getSource().equals(generateArrays)) {
                lab3.generateMasX();
                lab3.generateMasY();
                fullTable();
            }
            if (e.getSource().equals(findMin)) {
                updateInfo("minY = " + lab3.masY[lab3.findMinY()] + ", x = " + lab3.masX[lab3.findMinY()] + ", index = " + lab3.findMinY());
            }
            if (e.getSource().equals(findMax)) {
                updateInfo("maxY = " + lab3.masY[lab3.findMaxY()] + ", x = " + lab3.masX[lab3.findMaxY()] + ", index = " + lab3.findMaxY());
            }
            if (e.getSource().equals(findSum)) updateInfo("Summa minY+maxY = " + lab3.findSumY());
            if (e.getSource().equals(findAverage)) updateInfo("suma vidyemnih = " + lab3.findAverage());
            if (e.getSource().equals(sumDodatn)) updateInfo("suma dodatnih = " + lab3.findSumDodatn());
            if (e.getSource().equals(exit));
        }
    };

    private void fullTable() {
        String[] bashka = new String[]{"x", "y", "index"};
        String[][] values = new String[lab3.findAmountOfshag()][3];
        for (int i = 0; i < lab3.findAmountOfshag(); i++) {
            double x = lab3.masX[i];
            NumberFormat formatter = NumberFormat.getNumberInstance();
            String s = formatter.format(x);
            values[i][0] = String.valueOf(s);
            values[i][1] = String.valueOf(lab3.masY[i]);
            values[i][2] = String.valueOf(i);
        }
        listAndInfoPanel.remove(1);
        list = new JTable(values, bashka);
        s2 = new JScrollPane(list);
        listAndInfoPanel.add(s2);
        listAndInfoPanel.updateUI();

    }

    private void updateInfo(String info) {
        infoField.setText("<html>" + infoField.getText() + "<br>" + "          " + info);
    }

    public static void main(String[] args) {
        new UserInterface();
    }


}
