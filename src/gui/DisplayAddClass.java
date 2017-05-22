package gui;

import java.util.Arrays;
import java.util.List;
import javafx.event.ActionEvent;
import javafx.geometry.HPos;
import javafx.geometry.Pos;
import javafx.geometry.VPos;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.TextAlignment;

/**
 *
 * @author Luis
 */
public class DisplayAddClass {

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
        TextField classIDInput = new TextField();
        TextField classNameInput = new TextField();
        TextField classLocationInput = new TextField();

        //ComboBox
        ComboBox timeFromHourCB = new ComboBox();
        ComboBox timeFromMinuteCB = new ComboBox();
        ComboBox timeFromPeriodCB = new ComboBox();
        ComboBox timeToHourCB = new ComboBox();
        ComboBox timeToMinuteCB = new ComboBox();
        ComboBox timeToPeriodCB = new ComboBox();
        inputHour(timeFromHourCB);
        inputHour(timeToHourCB);
        inputMinutes(timeFromMinuteCB);
        inputMinutes(timeToMinuteCB);
        inputPeriod(timeFromPeriodCB);
        inputPeriod(timeToPeriodCB);

        //CheckBoxes
        CheckBox mondayChB = new CheckBox("M");
        CheckBox tuesdayChB = new CheckBox("T");
        CheckBox wednesdayChB = new CheckBox("W");
        CheckBox thursdayChB = new CheckBox("Th");
        CheckBox fridayChB = new CheckBox("F");
        CheckBox saturdayChB = new CheckBox("Sat");
        CheckBox sundayChB = new CheckBox("Sun");

        //HBox
        HBox daysOfTheWeekHB = new HBox(5);
        daysOfTheWeekHB.setAlignment(Pos.CENTER);
        daysOfTheWeekHB.getChildren().addAll(mondayChB, tuesdayChB, wednesdayChB,
                thursdayChB, fridayChB, saturdayChB, sundayChB);

        HBox timeFromHB = new HBox(5);
        timeFromHB.setAlignment(Pos.CENTER);
        timeFromHB.getChildren().addAll(timeFromHourCB, new Label(":"), timeFromMinuteCB);

        HBox timeToHB = new HBox(5);
        timeToHB.setAlignment(Pos.CENTER);
        timeToHB.getChildren().addAll(timeToHourCB, new Label(":"), timeToMinuteCB);

        //Button
        Button userSubmit = new Button("Submit");
        userSubmit.setOnAction((ActionEvent e) -> {
            DisplayStage.close();
        });

        //Warning Label
        Label userWarning = new Label("* - Are required!");
        userWarning.setTextFill(Color.RED);
        userWarning.setTextAlignment(TextAlignment.CENTER);
        userWarning.setWrapText(true);
        userWarning.setFont(Font.font(null, FontWeight.BOLD, 10));
        //Asterisk Label
        List<Label> asterisk = Arrays.asList(new Label("*"), new Label("*"),
                new Label(""), new Label("*"), new Label("*"), new Label("*"));
        for (Label label : asterisk) {
            label.setTextFill(Color.RED);
            label.setFont(Font.font(null, FontWeight.BOLD, 10));
        }

        //Children
        userForm.addColumn(0, new Label("Class ID: "), new Label("Class Name: "),
                new Label("Class Location: "), new Label("Time From: "), new Label("Time To: "),
                new Label("Days: "));
        userForm.addColumn(1, classIDInput, classNameInput, classLocationInput, timeFromHB, timeToHB, daysOfTheWeekHB);
        userForm.addColumn(2, (Node[]) asterisk.toArray());
        root.getChildren().addAll(userForm, userSubmit, userWarning);
        scene = new Scene(root, 400, 235);
    }

    private static void inputPeriod(ComboBox comboBox) {
        comboBox.getItems().addAll("AM", "PM");
        comboBox.setValue(comboBox.getItems().get(0));
    }

    private static void inputMinutes(ComboBox comboBox) {
        for (int i = 0; i < 60; i += 5) {
            if (Integer.toString(i).length() == 1) {
                comboBox.getItems().add("0" + Integer.toString(i));
            } else {
                comboBox.getItems().add(i);
            }
        }
        comboBox.setValue(comboBox.getItems().get(0));
    }

    private static void inputHour(ComboBox comboBox) {
        for (int i = 1; i <= 12; i++) {
            if (Integer.toString(i).length() == 1) {
                comboBox.getItems().add("0" + Integer.toString(i));
            } else {
                comboBox.getItems().add(i);
            }
        }
        comboBox.setValue(comboBox.getItems().get(0));
    }

    public static Scene getScene() {
        return scene;
    }

}
