package gui;

import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.layout.VBox;
import utils.io.Save;

/**
 *
 * @author Luis
 */
class DisplayRemoveClass {

    private static Scene scene;
    private static final ComboBox USER_CLASSES_TO_BE_REMOVED = new ComboBox();

    protected static void init() {
        //Root
        VBox root = new VBox(5);
        root.setAlignment(Pos.CENTER);

        //Button
        Button removeClass = new Button("Remove");
        removeClass.setOnAction(e -> {
            if (Save.isUserLoggedIn()) {
                if (!USER_CLASSES_TO_BE_REMOVED.getItems().isEmpty()) {
                    Save.currentUser.getClassesArrayList().remove(USER_CLASSES_TO_BE_REMOVED.getSelectionModel().getSelectedIndex());
                    DisplayTableView.addData();
                    DisplayStage.close();
                }
            }
        });

        //Children
        root.getChildren().addAll(USER_CLASSES_TO_BE_REMOVED, removeClass);
        scene = new Scene(root, 200, 150);
    }

    private static void fillComboBox() {
        if (Save.currentUser != null) {
            USER_CLASSES_TO_BE_REMOVED.getItems().clear();
            Save.currentUser.getClassesArrayList().forEach((classes) -> {
                USER_CLASSES_TO_BE_REMOVED.getItems().add(classes.getClassID() + "-" + classes.getClassName());
                //System.out.println("Index:" + USER_CLASSES_TO_BE_REMOVED.getItems().indexOf(classes)); //Logging
            });
            USER_CLASSES_TO_BE_REMOVED.getSelectionModel().selectFirst();
        }
    }

    protected static Scene getScene() {
        fillComboBox();
        return scene;
    }
}
