package com.astontech.console.OOPLab5;

import common.helpers.StringHelper;

/**
 * Created by Carlos Zubiran on 5/12/2016.
 */
public class ReverseCharArray implements CharSequence{

    //region PROPERTIES

    String stringInReverse = "";

    //endregion PROPERTIES

    //region CONSTRUCTORS

    //endregion CONSTRUCTORS

    //region GETTERS / SETTERS

    public String getAndSetStringInReverse(String stringToConvert) {
        //  make a variable to hold a converted String to charArray
        char[] convertedCharArray = stringToConvert.toCharArray();
        char[] resultCharArrayTogoBackToString = new char[convertedCharArray.length];
        for (int i = convertedCharArray.length - 1, j = 0; i >= 0 ; --i, ++j) {
            resultCharArrayTogoBackToString[i] = convertedCharArray[j];
        }
        return new String(resultCharArrayTogoBackToString);
    }

    public String getStringInReverse() {

        return getAndSetStringInReverse(this.stringInReverse);
    }

    public void setStringInReverse(String stringInReverse) {
        this.stringInReverse = stringInReverse;
    }

    //endregion GETTERS / SETTERS

    //region CUSTOM METHODS

    @Override
    public int length() {
        int charCount = 0;
        for (char c: stringInReverse.toCharArray()) {
            charCount++;
        }
        return charCount;
    }

    @Override
    public char charAt(int index) {
        if (index < stringInReverse.toCharArray().length){
            return stringInReverse.toCharArray()[index];
        }
        else{
            System.out.println("Your index is out of bounds");
            return '0';
        }
    }

    @Override
    public CharSequence subSequence(int start, int end) {
        return null;
    }

    //endregion CUSTOM METHODS

}
