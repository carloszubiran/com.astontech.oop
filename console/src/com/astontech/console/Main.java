package com.astontech.console;

import com.astontech.bo.Employee;
import com.astontech.bo.Person;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;
import java.util.concurrent.ExecutionException;



/**
 * Created by Carlos Zubiran on 5/5/2016.
 */
public class Main {

    public static void main(String[] args) {

        //notes:    private static method for the lesson
        LessonMethods();






//        try {
//            LessonExceptions();
//        } catch (Exception ex) {
//            System.out.println(ex.toString());
//        }

//        LessonFizzBuzzLab aFizzBuzzObject = new LessonFizzBuzzLab();
//        aFizzBuzzObject.LessonFizzBuzzLabQ2();
//        try {
//            aFizzBuzzObject.LessonCalculatorLabQ4();
//        } catch (Exception ex) {
//            System.out.println(ex);
//        }

    }

    private static void LessonMethods() {
        //notes:    method signature / declaration
        /*
        *  <access modifier> <instance/static> <return date type> <method name> (<date type> <param name> ...){ body }
        *   private             static              void            LessonMethods     (nothing passed in)
        *
        *   public                                  int             getPersonId         (nothing passed in)
        *
        *   public                                  void            setPersonId             (int personId)
        *
        * */

        //notes:    constructors are special methods with same name as class

        Employee constructorEmployee = new Employee("Carlos", "Zubiran");
        System.out.println(constructorEmployee.getFirstName() + " " + constructorEmployee.getLastName());

        Employee const2Employee = new Employee("Simmer");
        System.out.println(const2Employee.getLastName());

        Employee employeeJames = new Employee("James", "McRoberts");
        System.out.println(employeeJames.GetFullName());

    }

    private static void LessonInheritance() {
        //notes:    4 principles(tenets) Encapsulation, Abstraction, Inheritance, Polymorphism

        Employee employeeZub = new Employee();
        employeeZub.setFirstName("Carlos");
        employeeZub.setLastName("Zubiran");
        employeeZub.setId(3);

        System.out.println(employeeZub.getId()
                + ": " + employeeZub.getFirstName()
                + " " + employeeZub.getLastName());

        Person personZub = new Person();
        personZub.setFirstName("Carlos");
        personZub.setLastName("Zubiran");
        personZub.setId(2);

        System.out.println(personZub.getId()
                + ": " + personZub.getFirstName()
                + " " + personZub.getLastName());

    }

    private static void LessonClassObjects(){
        //notes:    instantiating a a new object
        Person myFirstPerson = new Person();
        myFirstPerson.setFirstName("Carlos");
        myFirstPerson.setLastName("Zubiran");
        myFirstPerson.setTitle("Mr.");

        Person mySecondPerson = new Person();
        mySecondPerson.setFirstName("Miguel");
        mySecondPerson.setLastName("Zubiran");
        mySecondPerson.setTitle("Mr.");

        System.out.print(myFirstPerson.getTitle());
        System.out.print(" ");
        System.out.print(myFirstPerson.getFirstName());
        System.out.print(" ");
        System.out.println(myFirstPerson.getLastName());

        System.out.print(mySecondPerson.getTitle());
        System.out.print(" ");
        System.out.print(mySecondPerson.getFirstName());
        System.out.print(" ");
        System.out.println(mySecondPerson.getLastName());

        //notes:    setting value for super or (inherited class)
        myFirstPerson.setId(3);
        System.out.print(myFirstPerson.getId());











    }

    private static void LessonExceptions() throws Exception{

        //todo:     simple unhandled exception
        String firstName = "Carlos";
        int x = Integer.parseInt(firstName);

        System.out.println("Integer value: ");
        System.out.println(x);

//        // TODO:    try - catch block
//
//        String firstName = "Carlos";
//        try {
//            int x = Integer.parseInt(firstName);
//
//            System.out.println("Integer value: ");
//            System.out.println(x);
//        } catch (NumberFormatException ex) {
//            System.out.println("Exception: Number Format Error.");
//        }
//
//        // TODO:    try - catch with multiple catch blocks
//        String firstName = "Carlos";
//        try {
//            int x = Integer.parseInt(firstName);
//
//            System.out.println("Integer value: ");
//            System.out.println(x);
//        } catch (NumberFormatException ex) {
//            System.out.println("Exception: Number Format Error.");
//        } catch (IllegalArgumentException ex) {
//            System.out.println("Exception: String was null or empty.");
//        } catch (Exception ex) {
//            System.out.println("Exception: Generic Exception.");
//        }
//
//        // TODO:    try - catch with multiple catch and finally
//        String firstName = "Carlos";
//        try {
//            int x = Integer.parseInt(firstName);
//
//            System.out.println("Integer value: ");
//            System.out.println(x);
//        } catch (IllegalArgumentException ex) {
//            System.out.println("Exception: " + ex.toString());
//        } catch (NullPointerException ex) {
//            System.out.println("Exception: " + ex.toString());
//        } catch (Exception ex) {
//            System.out.println("Exception: " + ex.toString());
//        } finally {
//            System.out.println("Program has been completed regardless of exceptions.");
//        }
//
//        // TODO: exception object
//        //notes:    base exception class
//
//        String firstName = "Carlos";
//        try {
//            int x = Integer.parseInt(firstName);
//
//            System.out.println("Integer value: ");
//            System.out.println(x);
//        } catch (NumberFormatException ex) {
//            System.out.println("Exception: Number Format Error.");
//        } catch (IllegalArgumentException ex) {
//            System.out.println("Exception: String was null or empty.");
//        } catch (Exception ex) {
//            System.out.println("Exception: Generic Exception.");
//        } finally {
//            System.out.println("Program has been completed regardless of exceptions.");
//        }
//
//        // TODO:    throwing an exception
//        String firstName = null;
//        try {
//            int x = Integer.parseInt(firstName);
//
//            System.out.println("Integer value: ");
//            System.out.println(x);
//
//        }
//        catch (Exception ex) {
//            throw new Exception();
//            throw new Exception("A Custom Exceptions method", ex);
//        }


    }

    private static void LessonFlowControl(){

        //notes:    IF-ELSE
        String name = "carlos";

        if (name.equals("dan")) {
            System.out.println("correct first name");

        } else {
            System.out.println("incorrect first name");

            if (name.length() > 10) {
                System.out.println("very long first name.");
            } else if(name.length() > 5){
                System.out.println("long first name.");
            } else {
                System.out.println("short first name.");
            }
        }


        //notes:    CASE-SWITCH
        switch (name) {
            case "carlos":
                break;
            case "dan":
            case "danny":
            case "daniel":
                System.out.println("first name is dan, danny or daniel");
                break;
            default:
                break;
        }


    }

    private static void LessonOperatos(){
        //notes:    plus / minus
        int val = 10;
        System.out.println(val + 10);
        System.out.println(val - 10);

        //notes:    modulus (%)
        int modval = 10 % 3; // the remainder 10 / 3 which is 1
        System.out.println(modval);

        //notes:    increment (++) / decrement (++)
        val = 10;
        System.out.println("increment after: ");
        System.out.println(val++);  //10
        System.out.println(val++);  //11
        System.out.println(val++);  //12
        System.out.println(val);    //val = 13;

        //notes:    increment (++) / decrement (++)
        val = 10;
        System.out.println("increment before: ");
        System.out.println(++val);  //11
        System.out.println(++val);  //12
        System.out.println(++val);  //13
        System.out.println(val);    //val;

        //notes:    decrement (++) / decrement (++)
        val = 10;
        System.out.println("decrement after: ");
        System.out.println(val++);  //10
        System.out.println(val++);  //9
        System.out.println(val++);  //8
        System.out.println(val);    //val = 13;

        //notes:    decrement (++) / decrement (++)
        val = 10;
        System.out.println("decrement before: ");
        System.out.println(++val);  //9
        System.out.println(++val);  //8
        System.out.println(++val);  //7
        System.out.println(val);    //val = 7;

        //notes:    logical equals (==) / logical not equals (!=)
        val = 10;
        int anotherVal = 10;

        if(val == anotherVal){
            System.out.println("Equals");
        } else{
            System.out.println("Not Equals");
        }

        //notes:    logical AND (&&) / logical OR (||) single for not short circuit & or |
        if (val == 10 && anotherVal == 10){
            System.out.println("is true");
        }else{
            System.out.println("not true");
        }

        //notes:    negation (!)
        boolean boolVar = true;
        if (!boolVar) {
            System.out.println("is true");
        } else {
            System.out.println("not true");
        }

    }

    private static void LessonLists() {
        //notes: collections / Lists

        List<String> myStringCollection = new ArrayList<String>();

        myStringCollection.add("1st String");
        myStringCollection.add("2nd String");
        myStringCollection.add("3rd String");
        myStringCollection.add("4th String");
        myStringCollection.add("5th String");

        System.out.println(myStringCollection);

        for (String singleString : myStringCollection) {
            System.out.println(singleString);
        }

        List<Integer> myIntCollection = new ArrayList<Integer>();

        myIntCollection.add(10);
        myIntCollection.add(20);
        myIntCollection.add(30);
        myIntCollection.add(40);
        myIntCollection.add(50);

        System.out.println(myIntCollection);

        for (int singleInt : myIntCollection) {
            System.out.println(singleInt);
        }

        //notes:    arrays

        String[] myStringArray = new String[5];

        myStringArray[0] = "1st";
        myStringArray[1] = "2st";
        myStringArray[2] = "3st";
        myStringArray[3] = "4th";
        myStringArray[4] = "5th";

        System.out.println(myStringArray[2]);

        for (String singleString : myStringArray) {
            System.out.println(singleString);
        }

    }

    private static void LessonStrings() {

        //notes:    strings have a value or not
        String firstString = "";
        firstString = "something";
        firstString = null;

        if (firstString == null || firstString.isEmpty()) {
            System.out.println("String is empty");
        } else {
            System.out.println("String has a value");
        }

        //notes:    immutable - unable to be changed
        firstString = "another value";  // this creates a new string

        for (int x = 0; x <= 100; x++) {
            firstString = "new value: " + Integer.toString(x);
            System.out.println(firstString); // we are creating a new string for every iteration!! 100 strings!!
            //VERY INEFFICIENT!!

        }

        //notes:    StringBuilder()
        StringBuilder myStringBuilder = new StringBuilder();
        for (int x = 0; x <= 100; x++) {
            myStringBuilder.append("new value with string builder: ");
            myStringBuilder.append(Integer.toString(x));
            myStringBuilder.append("\n");
        }

        System.out.println(myStringBuilder);

        //notes:    searching strings (indexOf, lastIndexOf)
        String myName = "Zubiran";

        /*
        * String can be visualized as an array of characters.
        *  C   a   r   l   o   s       Z   u   b   i   ....
        * [0] [1] [2] [3] [4] [5] [6] [7] [8] [9] [10] ....
        *
        * note that the array is zero based (starts at zero)
        *
        * character at index 2 is "r"
        *
        * */

        int indexOf = myName.indexOf("r");
        System.out.println(indexOf);

        int lastIndexOf = myName.lastIndexOf("i");
        System.out.println(lastIndexOf);

        //notes:    numerating a string
        String largeString = "This is a longer string than before";
        for (char c : largeString.toCharArray()) {
            System.out.println(c);
        }

        //notes:    substring(beginning index) ot substring (beginning index, end index)
        String partOfLargerString = largeString.substring(8, 16);
        System.out.println(partOfLargerString);

    }

    private static void LessonDataTypes() {
        //notes:    primitive data types
        //          int(number)
        //          float(floating point .)
        //          double(larger number)
        //          boolean(true / false)
        //          char(characters)

        //notes:    common data types
        boolean myBool = false;
        int     myInt = 4;
        String  myString = "Some Words";
        Date    myDate = new Date();

        System.out.println(myBool);
        System.out.println(myInt);
        System.out.println(myString);
        System.out.println(myDate);

        //notes:    parsing / converting data types
        //notes:    String -> int
        String numberString = "341";
        int intFromString = Integer.parseInt(numberString);

        System.out.println(intFromString);

        //notes:    int -> string
        int i = 312;
        String stringFromInt = Integer.toString(i);

        System.out.println(stringFromInt);

        //notes:    date -> string
        String stringFromDate = myDate.toString();

        //notes:    date -> string
        System.out.println(stringFromDate);

    }

    private static void LessonVariables(String ScopeVar){

        //notes:    use variable declared outside of this scope
        System.out.println(ScopeVar);

        //notes:    declare variable
        String lastName = "Zubiran", firstName = "Carlos";

        //notes:    output to console
        System.out.println(firstName + " " + lastName);


        //notes:    create a Scanner Object
        Scanner reader = new Scanner(System.in);
        //notes:    prompt the user
        System.out.println();
        //notes:    read input from the user and store it in a variable
        String input = reader.nextLine();
        //notes:    print the variable back to the screen
        System.out.println("Hello " + input);

    }


}