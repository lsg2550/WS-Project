package assets.css;

import com.sun.javafx.css.StyleManager;

/**
 *
 * @author Luis
 */
public class CSS {

    private static final String CSS_PATH = "assets/css/css.css";

    public static void init() {
        StyleManager.getInstance().addUserAgentStylesheet(CSS_PATH);
    }

    public static String getCSS_PATH() {
        return CSS_PATH;
    }

}
