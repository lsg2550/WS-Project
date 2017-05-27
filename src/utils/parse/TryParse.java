package utils.parse;

/**
 *
 * @author Luis
 */
public class TryParse {

    public static Boolean parseStringToBoolean(String boolToParse) {
        switch (boolToParse.toLowerCase()) {
            case "false":
                return false;
            case "true":
                return true;
            default:
                //Should not be reached, but since this app is using txt files, a small change in txt can break the app.
                //This program is not meant to be used with txt files, but in this case I'm not going to worry about it.
                return null;
        }
    }

}
