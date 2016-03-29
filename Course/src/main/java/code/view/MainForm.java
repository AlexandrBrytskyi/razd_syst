package code.view;

import code.controller.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

@Component
public class MainForm extends JFrame {
    private JPanel mainPanel;
    private JTabbedPane tabbedPane1;
    private JButton createDiagram;
    private JPanel oneDecade;
    private JPanel twoDecade;
    private JPanel threeDecade;
    private JButton addCourseButton;

    @Autowired
    private Service service;

    public MainForm() throws HeadlessException {
        super();
        setSize(new Dimension(700, 600));
        setResizable(false);
        add(mainPanel);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setVisible(true);
    }


    public void initComponents() {
        initTables();
        initButtons();
    }

    private void initButtons() {
        addCourseButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new AddCourse(service);
            }
        });
        createDiagram.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new Diagram(service);
            }
        });
    }

    private void initTables() {
        oneDecade.add(new Table(1, service).getMainPanel());
        twoDecade.add(new Table(2, service).getMainPanel());
        threeDecade.add(new Table(3, service).getMainPanel());
    }

    public JPanel getMainPanel() {
        return mainPanel;
    }
}
