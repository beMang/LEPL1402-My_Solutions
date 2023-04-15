public class StringUtils {


    /**
     * Split a string according to a delimiter
     *
     * @param str The string to split
     * @param delimiter The delimiter
     * @return An array containing the substring which fall
     *          between two consecutive occurence of the delimiter.
     *          If there is no occurence of the delimiter, it should
     *          return an array of size 1 with the string at element 0
     */
    public static String [] split(String str, char delimiter){
        char[] chars = str.toCharArray();
        java.util.ArrayList<String> result = new java.util.ArrayList<String>();

        String word = "";
        for (char c : chars){
            if (c == delimiter) {
                result.add(word);
                word = "";
            } else {
                word += c;
            }
        }
        result.add(word);
        
        return result.toArray(new String[0]);
    }


    /**
     * Find the first occurence of a substring in a string
     *
     * @param str The string to look in
     * @param sub The string to look for
     * @return The index of the start of the first appearance of
     *          the substring in str or -1 if sub does not appear
     *          in str
     */
    public static int indexOf(String str, String sub){
        char[] chars = str.toCharArray();
        char[] sub_char = sub.toCharArray();

        for (int i = 0; i < chars.length - sub_char.length +1; i++) {
            boolean equal = true;
            for (int j = 0; j < sub.length(); j++) {
                if (chars[i+j] != sub_char[j]) {
                    equal = false;
                    break;
                }
            }
            if (equal) {
                return i;
            }
        }
        return -1;
    }


    /**
     * Convert a string to lowercase
     *
     * @param str The string to convert
     * @return A new string, same as str but with every
     *          character put to lower case.
     */
    public static String toLowerCase(String str){
        char[] chars = str.toCharArray();
        String result = "";

        for (int i = 0; i < chars.length; i++) {
            int asciCode = chars[i];
            if (64 < asciCode && asciCode < 91) {
                asciCode += 32;
            }
            char test = (char) asciCode;
            result += test;
        }

        return result;
    }


    /**
     * Check if a string is a palyndrome
     *
     * A palyndrome is a sequence of character that is the
     * same when read from left to right and from right to
     * left.
     *
     * @param str The string to check
     * @return true if str is a palyndrome, false otherwise
     */
    public static boolean palindrome(String str){
        int n = str.length()/2;
        char[] chars = str.toCharArray();

        for (int i = 0; i < n; i++) {
            if (chars[i] != chars[str.length() - 1 - i]) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(java.util.Arrays.toString(split("bonjour,adrien,giele.", ',')));
        System.out.println(palindrome("test"));
    }


}