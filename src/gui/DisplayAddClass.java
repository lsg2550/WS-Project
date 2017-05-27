package gui;

import java.util.Arrays;
import java.util.List;
import javafx.event.ActionEvent;
import javafx.geometry.Pos;
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
import user.Classes;
import utils.io.Save;

/**
 *
 * @author Luis
 */
class DisplayAddClass {

    //TextField
    private static final TextField CLASS_ID_INPUT = new TextField(),
            CLASS_NAME_INPUT = new TextField(),
            CLASS_LOCATION_INPUT = new TextField();
    //ComboBox
    private static final ComboBox TIME_FROM_HOUR_CB = new ComboBox(),
            TIME_FROM_MINUTE_CB = new ComboBox(),
            TIME_FROM_PERIOD_CB = new ComboBox(),
            TIME_TO_HOUR_CB = new ComboBox(),
            TIME_TO_MINUTE_CB = new ComboBox(),
            TIME_TO_PERIOD_CB = new ComboBox();
    //CheckBoxes
    private static final CheckBox MONDAY_CHB = new CheckBox("M"),
            TUESDAY_CHB = new CheckBox("T"),
            WEDNESDAY_CHB = new CheckBox("W"),
            THURSDAY_CHB = new CheckBox("Th"),
            FRIDAY_CHB = new CheckBox("F"),
            SATURDAY_CHB = new CheckBox("Sat"),
            SUNDAY_CHB = new CheckBox("Sun");
    //Scene
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

        //ComboBox
        inputHour(TIME_FROM_HOUR_CB);
        inputHour(TIME_TO_HOUR_CB);
        inputMinutes(TIME_FROM_MINUTE_CB);
        inputMinutes(TIME_TO_MINUTE_CB);
        inputPeriod(TIME_FROM_PERIOD_CB);
        inputPeriod(TIME_TO_PERIOD_CB);

        //HBox
        HBox daysOfTheWeekHB = new HBox(5);
        daysOfTheWeekHB.setAlignment(Pos.CENTER);
        daysOfTheWeekHB.getChildren().addAll(MONDAY_CHB, TUESDAY_CHB, WEDNESDAY_CHB,
                THURSDAY_CHB, FRIDAY_CHB, SATURDAY_CHB, SUNDAY_CHB);

        HBox timeFromHB = new HBox(5);
        timeFromHB.setAlignment(Pos.CENTER);
        timeFromHB.getChildren().addAll(TIME_FROM_HOUR_CB, new Label(":"), TIME_FROM_MINUTE_CB,
                TIME_FROM_PERIOD_CB);

        HBox timeToHB = new HBox(5);
        timeToHB.setAlignment(Pos.CENTER);
        timeToHB.getChildren().addAll(TIME_TO_HOUR_CB, new Label(":"), TIME_TO_MINUTE_CB,
                TIME_TO_PERIOD_CB);

        //Button
        Button userSubmit = new Button("Submit");
        userSubmit.setOnAction((ActionEvent e) -> {
            if (Save.currentUser != null) {
                /**
                 * Do Checks
                 */

                Save.currentUser.getClassesArrayList().add(
                        new Classes(MONDAY_CHB.isSelected(), TUESDAY_CHB.isSelected(),
                                WEDNESDAY_CHB.isSelected(), THURSDAY_CHB.isSelected(),
                                FRIDAY_CHB.isSelected(), SATURDAY_CHB.isSelected(),
                                SUNDAY_CHB.isSelected(),
                                returnTimeFromComboBox(TIME_FROM_HOUR_CB.getSelectionModel().getSelectedItem()), //
                                returnTimeFromComboBox(TIME_FROM_MINUTE_CB.getSelectionModel().getSelectedItem()), //
                                returnTimeFromComboBox(TIME_FROM_PERIOD_CB.getSelectionModel().getSelectedItem()),
                                returnTimeFromComboBox(TIME_TO_HOUR_CB.getSelectionModel().getSelectedItem()), //
                                returnTimeFromComboBox(TIME_TO_MINUTE_CB.getSelectionModel().getSelectedItem()), //
                                returnTimeFromComboBox(TIME_TO_PERIOD_CB.getSelectionModel().getSelectedItem()),
                                CLASS_ID_INPUT.getText(), CLASS_NAME_INPUT.getText(), CLASS_LOCATION_INPUT.getText()));
                DisplayStage.close();
                //System.out.println("Class Input: " + Save.currentUser.getClassesArrayList().get(0)); //Logging
            } else {
                System.out.println("You're not logged in!");
            }
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
                new Label("Class Location: "), new Label("Time From: "),
                new Label("Time To: "), new Label("Days: "));
        userForm.addColumn(1, CLASS_ID_INPUT, CLASS_NAME_INPUT, CLASS_LOCATION_INPUT, timeFromHB, timeToHB, daysOfTheWeekHB);
        userForm.addColumn(2, (Node[]) asterisk.toArray());
        root.getChildren().addAll(userForm, userSubmit, userWarning);
        scene = new Scene(root, 400, 235);
    }

    private static String returnTimeFromComboBox(Object time) {
        try {
            String temp = (String) time;
            return temp;
        } catch (ClassCastException e) {
            //Because we know that the values will only be considered string or int,
            //we know that the classcastexception will be from Integer -> String
            return Integer.toString((int) time);
        }
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

    private static void clearFields() { //Called By Submit Button
        CLASS_ID_INPUT.setText("");
        CLASS_NAME_INPUT.setText("");
        CLASS_LOCATION_INPUT.setText("");
        TIME_FROM_HOUR_CB.getSelectionModel().selectFirst();
        TIME_FROM_MINUTE_CB.getSelectionModel().selectFirst();
        TIME_FROM_PERIOD_CB.getSelectionModel().selectFirst();
        TIME_TO_HOUR_CB.getSelectionModel().selectFirst();
        TIME_TO_MINUTE_CB.getSelectionModel().selectFirst();
        TIME_TO_PERIOD_CB.getSelectionModel().selectFirst();
        MONDAY_CHB.setSelected(false);
        TUESDAY_CHB.setSelected(false);
        WEDNESDAY_CHB.setSelected(false);
        THURSDAY_CHB.setSelected(false);
        FRIDAY_CHB.setSelected(false);
        SATURDAY_CHB.setSelected(false);
        SUNDAY_CHB.setSelected(false);
    }

    protected static Scene getScene() {
        clearFields();
        return scene;
    }

}
