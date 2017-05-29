package gui;

import javafx.collections.FXCollections;
import javafx.collections.ListChangeListener;
import javafx.collections.ObservableList;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import user.Classes;
import utils.io.Save;

/**
 *
 * @author Luis
 */
class DisplayTableView {

    private static final TableView<Classes> DISPLAY_CLASSES_TABLEVIEW = new TableView<Classes>();
    private static final ObservableList<Classes> DISPLAY_CLASSES_OBSERVABLELIST = FXCollections.observableArrayList();

    protected static void init() {
        //TableColumns
        TableColumn tableColumnTime = new TableColumn("Time");
        TableColumn tableColumnMonday = new TableColumn("Monday");
        TableColumn tableColumnTuesday = new TableColumn("Tuesday");
        TableColumn tableColumnWednesday = new TableColumn("Wednesday");
        TableColumn tableColumnThursday = new TableColumn("Thursday");
        TableColumn tableColumnFriday = new TableColumn("Friday");
        TableColumn tableColumnSaturday = new TableColumn("Saturday");
        TableColumn tableColumnSunday = new TableColumn("Sunday");

        //Array
        final TableColumn[] tableColumn = {tableColumnTime, tableColumnMonday,
            tableColumnTuesday, tableColumnWednesday, tableColumnThursday,
            tableColumnFriday, tableColumnSaturday, tableColumnSunday};

        //Sortable
        tableColumnTime.setSortable(false);
        tableColumnMonday.setSortable(false);
        tableColumnTuesday.setSortable(false);
        tableColumnWednesday.setSortable(false);
        tableColumnThursday.setSortable(false);
        tableColumnFriday.setSortable(false);
        tableColumnSaturday.setSortable(false);
        tableColumnSunday.setSortable(false);

        //Editable
        tableColumnTime.setEditable(false);
        tableColumnMonday.setEditable(false);
        tableColumnTuesday.setEditable(false);
        tableColumnWednesday.setEditable(false);
        tableColumnThursday.setEditable(false);
        tableColumnFriday.setEditable(false);
        tableColumnSaturday.setEditable(false);
        tableColumnSunday.setEditable(false);

        //Resizable
        tableColumnTime.setResizable(false);
        tableColumnMonday.setResizable(false);
        tableColumnTuesday.setResizable(false);
        tableColumnWednesday.setResizable(false);
        tableColumnThursday.setResizable(false);
        tableColumnFriday.setResizable(false);
        tableColumnSaturday.setResizable(false);
        tableColumnSunday.setResizable(false);

        //Cell Value Factory
        //tableColumnTime.setCellValueFactory(new PropertyValueFactory<>("itemName"));
        tableColumnMonday.setCellValueFactory(new PropertyValueFactory<>("monday"));
        tableColumnTuesday.setCellValueFactory(new PropertyValueFactory<>("tuesday"));
        tableColumnWednesday.setCellValueFactory(new PropertyValueFactory<>("wednesday"));
        tableColumnThursday.setCellValueFactory(new PropertyValueFactory<>("thursday"));
        tableColumnFriday.setCellValueFactory(new PropertyValueFactory<>("friday"));
        tableColumnSaturday.setCellValueFactory(new PropertyValueFactory<>("saturday"));
        tableColumnSunday.setCellValueFactory(new PropertyValueFactory<>("sunday"));

        DISPLAY_CLASSES_TABLEVIEW.setFixedCellSize(35);
        DISPLAY_CLASSES_TABLEVIEW.setEditable(false);
        DISPLAY_CLASSES_TABLEVIEW.getColumns().addAll(tableColumn);
        DISPLAY_CLASSES_TABLEVIEW.getColumns().addListener(new ListChangeListener<TableColumn<Classes, ?>>() {
            boolean suspsended = false;

            @Override
            public void onChanged(ListChangeListener.Change<? extends TableColumn<Classes, ?>> c) {
                c.next();
                if (c.wasReplaced() && !suspsended) {
                    this.suspsended = true;
                    DISPLAY_CLASSES_TABLEVIEW.getColumns().setAll(tableColumn);
                    this.suspsended = false;
                }
            }
        });
    }

    private static void generateTime() {
        /**
         * Generate Time for Time Column
         */

        for (int i = 1; i <= 12; i++) {//Hours
            for (int j = 0; j < 60; j += 5) { //Minutes
                if (Integer.toString(j).length() == 1) {
                    System.out.println("Time: " + i + ":0" + j);
                } else {
                    System.out.println("Time: " + i + ":" + j);
                }
            }
        }
    }

    protected static void addData() {
        DISPLAY_CLASSES_OBSERVABLELIST.clear();
        DISPLAY_CLASSES_OBSERVABLELIST.addAll(Save.currentUser.getClassesArrayList());
        DISPLAY_CLASSES_TABLEVIEW.setItems(DISPLAY_CLASSES_OBSERVABLELIST);
    }

    protected static TableView<Classes> getDISPLAY_CLASSES_TABLEVIEW() {
        return DISPLAY_CLASSES_TABLEVIEW;
    }

}
