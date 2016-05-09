package com.astontech.console;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

/**
 * Created by Carlos Zubiran on 5/5/2016.
 */

/*
* Question 1
* Create a new private
* static method called LessonFundamentalsLAB().
* */


class FundamentalsLAB{

    public static void LessonFundamentalsLabQ1(){

        /*
        * Question 2
        *
        * What is a variable? Write code that
        * prompts the user to enter a value from 1-10,
        * adds 1.75 to the number then outputs it to the console.
        * */

        // Ask the user to enter a valid number
        System.out.println("Enter a number, then it" +
                "will be added with 1.75");
        // A scanner to get the String from the user
        // from the System input aka CLI or Terminal
        Scanner aScanner = new Scanner(System.in);

        // Var to hold a string that the user entered in
        // as a string using the nextLine method
        String userValue = aScanner.nextLine();

        // Getting the string and finally converting it to a
        // float, Using a wrapper class of Float then
        // using the Auto Unboxing attributes of-
        // java to put it into a regular float
        float userValueConvertedtoFloat = Float.parseFloat(userValue);
        // finally doing the calculation and turning the casting the
        // 1.75 from a double to a float primitive data type
        float calculatedValue = (float)1.75 + userValueConvertedtoFloat;
        // print the calculation to the CLI or Terminal
        System.out.println(calculatedValue);

        /*
        * Question 3
        *
        * Research the eight data types in Java, create variables
        * for these, and output the default, max, and min values
        * (where applicable).
        *
        */
        // a single character only and can only hold
        // any 16-bit unicode character
        char aChar = 'a';
        // and integer with 2^32 maximum or minimum
        int aInt = 100;
        // an interger with a max or min of 2^64
        long aLong = 10000;
        // a rational or irrational number with 32 bit
        // precision of the machine (2^32)
        float aFloat = (float)1.25;
        // a rational or irrational number with 64 bit
        // precision of the machine (2^64)
        double adouble = 1.25;
        // a value that represents true or false
        boolean aBoolean = true;
        // a byte is a value that represents 8bits or
        // aka a byte and is a value that can hold
        // 2^8 = 256 values
        byte aByte= 127;

    }

    public static void LessonFundamentalsLabQ2() {

        /*
        * Question 4
        *
        * Strings are not part of the eight primitive data types,
        * why not?  which of the data types is a String actually
        * composed of? Prove this in your code.
        * */

        /*
        * A String is an Object in java, it has
        * methods and the String is itself
        * immutable, Generally strings at the
        * end of the day are an array of characters
        * primitive type "char" wrapped into an String
        * object.
        * */

        String aString = "My String composed of " +
                "Characters";

        for (char c: aString.toCharArray()) {
            System.out.println(c);
        }

        System.out.println(aString.toCharArray());

    }

    public static void LessonFundamentalsLabQ3() {

        /*
        * Question 5
        *
        * Create a List, populate it with values and
        * then iterate thru those values outputting
        * them to the console.  Why can you not create
        * a List of 'char' or 'int'?
        *
        * A list is an Object and is not designed to
        * take Primitives, unless there is a method for
        * it, but it can take a wrapper class i.e
        * Iterator. =)
        * */

        List<String> aList = new ArrayList<String>();
        aList.add("1st String");
        aList.add("2nd String");
        aList.add("3nd String");
        aList.add("4th String");

        for (String StringIterator: aList) {
            System.out.println(StringIterator);
        }

    }

    public static void LessonFundamentalsLabQ4(){
        /*
        * Question 6
        *
        * Create variables of appropriate data types,
        * to store information regarding a lottery ticket
        * (i.e. GameName, WinningNumbers, Jackpot, DrawingDate, etc..).
        * Populate these variables and output them to the console.
        * */

        String gameName = "Gopher 5";
        List<Integer> winningNumbers= new ArrayList<>();
        int jackPot = 347239;
        Date drawingDate = new Date();

        winningNumbers.add(3);
        winningNumbers.add(19);
        winningNumbers.add(23);
        winningNumbers.add(11);
        winningNumbers.add(27);


        System.out.println(gameName);
        System.out.println("Here are the winning numbers" +
                "for " + gameName + " for the date: " + drawingDate +
        "and the jackpot is " + jackPot + "!");
        for (Integer i: winningNumbers) {
            System.out.print(i + " ");
        }

    }

}


