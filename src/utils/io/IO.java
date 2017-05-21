package utils.io;

import java.io.File;

/**
 *
 * @author Luis
 */
public class IO {

    private static final File DOCS = new File("docs/users/");

    public static void init() {
        DOCS.mkdirs();
    }

    public static File getDOCS() {
        return DOCS;
    }

}
