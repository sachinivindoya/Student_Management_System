/*
  @ Author       : sachini vinodya

*/
import java.util.*;
public class Main {
    public static Scanner input = new Scanner(System.in);          //Input Scanner
    public static String[] SIDArray = new String[0];               //Student ID array = SIDArray
    public static String[] SNArray = new String[0];                //Student name array = SNArray
    public static double[] PMArray = new double[0];                //Programming Fundamental Marks Array = PMArray
    public static double[] DMArray = new double[0];                //Database ManagementSystem Marks Array = DMArray

    public static void main(String[] args) { //main method
        printHomePage();                     //Print Homepage Method
    }
    public static void printHomePage() {  //print Homepage
        System.out.println("------------------------------------------------------------------------------");
        System.out.println("|                WELCOME TO GDSE MARKS MANAGEMENT SYSTEM                     |");
        System.out.println("------------------------------------------------------------------------------");
        System.out.print("\n[1] Add New Student                     [2]Add New Student With Marks");
        System.out.print("\n[3] Add Marks                           [4] Update Student Details");
        System.out.print("\n[5] Update Marks                        [6]Delete Student");
        System.out.print("\n[7] Print Student Details               [8]Print Student Ranks");
        System.out.print("\n[9] Best in Programming Fundamentals    [10]Best in Datbase Management System");

        System.out.print("\n\nEnter an option to continue > ");
        int x = input.nextInt();
        if (x == 1) {                   //[1] Add New Student Method
            input.nextLine();
            clearConsole();
            addNewStudent();
        } else if (x == 2) {            //[2]Add New Student With Marks Method
            input.nextLine();
            clearConsole();
            addNewStudentWithMarks();
        } else if (x == 3) {            //[3] Add Marks Method
            input.nextLine();
            clearConsole();
            addMarks();
        } else if (x == 4) {            //[4] Update Student Details Method
            input.nextLine();
            clearConsole();
            updateStudentDetails();
        } else if (x == 5) {            //[5] Update Marks Method
            input.nextLine();
            clearConsole();
            updateMarks();
        } else if (x == 6) {            //[6]Delete Student Method
            input.nextLine();
            clearConsole();
            deleteStudent();
        } else if (x == 7) {            //[7] Print Student Details Method
            input.nextLine();
            clearConsole();
            printStudentDetails();
        } else if (x == 8) {            //[8]Print Student Ranks Method
            input.nextLine();
            clearConsole();
            printStudentsRanks();
        }else if (x == 9) {             //[9] Best in Programming Fundamentals Method
            input.nextLine();
            clearConsole();
            bestInPrf();
        }else if (x == 10) {           //[10]Best in Datbase Management System Method
            input.nextLine();
            clearConsole();
            bestInDbms();
        }
    }
    public static void addNewStudent() {      //[1] Add New Student
        boolean MainL = true;
        while (MainL) {                       //Main while loop for Input student ID and Name
            System.out.println("------------------------------------------------------------------------------");
            System.out.println("|                          ADD NEW STUDENT                                   |");
            System.out.println("------------------------------------------------------------------------------");
            boolean INSId = true;
            while (INSId) {
                System.out.print ("\nEnter Student ID    : ");
                String sIdValue = input.nextLine();
                if ( checkDiId(sIdValue) ) {                              //check duplicated student id
                    System.out.print("The Student ID already exists\n");
                } else {
                    INSId = false;
                    SIDArray = incrementSIDArray(sIdValue);               //increment old Student ID Array Length and store new Student ID value into incremented Student Id Array (using method)
                    PMArray = incrementPMArray();                         //increment Programming Fundamental Marks Array Length(using method)
                    DMArray = incrementDMArray();                         //increment Database ManagementSystem Marks Array Length(using method)
                    System.out.print("Enter Student  name : ");
                    String sNameValue = input.nextLine();
                    SNArray = incrementSNArray(sNameValue);               //increment old Student Name Array Length and store new Student Name value into incremented Student Name Array (using method)
                    System.out.print("\nStudent has been added sucessfully. Do you want to add a new student (y/n) : ");
                    String check = input.nextLine();
                    if (check.equals("y")) {
                        clearConsole();
                    } else if (check.equals("n")) {
                        MainL = false;
                        clearConsole();
                        printHomePage();
                    }
                }
            }
        }
    }
    public static boolean checkDiId(String sIdValue) {           //Get new Student Id and check Student Id was duplicated and return boolean value
        boolean duplicate = false;
        for (String i : SIDArray ) {
            if ( sIdValue.equals(i) ) {
                duplicate = true;
                break;
            }
        }
        return duplicate;
    }
    public static String[] incrementSIDArray(String sIdValue) {   //Get new Student Id and increment old Student Id Array length and assign into new Student Id Array
        String[] temp = new String[(SIDArray.length) + 1];
        for (int i = 0; i < SIDArray.length; i++) {
            temp[i] = SIDArray[i];
        }
        temp[temp.length - 1] = sIdValue;
        return temp;
    }
    public static double[] incrementPMArray() {                   //Increment marks array length and assign -1 value into new element
        double[] temp = new double[(PMArray.length) + 1];
        for (int i = 0; i < PMArray.length; i++) {
            temp[i] = PMArray[i];
        }
        temp[temp.length - 1] = -1;
        return temp;
    }
    public static double[] incrementDMArray() {                   //Increment marks array length and assign -1 value into new element
        double[] temp = new double[(DMArray.length) + 1];
        for (int i = 0; i < DMArray.length; i++) {
            temp[i] = DMArray[i];
        }
        temp[temp.length - 1] = -1;
        return temp;
    }
    public static String[] incrementSNArray(String sNameValue) {  //Get new Student name and increment old Student name Array length and assign into new Student name Array
        String[] temp = new String[(SNArray.length) + 1];
        for (int i = 0; i < SNArray.length; i++) {
            temp[i] = SNArray[i];
        }
        temp[temp.length - 1] = sNameValue;
        return temp;
    }
    public static void addNewStudentWithMarks() {          //[2]Add New Student With Marks Method
        boolean MainL = true;
        while ( MainL ) {
            System.out.println("------------------------------------------------------------------------------");
            System.out.println("|                      ADD NEW STUDENT WITH MARKS                            |");
            System.out.println("------------------------------------------------------------------------------");
            boolean INSId = true;
            while ( INSId ) {
                System.out.print("\nEnter Student ID    : ");
                String sIdValue = input.nextLine();
                if ( checkDiId(sIdValue)  ) {                                                     //check duplicated student id
                    System.out.print("The Student ID already exists\n");
                } else {
                    SIDArray = incrementSIDArray(sIdValue);                                      //increment old Student ID Array Length and store new Student ID value into incremented Student Id Array (using method)
                    System.out.print("Enter Student  name : ");
                    String sNameValue = input.nextLine();
                    SNArray = incrementSNArray( sNameValue );                                    //increment old Student Name Array Length and store new Student Name value into incremented Student Name Array (using method)
                    boolean tryPrfM = true;
                    boolean tryDbmsM = false;
                    while ( tryPrfM ) {
                        System.out.print("Programming Fundamentals Marks   : ");
                        double prfmarks = input.nextDouble();
                        if (prfmarks >= 0 && prfmarks <= 100) {
                            PMArray = increment_StorePMArray(prfmarks);                          //Increment and Store entered new Programming Fundamentals Marks into Programming Fundamentals Marks Array
                            tryPrfM = false;
                            tryDbmsM = true;
                        } else {
                            System.out.print("Invalid marks. please enter correct marks.\n\n");
                        }
                    }
                    while ( tryDbmsM ) {
                        System.out.print("Database Management System Marks : ");
                        double dbmsmarks = input.nextDouble();
                        if (dbmsmarks >= 0 && dbmsmarks <= 100) {
                            DMArray = increment_StoreDMArray(dbmsmarks);                         //Increment and Store entered new Database Management System Marks into Database ManagementSystem Marks Array
                            tryDbmsM = false;
                        } else {
                            System.out.print("Invalid maks. please enter correct marks.\n\n");
                        }
                    }
                    input.nextLine();
                    System.out.print("\nStudent has been added sucessfully. Do you want to add a new student (y/n) : ");
                    String check = input.nextLine();
                    if (check.equals("y")) {
                    } else if (check.equals("n")) {
                        INSId = false;
                        MainL = false;
                        clearConsole();
                        printHomePage();
                    }
                }
            }
        }
    }
    public static double[] increment_StorePMArray(double newprfvalue) {     //Get new Programming Fundamentals Marks and increment old Programming Fundamentals Marks Array length and assign into new Programming Fundamentals Marks Array
        double[] temp = new double[(PMArray.length) + 1];
        for (int i = 0; i < PMArray.length; i++) {
            temp[i] = PMArray[i];
        }
        temp[temp.length - 1] = newprfvalue;
        return temp;
    }
    public static double[] increment_StoreDMArray(double newdbmsvalue) {    //Get new Database Management System Marks and increment old Database Management System Marks Array length and assign into new Database Management System Marks
        double[] temp = new double[(DMArray.length) + 1];
        for (int i = 0; i < DMArray.length; i++) {
            temp[i] = DMArray[i];
        }
        temp[temp.length - 1] = newdbmsvalue;
        return temp;
    }
    public static void addMarks() {              //[3] Add Marks Method
        boolean MainL = true;
        while ( MainL ) {
            System.out.println("------------------------------------------------------------------------------");
            System.out.println("|                                ADD MARKS                                   |");
            System.out.println("------------------------------------------------------------------------------");
            System.out.print("\nEnter Student ID : ");
            String studentid = input.nextLine();
            if ( searchSId( studentid ) ) {                                                    //check student id is already stored in the student id array using method
                int studentindex = getIndexUsingSID( studentid );                              //get entered student id index using method
                if (PMArray[studentindex] == (-1)) {
                    boolean addPRFMarks = true;
                    boolean addDBMSMarks = false;
                    while (addPRFMarks) {
                        System.out.print("\nProgramming Fundamentals Marks   : ");
                        double prfmarks = input.nextDouble();
                        if (prfmarks >= 0 && prfmarks <= 100) {
                            PMArray[studentindex] = prfmarks;                                  //store prf marks into entred id index
                            addPRFMarks = false;
                            addDBMSMarks = true;
                        } else {
                            System.out.print("Invalid marks. please enter correct marks.\n");
                        }
                    }
                    while (addDBMSMarks) {
                        System.out.print("Database Management System Marks : ");
                        double dbmsmarks = input.nextInt();
                        if (dbmsmarks >= 0 && dbmsmarks < 100) {
                            DMArray[studentindex] = dbmsmarks;                                 //store dbms marks into entered id index
                            addDBMSMarks = false;
                            input.nextLine();
                            System.out.print("Marks have been added. Do you want to add marks for another student? (y/n) : ");
                            String doretry1 = input.nextLine();
                            if (doretry1.equals("y")) {
                                clearConsole();
                            } else if (doretry1.equals("n")) {
                                MainL = false;
                                clearConsole();
                                printHomePage();
                            }
                        } else {
                            System.out.print("Invalid marks. please enter correct marks.\n\n");
                        }
                    }
                } else {
                    System.out.print("This student's marks have been already added. ");
                    System.out.print("\nIf you want to update the marks. please use [4] Update Marks option.");
                    System.out.print("\n\n Do you want to add marks for another student? (y/n) : ");
                    String doretry2 = input.nextLine();
                    if (doretry2.equals("y")) {
                        clearConsole();
                    } else if (doretry2.equals("n")) {
                        MainL = false;
                        clearConsole();
                        printHomePage();
                    }
                }
            } else {
                System.out.print("Invalid Student ID. Do you want to search again? (y/n) ");
                String doretry3 = input.nextLine();
                if (doretry3.equals("y")) {
                } else if (doretry3.equals("n")) {
                    MainL = false;
                    clearConsole();
                    printHomePage();
                }
            }
        }
    }
    public static boolean searchSId( String studentid ) {            ////Search Student id is already stored in student id array (method) ////
        boolean validate = false;
        for (String i : SIDArray ) {
            if (i.equals(studentid)) {
                validate = true;
                break;
            }
        }
        return validate;
    }
    public static int getIndexUsingSID(String studentid) {          ////Get Student id's index using ID (method) ////
        int index = 0;
        for (int i = 0; i < SIDArray.length; i++) {
            if (SIDArray[i].equals(studentid)) {
                index = i;
                break;
            }
        }
        return index;
    }
    public static void updateStudentDetails() {         //[4] Update Student Details Method
        boolean MainL = true;
        while (MainL) {
            System.out.println("------------------------------------------------------------------------------");
            System.out.println("|                         UPDATE STUDENT DETAILS                             |");
            System.out.println("------------------------------------------------------------------------------");
            System.out.print("\nEnter Student ID : ");
            String studentid = input.nextLine();
            if ( searchSId( studentid ) ) {                                         //check student id is already stored in the student id array using method
                int studentindex = getIndexUsingSID(studentid);                     //get entered student id index using method
                System.out.print("\nStudent name : " + SNArray[studentindex]);
                System.out.print("\n\nEnter the new student name : ");
                String newstudentname = input.nextLine();
                SNArray[studentindex] = newstudentname;                             //store ame into student name array
                System.out.print("\nStudent details has been updated successfully.");
                System.out.print("\nDo you want to update another student details? (y/n)");
                String checkretry = input.nextLine();
                if (checkretry.equals("y")) {
                    clearConsole();
                } else if (checkretry.equals("n")) {
                    MainL = false;
                    clearConsole();
                    printHomePage();
                }
            } else {
                System.out.print("\nInvalid Student ID. Do you want to search again? (y/n) : ");
                String check = input.nextLine();
                if (check.equals("y")) {
                    clearConsole();
                } else if (check.equals("n")) {
                    MainL = false;
                    clearConsole();
                    printHomePage();
                }
            }
        }
    }
    public static void updateMarks() {                   //[5] Update Marks Method
        boolean MainL = true;
        while ( MainL ) {
            System.out.println("------------------------------------------------------------------------------");
            System.out.println("|                             UPDATE MARKS                                   |");
            System.out.println("------------------------------------------------------------------------------");
            System.out.print("\nEnter Student ID : ");
            String studentid = input.nextLine();
            if ( searchSId( studentid ) ) {
                int studentindex = getIndexUsingSID(studentid);
                if( PMArray[studentindex]!= -1 && DMArray[studentindex]!= -1 ){
                    System.out.print("\nStudent Name : " + SNArray[studentindex]);
                    System.out.printf("\n\nProgramming Fundamentals Marks : %.0f" ,PMArray[studentindex]);
                    System.out.printf("\nDatabase Management System Marks : %.0f" ,DMArray[studentindex]);
                    boolean addPRFMarks = true;
                    boolean addDBMSMarks = false;
                    while (addPRFMarks) {
                        System.out.print("\nEnter new Programming Fundamentals Marks : ");
                        int prfmarks = input.nextInt();
                        if (prfmarks >= 0 && prfmarks <= 100) {
                            PMArray[studentindex] = prfmarks;                                      //store new prf marks val into entered student id index
                            addPRFMarks = false;
                            addDBMSMarks = true;
                        } else {
                            System.out.print("Invalid marks. please enter correct marks.\n");
                        }
                    }
                    while (addDBMSMarks) {
                        System.out.print("\nEnter new Database Management System Marks : ");
                        int dbmsmarks = input.nextInt();
                        if (dbmsmarks >= 0 && dbmsmarks < 100) {
                            DMArray[studentindex] = dbmsmarks;                                      //store new dbms marks val into entered student id index
                            addDBMSMarks = false;
                            input.nextLine();
                            System.out.print("Marks have been added. Do you want to add marks for another student? (y/n) : ");
                            String doretry = input.nextLine();
                            if (doretry.equals("y")) {
                                clearConsole();
                            } else if (doretry.equals("n")) {
                                MainL = false;
                                clearConsole();
                                printHomePage();
                            }
                        } else {
                            System.out.print("Invalid marks. please enter correct marks.\n");
                        }
                    }
                } else {
                    System.out.print("\nThis student's marks yet to be added.");
                    System.out.print("\nDo you want to update the marks of another student? (y/n) : ");
                    String check = input.nextLine();
                    if (check.equals("y")) {
                        clearConsole();
                    } else if (check.equals("n")) {
                        MainL = false;
                        clearConsole();
                        printHomePage();
                    }
                }
            } else {
                System.out.print("\nInvalid Student ID. Do you want to search again? (y/n) : ");
                String check = input.nextLine();
                if (check.equals("y")) {
                    clearConsole();
                } else if (check.equals("n")) {
                    MainL = false;
                    clearConsole();
                    printHomePage();
                }
            }
        }
    }
    public static void deleteStudent() {                 //[6]Delete Student Method
        boolean MainL = true;
        while ( MainL ) {
            System.out.println("------------------------------------------------------------------------------");
            System.out.println("|                            DELETE STUDENT                                  |");
            System.out.println("------------------------------------------------------------------------------");
            System.out.print("\nEnter Student ID : ");
            String studentid = input.nextLine();
            if ( searchSId ( studentid ) ) {                                             //check student id is already stored in the student id array using method
                int studentindex = getIndexUsingSID( studentid );
                SIDArray = removeSIdInArray( studentindex );                             //remove entered student id's index student id in the student id array
                SNArray = removeSNameInArray( studentindex );                            //remove entered student id's index student name in the student name array
                PMArray = removePMInArray( studentindex );                               //remove entered student id's index prf marks in the prf marks array
                DMArray = removeDMInArray( studentindex );                               //remove entered student id's index dbms marks in the dbms marks array
                System.out.print("Student has been deleted successfully. \nDo you want to delete another student? (y/n) : ");
                String doretry = input.nextLine();
                if (doretry.equals("y")) {
                    clearConsole();
                } else if (doretry.equals("n")) {
                    MainL = false;
                    clearConsole();
                    printHomePage();
                }
            } else {
                System.out.print("\nInvalid Student ID. Do  you want to search again? (y/n) : ");
                String check = input.nextLine();
                if (check.equals("y")) {
                } else if (check.equals("n")) {
                    MainL = false;
                    clearConsole();
                    printHomePage();
                }
            }
        }
    }
    public static String[] removeSIdInArray(int studentindex) {        //remove student id using student id index
        String[] temp = new String[SIDArray.length - 1];
        for (int i = 0; i < studentindex; i++) {
            temp[i] = SIDArray[i];
        }
        for (int i = studentindex; i < SIDArray.length - 1; i++) {
            temp[i] = SIDArray[i + 1];
        }
        return temp;
    }
    public static String[] removeSNameInArray(int studentindex) {      //remove student name using student id index
        String[] temp = new String[SNArray.length - 1];
        for (int i = 0; i < studentindex; i++) {
            temp[i] = SNArray[i];
        }
        for (int i = studentindex; i < SNArray.length - 1; i++) {
            temp[i] = SNArray[i + 1];
        }
        return temp;
    }
    public static double[] removePMInArray(int studentindex) {         //remove prf marks using student id index
        double[] temp = new double[PMArray.length - 1];
        for (int i = 0; i < studentindex; i++) {
            temp[i] = PMArray[i];
        }
        for (int i = studentindex; i < PMArray.length - 1; i++) {
            temp[i] = PMArray[i + 1];
        }
        return temp;
    }
    public static double[] removeDMInArray(int studentindex) {         //remove dbms marks using student id index
        double[] temp = new double[DMArray.length - 1];
        for (int i = 0; i < studentindex; i++) {
            temp[i] = DMArray[i];
        }
        for (int i = studentindex; i < DMArray.length - 1; i++) {
            temp[i] = DMArray[i + 1];
        }
        return temp;
    }
    public static void printStudentDetails() {               //[7] Print Student Details
        boolean MainL = true;
        while ( MainL ) {
            System.out.println("------------------------------------------------------------------------------");
            System.out.println("|                          PRINT STUDENT DETAILS                             |");
            System.out.println("------------------------------------------------------------------------------");
            System.out.print("\nEnter Student ID : ");
            String studentid = input.nextLine();
            if ( searchSId( studentid ) ) {                                                        //check student id is already stored in the student id array using method
                int studentindex = getIndexUsingSID(studentid);
                System.out.print("Student Name : " + (SNArray[studentindex]));
                if (PMArray[studentindex] == (-1) && DMArray[studentindex] == (-1)) {              //marks not entered element value is -1
                    System.out.print("\nMarks  yet to be added");
                    System.out.print("\nDo you want to search another student details? (y/n) : ");
                    String check = input.nextLine();
                    if (check.equals("y")) {
                        clearConsole();
                    } else if (check.equals("n")) {
                        MainL = false;
                        clearConsole();
                        printHomePage();
                    }
                } else {
                    System.out.print("\n+----------------------------------+------------+");
                    System.out.print("\n|Programming Fundamentals Marks    |"); System.out.printf( "%12.0f|" , (PMArray[studentindex]));
                    System.out.print("\n|Database Managemwnt System Marks  |"); System.out.printf( "%12.0f|" , (DMArray[studentindex]));
                    System.out.print("\n|Total Marks                       |"); System.out.printf( "%12.0f|" , getTotalMarkUseIndex( studentindex ) );
                    System.out.print("\n|Avg. Marks                        |"); System.out.printf( "%12.2f|" , getAverageMarkUseIndex( studentindex ));
                    System.out.print("\n|Ranks                             |"); System.out.printf( "%12s|" , getRankMarkUseIndex( getRankAllStudentMarks(), getAverageMarkUseIndex( studentindex ) ) );
                    System.out.print("\n+----------------------------------+------------+");

                    System.out.print("\nDo you want to search another student details? (y/n) : ");
                    String doretry = input.nextLine();
                    if (doretry.equals("y")) {
                        clearConsole();
                    } else if (doretry.equals("n")) {
                        MainL = false;
                        clearConsole();
                        printHomePage();
                    }
                }
            } else {
                System.out.print("\nInvalid Student ID. Do you want to search again? (y/n) : ");
                String check = input.nextLine();
                if (check.equals("y")) {
                    clearConsole();
                } else if (check.equals("n")) {
                    MainL = false;
                    clearConsole();
                    printHomePage();
                }
            }
        }
    }
    public static double getAverageMarkUseIndex(int studentindex) {               //get average marks using student id's index
        double total = 0;
        if (PMArray[studentindex] >= 0 && PMArray[studentindex] <= 100) {
            total += PMArray[studentindex];
        }
        if (DMArray[studentindex] >= 0 && DMArray[studentindex] <= 100) {
            total += DMArray[studentindex];
        }
        double avg = total / 2;
        return avg;
    }
    public static double getTotalMarkUseIndex(int studentindex) {                  //get total marks using student id's index
        double total = 0;
        if (PMArray[studentindex] >= 0 && PMArray[studentindex] <= 100) {
            total += PMArray[studentindex];
        }
        if (DMArray[studentindex] >= 0 && DMArray[studentindex] <= 100) {
            total += DMArray[studentindex];
        }
        return total;
    }
    public static String getRankMarkUseIndex(double[] studentrankar, double avg) {  //get student rank using student id's index and return rank with string type ordinal output w
        int index = 1;
        for (int i = 0; i < SIDArray.length; i++) {
            if (studentrankar[i] == avg) {
                break;
            }
            index++;
        }
        return getOrdinalOutput(index);
    }
    private static String getOrdinalOutput(int number) {
        int temp = number;
        if (number <= 3 && number >= 1) {
            if (number == 1) {
                return number + " (First)";
            } else if (number == 2) {
                return number + " (Second)";
            } else if (number == 3) {
                return number + " (Third)";
            }
        }
        if (number >= 4) {
            temp = number % 10;
        }
        switch (temp) {
            case 1:
                return number + " (" + number + "st)";
            case 2:
                return number + " (" + number + "nd)";
            case 3:
                return number + " (" + number + "rd)";
            default:
                return number + " (" + number + "th)";
        }
    }
    public static void printStudentsRanks() {                    //[8]Print Student Ranks
        boolean MainL = true;
        while( MainL) {
            System.out.println("------------------------------------------------------------------------------");
            System.out.println("|                    PRINT STUDENTS' RANKS                                   |");
            System.out.println("------------------------------------------------------------------------------");
            double[] avgar = new double[SIDArray.length];
            double[] totalar = new double[SIDArray.length];
            for (int j = 0; j < SIDArray.length; j++) {         //make new two arrays - total marks array and average marks array
                avgar[j] = ((PMArray[j] + DMArray[j]) / 2);
                totalar[j] = (PMArray[j] + DMArray[j]);
            }
            System.out.print  ("\n+-------+--------------+---------------------------+-----------+----------+");
            System.out.print  ("\n|Rank   |ID            |Name                       |Total Marks|Avg. Marks|");
            System.out.print  ("\n+-------+--------------+---------------------------+-----------+----------+");
            for (int i = 0; i < avgar.length; i++) {
                int index=0;
                for (int l = 0; l < avgar.length; l++) {
                    if( avgar[l] >-1 && totalar[l]>-1 ){
                        if ((getRankAllStudentMarks())[i] == avgar[l]  ) {
                            index=l;
                            System.out.printf("\n|%-7d|%-14s|%-27s|%11.0f|%10.2f|",(rankArray())[i],SIDArray[index], SNArray[index], totalar[index], avgar[index]);
                            avgar[index]=-1;
                        }
                    }
                }
            }
            System.out.print  ("\n+-------+--------------+---------------------------+-----------+----------+");
            System.out.print("\nDo you want to go back to main menu? (y/n) : ");
            String check = input.nextLine();
            if (check.equals("n")) {
                clearConsole();
            } else if (check.equals("y")) {
                MainL = false;
                clearConsole();
                printHomePage();
            }
        }
    }
    public static int[] rankArray(){                          //return all student's Rank
        int[] temp=new int[SIDArray.length];
        for(int i=0;i<SIDArray.length;i++){
            for(int j=0;j<SIDArray.length;j++){
                if( (getRankAllStudentMarks())[i] == (getRankAllStudentMarks())[j] ){
                    temp[i]=j+1;
                    break;
                }
            }
        }
        return temp;
    }
    public static double[] getRankAllStudentMarks() {           //return all student's average marks using descending sort
        double[] temp1 = new double[SIDArray.length];
        for (int i = 0; i < SIDArray.length; i++) {
            double avg = ((PMArray[i] + DMArray[i]) / 2);
            temp1[i] = avg;
        }
        double[] copyar = new double[temp1.length];
        for (int i = 0; i < temp1.length; i++) {
            copyar[i] = temp1[i];
        }//array copied
        double temp;
        int i,j;
        for ( i = 0; i < ( copyar.length - 1 ); i++) {
            for ( j = 0; j < copyar.length - i - 1; j++) {
                if (copyar[j] < copyar[j+1]) {
                    temp = copyar[j];
                    copyar[j] = copyar[j+1];
                    copyar[j+1] = temp;
                }
            }
        }
        return copyar;
    }
    public static void bestInPrf(){           //[9] Best in Programming Fundamentals
        boolean MainL = true;
        while( MainL ){
            System.out.println("------------------------------------------------------------------------------");
            System.out.println("|                     BEST IN PROGRAMMING FUNDAMENTALS                       |");
            System.out.print  ("\n------------------------------------------------------------------------------");
            System.out.print  ("\n+--------------+---------------------------+-----------+----------+");
            System.out.print  ("\n|ID            |Name                       |PF Marks   |DBMS Marks|");
            System.out.print  ("\n+--------------+---------------------------+-----------+----------+");
            double[] tempPMArray = new double[PMArray.length];
            for( int i=0; i<PMArray.length; i++){                         //copy original prf marks array to new temp prf marks array
                tempPMArray[i] = PMArray[i];
            }
            for (int i = 0; i < tempPMArray.length; i++) {
                int index = 0;
                if ( (getRankPrfMarks())[i] >-1) {
                    for (int l = 0; l< tempPMArray.length; l++) {
                        if ( (getRankPrfMarks())[i] == tempPMArray[l] ) {
                            index = l;
                            System.out.printf("\n|%-14s|%-27s|%11.0f|%10.0f|",SIDArray[index], SNArray[index], PMArray[index], DMArray[index]);
                            tempPMArray[index]= -1;
                        }
                    }
                }
            }
            System.out.print  ("\n+--------------+---------------------------+-----------+----------+");
            System.out.print("\nDo you want to go back to main menu? (y/n) : ");
            String check = input.nextLine();
            if (check.equals("n")) {
                clearConsole();
            } else if (check.equals("y")) {
                MainL = false;
                clearConsole();
                printHomePage();
            }
        }
    }
    public static void bestInDbms(){                  //[10]Best in Datbase Management System
        boolean MainL = true;
        while( MainL ){
            System.out.println("------------------------------------------------------------------------------");
            System.out.println("|                     BEST IN DATABASE MANAGEMENT SYSTEM                     |");
            System.out.println("------------------------------------------------------------------------------");
            System.out.print  ("\n+--------------+---------------------------+-----------+----------+");
            System.out.print  ("\n|ID            |Name                       |PF Marks   |DBMS Marks|");
            System.out.print  ("\n+--------------+---------------------------+-----------+----------+");
            double[] tempDMArray = new double[DMArray.length];
            for( int i=0; i<DMArray.length; i++){                       //copy original dbms marks array to new temp dbms marks array
                tempDMArray[i] = DMArray[i];
            }
            for (int i = 0; i < SIDArray.length; i++) {
                int index = 0;
                if ( (getRankDbmsMarks())[i]> -1) {
                    for (int l = 0; l < SIDArray.length; l++) {
                        if ( (getRankDbmsMarks())[i] == tempDMArray[l]  ) {
                            index = l;
                            System.out.printf("\n|%-14s|%-27s|%11.0f|%10.0f|",SIDArray[index], SNArray[index], PMArray[index], DMArray[index]);
                            tempDMArray[index]= -1;
                        }
                    }
                }
            }
            System.out.print  ("\n+--------------+---------------------------+-----------+----------+");
            System.out.print("\nDo you want to go back to main menu? (y/n) : ");
            String check = input.nextLine();
            if (check.equals("n")) {
                clearConsole();
            } else if (check.equals("y")) {
                MainL = false;
                clearConsole();
                printHomePage();
            }
        }
    }
    public static double[] getRankPrfMarks() {         //deassending sorted using bubble sort
        double[] copyar = new double[PMArray.length];
        for (int i = 0; i < PMArray.length; i++) {
            copyar[i] = PMArray[i];
        }
        double temp;
        int i,j;
        for ( i = 0; i < ( copyar.length - 1 ); i++) {
            for ( j = 0; j < copyar.length - i - 1; j++) {
                if (copyar[j] < copyar[j+1]) {
                    temp = copyar[j];
                    copyar[j] = copyar[j+1];
                    copyar[j+1] = temp;
                }
            }
        }
        return copyar;
    }
    public static double[] getRankDbmsMarks() {      //deassending sorted using bubble sort
        double[] copyar = new double[DMArray.length];
        for (int i = 0; i < DMArray.length; i++) {
            copyar[i] = DMArray[i];
        }
        double temp;
        int i,j;
        for ( i = 0; i < ( copyar.length - 1 ); i++) {
            for ( j = 0; j < copyar.length - i - 1; j++) {
                if (copyar[j] < copyar[j+1]) {
                    temp = copyar[j];
                    copyar[j] = copyar[j+1];
                    copyar[j+1] = temp;
                }
            }
        }
        return copyar;
    }
    public final static void clearConsole() {        //clearConsole method
        try {
            final String os = System.getProperty("os.name");
            if (os.contains("Windows")) {
                new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
            } else {
                System.out.print("\033[H\033[2J");
                System.out.flush();
            }
        } catch (final Exception e) {
            e.printStackTrace();
            // Handle any exceptions.
        }
    }
}
