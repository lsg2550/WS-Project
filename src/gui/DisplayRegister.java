package gui;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.Tooltip;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import user.User;

/**
 *
 * @author Luis
 */
public class DisplayRegister {

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
        TextField userIDInput = new TextField();
        TextField userFirstNameInput = new TextField();
        TextField userLastNameInput = new TextField();
        TextField userPassInput = new TextField();
        TextField userSemesterInput = new TextField();
        userIDInput.setPromptText("123456");
        userFirstNameInput.setPromptText("John");
        userLastNameInput.setPromptText("Doe");
        userPassInput.setPromptText("password");
        userSemesterInput.setPromptText("Fall-2015");
        userIDInput.setFocusTraversable(false);
        userFirstNameInput.setFocusTraversable(false);
        userLastNameInput.setFocusTraversable(false);
        userPassInput.setFocusTraversable(false);
        userSemesterInput.setFocusTraversable(false);

        //Button
        Button userSubmit = new Button("Register");
        userSubmit.setOnAction(e -> {
            if (userIDInput.getText().equals("") || userFirstNameInput.getText().equals("") || userLastNameInput.getText().equals("") || userPassInput.getText().equals("")) {
                System.out.println("Some Required Fields Were Not Filled Out.");
            } else {//
                if (!new File("docs/users/" + userIDInput.getText() + ".txt").exists()) {
                    File userFile = new File("docs/users/" + userIDInput.getText() + ".txt");
                    userFile.mkdirs();

                    User newUser;

                    if (userSemesterInput.getText().equals("")) {
                        newUser = new User(userFirstNameInput.getText(), userFirstNameInput.getText(), userPassInput.getText(), userIDInput.getText());
                    } else {
                        newUser = new User(userFirstNameInput.getText(), userFirstNameInput.getText(), userPassInput.getText(), userIDInput.getText(), userSemesterInput.getText());
                    }

                    try (BufferedWriter bw = new BufferedWriter(new FileWriter(userFile))) {
                        bw.write(newUser.toString());
                        bw.flush();
                        bw.close();
                    } catch (IOException ex) {
                        ex.printStackTrace();
                        System.out.println("Could Not Create A New User!");
                    }
                } else {
                    System.out.println("Account Already Exists!");
                }
                //
            }

        });

        //Warning Label
        Label userWarning = new Label("* - Are required!");
        userWarning.setTextFill(Color.RED);
        userWarning.setFont(Font.font(null, FontWeight.BOLD, 10));
        //Asterisk Label
        List<Label> asterisk = Arrays.asList(new Label("*"), new Label("*"), new Label("*"), new Label("*"));
        for (Label label : asterisk) {
            label.setTextFill(Color.RED);
            label.setFont(Font.font(null, FontWeight.BOLD, 10));
        }

        userForm.addColumn(0, new Label("Student ID: "), new Label("First Name:"),
                new Label("Last Name:"), new Label("Password: "), new Label("Semester:"));
        userForm.addColumn(1, userIDInput, userFirstNameInput, userLastNameInput, userPassInput, userSemesterInput);
        userForm.addColumn(2, (Node[]) asterisk.toArray());
        root.getChildren().addAll(userForm, userSubmit, userWarning);
        scene = new Scene(root, 300, 225);
    }

    protected static Scene getScene() {
        return scene;
    }

}
