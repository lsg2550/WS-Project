package utils.io;

import gui.DisplayWarning;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import user.Classes;
import user.User;
import utils.parse.TryParse;

/**
 *
 * @author Luis
 */
public class Save {

    public static User currentUser;

    public static void saveInfo() {
        if (isUserLoggedIn()) {
            File file = new File(IO.getDOCS().toString() + "/" + currentUser.getStudentID() + ".txt");

            if (file.exists()) {
                try (BufferedWriter bw = new BufferedWriter(new FileWriter(file))) {
                    bw.write(currentUser.toString()); //User Info

                    for (Classes classes : currentUser.getClassesArrayList()) { //User's Class Info
                        bw.append(classes.toString());
                    }

                    bw.flush();
                    bw.close();
                } catch (IOException ex) {
                    System.out.println("There was an issue saving.");
                }
            } else {
                DisplayWarning.show("It appears you have not created an account or your information has gone missing.");
                //System.out.println("It appears you have not created an account or your information has gone missing.");
            }
        }
    }

    public static void loadInfo(File userFile) {
        try (BufferedReader br = new BufferedReader(new FileReader(userFile))) {
            currentUser = new User();

            for (String line = br.readLine(); line != null; line = br.readLine()) {
                if (line.startsWith("ID: ")) {
                    line = line.replace("ID: ", " ").trim();
                    currentUser.setStudentID(line);
                }
                if (line.startsWith("FN: ")) {
                    line = line.replace("FN: ", " ").trim();
                    currentUser.setFirstName(line);
                }
                if (line.startsWith("LN: ")) {
                    line = line.replace("LN: ", " ").trim();
                    currentUser.setLastName(line);
                }
                if (line.startsWith("PW: ")) {
                    line = line.replace("PW: ", " ").trim();
                    currentUser.setPassword(line);
                }
                if (line.startsWith("SEM: ")) {
                    line = line.replace("SEM: ", " ").trim();
                    currentUser.setCurrentSemester(line);
                }
                if (line.equals("CLASS INFO START")) {
                    Classes newClass = new Classes();
                    boolean getClassBool = true;
                    line = br.readLine();
                    while (getClassBool) { //Start while
                        String[] temp;
                        if (line.startsWith("CLASS: ")) {
                            temp = line.replace("CLASS: ", " ").trim().split(":");
                            newClass.setClassID(temp[0]);
                            newClass.setClassName(temp[1]);
                            newClass.setClassLocation(temp[2]);
                        }
                        if (line.startsWith("DAYS: ")) {
                            temp = line.replace("DAYS: ", " ").trim().split(":");
                            newClass.setMonday(TryParse.parseStringToBoolean(temp[0]));
                            newClass.setTuesday(TryParse.parseStringToBoolean(temp[1]));
                            newClass.setWednesday(TryParse.parseStringToBoolean(temp[2]));
                            newClass.setThursday(TryParse.parseStringToBoolean(temp[3]));
                            newClass.setFriday(TryParse.parseStringToBoolean(temp[4]));
                            newClass.setSaturday(TryParse.parseStringToBoolean(temp[5]));
                            newClass.setSunday(TryParse.parseStringToBoolean(temp[6]));
                        }
                        if (line.startsWith("FROM: ")) {
                            temp = line.replace("FROM: ", " ").trim().split(":");
                            newClass.setTimeFromHour(temp[0]);
                            newClass.setTimeFromMinute(temp[1]);
                            newClass.setTimeFromPeriod(temp[2]);
                        }
                        if (line.startsWith("TO: ")) {
                            temp = line.replace("TO: ", " ").trim().split(":");
                            newClass.setTimeToHour(temp[0]);
                            newClass.setTimeToMinute(temp[1]);
                            newClass.setTimeToPeriod(temp[2]);
                        }
                        if (line.equals("CLASS INFO END")) {
                            getClassBool = false;
                        } else {
                            line = br.readLine();
                        }
                    }//end while
                    //Add Loaded Class
                    currentUser.getClassesArrayList().add(newClass);
                }
            }
            br.close(); //Reading is done.
        } catch (IOException ex) {
            DisplayWarning.show("Issue Loading User File!");
            //System.out.println("Issue Loading User File!");
        }
    }

    public static boolean isUserLoggedIn() {
        if (currentUser != null) {
            return true;
        } else {
            System.out.println("You're Not Logged In!");
            return false;
        }
    }
}
