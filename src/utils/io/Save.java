package utils.io;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import user.Classes;
import user.User;

/**
 *
 * @author Luis
 */
public class Save {

    public static User currentUser;

    public static void saveInfo() {
        if (currentUser != null) {
            File file = new File(IO.getDOCS().toString() + "/" + currentUser.getStudentID() + ".txt");

            if (file.exists()) {
                try (BufferedWriter bw = new BufferedWriter(new FileWriter(file))) {
                    bw.write(currentUser.toString());
                    for (Classes classes : currentUser.getClassesArrayList()) {
                        bw.append(classes.toString());
                    }

                    bw.flush();
                    bw.close();
                } catch (IOException ex) {
                    System.out.println("There was an issue saving.");
                }
            } else {
                System.out.println("It appears you have not created an account or your information has gone missing.");
            }
        }
    }
}
