package gui;

import java.io.File;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;

/**
 *
 * @author Luis
 */
public class DisplaySignIn {

    private static Scene scene;

    protected static void init() {
        //Root
        VBox root = new VBox(5);
        root.setAlignment(Pos.CENTER);

        //Form
        GridPane userForm = new GridPane();
        userForm.setHgap(2.0);
        userForm.setHgap(2.0);
        userForm.setAlignment(Pos.CENTER);

        //TextField
        TextField userNameInput = new TextField();
        PasswordField userPassInput = new PasswordField();

        //Button
        Button userSubmit = new Button("Sign-In");
        userSubmit.setOnAction(e -> {
            if (new File("docs/users/" + userNameInput + ".txt").exists()) {
                System.out.println("Logged In!");
            } else {
                System.out.println("User doesn't exist or password is entered incorrectly.");
            }
        });

        //Warning Label
        Label userWarning = new Label("If you're already signed in, you will be logged out without saving!");
        userWarning.setTextFill(Color.RED);
        userWarning.setFont(Font.font(null, FontWeight.BOLD, 10));

        userForm.addColumn(0, new Label("Student ID: "), new Label("Password: "));
        userForm.addColumn(1, userNameInput, userPassInput);
        root.getChildren().addAll(userForm, userSubmit, userWarning);
        scene = new Scene(root, 250, 175);
    }

    protected static Scene getScene() {
        return scene;
    }

}
