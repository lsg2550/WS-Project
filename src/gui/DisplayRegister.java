package gui;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import user.User;
import utils.io.IO;
import utils.io.Sanitize;

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

        //Button
        Button userSubmit = new Button("Register");
        userSubmit.setOnAction(e -> {
            if (Sanitize.checkForEmptyString(userIDInput.getText())
                    || Sanitize.checkForEmptyString(userFirstNameInput.getText())
                    || Sanitize.checkForEmptyString(userLastNameInput.getText())
                    || Sanitize.checkForEmptyString(userPassInput.getText())) {
                System.out.println("Some Required Fields Were Not Filled Out.");
            } else if (Sanitize.checkForRandomSymbols(userIDInput.getText())
                    || Sanitize.checkForRandomSymbols(userFirstNameInput.getText())
                    || Sanitize.checkForRandomSymbols(userLastNameInput.getText())) {
                System.out.println("Some Fields Have Special Symbols.");
            } else if (Sanitize.checkForDigits(userFirstNameInput.getText())
                    || Sanitize.checkForDigits(userLastNameInput.getText())) {
                System.out.println("First And/Or Last Name Have Digits.");
            } else {
                if (!new File(IO.getDOCS().toString() + "/" + userIDInput.getText() + ".txt").exists()) {
                    File userFile = new File(IO.getDOCS().toString() + "/" + userIDInput.getText() + ".txt"); //Creates User File

                    User newUser; //Creates New User
                    if (userSemesterInput.getText().equals("")) {
                        newUser = new User(userFirstNameInput.getText(), userLastNameInput.getText(), userPassInput.getText(), userIDInput.getText());
                    } else {
                        newUser = new User(userFirstNameInput.getText(), userLastNameInput.getText(), userPassInput.getText(), userIDInput.getText(), userSemesterInput.getText());
                    }

                    //Writes Info To User File
                    try (BufferedWriter bw = new BufferedWriter(new FileWriter(userFile))) {
                        bw.write(newUser.toString());
                        bw.flush();
                        bw.close();
                        System.out.println("Please Log-In With Your New Account!");
                    } catch (IOException ex) {
                        ex.printStackTrace();
                        System.out.println("Could Not Create A New User!");
                    } finally {
                        DisplayStage.close();
                    }
                } else {
                    System.out.println("Account Already Exists!");
                }
            }

            //Clear TextFields
            userIDInput.setText("");
            userFirstNameInput.setText("");
            userLastNameInput.setText("");
            userPassInput.setText("");
            userSemesterInput.setText("");
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

        //Children
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
