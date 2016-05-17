//region IMPORTS
package com.astontech.console;
import com.astontech.bo.Employee;
import com.astontech.bo.Person;
import com.astontech.bo.*;
import java.sql.*;
import java.util.*;
import java.util.Date;
import com.astontech.bo.interfaces.Home;
import com.astontech.bo.interfaces.ILocation;
import com.astontech.bo.interfaces.Site;
import com.astontech.console.OOPLab5.*;
import com.astontech.dao.*;
import com.astontech.dao.mysql.*;
import common.helpers.MathHelper;
import org.apache.log4j.Logger;

//endregion

/**
 * Created by Carlos Zubiran on 5/5/2016.
 */
public class Main {

    final static Logger logger = Logger.getLogger(Main.class);

    public static void main(String[] args) {

        LessonDAODelete();

        //region OOPPrinciplesLab4
//
//        // this is coming from a static context
//        int someNum = OOPPrinciplesLab4.aStaticInt;
//        // this is replacing the value in someNum
//        // with a value from an newly instantiated object
//        someNum = new OOPPrinciplesLab4().getNotStaticInt();
//
//        // Objects in java references with variable, primitive types
//        // use values with variables, objects -> reference, primitives -> calculation
//
//        // creating two references, one with a newly instantiated
//        // object, the other is a empty reference.
//        OOPPrinciplesLab4 firstObjectRef = new OOPPrinciplesLab4();
//        OOPPrinciplesLab4 secondObjectRef;
//        // now the second reference points to the same object as the first
//        secondObjectRef = firstObjectRef;
//        System.out.println("Ref in memory for first test \n" + secondObjectRef.hashCode());
//        System.out.println(firstObjectRef.hashCode());
//        // now lets actually put a new object in the second reference
//        secondObjectRef = new OOPPrinciplesLab4();
//        System.out.println("Ref in memory for second test \n" + secondObjectRef.hashCode());
//        System.out.println(firstObjectRef.hashCode());
//
//        // now lets play with primitives
//        int firstInt, secondInt;
//        // set firstInt to one, then add the same value to secondInt
//        // the firstInt Variable
//        firstInt = 1;
//        secondInt = firstInt;
//        // change the firstInt variable to 2
//        firstInt = 2;
//        // print the changes
//        System.out.println("Primitive tests:\n" + secondInt);
//        System.out.println(firstInt);
//
//        // Hash Objects
//        // HashTable
//        Hashtable<Integer, String> aHashTable = new Hashtable<>();
//        aHashTable.put(1, "firstVal");
//        aHashTable.put(2, "secondVal");
//
//        for (Integer k: aHashTable.keySet()) {
//            System.out.println("Key: " + k + " Value: " + aHashTable.get(k));
//        }
//
//        // HashMap
//        HashMap<Integer, String> aHashMap = new HashMap<>();
//        aHashMap.put(1, "firstVal");
//        aHashMap.put(2, "secondVal");
//
//        for (Integer k: aHashMap.keySet()) {
//            System.out.println("Key: " + k + " Value: " + aHashMap.get(k));
//        }
//
//        // HashSet
//        HashSet<String> aHashSet = new HashSet<>();
//        aHashSet.add("firstVal");
//        aHashSet.add("secondVal");
//
//        for (String s: aHashSet) {
//            System.out.println(s);
//        }
//

        //endregion OOPPrinciplesLab4

        //region LessonExceptions
        //        try {
        //            LessonExceptions();
        //        } catch (Exception ex) {
        //            System.out.println(ex.toString());
        //        }
        //endregion

        //region LessonFizzBuzzLab
        //        LessonFizzBuzzLab aFizzBuzzObject = new LessonFizzBuzzLab();
        //        aFizzBuzzObject.LessonFizzBuzzLabQ2();
        //        try {
        //            aFizzBuzzObject.LessonCalculatorLabQ4();
        //        } catch (Exception ex) {
        //            System.out.println(ex);
        //        }
        //endregion LessonFizzBuzzLab
    }


    private static void DOALAB2Employee() {

    }

    private static void LessonDAODelete() {
        PersonDAO personDAO = new PersonDAOImpl();

        if (personDAO.deletePerson(20)) {
            logger.info("Person Deleted Successfully");
        } else {
            logger.info("Person Deleted Failed");
        }

    }

    private static void LessonDAOUpdate() {

        PersonDAO personDAO = new PersonDAOImpl();

        Person person = personDAO.getPersonById(20);
        person.setMiddleName("Iron Man");

        if (personDAO.updatePerson(person)) {
            logger.info("Person updated Successfully.");
        } else{
            logger.info("Person Update Failed!");
        }

        // call usp_ExecPerson(10, personId, Title, FirstName, MiddleName, LastName, DisplayFirstName,
        // Gender, BirthDate, SSN)



    }

    private static void LessonDAOInsert() {

        // call usp_ExecPerson(10, personId, Title, FirstName, MiddleName, LastName, DisplayFirstName,
        // Gender, BirthDate, SSN)

        Person person = new Person();
        person.setTitle("Mr.");
        person.setFirstName("Tony");
        person.setMiddleName("IronMan");
        person.setLastName("Stark");
        person.setDisplayFirstName("Antonio");
        person.setGender("M");
        person.setBirthDate(new Date());
        person.setSSN("yyy-yy-yyyy");

        PersonDAO personDAO = new PersonDAOImpl();
        int id = personDAO.insertPerson(person);

        logger.info("New Person Record Inserted. ID = " + id);

    }

    //region DOA Lab 1

    private static void DOALAB1VehicleModel() {

        //region CREATE MENU
        VehicleModelDAO vehicleModelDAO = new VehicleModelDAOImpl();
        List<VehicleModel> vehicleModelList = vehicleModelDAO.getVehicleModelList();

        System.out.println("=========================");

        for (VehicleModel vehicleModel: vehicleModelList) {
            System.out.println(vehicleModel.getVehicleModelId() + ": ");
        }

        System.out.println("=========================");

        //endregion

        //region PROMPT USER

        Scanner reader = new Scanner(System.in);
        System.out.println("Please select a vehicleModel from list: ");
        String vehicleModelId = reader.next();
        //endregion

        //region GET PERSON DETAILS

        VehicleModel vehicleModelDetail = vehicleModelDAO.getVehicleModelById(Integer.parseInt(vehicleModelId));

        System.out.println("----- VehicleModel Details -----");
        System.out.println("VehicleModelId: " + vehicleModelDetail.getVehicleModelId());
        System.out.println("Vehicle Name: " + vehicleModelDetail.getVehicleModelName());
        System.out.println("Vehicle Make: " + vehicleModelDetail.getVehicleMakeId());



        //endregion

    }

    private static void DOALAB1VehicleMake() {

        //region CREATE MENU
        VehicleMakeDAO vehicleMakeDAO = new VehicleMakeDAOImpl();
        List<VehicleMake> vehicleMakeList = vehicleMakeDAO.getVehicleMakeList();

        System.out.println("=========================");

        for (VehicleMake vehicleMake: vehicleMakeList) {
            System.out.println(vehicleMake.getVehicleMakeId() + ": ");
        }

        System.out.println("=========================");

        //endregion

        //region PROMPT USER

        Scanner reader = new Scanner(System.in);
        System.out.println("Please select a vehicleMake from list: ");
        String vehicleMakeId = reader.next();
        //endregion

        //region GET PERSON DETAILS

        VehicleMake vehicleMakeDetail = vehicleMakeDAO.getVehicleMakeById(Integer.parseInt(vehicleMakeId));

        System.out.println("----- VehicleMake Details -----");
        System.out.println("VehicleMakeId: " + vehicleMakeDetail.getVehicleMakeId());
        System.out.println("Vehicle Name: " + vehicleMakeDetail.getVehicleMakeName());
        System.out.println("CreateDate: " + vehicleMakeDetail.getCreateDate());



        //endregion

    }

    private static void DOALAB1Vehicle() {

        //region CREATE MENU
        VehicleDAO vehicleDAO = new VehicleDAOImpl();
        List<Vehicle> vehicleList = vehicleDAO.getVehicleList();

        System.out.println("=========================");

        for (Vehicle vehicle: vehicleList) {
            System.out.println(vehicle.getVehicleId() + ": ");
        }

        System.out.println("=========================");

        //endregion

        //region PROMPT USER

        Scanner reader = new Scanner(System.in);
        System.out.println("Please select a vehicle from list: ");
        String vehicleId = reader.next();
        //endregion

        //region GET PERSON DETAILS

        Vehicle vehicleDetail = vehicleDAO.getVehicleById(Integer.parseInt(vehicleId));

        System.out.println("----- Vehicle Details -----");
        System.out.println("VehicleId: " + vehicleDetail.getVehicleId());
        System.out.println("Year: " + vehicleDetail.getYear());
        System.out.println("LicencePlate: " + vehicleDetail.getLicensePlate());
        System.out.println("VIN: " + vehicleDetail.getVIN());
        System.out.println("Color: " + vehicleDetail.getColor());
        System.out.println("IsPurchase: " + vehicleDetail.isPurchase());
        System.out.println("PurchasePrice: " + vehicleDetail.getPurchasePrice());
        System.out.println("PurchaseDate: " + vehicleDetail.getPurchaseDate());
        System.out.println("VehicleId: " + vehicleDetail.getVehicleId());
        System.out.println("VehicleModelId: " + vehicleDetail.getVehicleModel());


        //endregion

    }

    private static void DOALAB1Email() {

        //region CREATE MENU
        EmailDAO emailDAO = new EmailDAOImpl();
        List<Email> emailList = emailDAO.getEmailList();

        System.out.println("=========================");

        for (Email email: emailList) {
            System.out.println(email.getEmailId() + ": ");
        }

        System.out.println("=========================");

        //endregion

        //region PROMPT USER

        Scanner reader = new Scanner(System.in);
        System.out.println("Please select a email from list: ");
        String emailId = reader.next();
        //endregion

        //region GET PERSON DETAILS

        Email emailDetail = emailDAO.getEmailById(Integer.parseInt(emailId));

        System.out.println("----- Email Details -----");
        System.out.println("EmailId: " + emailDetail.getEmailId());
        System.out.println("EmailAddress: " + emailDetail.getEmailAddress());
        System.out.println("EmployeeId: " + emailDetail.getEmployeeId());
        System.out.println("EntityTypeId: " + emailDetail.getEntityType().getId());

        //endregion

    }

    private static void DOALAB1Phone() {

        //region CREATE MENU
        PhoneDAO phoneDAO = new PhoneDAOImpl();
        List<Phone> phoneList = phoneDAO.getPhoneList();

        System.out.println("=========================");

        for (Phone phone: phoneList) {
            System.out.println(phone.getPhoneId() + ": ");
        }

        System.out.println("=========================");

        //endregion

        //region PROMPT USER

        Scanner reader = new Scanner(System.in);
        System.out.println("Please select a phone from list: ");
        String phoneId = reader.next();
        //endregion

        //region GET PERSON DETAILS

        Phone phoneDetail = phoneDAO.getPhoneById(Integer.parseInt(phoneId));

        System.out.println("----- Phone Details -----");
        System.out.println("PhoneId: " + phoneDetail.getPhoneId());
        System.out.println("EntityTypeId: " + phoneDetail.getEntityTypeId());
        System.out.println("ClientId: " + phoneDetail.getClientId());
        System.out.println("PersonId: " + phoneDetail.getPersonId());
        System.out.println("AreaCode: " + phoneDetail.getAreaCode());
        System.out.println("PhoneNumber: " + phoneDetail.getPhoneNumber());
        System.out.println("PhoneNumberPost: " + phoneDetail.getPhoneNumberPost());



        //endregion

    }

    private static void DOALAB1Employee() {

        //region CREATE MENU
        EmployeeDAO employeeDAO = new EmployeeDAOImpl();
        List<Employee> employeeList = employeeDAO.getEmployeeList();

        System.out.println("=========================");

        for (Employee employee: employeeList) {
            System.out.println(employee.getEmployeeId() + ": "
                    + employee.getLastName() + ". " +employee.getFirstName());
        }

        System.out.println("=========================");

        //endregion

        //region PROMPT USER

        Scanner reader = new Scanner(System.in);
        System.out.println("Please select a employee from list: ");
        String employeeId = reader.next();
        //endregion

        //region GET PERSON DETAILS

        Employee employeeDetail = employeeDAO.getEmployeeById(Integer.parseInt(employeeId));

        System.out.println("----- Employee Details -----");
        System.out.println("Employee Id: " + employeeDetail.getEmployeeId());
        System.out.println("CreateDate: " + employeeDetail.getCreateDate());
        System.out.println("TermDate: " + employeeDetail.getTermDate());
        System.out.println("HireDate: " + employeeDetail.getHireDate());

        //endregion

    }

    //endregion

    private static void LessonDAO() {

        //region CREATE MENU
        PersonDAO personDAO = new PersonDAOImpl();
        List<Person> personList = personDAO.getPersonList();

        System.out.println("=========================");

        for (Person person: personList) {
            System.out.println(person.getPersonId() + ": "
            + person.getLastName() + ". " +person.getFirstName());
        }

        System.out.println("=========================");

        //endregion

        //region PROMPT USER

        Scanner reader = new Scanner(System.in);
        System.out.println("Please select a person from list: ");
        String personId = reader.next();
        //endregion

        //region GET PERSON DETAILS

        Person personDetail = personDAO.getPersonById(Integer.parseInt(personId));

        System.out.println("----- Person Details -----");
        System.out.println("Full Name: " + personDetail.GetFullName());
        System.out.println("DOB: " + personDetail.getBirthDate());
        System.out.println("SSN: " + personDetail.getBirthDate());

        //endregion

    }

    private static void DatabaseConnectionLab() {

        Connection conn = DatabaseConnectionToMSSQLLab();

        try{
            String sql =    "select  a.employeeID," +
                            "b.firstName," +
                            "b.lastName " +
                            "from Employee a " +
                            "inner join Person b on a.PersonId = b.PersonId;";
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);

            while (rs.next()) {
                int employeeId = rs.getInt(1);
                String firstName = rs.getString(2);
                String lastName = rs.getString(3);

                logger.info("employeeId" + employeeId + "FirstName: " + firstName + " - LastName" + lastName);
            }
            conn.close();

        }
        catch (SQLException sqlEx){
            logger.error(sqlEx);
        }

    }

    private static Connection DatabaseConnectionToMSSQLLab() {

        String dbName = "AstonEngineer";
        String dbUser = "carlzubi1";
        String dbPass = "";

        String connectionUrl = "jdbc:sqlserver://localhost:1433" +
                ";integratedSecurity=true"+
                ";databaseName=" + dbName +
                ";user=" + dbUser +
                ";password=" + dbPass + ";";

        try {
            Connection con = DriverManager.getConnection(connectionUrl);
            logger.info("Microsoft Connection Success.");
            return con;

        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }

    }

    private static void LessonStoreProcedure() {
        Connection conn = LessonDBConnection();
        try {
            String sp = "{call usp_GetPerson(?,?)}";
            CallableStatement cStmt = conn.prepareCall(sp);

            cStmt.setInt(1, 10);    // note: (index, value) for the usp_GetPerson(?,?)
            cStmt.setInt(2, 2);     // note: (index, value)
            ResultSet rs = cStmt.executeQuery();

            while (rs.next()) {

                /*
                *   a.PersonId,         index 1 INT
					a.Title,            index 2 VARCHAR
                    a.FirstName,        index 3 VARCHAR
					a.LastName,         index 4 VARCHAR
					a.CreateDate,       index 5 VARCHAR
					a.DisplayFirstName, index 6 VARCHAR
					a.IsDeleted,        index 7 DATETIME
					a.Gender            index 8 VARCHAR
                * */

                logger.info(rs.getString(2) + ": " + rs.getString(3) + ": " + rs.getString(4));
            }

        }
        catch (SQLException sqlEx) {
            logger.error(sqlEx);
        }
    }

    private static void LessonExecQuery() {
        Connection conn = LessonDBConnection();

        try{
            Statement statement = conn.createStatement();
            String sql = "select PersonId, firstName, lastName from person";

            ResultSet rs = statement.executeQuery(sql);

            while (rs.next()) {
                int personId = rs.getInt(1);
                String firstName = rs.getString(2);
                String lastName = rs.getString(3);

                logger.info("personId" + personId + "FirstName: " + firstName + " - LastName" + lastName);
            }
            conn.close();

        }
        catch (SQLException sqlEx){
            logger.error(sqlEx);
        }



    }

    private static Connection LessonDBConnection() {

        String dbHost = "localhost";
        String dbName = "astonengineer";
        String dbUser = "consoleUser";
        String dbPass = "qwe123$!";
        String useSSL = "false";
        String procBod = "true";

        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException ex) {
            logger.error("MySQL Driver not found! " + ex);
            return null;
        }

        logger.info("MySQL Driver Registered.");
        Connection connection = null;

        try {
            connection = DriverManager.getConnection("jdbc:mysql://" + dbHost + ":3306/" + dbName
                    + "?useSSL=" + useSSL + "&noAccessToProcedureBodies=" + procBod, dbUser, dbPass);
        }
        catch (SQLException ex) {
            logger.error("Connection failed!" + ex);
            return null;
        }

        if (connection != null) {
            logger.info("Successfully connected to MySQL database");
            return connection;
        } else {
            logger.info("Connection failed!");
            return null;
        }



    }

    private static void OOPPrinciplesLab5() {

        //region Implements

//        Desktop aDesktop = new Desktop(1000, 32, false, false);
//        Laptop aLaptop = new Laptop(15.5, 500, 16, true);

        // using the method for the IComputer interface
        // using the has methods for IComputer too
        // see if there is a display or a ssd in the computer
//        OOPPrinciplesLabForInterface(aDesktop);
//        OOPPrinciplesLabForInterface(aLaptop);

//        System.out.println(new ReverseCharArray().getAndSetStringInReverse("Carlos"));

        Person a = new Person();
        Person b = new Person();

        a.setFirstName("Carlos");
        b.setFirstName("Bipin");

        System.out.println(a.compareTo(b));;

        //endregion Implements


        //region String Helper and Math Helper

        // Using 3 StringHelper Methods
//        char aCharArray[] = {'H', 'e', 'l', 'l', 'o'};
//        System.out.println(StringHelper.arrayOfCharsToString(aCharArray));
//
//        String[] aStringArray = {"Hello ", "There! ", "HAHAHAHAHAHA!"};
//        System.out.println(StringHelper.convertStringArrayIntoASingleString(aStringArray));
//
//        String[] anotherStringArray;
//
//        anotherStringArray = StringHelper.seperateWordsAndPutIntoAnArrayThenStripNonWordChars("Hello There Hi!");
//
//        for (String s: anotherStringArray) {
//            System.out.println(s);
//        }

//        System.out.println(MathHelper.Power((1.0/2),6));
//
//        System.out.println(MathHelper.areaOfACircle(3));
//
//        System.out.println(MathHelper.areaOfARectangle(3,5));

        //endregion String Helper and Math Helper



    }

    private static void OOPPrinciplesLabForInterface(IComputer aComputer) {
        System.out.println("Does this computer have a Display?");
        System.out.println(aComputer.hasDisplay());
        System.out.println("Does this computer have an SSD?");
        System.out.println(aComputer.hasSSD());
    }

    private static void LessonLogging() {

        //notes:    levels of logging.
        logger.debug("This is a DEBUG log message");
        logger.info("This is an INFO log message");

        //notes:    production levels
        logger.warn("This is a WARN log message");
        logger.error("This is a ERROR log message");
        logger.fatal("This is a Fatal log message");

        //notes:    log an exception
        try {
            int i = 10 / 0;

        }
        catch (ArithmeticException ex) {
            System.out.println("An error Occurred! Please " +
                    "contact your system admin.");
            logger.error("An exception occurred: " + ex);
        }
    }

    private static void LessonInterfacesTest() {
        Site MN010 = new Site();
        MN010.setSiteName("MN010");
        MN010.setCoffeeMachines(2);
        MN010.setCoffeeMachines(1);
        MN010.setConferenceRooms(1);
        MN010.setCubicles(7);
        MN010.setOffices(6);
        MN010.setTrainingDesks(36);

        Home CarlosHouse = new Home();
        CarlosHouse.setAddress("1 Main St.");
        CarlosHouse.setOwner(new Employee("Carlos", "Zubiran"));

        lessonInterfaces(MN010);
        lessonInterfaces(CarlosHouse);

    }

    private static void lessonInterfaces(ILocation Ilocation) {
        System.out.println("===============");
        System.out.println("Location Name: " + Ilocation.getLocationName());
        System.out.println("Can Have Meetings: " + Ilocation.canHaveMeetings());
        System.out.println("Number of Workspaces: " + Ilocation.numberOfWorkspaces());
        System.out.println("Has Coffee: " + Ilocation.hasCoffee());
    }

    public static class OOPPrinciplesLab4 {

        public static int aStaticInt = 0;
        private int notStaticInt = 0;

        private int getNotStaticInt() {
            return notStaticInt;
        }

        private void setNotStaticInt(int notStaticInt) {
            this.notStaticInt = notStaticInt;
        }
    }

    private static void LessonValueVsRef() {
        //notes:    reference type
        Employee firstEmp = new Employee();
        firstEmp.setFirstName("Carlos");

        Employee secondEmp = firstEmp;
        firstEmp.setFirstName("Dean");
        secondEmp.setFirstName("Bob");

        System.out.println(secondEmp.getFirstName());

        //notes:    value types
        int firstInt = 10;
        int secondInt = firstInt;

        firstInt = 20;

        System.out.println(secondInt);

    }

    private static void LessonHash() {
        //notes:    key-value pairs / value list

        //todo:     HashTable
        /*
        * 1) does NOT allow null for either key or value
        * 2) synchronized, thread safe, but performance is decreased
        * */

        System.out.println("---HASH TABLE---");

        Hashtable<Integer, String> firstHashTable = new Hashtable<>();
        firstHashTable.put(1, "Inheritance");
        firstHashTable.put(2, "Polymorphism");
        firstHashTable.put(3, "Abstraction");
        firstHashTable.put(4, "Encapsulation");
//        firstHashTable.put(5, null);    // throw a NullPointerExemption (NPE)

        System.out.println("value from given key:" + firstHashTable.get(3));

        for (Integer key : firstHashTable.keySet()) {
            System.out.println("key: " + key + " value:" + firstHashTable.get(key));
        }

        System.out.println("----------------");

        //todo:     hashMap
        /*
        * 1) DOES allow null for either key or value
        * 2) un-synchronized, not thread safe , better performance
        * */

        System.out.println("---HASH MAP---");

        HashMap<Integer, String> firstHashMap = new HashMap<>();

        firstHashMap.put(1, "Inheritance");
        firstHashMap.put(2, "Polymorphism");
        firstHashMap.put(3, "Abstraction");
        firstHashMap.put(4, "Encapsulation");
        firstHashMap.put(5, null);    // throw a NullPointerExemption (NPE)


        System.out.println("value from given key:" + firstHashMap.get(3));

        for (Integer key : firstHashMap.keySet()) {
            System.out.println("key: " + key + " value:" + firstHashMap.get(key));
        }

        System.out.println("----------------");


        //todo:     hashSet
        /*
        * 1) built in mechanism for duplicates
        * 2) used for where you want to maintain a unique list
        * */

        System.out.println("---HASH SET---");

        HashSet<String> oopPrinc = new HashSet<>();
        oopPrinc.add("Inheritance");
        oopPrinc.add("Encapsulation");
        oopPrinc.add("Encapsulation");
        oopPrinc.add("Encapsulation");

        if (oopPrinc.contains("Polymorphism")) {
            System.out.println("value exists");
        } else {
            System.out.println("value does not exists");
        }
        oopPrinc.contains("Encapsulation");

        for (String s : oopPrinc) {
            System.out.println(s);
        }


        System.out.println("----------------");

    }

    private static void LessonPolymorphism() {
        //notes:    compile time Polymorphism - overloaded

        //notes:    run-time Polymorphism - override
        BaseBO baseBO = new BaseBO();
        System.out.println(baseBO.test_method());

        EntityType entityType = new EntityType();
        System.out.println(entityType.test_method());


    }

    private static void LessonInstanceVsStatic() {

        System.out.println(Math.E);
        System.out.println(Math.PI);

        System.out.println(MathHelper.square(4));

        // Fully qualified namespace in java
        common.helpers.MathHelper blah = new common.helpers.MathHelper();
    }

    private static void LessonCollectionLAB() {

        List<Vehicle> groupOfVehicles = new ArrayList<>();

        groupOfVehicles.add(new Vehicle());
        groupOfVehicles.add(new Vehicle());
        groupOfVehicles.add(new Vehicle());

        // Set the id from the inherited class of BaseBO
        groupOfVehicles.get(0).setId(0);
        groupOfVehicles.get(1).setId(1);
        groupOfVehicles.get(2).setId(2);

        // Set the makes of all Vehicles in the list, calling the
        // appropriate get methods to get the desired object
        // then set the attribute.
        groupOfVehicles.get(0).getVehicleMake().setVehicleMakeName("Citroen");
        groupOfVehicles.get(1).getVehicleMake().setVehicleMakeName("Audi");
        groupOfVehicles.get(2).getVehicleMake().setVehicleMakeName("Dacia");
        // Same " but for the Vehicle Model instead of the make.
        groupOfVehicles.get(0).getVehicleModel().setVehicleModelName("Berlingo");
        groupOfVehicles.get(1).getVehicleModel().setVehicleModelName("A3");
        groupOfVehicles.get(2).getVehicleModel().setVehicleModelName("Sandero");

        for (Vehicle v : groupOfVehicles) {
            System.out.println(v.toString());
        }


    }

    private static void LessonComplexProperties() {

        //notes:    when to use inheritance (should answer the question 'IS A'
        //          when to use complex (nested) objects (should answer the questionL 'HAS A')

        EntityType emailWorkType = new EntityType("Work");
        emailWorkType.setEntityTypeId(1);

        Email myEmail = new Email("carlos@carlos.com");
        myEmail.setEntityType(emailWorkType);

        System.out.println(myEmail.getEmailAddress() + " Type: "
                + myEmail.getEntityType().getEntityTypeName());

        //notes:    collection/list of complex(nested) objects as a property.
        Employee myEmployee = new Employee();
        myEmployee.getEmails().add(new Email("test@test.com"));
        myEmployee.getEmails().add(new Email("dan@test.com"));
        myEmployee.getEmails().add(new Email("jason@test.com"));

        for (Email email : myEmployee.getEmails()) {
            System.out.println(email.getEmailAddress());

        }
    }

    private static void LessonCollections() {

        //notes:    List<T> - generic type 'T'
        List<Employee> employeeList = new ArrayList<>();

        Employee emp1 = new Employee("Dan", "Simmer");
        Employee emp2 = new Employee("James", "McRoberts");
        Employee emp3 = new Employee("Sean", "Nilsen");

        employeeList.add(emp1); // index 0
        employeeList.add(emp2); // 1
        employeeList.add(emp3); // 2
        employeeList.add(new Employee("Adrian", "Ratanyake"));  //3
        employeeList.add(new Employee("John", "Doe"));          //4

        System.out.println(employeeList.get(0).GetFullName());

        for (Employee e : employeeList) {
            System.out.println(e.GetFullName());
        }


    }

    private static void LessonObjectsLab() {


        // Create all BOs
        Address anAddress = new Address();
        Client aClient = new Client();
        ClientContract theClientContract = new ClientContract();
        Email aEmail = new Email();
        Employee anEmployee = new Employee();
        EmployeeProject aEmployeeProject = new EmployeeProject();
        Entity aEntity = new Entity();
        EntityType aEntityType = new EntityType();
        LoyaltyAccount aLoyaltyAccount = new LoyaltyAccount();
        LoyaltyCompany aLoyaltyCompany = new LoyaltyCompany();
        Person aPerson = new Person();
        Phone aPhone = new Phone();
        Project aProject = new Project();
        ProjectStatus theProjectStatus = new ProjectStatus();
        Review aReview = new Review();
        ReviewData theReviewData = new ReviewData();
        Training theTraining = new Training();
        TrainingData theTrainingData = new TrainingData();
        Vehicle aVehicle = new Vehicle();
        VehicleMake theVehicleMake = new VehicleMake();
        VehicleModel theVehicleModel = new VehicleModel();
        VehicleStatus theVehicleStatud = new VehicleStatus();

        anAddress.setCity("Saint Paul");
        aClient.setClientName("Carlos Zubiran");
        theClientContract.setPersonId(1);

        System.out.println(anAddress.getCity());
        System.out.println(aClient.getClientName());
        System.out.println(theClientContract.getPersonId());
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

    private static void LessonClassObjects() {
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

    private static void LessonExceptions() throws Exception {

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

    private static void LessonFlowControl() {

        //notes:    IF-ELSE
        String name = "carlos";

        if (name.equals("dan")) {
            System.out.println("correct first name");

        } else {
            System.out.println("incorrect first name");

            if (name.length() > 10) {
                System.out.println("very long first name.");
            } else if (name.length() > 5) {
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

    private static void LessonOperatos() {
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

        if (val == anotherVal) {
            System.out.println("Equals");
        } else {
            System.out.println("Not Equals");
        }

        //notes:    logical AND (&&) / logical OR (||) single for not short circuit & or |
        if (val == 10 && anotherVal == 10) {
            System.out.println("is true");
        } else {
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
        int myInt = 4;
        String myString = "Some Words";
        Date myDate = new Date();

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

    private static void LessonVariables(String ScopeVar) {

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