package common.helpers;

/**
 * Created by Carlos Zubiran on 5/11/2016.
 */
public class StringHelper {

    //region PROPERTIES


    //endregion PROPERTIES

    //region CONSTRUCTORS


    //endregion CONSTRUCTORS

    //region GETTERS / SETTERS


    //endregion GETTERS / SETTERS

    //region CUSTOM METHODS

    //notes:    his checks a string if it is null or
    //          empty returns true, otherwise returns false
    public static boolean isNullOrEmpty(String s) {
        return s == null || s.length() == 0;
    }

    public static String[] seperateWordsAndPutIntoAnArrayThenStripNonWordChars(String aString){

        String[] anArrayOfStrings;
        // Split the strings and put them into the array
        // using the split method and a regular expression
        anArrayOfStrings = aString.split("\\s");
        // go trough ever string in the array and strip
        // out non-alpha numeric numbers and replace them
        // with blank
        for (String s:anArrayOfStrings) {
            s.replaceAll("\\W","");
        }
        // finally return the array
        return anArrayOfStrings;
    }

    public static String convertStringArrayIntoASingleString(String[] stringArray) {
        StringBuilder aStringBuilder = new StringBuilder();
        // the for loop is used to append each string into the SB
        // class, inserting a blank space between each word
        for (String s: stringArray){
            aStringBuilder.append(s + " ");
        }
        return aStringBuilder.toString();
    }

    public static String arrayOfCharsToString(char[] aCharArray) {
        // get an array of characters and then put them into a
        // newly created string. This is supported by the constructor of
        // the String class.
        return new String(aCharArray);
    }

    //endregion CUSTOM METHODS


}
