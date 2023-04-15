import java.text.ParseException;
import java.util.ArrayList;
import java.util.Arrays;

public class Decoder {

    /*
     * Forbidden characters are passed as an array of int.
     * Each element of this array correspond to the decimal ASCII code
     * of a forbidden character OR null if there's no forbidden character
     * If you encounter one of these forbidden character
     * you must ignore it when you translate your sentence.
     *
     * the 2D array "sentences" contain a set of decimal ASCII code we want you
     * to translate. Each sub-element of this array is a different sentence.
     * Ex : if we pass this array : [ ["42", "72", "88"], ["98", "99", "111", "47", "55"]]
     * to your decode method, you should return : [ "*HX", "bco/7" ]
     *
     * You should NEVER return null or an array containing null
     */
    public static String [] decode(int[] forbidden, String[][] sentences){
        String[] result = new String[sentences.length];
        for (int i = 0; i<sentences.length; i++){
            result[i] = "";
            for (String number : sentences[i]) {
                int code;
                try {
                    code = Integer.parseInt(number);
                } catch (NumberFormatException e) {
                    System.out.println(e.getMessage());
                    continue;
                }

                boolean autorisation = true;
                if (forbidden != null) {
                    for (int forbidInt : forbidden) {
                        if (forbidInt == code) {
                            autorisation = false;
                            break;
                        }
                    }
                }
                if (autorisation) {
                    char c = (char) code;
                    result[i] += c;
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        String[][] test = {};
        System.out.println(Arrays.toString(decode(null, test)));
    }

}