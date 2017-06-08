package gui;

import assets.css.CSS;
import assets.icon.Icon;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

/**
 *
 * @author Luis
 */
class GUI {

    private Stage primaryStage;

    protected GUI(Stage primaryStage) {
        this.primaryStage = primaryStage;
        display();
    }

    private void display() {
        //Root
        BorderPane root = new BorderPane();

        //Children
        root.setTop(DisplayMenu.getDISPLAY_MENUBAR());
        root.setCenter(DisplayTableView.getDISPLAY_CLASSES_TABLEVIEW());
        Scene scene = new Scene(root, 800, 600);
        scene.getStylesheets().add(CSS.getCSS_PATH());

        //Stage
        primaryStage.setTitle("Weekly Schedule");
        primaryStage.getIcons().add(Icon.STAGE_ICON);
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}
