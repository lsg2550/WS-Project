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

    public User(String firstName, String lastName, String password, String studentID) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.password = password;
        this.studentID = studentID;
    }

    public User(String firstName, String lastName, String password, String studentID, String currentSemester) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.password = password;
        this.studentID = studentID;
        this.currentSemester = currentSemester;
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
        String userInfo = studentID
                + "\n" + firstName
                + "\n" + lastName
                + "\n" + password
                + "\n" + currentSemester;
        return userInfo;
    }

}
