package lab5.ui;

import razd_syst.lab5.model.*;
import razd_syst.lab5.service.UserServ;
import razd_syst.lab5.service.UserService;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.ArrayList;

/**
 * Created with IntelliJ IDEA.
 * User: huyti
 * Date: 27.09.15
 * Time: 22:04
 * To change this template use File | Settings | File Templates.
 */
public class UserInterf {
    private UserService service;


    private JTabbedPane tabbedPane1;
    private JRadioButton konstruktorRadioButton;
    private JRadioButton ballRadioButton;
    private JRadioButton lialkaRadioButton;
    private JRadioButton cubesRadioButton;
    private JTextField textField2;
    private JTextField textField3;
    private JTextField textField4;
    private JButton addButton;
    private JButton showAllButton;
    private JButton showKonstruktorsButton;
    private JPanel groundPanel;
    private JPanel southPanel;
    private JPanel northPanel;
    private JPanel textFieldsPanel;
    private JPanel labelPanels;
    private JPanel radiopan;
    private JPanel radioPanel;
    private JLabel label2;
    private JLabel label3;
    private JLabel label4;
    private JTable table1;
    private JPanel igrushki;
    private JTextField fileField;
    private JButton editFileButton;
    private JPanel scrollPanel;

    public UserInterf() throws IOException, ClassNotFoundException {

        label2.setText("Enter price");
        label3.setText("Min-max age");
        label4.setText("Kst konstrukziy");

        ButtonGroup bg = new ButtonGroup();
        bg.add(konstruktorRadioButton);
        bg.add(ballRadioButton);
        bg.add(lialkaRadioButton);
        bg.add(cubesRadioButton);
        table1 = new JTable();
        igrushki.add(table1);
        addButton.addActionListener(add);
        showAllButton.addActionListener(showAll);
        showKonstruktorsButton.addActionListener(showKonstr);

        ballRadioButton.addActionListener(l);
        konstruktorRadioButton.addActionListener(l);
        lialkaRadioButton.addActionListener(l);
        cubesRadioButton.addActionListener(l);

        editFileButton.addActionListener(editFileListener);
    }

    ActionListener editFileListener = new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            try {
                service = new UserServ(fileField.getText());
            } catch (IOException e1) {
                e1.printStackTrace();
            } catch (ClassNotFoundException e1) {
                e1.printStackTrace();
            }
        }
    };

    ActionListener l = new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            if (ballRadioButton.isSelected()) label4.setText("Enter weight");
            if (konstruktorRadioButton.isSelected()) label4.setText("Kst konstrukziy");
            if (lialkaRadioButton.isSelected()) label4.setText("Enter length ");
            if (cubesRadioButton.isSelected()) label4.setText("Amount of cubes");
        }
    };


    ActionListener add = new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            int a;
            int b;
            String s = textField3.getText();
            String vala = "";
            String valb = "";
            boolean is = false;
            int i = 0;
            while (!is) {
                if (s.charAt(i) != '-') {
                    vala = vala + s.charAt(i);
                    i++;
                } else {
                    valb = s.substring(i + 1);
                    is = true;
                }
            }
            a = Integer.valueOf(vala);
            b = Integer.valueOf(valb);
            if (konstruktorRadioButton.isSelected()) {
                try {
                    if (textField2.getText() != null && textField3.getText() != null && textField4.getText() != null) {
                        service.addIgrushka(new Konstruktor("Konstruktor", Integer.valueOf(textField2.getText()),
                                new MyEntry(Integer.valueOf(a), Integer.valueOf(b)), Integer.valueOf(textField4.getText())));
                    }
                } catch (IOException e1) {
                    e1.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
                }
            }
            if (ballRadioButton.isSelected()) {
                try {
                    if (textField2.getText() != null && textField3.getText() != null && textField4.getText() != null) {
                        service.addIgrushka(new Ball("Ball", Integer.valueOf(textField2.getText()),
                                new MyEntry(Integer.valueOf(a), Integer.valueOf(b)), Integer.valueOf(textField4.getText())));
                    }
                } catch (IOException e1) {
                    e1.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
                }
            }
            if (lialkaRadioButton.isSelected()) {
                try {
                    if (textField2.getText() != null && textField3.getText() != null && textField4.getText() != null) {
                        service.addIgrushka(new Lialka("Lialka", Integer.valueOf(textField2.getText()),
                                new MyEntry(Integer.valueOf(a), Integer.valueOf(b)), Integer.valueOf(textField4.getText())));
                    }
                } catch (IOException e1) {
                    e1.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
                }
            }
            if (cubesRadioButton.isSelected()) {
                try {
                    if (textField2.getText() != null && textField3.getText() != null && textField4.getText() != null) {
                        service.addIgrushka(new Cubes("Cubes", Integer.valueOf(textField2.getText()),
                                new MyEntry(Integer.valueOf(a), Integer.valueOf(b)), Integer.valueOf(textField4.getText())));
                    }
                } catch (IOException e1) {
                    e1.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
                }
            }
            setTextNull();
        }
    };

    private void setTextNull() {
        textField2.setText(null);
        textField3.setText(null);
        textField4.setText(null);
    }

    ActionListener showAll = new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            String[] bashka;
            String[][] values;
            if (konstruktorRadioButton.isSelected()) {
                bashka = new String[]{"Name", "Price", "AgeLimit", "Amount of Constr.."};
                ArrayList<Konstruktor> list = service.showKonstruktors();
                values = new String[list.size()][4];
                for (int i = 0; i < list.size(); i++) {
                    String ageog = "from " + list.get(i).getAgeOgr().getKey() + " to " +
                            list.get(i).getAgeOgr().getValue();
                    values[i][0] = list.get(i).getName();
                    values[i][1] = list.get(i).getPrice() / 100 + "grn" + list.get(i).getPrice() % 100 + "kop";
                    values[i][2] = ageog;
                    values[i][3] = list.get(i).getKstKonstrukziy() + "shtuk";
                }
                igrushki.remove(0);
                table1 = new JTable(values, bashka);
                JScrollPane js = new JScrollPane(table1);
                igrushki.add(js);
                igrushki.updateUI();
            }
            if (ballRadioButton.isSelected()) {
                bashka = new String[]{"Name", "Price", "AgeLimit", "Vaga"};
                ArrayList<Ball> list = service.showBalls();
                values = new String[list.size()][4];
                for (int i = 0; i < list.size(); i++) {
                    String ageog = "from " + list.get(i).getAgeOgr().getKey() + " to " +
                            list.get(i).getAgeOgr().getValue();
                    values[i][0] = list.get(i).getName();
                    values[i][1] = list.get(i).getPrice() / 100 + "grn" + list.get(i).getPrice() % 100 + "kop";
                    values[i][2] = ageog;
                    values[i][3] = list.get(i).getVaga() + "gram";
                }
                igrushki.remove(0);
                table1 = new JTable(values, bashka);
                JScrollPane js = new JScrollPane(table1);
                igrushki.add(js);
                igrushki.updateUI();
            }
            if (lialkaRadioButton.isSelected()) {
                bashka = new String[]{"Name", "Price", "AgeLimit", "Size"};
                ArrayList<Lialka> list = service.showLialka();
                values = new String[list.size()][4];
                for (int i = 0; i < list.size(); i++) {
                    String ageog = "from " + list.get(i).getAgeOgr().getKey() + " to " +
                            list.get(i).getAgeOgr().getValue();
                    values[i][0] = list.get(i).getName();
                    values[i][1] = list.get(i).getPrice() / 100 + "grn" + list.get(i).getPrice() % 100 + "kop";
                    values[i][2] = ageog;
                    values[i][3] = list.get(i).getRazmer() + "cm";
                }
                igrushki.remove(0);
                table1 = new JTable(values, bashka);
                JScrollPane js = new JScrollPane(table1);
                igrushki.add(js);
                igrushki.updateUI();
            }
            if (cubesRadioButton.isSelected()) {
                bashka = new String[]{"Name", "Price", "AgeLimit", "Amount of Cubes"};
                ArrayList<Cubes> list = service.showCubes();
                values = new String[list.size()][4];
                for (int i = 0; i < list.size(); i++) {
                    String ageog = "from " + list.get(i).getAgeOgr().getKey() + " to " +
                            list.get(i).getAgeOgr().getValue();
                    values[i][0] = list.get(i).getName();
                    values[i][1] = list.get(i).getPrice() / 100 + "grn" + list.get(i).getPrice() % 100 + "kop";
                    values[i][2] = ageog;
                    values[i][3] = list.get(i).getKst() + "shtuk v nabore";
                }
                igrushki.remove(0);
                table1 = new JTable(values, bashka);
                JScrollPane js = new JScrollPane(table1);
                igrushki.add(js);
                igrushki.updateUI();
            }
        }
    };

    ActionListener showKonstr = new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            konstruktorRadioButton.setSelected(true);

            String[] bashka;
            String[][] values;
            bashka = new String[]{"Name", "Price", "AgeLimit", "Amount of Constr.."};
            ArrayList<Konstruktor> list = service.showKonstruktors();
            values = new String[list.size()][4];
            for (int i = 0; i < list.size(); i++) {
                String ageog = "from " + list.get(i).getAgeOgr().getKey() + " to " +
                        list.get(i).getAgeOgr().getValue();
                values[i][0] = list.get(i).getName();
                values[i][1] = list.get(i).getPrice() / 100 + "grn" + list.get(i).getPrice() % 100 + "kop";
                values[i][2] = ageog;
                values[i][3] = list.get(i).getKstKonstrukziy() + "shtuk";
            }
            igrushki.remove(0);
            table1 = new JTable(values, bashka);
            JScrollPane js = new JScrollPane(table1);
            igrushki.add(js);
            igrushki.updateUI();

        }
    };

    public static void main(String[] args) throws IOException, ClassNotFoundException {
        JFrame frame = new JFrame("Base of Igrashki");
        frame.setContentPane(new UserInterf().groundPanel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }


    private void createUIComponents() {
        igrushki = new JPanel(new GridLayout());
    }
}
