package javabegin.demo;

import java.sql.*;

import javax.swing.*;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;

public class Start {

    public static void main(String[] args) {

        try (Connection con = SQLiteConnection.getConnection()) {// соединение с БД в конце блока try закроется автоматически
            TableModel mod = new MyTableModel(con, "CarBrand");

            JTable jtable = new JTable(mod);

//            jtable.setAutoCreateRowSorter(true);
            TableRowSorter<TableModel> sorter = new TableRowSorter<TableModel>(mod);

            sorter.setComparator(2, new MyComparator());

            jtable.setRowSorter(sorter);

            MyTableRenderer cellRenderer = new MyTableRenderer();
            jtable.setDefaultRenderer(Object.class, cellRenderer);

            JScrollPane scroller = new JScrollPane(jtable, ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED, ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED);

            JFrame frame = new JFrame("Загрузка данных в JTable");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.getContentPane().add(scroller);
            frame.pack();
            frame.setVisible(true);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
