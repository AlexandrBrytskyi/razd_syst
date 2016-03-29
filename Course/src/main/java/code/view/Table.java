package code.view;

import code.controller.Service;
import code.model.Valuta;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;


public class Table {
    private JPanel mainPanel;
    private JTable table;
    private JButton removeSelectedButton;
    private JScrollPane scrollPane;
    private Valuta selectedValuta;
    private int decade;
    private code.controller.Service service;
    public ValutaTableModel tableModel;

    public Table(int decade, final Service service) {
        this.decade = decade;
        this.service = service;
        table.setModel(new ValutaTableModel(new String[]{"Валюта", "Час", "Курс"}));
        removeSelectedButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (selectedValuta == null) {
                    JOptionPane.showMessageDialog(mainPanel, "Виберіть, що видалити");
                } else {
                    service.removeValuta(selectedValuta);
                    JOptionPane.showMessageDialog(mainPanel, "Видалено!");
                    tableModel.updateList();
                    table.updateUI();
                }
            }
        });
        service.registerTable(this);
    }

    private class ValutaTableModel extends AbstractTableModel {

        private java.util.List<Valuta> valutas;
        private String[] colNames;


        public ValutaTableModel(String[] colNames) {
            this.colNames = colNames;
            updateList();
            table.getSelectionModel().addListSelectionListener(listSelectionListener);
            tableModel = this;
            initSorter();
        }

        private void initSorter() {
            TableRowSorter<TableModel> sorter = new TableRowSorter<TableModel>(this);
            table.setRowSorter(sorter);
            List<RowSorter.SortKey> sortKeys = new ArrayList<RowSorter.SortKey>();
            sortKeys.add(new RowSorter.SortKey(0, SortOrder.ASCENDING));
            sorter.setSortKeys(sortKeys);
        }


        private ListSelectionListener listSelectionListener = new ListSelectionListener() {
            public void valueChanged(ListSelectionEvent e) {
                int selectedIndex = table.getSelectedRow();
                selectedValuta = valutas.get(selectedIndex);
            }
        };


        public int getRowCount() {
            if (valutas != null) return valutas.size();
            return 0;
        }

        public int getColumnCount() {
            return colNames.length;
        }

        @Override
        public String getColumnName(int column) {
            return colNames[column];
        }

        public Object getValueAt(int rowIndex, int columnIndex) {
            Valuta selected = valutas.get(rowIndex);

            switch (columnIndex) {
                case 0:
                    return selected.getType();
                case 1:
                    return selected.getAddedTime();
                case 2:
                    return selected.getCourseValue();
                default:
                    return null;
            }
        }

        public void updateList() {
            if (service != null) {
                this.valutas = service.getAllValutaForDecade(decade);
            }
        }

    }

    public JPanel getMainPanel() {
        return mainPanel;
    }

    public int getDecade() {
        return decade;
    }

    public void updateUI() {
        tableModel.updateList();
        table.updateUI();
    }
}
