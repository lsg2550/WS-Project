package gui;

import javafx.collections.FXCollections;
import javafx.collections.ListChangeListener;
import javafx.collections.ObservableList;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import user.Classes;

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
//        tableColumnTime.setCellValueFactory(new PropertyValueFactory<>("itemName"));
//        tableColumnMonday.setCellValueFactory(new PropertyValueFactory<>("itemDesc"));
//        tableColumnTuesday.setCellValueFactory(new PropertyValueFactory<>("invStock"));
//        tableColumnWednesday.setCellValueFactory(new PropertyValueFactory<>("itemDesc"));
//        tableColumnThursday.setCellValueFactory(new PropertyValueFactory<>("invStock"));
//        tableColumnFriday.setCellValueFactory(new PropertyValueFactory<>("itemDesc"));
//        tableColumnSaturday.setCellValueFactory(new PropertyValueFactory<>("invStock"));
//        tableColumnSunday.setCellValueFactory(new PropertyValueFactory<>("invStock"));
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

    protected static void addData() {
        /**
         * Grab Info from Save.currentUser and put it into the tableview
         */

        DISPLAY_CLASSES_TABLEVIEW.setItems(DISPLAY_CLASSES_OBSERVABLELIST);
    }

    protected static TableView<Classes> getDISPLAY_CLASSES_TABLEVIEW() {
        return DISPLAY_CLASSES_TABLEVIEW;
    }

}
