package gui;

import javafx.application.Application;
import javafx.stage.Stage;

/**
 *
 * @author Luis
 */
public class Launcher extends Application {

    @Override
    public void start(Stage primaryStage) {
        new GUI(primaryStage);
        DisplayStage.init();
        DisplayMenu.init();
        DisplaySignIn.init();
        DisplayRegister.init();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }

}
