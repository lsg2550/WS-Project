package utils.io;

/**
 *
 * @author Luis
 */
public class Sanitize {

    /**
     * Class to be used to sanitize user input
     *
     * @param toBeSanitized
     * @return If there contains random symbols, return true; If there contains
     * no random symbols, return false;
     */
    public static boolean checkForRandomSymbols(String toBeSanitized) {
        for (int i = 0; i < toBeSanitized.length(); i++) {
            if (toBeSanitized.charAt(i) == '!' || toBeSanitized.charAt(i) == '@'
                    || toBeSanitized.charAt(i) == '#' || toBeSanitized.charAt(i) == '$'
                    || toBeSanitized.charAt(i) == '%' || toBeSanitized.charAt(i) == '^'
                    || toBeSanitized.charAt(i) == '&' || toBeSanitized.charAt(i) == '*'
                    || toBeSanitized.charAt(i) == '(' || toBeSanitized.charAt(i) == ')'
                    || toBeSanitized.charAt(i) == '~' || toBeSanitized.charAt(i) == '\\'
                    || toBeSanitized.charAt(i) == '|' || toBeSanitized.charAt(i) == '}'
                    || toBeSanitized.charAt(i) == '{' || toBeSanitized.charAt(i) == '['
                    || toBeSanitized.charAt(i) == ']' || toBeSanitized.charAt(i) == '"'
                    || toBeSanitized.charAt(i) == ';' || toBeSanitized.charAt(i) == ':'
                    || toBeSanitized.charAt(i) == '/' || toBeSanitized.charAt(i) == '?'
                    || toBeSanitized.charAt(i) == '>' || toBeSanitized.charAt(i) == '.'
                    || toBeSanitized.charAt(i) == '<' || toBeSanitized.charAt(i) == ','
                    || toBeSanitized.charAt(i) == '-' || toBeSanitized.charAt(i) == '_'
                    || toBeSanitized.charAt(i) == '+' || toBeSanitized.charAt(i) == '='
                    || toBeSanitized.charAt(i) == '`' || toBeSanitized.charAt(i) == ' ') {
                return true;
            }
        }

        return false;
    }

    /**
     *
     * @param toBeSanitized
     * @return If there are digits return true; Otherwise, return false;
     */
    public static boolean checkForDigits(String toBeSanitized) {
        for (int i = 0; i < toBeSanitized.length(); i++) {
            if (toBeSanitized.charAt(i) == '1' || toBeSanitized.charAt(i) == '2'
                    || toBeSanitized.charAt(i) == '3' || toBeSanitized.charAt(i) == '4'
                    || toBeSanitized.charAt(i) == '5' || toBeSanitized.charAt(i) == '6'
                    || toBeSanitized.charAt(i) == '7' || toBeSanitized.charAt(i) == '8'
                    || toBeSanitized.charAt(i) == '9' || toBeSanitized.charAt(i) == '0') {
                return true;
            }
        }
        return false;
    }

    /**
     *
     * @param toBeSanitized
     * @return If there string is empty return true; Otherwise, return false;
     */
    public static boolean checkForEmptyString(String toBeSanitized) {
        return toBeSanitized.trim().equals("");
    }
}
