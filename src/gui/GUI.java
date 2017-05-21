package gui;

import assets.icon.Icon;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

/**
 *
 * @author Luis
 */
public class GUI {
    
    private Stage primaryStage;
    
    protected GUI(Stage primaryStage) {
        this.primaryStage = primaryStage;
        display();
    }
    
    private void display() {
        BorderPane root = new BorderPane();
        root.setTop(DisplayMenu.getDISPLAY_MENUBAR());
        
        Scene scene = new Scene(root, 800, 600);
        primaryStage.setTitle("Weekly Schedule");
        primaryStage.getIcons().add(Icon.ICON);
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}
