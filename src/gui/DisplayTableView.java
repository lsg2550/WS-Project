package gui;

import javafx.scene.control.TableView;
import user.Classes;

/**
 *
 * @author Luis
 */
public class DisplayTableView {

    private static final TableView<Classes> DISPLAY_CLASSES_TABLEVIEW = new TableView<>();

    protected static void init() {
        
    }

    public static TableView<Classes> getDISPLAY_CLASSES_TABLEVIEW() {
        return DISPLAY_CLASSES_TABLEVIEW;
    }

}
