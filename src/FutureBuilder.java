//    Abhijay Singh
//    Branch - CSAM
//    Roll Number - 2021226

//    ASSIGNMENT 1

import java.util.Date;
import java.util.Objects;
import java.util.Scanner;
import java.util.ArrayList;
import java.time.format.DateTimeFormatter;
import java.time.LocalDateTime;
import java.util.Random;

public class FutureBuilder {
    public static void main(String[] args) {
        ArrayList<Student> students = new ArrayList<>();
        ArrayList<Company> companies = new ArrayList<>();
//        MainMenu();
        System.out.println("""
                
                ███████╗██╗░░░██╗████████╗██╗░░░██╗██████╗░███████╗  ██████╗░██╗░░░██╗██╗██╗░░░░░██████╗░███████╗██████╗░
                ██╔════╝██║░░░██║╚══██╔══╝██║░░░██║██╔══██╗██╔════╝  ██╔══██╗██║░░░██║██║██║░░░░░██╔══██╗██╔════╝██╔══██╗
                █████╗░░██║░░░██║░░░██║░░░██║░░░██║██████╔╝█████╗░░  ██████╦╝██║░░░██║██║██║░░░░░██║░░██║█████╗░░██████╔╝
                ██╔══╝░░██║░░░██║░░░██║░░░██║░░░██║██╔══██╗██╔══╝░░  ██╔══██╗██║░░░██║██║██║░░░░░██║░░██║██╔══╝░░██╔══██╗
                ██║░░░░░╚██████╔╝░░░██║░░░╚██████╔╝██║░░██║███████╗  ██████╦╝╚██████╔╝██║███████╗██████╔╝███████╗██║░░██║
                ╚═╝░░░░░░╚═════╝░░░░╚═╝░░░░╚═════╝░╚═╝░░╚═╝╚══════╝  ╚═════╝░░╚═════╝░╚═╝╚══════╝╚═════╝░╚══════╝╚═╝░░╚═╝
                """);

        Scanner scs = new Scanner(System.in);

        while (true){
            System.out.println("""
                1) Enter the Application
                2) Exit the Application""");
            int welcome = scs.nextInt();

            if (welcome == 1){
                System.out.println("""
                    Choose the mode you want to enter in:
                    1) Enter as Student Mode
                    2) Enter as Company Mode
                    3) Enter as Placement Cell Mode
                    4) Return To Main Application""");
                int mode = scs.nextInt();
                if (mode == 1) {
                    while (true){
                        System.out.println("""
                                Choose the Student Query to perform-
                                1) Enter as a Student(Give Student Name, and Roll No.)                     
                                2) Add students
                                3) Back""");
                    int studentQuery = scs.nextInt();
                    if (studentQuery == 1) {
                        String name2 = scs.next();
                        for (int i = 0; i < students.size(); i++) {
                            if (name2.equals(students.get(i).name)) {
                                while (true) {
                                    System.out.println("Welcome" + " " + students.get(i).name);
                                    System.out.println("""
                                        1) Register For Placement Drive
                                        2) Register For Company
                                        3) Get All available companies
                                        4) Get Current Status
                                        5) Update CGPA
                                        6) Accept offer
                                        7) Reject offer
                                        8) Back""");
                                    int studentSettings = scs.nextInt();
                                    if (studentSettings == 1) {
                                        students.get(i).appliedforPlacementDrive();
                                        System.out.println("Congratulations you are registered for the placement drive on " + students.get(i).regtime);

                                    } else if (studentSettings == 2) {
                                        System.out.print("Enter name of company: ");
                                        String z = scs.nextLine();
                                        for (int k = 0; k < companies.size(); k++) {
                                            if (z.equals(companies.get(k).name) && students.get(i).isPlaced==false && students.get(i).cgpa>=companies.get(k).cgpaReq && companies.get(k).ctc>=(3*students.get(i).currentOfferFrom.ctc)) {
                                                students.get(i).companiesRegisteredFor.add(companies.get(k));
                                                companies.get(k).studentsRegisteredFor.add(students.get(i));
                                            }
                                        }

                                    } else if (studentSettings == 3) {
                                        for (int j = 0; j < companies.size(); j++) {
                                            System.out.println("Company Name: " + companies.get(j).name);
                                            System.out.println("Role offering: " + companies.get(j).role);
                                            System.out.println("CTC offering: " + companies.get(j).ctc);
                                            System.out.println("Minimum CGPA Requirement: " + companies.get(j).cgpaReq);
                                            System.out.println("");
                                        }
                                    } else if (studentSettings == 4) {
                                        for (int l=0; l<students.get(i).companiesGotOfferFrom.size(); l++){
                                            System.out.println(students.get(i).companiesGotOfferFrom.get(l).name);

                                        }
                                        System.out.println("""
                                                Available options
                                                1. Choose an offer
                                                2. Reject all""");
                                        String offerchoice = scs.next();
                                        for (int u=0; u<students.get(i).companiesGotOfferFrom.size();u++){
                                            if (students.get(i).companiesGotOfferFrom.get(u).name==offerchoice){
                                                students.get(i).isPlaced(students.get(i).companiesGotOfferFrom.get(u));
                                            }
                                            else {
                                                students.get(i).isBlocked=true;
                                            }
                                        }
                                    } else if (studentSettings == 5) {
                                        System.out.print("Enter new CGPA: ");
                                        students.get(i).cgpa = scs.nextFloat();
                                    } else if (studentSettings == 6) {

                                    } else if (studentSettings == 7) {

                                    } else if (studentSettings == 8) {
                                        break;
                                    }
                                }
                            }
                        }
                    } else if (studentQuery == 2) {
                        System.out.print("Number of students to add: ");
                        int noofstudents = scs.nextInt();
                        System.out.println("Please add students Name, Roll No, CGPA, Branch(in order): ");
                        for (int i = 0; i < noofstudents; i++) {
                            String name1 = scs.next();
                            int rollno1 = scs.nextInt();
                            float cgpa1 = scs.nextFloat();
                            String branch1 = scs.next();
                            Student e = new Student(name1, rollno1, cgpa1, branch1);
                            students.add(e);
                            System.out.println("");

                        }
                    }
                }
                }
                else if (mode == 2){
                    while (true){
                        System.out.println("Choose the company query to perform");
                        System.out.println("""
                                1) Add Company and Details                                                  
                                2) Choose Company
                                3) Get Available Companies
                                4) Back""");
                        int companyQuery = scs.nextInt();
                        if (companyQuery==1){
                            String name3 = scs.next();
                            String role = scs.next();
                            float ctc = scs.nextFloat();
                            float cgpaReq = scs.nextFloat();
                            Company q = new Company(name3, role, ctc, cgpaReq);
                            companies.add(q);
                        }
                        else if (companyQuery==2){
                            String name4 = scs.next();
                            for (int i = 0; i < companies.size(); i++) {
                                if (name4.equals(companies.get(i).name)) {
                                    while (true) {
                                        System.out.println("Welcome" + " " + companies.get(i).name);
                                        System.out.println("""
                                                1) Update Role
                                                2) Update Package
                                                3) Update CGPA criteria
                                                4) Register To Institute Drive
                                                5) Back""");
                                        int companySettings = scs.nextInt();
                                        if (companySettings == 1) {
                                            System.out.print("Enter new Role: ");
                                            companies.get(i).role = scs.next();

                                        } else if (companySettings == 2) {
                                            System.out.print("Enter new Package: ");
                                            companies.get(i).ctc = scs.nextFloat();
                                        } else if (companySettings == 3) {
                                            System.out.print("Enter new CGPA requirement: ");
                                            companies.get(i).cgpaReq = scs.nextFloat();
                                        } else if (companySettings == 4) {
                                            companies.get(i).appliedforPlacement();
                                            System.out.println("Congratulations you are registered for the placement drive on " + companies.get(i).regetime);

                                        } else if (companySettings == 5) {
                                            break;
                                        }
                                    }
                                }
                            }
                        }
                        else if (companyQuery==3){
                            for (int i=0; i<companies.size(); i++){
                                System.out.println(companies.get(i).name);
                                System.out.println(companies.get(i).role);
                                System.out.println(companies.get(i).ctc);
                                System.out.println(companies.get(i).cgpaReq);
                                System.out.println("");
                            }
                        }
                        else if (companyQuery==4){
                            break;
                        }
                    }

                }
                else if (mode == 3){
                    while (true) {
                        System.out.println("""
                                Welcome to IIITD Placement Cell
                                1) Open Student Registrations
                                2) Open Company Registrations
                                3) Get Number of Student Registrations
                                4) Get Number of Company Registrations
                                5) Get Number of Offered/Unoffered/Blocked Students
                                6) Get Student Details
                                7) Get Company Details
                                8) Get Average Package
                                9) Get Company Process Results
                                10) Back""");
                        int placementCell_option = scs.nextInt();
                        if (placementCell_option == 1) {

                        } else if (placementCell_option == 2) {

                        } else if (placementCell_option == 3) {
                            System.out.println("Number of Student Registrations: "+students.size());
                        } else if (placementCell_option == 4) {
                            System.out.println("Number of Company Registrations: "+companies.size());
                        } else if (placementCell_option == 5) {
                            int placed=0;
                            int unplaced=0;
                            int blocked=0;
                            for (int i=0; i<students.size(); i++){
                                if (students.get(i).isPlaced==true){
                                    placed++;

                                }
                                else if (students.get(i).isPlaced==false){
                                    unplaced++;
                                }
                                else if (students.get(i).isBlocked==true){
                                    blocked++;

                                }

                            }
                            System.out.println("Placed students: "+placed);
                            System.out.println("UnPlaced students: "+unplaced);
                            System.out.println("Blocked students: "+blocked);
                        } else if (placementCell_option == 6) {

                        } else if (placementCell_option == 7) {

                        } else if (placementCell_option == 8) {

                        } else if (placementCell_option == 9) {

                        } else if (placementCell_option == 10) {
                            break;
                        }
                    }
                }
                else if (mode == 4){
                    System.out.println("""
                1) Enter the Application
                2) Exit the Application""");
                    welcome = scs.nextInt();
                }
            }
            else{
                break;
            }
        }
        Random rand = new Random();

        for (int i=0; i<companies.size(); i++){
            int index = rand.nextInt(0,companies.get(i).studentsRegisteredFor.size());
            for (int k=0; k<index; k++){
                companies.get(i).studentsofferGivento.add(companies.get(i).studentsRegisteredFor.get(k));

            }
        }
        for (int i=0; i<students.size(); i++){
            for (int j=0; j<companies.size(); j++) {
                for (int k = 0; k < companies.get(j).studentsofferGivento.size(); k++) {
                    if (companies.get(j).studentsofferGivento.get(k)==students.get(i)){
                        students.get(i).companiesGotOfferFrom.add(companies.get(j));
                    }
                }
            }

        }
    }

}
class Student{
    String name;
    int rollno;
    float cgpa;
    String branch;
    boolean hasAppliedPD = false;
    String regtime;
    boolean isPlaced;
    Company currentOfferFrom;
    Company placedat;
    ArrayList<Company> companiesRegisteredFor = new ArrayList<>();
    ArrayList<Company> companiesGotOfferFrom = new ArrayList<>();
    boolean isBlocked;


    Student (String name, int rollno, float cgpa, String branch){
        this.name = name;
        this.rollno = rollno;
        this.branch = branch;
        this.cgpa = cgpa;
    }

    void appliedforPlacementDrive(){
        hasAppliedPD = true;
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
        LocalDateTime now = LocalDateTime.now();
        regtime = dtf.format(now);

    }
    void isPlaced(Company c1){
        isPlaced=true;
        placedat=c1;
    }
}

class Company{
    String name;
    String role;
    float ctc;
    float cgpaReq;
    String regetime;
    ArrayList<Student> studentsRegisteredFor = new ArrayList<>();
    ArrayList<Student> studentsofferGivento = new ArrayList<>();
    boolean hasAppliedP = false;
    Company (String name, String role, float ctc, float cgpaReq){
        this.name = name;
        this.role = role;
        this.ctc = ctc;
        this.cgpaReq = cgpaReq;
    }
    void appliedforPlacement(){
        hasAppliedP = true;
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
        LocalDateTime now = LocalDateTime.now();
        regetime = dtf.format(now);

    }
}class Hiring{

}




