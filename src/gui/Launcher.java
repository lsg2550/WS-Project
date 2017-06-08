package gui;

import assets.css.CSS;
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
        DisplayStage.init();
        DisplayMenu.init();
        DisplaySignIn.init();
        DisplayRegister.init();
        DisplayTableView.init();
        DisplayAddClass.init();
        DisplayRemoveClass.init();
        DisplayWarning.init();
        DisplayAbout.init();
        IO.init();
        CSS.init();
        GUI gui = new GUI(primaryStage);
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }

}
