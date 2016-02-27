package WeeklyScheduler;

import java.util.Scanner;

public class Courses {

    private String[] courseName, courseDesc, location, roomNM, timeF, timeT;
    private boolean[][] day;
    private int amt;
    private Scanner input = new Scanner(System.in);

    public void userInput() {
        System.out.println("Enter the amount of courses you're taking.(Currently max amount of classes is 3)");
        amt = input.nextInt();
        courseName = new String[amt];
        courseDesc = new String[amt];
        timeF = new String[amt];
        timeT = new String[amt];
        location = new String[amt];
        roomNM = new String[amt];

        System.out.println("Enter the information of your classes.");
        for (int i = 0; i < amt; i++) {
            System.out.print("Course ID (e.g 'CSCI-3340'): ");
            courseName[i] = input.next();
            System.out.print("Course Description (e.g 'Software Engineering'): ");
            //Need this blank nextLine otherwise it skips over courseDesc[i] input
            input.nextLine();
            courseDesc[i] = input.nextLine();
            System.out.print("Time class starts (e.g '08:00 AM'): ");
            timeF[i] = input.nextLine();
            System.out.print("Time class ends (e.g '09:15 AM'): ");
            timeT[i] = input.nextLine();
            System.out.print("Class location (e.g 'LHSB'): ");
            location[i] = input.nextLine();
            System.out.print("Room Number (e.g '1.402'): ");
            roomNM[i] = input.nextLine();

            //Create a space to indicate inputting information for a new class
            System.out.println();
        }
        //Getting the days the user attends class
        whatDay();
    }

    public boolean[][] whatDay() {
        char YN;
        String weekDay;
        day = new boolean[amt][5];
        //Returns boolean array of week days. e.g {true, false, false, false, false} = Monday only class
        for (int i = 0; i < amt; i++) {
            loop:
            while (true) {
                System.out.print("Enter the first day of the week you have '" + courseDesc[i] + "' (Caps sensitive, e.g 'Monday'): ");
                weekDay = input.nextLine();
                switch (weekDay) {
                    case "Monday":
                        System.out.print("Is this class also scheduled for Wednesday? (Y/N) ");
                        YN = input.next(".").charAt(0);
                        if (YN == 'Y' || YN == 'y') {
                            day[i][0] = true;
                            day[i][2] = true;
                        }
                        day[i][0] = true;
                        break loop;
                    case "Tuesday":
                        System.out.print("Is this class also scheduled for Thursday? (Y/N) ");
                        YN = input.next(".").charAt(0);
                        if (YN == 'Y' || YN == 'y') {
                            day[i][1] = true;
                            day[i][3] = true;
                        }
                        day[i][1] = true;
                        break loop;
                    case "Wednesday":
                        day[i][2] = true;
                        /*
                         System.out.print("Is this class also scheduled for another day? (Y/N) ");
                         YN = input.next(".").charAt(0);
                         if (YN == 'Y' || YN == 'y') {
                         System.out.print("What other day is this class scheduled: ");
                         weekDay = input.next();
                         switch (weekDay) {
                         case "Monday":
                         day[i][0] = true;
                         break;
                         case "Tuesday":
                         day[i][1] = true;
                         break;
                         case "Thursday":
                         day[i][3] = true;
                         break;
                         case "Friday":
                         day[i][4] = true;
                         break;
                         }
                         } else {
                         }
                         */
                        break loop;
                    case "Thursday":
                        day[i][3] = true;
                        /*
                         System.out.print("Is this class also scheduled for another day? (Y/N) ");
                         YN = input.next(".").charAt(0);
                         if (YN == 'Y' || YN == 'y') {
                         System.out.print("What other day is this class scheduled: ");
                         weekDay = input.nextLine();
                         switch (weekDay) {
                         case "Monday":
                         day[i][0] = true;
                         break;
                         case "Tuesday":
                         day[i][1] = true;
                         break;
                         case "Wednesday":
                         day[i][2] = true;
                         break;
                         case "Friday":
                         day[i][4] = true;
                         break;
                         }
                         } else {
                         }
                         */
                        break loop;
                    case "Friday":
                        day[i][4] = true;
                        /*
                         System.out.print("Is this class also scheduled for another day? (Y/N) ");
                         YN = input.next(".").charAt(0);
                         if (YN == 'Y' || YN == 'y') {
                         System.out.print("What other day is this class scheduled: ");
                         weekDay = input.nextLine();
                         switch (weekDay) {
                         case "Monday":
                         day[i][0] = true;
                         break;
                         case "Tuesday":
                         day[i][1] = true;
                         break;
                         case "Wednesday":
                         day[i][2] = true;
                         break;
                         case "Thursday":
                         day[i][3] = true;
                         break;
                         }
                         } else {
                         }
                         */
                        break loop;
                    default:
                        System.out.println("You either misspelled a day or you picked a weekend day.");
                        break;
                }
            }
        }
        return getDay();
    }

    public void printInfo() {
        System.out.println("\t\tThese are the classes you're registered for:");
        for (int i = 0; i < amt; i++) {
            System.out.println("\t\t" + getCourseName()[i] + ": " + courseDesc[i]
                    + "(From " + getTimeF()[i] + " to " + getTimeT()[i] + " in "
                    + location[i] + " " + roomNM[i] + ")");
        }
        System.out.println("\t--------------------------------------------------------------");

        /* for loop to test if the days were correct
         for (int i = 0; i < amt; i++) {
         for (int j = 0; j < 5; j++) {
         System.out.print(getDay()[i][j] + "\t");

         }
         System.out.println();
        
         }
         */
    }

    public boolean[][] getDay() {
        return day;
    }

    public String[] getTimeF() {
        return timeF;
    }

    public String[] getTimeT() {
        return timeT;
    }

    public String[] getCourseName() {
        return courseName;
    }
}
