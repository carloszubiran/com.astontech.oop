package com.astontech.console;

import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * Created by Carlos Zubiran on 5/6/2016.
 */


class LessonFizzBuzzLab {

    /*
    * Question 2
    *
    * Write a loop that counts from 0-100
    * If the value is divisible by 3 print "Fizz"
    * If the value is divisible by 5 print "Buzz"
    * If the value is divisible by 15 print "FizzBuzz"
    * If the value is not divisible by 3,5, or 15 simply print the number
    * */

    public static void LessonFizzBuzzLabQ2(){

        for (int i = 0; i < 101; i++) {
            if (i % 3 == 0) {
                System.out.println(i + " is a number divisible by 3 FIZZ!");
            }
            else if (i % 5 == 0) {
                System.out.println(i + " is a number divisible by 5 BUZZ!");
            }
            else if (i % 15 == 0) {
                System.out.println(i + " is a number divisible by 15 FIZZBUZZ!");
            }
        }


    }

    public static void LessonCalculatorLabQ4() throws Exception{
        /*
        * Question 4
        * Write code that prompts the user to enter a
        * number from 0-9 and then reads the users input.
        * */
        int firstValue = 0;
        int secondValue = 0;
        String operator = "";
        VerifyInput aInputVerifier = new VerifyInput();


        // Set an infinite loop to prompt the user of what to do.
        // If the user has made a valid entry the for loop will increment
        // go to the next screen
        for (int i = 0; i < 3;) {
            if (i == 0) {
                // prompt the user for input
                System.out.println("Please enter your first number 0-9:");
                // check if the user made a proper entry using the
                // VerityInput object with it's proper method else rerun the loop
                if (aInputVerifier.checkForValidNumber()) {
                    firstValue = aInputVerifier.getValidNumber();
                    i++;
                }
            }
            else if (i == 1){
                System.out.println("Please enter your mathematical operator +, -, *, /:");
                if (aInputVerifier.checkForValidOperator()) {
                        operator = aInputVerifier.getValidOperator();
                    i++;
                } else System.out.println("INVALID. Please put in a appropriate operator.");
            }
            else if (i == 2) {
                System.out.println("Please enter your second number 0-9:");
                if (aInputVerifier.checkForValidNumber()) {
                    secondValue = aInputVerifier.getValidNumber();
                    i++;
                }
            }
        }


        switch (operator) {
            case ("+"):
                System.out.println(firstValue + secondValue);
            break;
            case ("-"):
                System.out.println(firstValue - secondValue);
            break;
            case ("*"):
                System.out.println(firstValue * secondValue);
            break;
            case ("/"):

                try {
                    System.out.println(firstValue / secondValue);

                } catch (Exception ex){

                    throw new Exception("You are trying to divide by zero" +
                            "please select another value for your denominator!");
                }


            break;
        }

    }


    private static class VerifyInput{

        private int verifiedInt;
        private String verifiedString = "";
        private Scanner aScanner;

        public VerifyInput() {
        }

        public boolean checkForValidNumber() {
            aScanner = new Scanner(System.in);
            try {
                int testInt = aScanner.nextInt();
                setValidNumber(testInt);
                return true;
            } catch (InputMismatchException ex) {
                System.out.println("INVALID. Please put in a appropriate number.");
                return false;
            }
        }

        public boolean checkForValidOperator() {
            aScanner = new Scanner(System.in);
            String validOperators[] = {"+", "-", "*", "/"};
            String aStringForScanner = aScanner.nextLine();
            for (String i : validOperators) {
                if (aStringForScanner.contentEquals(i)) {
                    setValidOperator(i);
                    return true;
                } else {}
            }
            return false;

        }


        public int setValidNumber(int aNum){
            verifiedInt = aNum;
            return aNum;
        }

        public int getValidNumber(){
            return verifiedInt;
        }

        public String setValidOperator(String aString){
            verifiedString = aString;
            return verifiedString;
        }

        public String getValidOperator(){
            return verifiedString;
        }

    }


}

