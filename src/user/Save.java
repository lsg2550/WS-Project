package user;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

/**
 *
 * @author Luis
 */
public class Save {

    public static User currentUser;

    public static void saveInfo() {
        if (currentUser != null) {
            String fileName = currentUser.getStudentID();
            File file = new File("docs/users/" + fileName + ".txt");

            try (BufferedWriter bw = new BufferedWriter(new FileWriter(file))) {
                file.mkdirs();

                bw.write(currentUser.toString());
                for (Classes classes : currentUser.getClassesArrayList()) {
                    bw.append(classes.toString());
                }

                bw.flush();
                bw.close();
            } catch (IOException ex) {
                System.out.println("There was an issue saving.");
            }
        }
    }
}
