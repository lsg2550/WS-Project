package WeeklyScheduler;

import java.util.Scanner;

public class ScheduleGenerator {

    /**
     * @author MQ0162246
     */
    //Personal Info
    private Info wsInfo = new Info();
    //Courses
    private Courses wsCor = new Courses();
    //Time Increment
    private int timeIncrement;
    //Time Intervals
    private String[] timeIntervals;

    public void getUserInfo() {
        wsInfo.userInput();
    }

    public void getCoursesFromUser() {
        wsCor.userInput();
    }

    public void printUserInfo() {
        wsInfo.printInfo();
    }

    public void printCourseInfo() {
        wsCor.printInfo();
    }

    public void printWeekDays() {
        String[] weekDays = {"Monday", "Tuesday", "Wednesday", "Thursday", "Friday"};
        boolean[] weekDaysB = {true, true, true, true, true};
        String[] timeIntF = wsCor.getTimeF();
        String[] timeIntT = wsCor.getTimeT();
        boolean[][] compDays = wsCor.getDay();
        String[] descC = wsCor.getCourseName();

        for (int i = 0; i < weekDays.length; i++) {
            System.out.print(" \t\t" + weekDays[i] + "\t");
        }

        System.out.println();

        for (int i = 0; i < timeIntervals.length; i++) {
            //Class[0] 
            //Monday and/or Wednesday
              if (timeIntervals[i].equals(timeIntF[0]) && compDays[0][0] == weekDaysB[0] && compDays[0][2] != weekDaysB[2]) {
                System.out.println(timeIntervals[i] + " \t" + descC[0]);
            } else if (timeIntervals[i].equals(timeIntF[0]) && compDays[0][0] == weekDaysB[0] && compDays[0][2] == weekDaysB[2]) {
                System.out.println(timeIntervals[i] + " \t" + descC[0] + "\t \t\t\t \t\t" + descC[0]);
            } else if (timeIntervals[i].equals(timeIntT[0]) && compDays[0][0] == weekDaysB[0] && compDays[0][2] != weekDaysB[2]) {
                System.out.println(timeIntervals[i] + " \t" + descC[0]);
            } else if (timeIntervals[i].equals(timeIntT[0]) && compDays[0][0] == weekDaysB[0] && compDays[0][2] == weekDaysB[2]) {
                System.out.println(timeIntervals[i] + " \t" + descC[0] + "\t \t\t\t \t\t" + descC[0]);
            } //Tuesday and/or Thursday
              else if (timeIntervals[i].equals(timeIntF[0]) && compDays[0][1] == weekDaysB[1] && compDays[0][3] != weekDaysB[3]) {
                System.out.println(timeIntervals[i] + " \t\t \t\t" + descC[0]);
            } else if (timeIntervals[i].equals(timeIntF[0]) && compDays[0][1] == weekDaysB[1] && compDays[0][3] == weekDaysB[3]) {
                System.out.println(timeIntervals[i] + " \t\t \t\t" + descC[0] + "\t \t\t\t \t\t\t" + descC[0]);
            } else if (timeIntervals[i].equals(timeIntT[0]) && compDays[0][1] == weekDaysB[1] && compDays[0][3] != weekDaysB[3]) {
                System.out.println(timeIntervals[i] + " \t\t \t\t" + descC[0]);
            } else if (timeIntervals[i].equals(timeIntT[0]) && compDays[0][1] == weekDaysB[1] && compDays[0][3] == weekDaysB[3]) {
                System.out.println(timeIntervals[i] + " \t\t \t\t" + descC[0] + "\t \t\t\t \t\t\t" + descC[0]);
            } //Wednesday
              else if (timeIntervals[i].equals(timeIntF[0]) && compDays[0][2] == weekDaysB[2]) {
                System.out.println(timeIntervals[i] + " \t\t \t\t\t \t\t" + descC[0]);
            } else if (timeIntervals[i].equals(timeIntT[0]) && compDays[0][2] == weekDaysB[2]) {
                System.out.println(timeIntervals[i] + " \t\t \t\t\t \t\t" + descC[0]);
            } //Thursday
              else if (timeIntervals[i].equals(timeIntF[0]) && compDays[0][3] == weekDaysB[3]) {
                System.out.println(timeIntervals[i] + " \t\t \t\t\t \t\t\t \t\t\t" + descC[0]);
            } else if (timeIntervals[i].equals(timeIntT[0]) && compDays[0][3] == weekDaysB[3]) {
                System.out.println(timeIntervals[i] + " \t\t \t\t\t \t\t\t \t\t\t" + descC[0]);
            } //Friday
              else if (timeIntervals[i].equals(timeIntF[0]) && compDays[0][4] == weekDaysB[4]) {
                System.out.println(timeIntervals[i] + " \t\t \t\t\t \t\t\t \t\t\t \t\t\t" + descC[0]);
            } else if (timeIntervals[i].equals(timeIntT[0]) && compDays[0][4] == weekDaysB[4]) {
                System.out.println(timeIntervals[i] + " \t\t \t\t\t \t\t\t \t\t\t \t\t\t" + descC[0]);
            } 
            //Class[1]----------------------------------------------------------------------------------
            //Monday and/or Wednesday 
              else if (timeIntervals[i].equals(timeIntF[1]) && compDays[1][0] == weekDaysB[0] && compDays[1][2] != weekDaysB[2]) {
                System.out.println(timeIntervals[i] + " \t" + descC[1]);
            } else if (timeIntervals[i].equals(timeIntF[1]) && compDays[1][0] == weekDaysB[0] && compDays[1][2] == weekDaysB[2]) {
                System.out.println(timeIntervals[i] + " \t" + descC[1] + "\t \t\t\t \t\t" + descC[1]);
            } else if (timeIntervals[i].equals(timeIntT[1]) && compDays[1][0] == weekDaysB[0] && compDays[1][2] != weekDaysB[2]) {
                System.out.println(timeIntervals[i] + " \t" + descC[1]);
            } else if (timeIntervals[i].equals(timeIntT[1]) && compDays[1][0] == weekDaysB[0] && compDays[1][2] == weekDaysB[2]) {
                System.out.println(timeIntervals[i] + " \t" + descC[1] + "\t \t\t\t \t\t" + descC[1]);
            } //Tuesday and/or Thursday
              else if (timeIntervals[i].equals(timeIntF[1]) && compDays[1][1] == weekDaysB[1] && compDays[1][3] != weekDaysB[3]) {
                System.out.println(timeIntervals[i] + " \t\t \t\t" + descC[1]);
            } else if (timeIntervals[i].equals(timeIntF[1]) && compDays[1][1] == weekDaysB[1] && compDays[1][3] == weekDaysB[3]) {
                System.out.println(timeIntervals[i] + " \t\t \t\t" + descC[1] + "\t \t\t\t \t\t\t" + descC[1]);
            } else if (timeIntervals[i].equals(timeIntT[1]) && compDays[1][1] == weekDaysB[1] && compDays[1][3] != weekDaysB[3]) {
                System.out.println(timeIntervals[i] + " \t\t \t\t" + descC[1]);
            } else if (timeIntervals[i].equals(timeIntT[1]) && compDays[1][1] == weekDaysB[1] && compDays[1][3] == weekDaysB[3]) {
                System.out.println(timeIntervals[i] + " \t\t \t\t" + descC[1] + "\t \t\t\t \t\t\t" + descC[1]);
            } //Wednesday
              else if (timeIntervals[i].equals(timeIntF[1]) && compDays[1][2] == weekDaysB[2]) {
                System.out.println(timeIntervals[i] + " \t\t \t\t\t \t\t" + descC[1]);
            } else if (timeIntervals[i].equals(timeIntT[1]) && compDays[1][2] == weekDaysB[2]) {
                System.out.println(timeIntervals[i] + " \t\t \t\t\t \t\t" + descC[1]);
            } //Thursday
              else if (timeIntervals[i].equals(timeIntF[1]) && compDays[1][3] == weekDaysB[3]) {
                System.out.println(timeIntervals[i] + " \t\t \t\t\t \t\t\t \t\t\t" + descC[1]);
            } else if (timeIntervals[i].equals(timeIntT[1]) && compDays[1][3] == weekDaysB[3]) {
                System.out.println(timeIntervals[i] + " \t\t \t\t\t \t\t\t \t\t\t" + descC[1]);
            } //Friday
              else if (timeIntervals[i].equals(timeIntF[1]) && compDays[1][4] == weekDaysB[4]) {
                System.out.println(timeIntervals[i] + " \t\t \t\t\t \t\t\t \t\t\t \t\t\t" + descC[1]);
            } else if (timeIntervals[i].equals(timeIntT[1]) && compDays[1][4] == weekDaysB[4]) {
                System.out.println(timeIntervals[i] + " \t\t \t\t\t \t\t\t \t\t\t \t\t\t" + descC[1]);
            }
            //Class[2]----------------------------------------------------------------------------------
            //Monday and/or Wednesday 
              else if (timeIntervals[i].equals(timeIntF[2]) && compDays[2][0] == weekDaysB[0] && compDays[2][2] != weekDaysB[2]) {
                System.out.println(timeIntervals[i] + " \t" + descC[2]);
            } else if (timeIntervals[i].equals(timeIntF[2]) && compDays[2][0] == weekDaysB[0] && compDays[2][2] == weekDaysB[2]) {
                System.out.println(timeIntervals[i] + " \t" + descC[2] + "\t \t\t\t \t\t" + descC[2]);
            } else if (timeIntervals[i].equals(timeIntT[2]) && compDays[2][0] == weekDaysB[0] && compDays[2][2] != weekDaysB[2]) {
                System.out.println(timeIntervals[i] + " \t" + descC[2]);
            } else if (timeIntervals[i].equals(timeIntT[2]) && compDays[2][0] == weekDaysB[0] && compDays[2][2] == weekDaysB[2]) {
                System.out.println(timeIntervals[i] + " \t" + descC[2] + "\t \t\t\t \t\t" + descC[2]);
            } //Tuesday and/or Thursday
              else if (timeIntervals[i].equals(timeIntF[2]) && compDays[2][1] == weekDaysB[1] && compDays[2][3] != weekDaysB[3]) {
                System.out.println(timeIntervals[i] + " \t\t \t\t" + descC[2]);
            } else if (timeIntervals[i].equals(timeIntF[2]) && compDays[2][1] == weekDaysB[1] && compDays[2][3] == weekDaysB[3]) {
                System.out.println(timeIntervals[i] + " \t\t \t\t" + descC[2] + "\t \t\t\t \t\t\t" + descC[2]);
            } else if (timeIntervals[i].equals(timeIntT[2]) && compDays[2][1] == weekDaysB[1] && compDays[2][3] != weekDaysB[3]) {
                System.out.println(timeIntervals[i] + " \t\t \t\t" + descC[2]);
            } else if (timeIntervals[i].equals(timeIntT[2]) && compDays[2][1] == weekDaysB[1] && compDays[2][3] == weekDaysB[3]) {
                System.out.println(timeIntervals[i] + " \t\t \t\t" + descC[2] + "\t \t\t\t \t\t\t" + descC[2]);
            } //Wednesday
              else if (timeIntervals[i].equals(timeIntF[2]) && compDays[2][2] == weekDaysB[2]) {
                System.out.println(timeIntervals[i] + " \t\t \t\t\t \t\t" + descC[2]);
            } else if (timeIntervals[i].equals(timeIntT[2]) && compDays[2][2] == weekDaysB[2]) {
                System.out.println(timeIntervals[i] + " \t\t \t\t\t \t\t" + descC[2]);
            } //Thursday
              else if (timeIntervals[i].equals(timeIntF[2]) && compDays[2][3] == weekDaysB[3]) {
                System.out.println(timeIntervals[i] + " \t\t \t\t\t \t\t\t \t\t\t" + descC[2]);
            } else if (timeIntervals[i].equals(timeIntT[2]) && compDays[2][3] == weekDaysB[3]) {
                System.out.println(timeIntervals[i] + " \t\t \t\t\t \t\t\t \t\t\t" + descC[2]);
            } //Friday
              else if (timeIntervals[i].equals(timeIntF[2]) && compDays[2][4] == weekDaysB[4]) {
                System.out.println(timeIntervals[i] + " \t\t \t\t\t \t\t\t \t\t\t \t\t\t" + descC[2]);
            } else if (timeIntervals[i].equals(timeIntT[2]) && compDays[2][4] == weekDaysB[4]) {
                System.out.println(timeIntervals[i] + " \t\t \t\t\t \t\t\t \t\t\t \t\t\t" + descC[2]);
            }
            /*
            //Class[3]----------------------------------------------------------------------------------
            //Monday and/or Wednesday 
              else if (timeIntervals[i].equals(timeIntF[3]) && compDays[3][0] == weekDaysB[0] && compDays[3][2] != weekDaysB[2]) {
                System.out.println(timeIntervals[i] + " \t" + descC[3]);
            } else if (timeIntervals[i].equals(timeIntF[3]) && compDays[3][0] == weekDaysB[0] && compDays[3][2] == weekDaysB[2]) {
                System.out.println(timeIntervals[i] + " \t" + descC[3] + "\t \t\t\t \t\t" + descC[3]);
            } else if (timeIntervals[i].equals(timeIntT[3]) && compDays[3][0] == weekDaysB[0] && compDays[3][2] != weekDaysB[2]) {
                System.out.println(timeIntervals[i] + " \t" + descC[3]);
            } else if (timeIntervals[i].equals(timeIntT[3]) && compDays[3][0] == weekDaysB[0] && compDays[3][2] == weekDaysB[2]) {
                System.out.println(timeIntervals[i] + " \t" + descC[3] + "\t \t\t\t \t\t" + descC[3]);
            } //Tuesday and/or Thursday
              else if (timeIntervals[i].equals(timeIntF[3]) && compDays[3][1] == weekDaysB[1] && compDays[3][3] != weekDaysB[3]) {
                System.out.println(timeIntervals[i] + " \t\t \t\t" + descC[3]);
            } else if (timeIntervals[i].equals(timeIntF[3]) && compDays[3][1] == weekDaysB[1] && compDays[3][3] == weekDaysB[3]) {
                System.out.println(timeIntervals[i] + " \t\t \t\t" + descC[3] + "\t \t\t\t \t\t\t" + descC[3]);
            } else if (timeIntervals[i].equals(timeIntT[3]) && compDays[3][1] == weekDaysB[1] && compDays[3][3] != weekDaysB[3]) {
                System.out.println(timeIntervals[i] + " \t\t \t\t" + descC[3]);
            } else if (timeIntervals[i].equals(timeIntT[3]) && compDays[3][1] == weekDaysB[1] && compDays[3][3] == weekDaysB[3]) {
                System.out.println(timeIntervals[i] + " \t\t \t\t" + descC[3] + "\t \t\t\t \t\t\t" + descC[3]);
            } //Wednesday
              else if (timeIntervals[i].equals(timeIntF[3]) && compDays[3][2] == weekDaysB[2]) {
                System.out.println(timeIntervals[i] + " \t\t \t\t\t \t\t" + descC[3]);
            } else if (timeIntervals[i].equals(timeIntT[3]) && compDays[3][2] == weekDaysB[2]) {
                System.out.println(timeIntervals[i] + " \t\t \t\t\t \t\t" + descC[3]);
            } //Thursday
              else if (timeIntervals[i].equals(timeIntF[3]) && compDays[3][3] == weekDaysB[3]) {
                System.out.println(timeIntervals[i] + " \t\t \t\t\t \t\t\t \t\t\t" + descC[3]);
            } else if (timeIntervals[i].equals(timeIntT[3]) && compDays[3][3] == weekDaysB[3]) {
                System.out.println(timeIntervals[i] + " \t\t \t\t\t \t\t\t \t\t\t" + descC[3]);
            } //Friday
              else if (timeIntervals[i].equals(timeIntF[3]) && compDays[3][4] == weekDaysB[4]) {
                System.out.println(timeIntervals[i] + " \t\t \t\t\t \t\t\t \t\t\t \t\t\t" + descC[3]);
            } else if (timeIntervals[i].equals(timeIntT[3]) && compDays[3][4] == weekDaysB[4]) {
                System.out.println(timeIntervals[i] + " \t\t \t\t\t \t\t\t \t\t\t \t\t\t" + descC[3]);
            }
            //Class[4]----------------------------------------------------------------------------------
            //Monday and/or Wednesday 
              else if (timeIntervals[i].equals(timeIntF[4]) && compDays[4][0] == weekDaysB[0] && compDays[4][2] != weekDaysB[2]) {
                System.out.println(timeIntervals[i] + " \t" + descC[4]);
            } else if (timeIntervals[i].equals(timeIntF[4]) && compDays[4][0] == weekDaysB[0] && compDays[4][2] == weekDaysB[2]) {
                System.out.println(timeIntervals[i] + " \t" + descC[4] + "\t \t\t\t \t\t" + descC[4]);
            } else if (timeIntervals[i].equals(timeIntT[4]) && compDays[4][0] == weekDaysB[0] && compDays[4][2] != weekDaysB[2]) {
                System.out.println(timeIntervals[i] + " \t" + descC[4]);
            } else if (timeIntervals[i].equals(timeIntT[4]) && compDays[4][0] == weekDaysB[0] && compDays[4][2] == weekDaysB[2]) {
                System.out.println(timeIntervals[i] + " \t" + descC[4] + "\t \t\t\t \t\t" + descC[4]);
            } //Tuesday and/or Thursday
              else if (timeIntervals[i].equals(timeIntF[4]) && compDays[4][1] == weekDaysB[1] && compDays[4][3] != weekDaysB[3]) {
                System.out.println(timeIntervals[i] + " \t\t \t\t" + descC[4]);
            } else if (timeIntervals[i].equals(timeIntF[4]) && compDays[4][1] == weekDaysB[1] && compDays[4][3] == weekDaysB[3]) {
                System.out.println(timeIntervals[i] + " \t\t \t\t" + descC[4] + "\t \t\t\t \t\t\t" + descC[4]);
            } else if (timeIntervals[i].equals(timeIntT[4]) && compDays[4][1] == weekDaysB[1] && compDays[4][3] != weekDaysB[3]) {
                System.out.println(timeIntervals[i] + " \t\t \t\t" + descC[4]);
            } else if (timeIntervals[i].equals(timeIntT[4]) && compDays[4][1] == weekDaysB[1] && compDays[4][3] == weekDaysB[3]) {
                System.out.println(timeIntervals[i] + " \t\t \t\t" + descC[4] + "\t \t\t\t \t\t\t" + descC[4]);
            } //Wednesday
              else if (timeIntervals[i].equals(timeIntF[4]) && compDays[4][2] == weekDaysB[2]) {
                System.out.println(timeIntervals[i] + " \t\t \t\t\t \t\t" + descC[4]);
            } else if (timeIntervals[i].equals(timeIntT[4]) && compDays[4][2] == weekDaysB[2]) {
                System.out.println(timeIntervals[i] + " \t\t \t\t\t \t\t" + descC[4]);
            } //Thursday
              else if (timeIntervals[i].equals(timeIntF[4]) && compDays[4][3] == weekDaysB[3]) {
                System.out.println(timeIntervals[i] + " \t\t \t\t\t \t\t\t \t\t\t" + descC[4]);
            } else if (timeIntervals[i].equals(timeIntT[4]) && compDays[4][3] == weekDaysB[3]) {
                System.out.println(timeIntervals[i] + " \t\t \t\t\t \t\t\t \t\t\t" + descC[4]);
            } //Friday
              else if (timeIntervals[i].equals(timeIntF[4]) && compDays[4][4] == weekDaysB[4]) {
                System.out.println(timeIntervals[i] + " \t\t \t\t\t \t\t\t \t\t\t \t\t\t" + descC[4]);
            } else if (timeIntervals[i].equals(timeIntT[4]) && compDays[4][4] == weekDaysB[4]) {
                System.out.println(timeIntervals[i] + " \t\t \t\t\t \t\t\t \t\t\t \t\t\t" + descC[4]);
            }
                    */
            else {
                System.out.println(timeIntervals[i]);
            }

        }
    }

// Get Time Intervals
    public int getTimeIncrmentFromUser() {
        Scanner input = new Scanner(System.in);
        System.out.println("Please enter you're preferred time increment. From 0 to 60.");
        return input.nextInt();
    }

    // This part is working! I implemented it for you
    public void generateTimeTickse() {
        timeIncrement = getTimeIncrmentFromUser();
        TimeInterval timeTicks = new TimeInterval(timeIncrement); // works for increments from 0-60
        timeTicks.generateTicks();
        timeIntervals = timeTicks.getTimeTicksStrings();
    }

    // Generate the Schedule
    public void generateSchedule() {
        getUserInfo();
        getCoursesFromUser();
        generateTimeTickse();
        printUserInfo();
        printCourseInfo();
        printWeekDays();
    }
}
