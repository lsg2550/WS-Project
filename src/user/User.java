package user;

import java.util.ArrayList;

/**
 *
 * @author Luis
 */
public class User {

    /*Intended to be used with database, but for the time being will be used with a textfile*/
    private String firstName, lastName;
    private String studentID;
    private String password;
    private String currentSemester; //Can be null
    private final ArrayList<Classes> STUDENT_CLASSES = new ArrayList<>(10);

    public User() {

    }

    public User(String firstName, String lastName, String password, String studentID, String currentSemester) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.password = password;
        this.studentID = studentID;
        
        if (currentSemester == null || currentSemester.equals("")) {
            this.currentSemester = "N/A";
        } else {
            this.currentSemester = currentSemester;
        }
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getStudentID() {
        return studentID;
    }

    public void setStudentID(String studentID) {
        this.studentID = studentID;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getCurrentSemester() {
        if (currentSemester == null) {
            return "";
        } else {
            return currentSemester;
        }
    }

    public void setCurrentSemester(String currentSemester) {
        this.currentSemester = currentSemester;
    }

    public ArrayList<Classes> getClassesArrayList() {
        return STUDENT_CLASSES;
    }

    @Override
    public String toString() {
        StringBuilder userInfo = new StringBuilder();
        userInfo.append("ID: ").append(studentID);
        userInfo.append(System.lineSeparator());
        userInfo.append("FN: ").append(firstName);
        userInfo.append(System.lineSeparator());
        userInfo.append("LN: ").append(lastName);
        userInfo.append(System.lineSeparator());
        userInfo.append("PW: ").append(password);
        userInfo.append(System.lineSeparator());
        userInfo.append("SEM: ").append(currentSemester);
        return userInfo.toString();
    }

}
