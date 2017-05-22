package gui;

import javafx.application.Application;
import javafx.stage.Stage;
import utils.io.IO;

/**
 *
 * @author Luis
 */
public class Launcher extends Application {

    @Override
    public void start(Stage primaryStage) {
        GUI gui = new GUI(primaryStage);
        DisplayStage.init();
        DisplayMenu.init();
        DisplaySignIn.init();
        DisplayRegister.init();
        DisplayTableView.init();
        DisplayAddClass.init();
        DisplayRemoveClass.init();
        IO.init();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }

}
