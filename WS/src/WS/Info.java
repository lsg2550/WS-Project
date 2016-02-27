package WeeklyScheduler;

import java.util.Scanner;

public class Info {

    private String fname;
    private String lname;
    private String idNum;
    private String semYear;

    public void userInput() {
        Scanner input = new Scanner(System.in);
        System.out.println("Please type your first and last name then press enter. e.g 'John Doe'");
        fname = input.next();
        lname = input.next();
        System.out.println("Please type your ID number then press enter.");
        idNum = input.next();
        System.out.println("Please type the semester-year you're registered for. e.g 'Fall-2015'");
        semYear = input.next();
    }

    public void printInfo() {
        System.out.println("\t\t\tPERSONAL INFORMATION");
        System.out.println("\t--------------------------------------------------------------");
        System.out.println("\t\t\tFirst Name: " + fname);
        System.out.println("\t\t\tLast Name: " + lname);
        System.out.println("\t\t\tID Number: " + idNum);
        System.out.println("\t\t\tSemester: " + semYear);
        System.out.println("\t--------------------------------------------------------------");
    }
}
