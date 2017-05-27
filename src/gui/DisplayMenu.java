package gui;

import javafx.application.Platform;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.control.SeparatorMenuItem;
import utils.io.Save;

/**
 *
 * @author Luis
 */
class DisplayMenu {

    private static final MenuBar DISPLAY_MENUBAR = new MenuBar();

    protected static void init() {
        //Files
        Menu file = new Menu("File");
        MenuItem fileSignIn = new MenuItem("Sign In"), fileRegister = new MenuItem("Register"),
                fileSave = new MenuItem("Save"), fileExit = new MenuItem("Exit");
        file.getItems().addAll(fileSignIn, fileRegister, new SeparatorMenuItem(), fileSave, new SeparatorMenuItem(), fileExit);
        fileSignIn.setOnAction(e -> {
            DisplayStage.setResizable(false);
            DisplayStage.setScene(DisplaySignIn.getScene());
            DisplayStage.show();
        });
        fileRegister.setOnAction(e -> {
            DisplayStage.setResizable(false);
            DisplayStage.setScene(DisplayRegister.getScene());
            DisplayStage.show();
        });
        fileSave.setOnAction(e -> {
            if (Save.currentUser != null) {
                Save.saveInfo();
            }
        });
        fileExit.setOnAction(e -> {
            Platform.exit();
        });

        //Operations
        Menu userOperations = new Menu("Operations");
        MenuItem userAddClass = new MenuItem("Add Class"),
                userRemoveClass = new MenuItem("Remove Class");
        userOperations.getItems().addAll(userAddClass, userRemoveClass);
        userAddClass.setOnAction(e -> {
            DisplayStage.setResizable(false);
            DisplayStage.setScene(DisplayAddClass.getScene());
            DisplayStage.show();
        });
        userRemoveClass.setOnAction(e -> {
            DisplayStage.setResizable(false);
            DisplayStage.setScene(DisplayRemoveClass.getScene());
            DisplayStage.show();
        });

        //About
        Menu help = new Menu("Help");
        MenuItem helpAbout = new MenuItem("About");
        help.getItems().add(helpAbout);
        helpAbout.setOnAction(e -> {
            DisplayStage.setResizable(false);
            DisplayStage.setScene(DisplayAbout.getScene());
            DisplayStage.show();
        });

        //Add Children
        DISPLAY_MENUBAR.getMenus().addAll(file, userOperations, help);
    }

    protected static MenuBar getDISPLAY_MENUBAR() {
        return DISPLAY_MENUBAR;
    }

}
