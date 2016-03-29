package code.view;

import code.controller.Service;
import code.model.Valuta;
import code.model.ValutaType;
import net.sourceforge.jdatepicker.impl.DateComponentFormatter;
import net.sourceforge.jdatepicker.impl.JDatePanelImpl;
import net.sourceforge.jdatepicker.impl.JDatePickerImpl;
import net.sourceforge.jdatepicker.impl.SqlDateModel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Date;
import java.time.LocalDate;


public class AddCourse extends JFrame {
    private JComboBox typeComboBox;
    private JTextField valueField;
    private JButton addButton;
    private JPanel mainPanel;
    private JPanel datePanel;
    private Service service;
    private SqlDateModel model;
    private MainForm mainForm;

    public AddCourse(final Service service) {
        super();
        this.service = service;
        this.mainForm = mainForm;
        putTypeValues();
        initDatePanel();
        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (checkCourseDateField()) {
                    service.putNewValuta(new Valuta((ValutaType) typeComboBox.getSelectedItem(),
                            Double.valueOf(valueField.getText()), model.getValue().toLocalDate()));
                    JOptionPane.showMessageDialog(mainPanel, "Додано :)");
                } else {
                    JOptionPane.showMessageDialog(mainPanel, "Невірний курс, має бути число");
                }
            }
        });
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setSize(new Dimension(330, 200));
        setResizable(false);
        add(mainPanel);
        setVisible(true);
    }

    private void initDatePanel() {
        model = new SqlDateModel(Date.valueOf(LocalDate.now()));
        JDatePanelImpl panel = new JDatePanelImpl(model);
        JDatePickerImpl picker = new JDatePickerImpl(panel, new DateComponentFormatter());
        picker.setEnabled(true);
        datePanel.add(picker);
    }

    private void putTypeValues() {
        for (ValutaType valutaType : ValutaType.values()) {
            typeComboBox.addItem(valutaType);
        }
        typeComboBox.setSelectedIndex(0);
    }

    private boolean checkCourseDateField() {
        try {
            Double.valueOf(valueField.getText());
            if (LocalDate.now().compareTo(model.getValue().toLocalDate()) < 0)
                return false;
        } catch (NumberFormatException e) {
            return false;
        }
        return true;
    }
}
