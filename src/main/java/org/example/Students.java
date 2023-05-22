package org.example;

import java.io.Serializable;
import java.time.DateTimeException;
import java.util.ArrayList;
import java.time.LocalDate;
import java.util.InputMismatchException;
import java.util.List;

public class Students implements Serializable {
    private List<StudentClass> students=new ArrayList<>();
    public void add(){
        StudentClass student=new StudentClass();
        System.out.println("Enter name and surname");
        student.name=Main.scanner.nextLine();
        System.out.println("Enter id");
        student.ID=Main.scanner.nextLine();
        System.out.println("Enter email");
        student.email=Main.scanner.nextLine();
        System.out.println("Enter date of birth");
        try {
            System.out.println("Enter day of birth");
            int day=Main.scanner.nextInt();
            System.out.println("Enter month of birth");
            int month = Main.scanner.nextInt();
            System.out.println("Enter year of birth");
            int year = Main.scanner.nextInt();
            student.dob=LocalDate.of(year,month,day);
            students.add(student);
            Main.logger.info("Student has been added successfully!");
        }
        catch (DateTimeException e){
        }
        catch (InputMismatchException e){
            Main.logger.info("Incorrect input");
        }
    }



    public void remove(){
        System.out.println("Enter ID of student");
        String id=Main.scanner.nextLine();
        try {
            StudentClass searchedStudent=search(id);
            students.remove(searchedStudent);
            Main.logger.info("Student deleted successfully");
        }
        catch (Exception e){
        }

    }
    public StudentClass search(String id){
        StudentClass searchedStudent;
        try{
            searchedStudent=students.stream().filter(student -> student.ID.equals(id)).findAny().get();
            return searchedStudent;
        }
        catch (Exception e){
            return null;
        }
    }
    public void searchStudent(){
        System.out.println("Enter ID of student");
        String id=Main.scanner.nextLine();
        try {
            StudentClass foundStudent=search(id);
            System.out.println(foundStudent);
        }
        catch (Exception e){
        }
    }
    public List<StudentClass> getStudents() {
        return students;
    }
}
