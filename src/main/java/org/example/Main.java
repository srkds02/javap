package org.example;

import java.util.Arrays;
import java.util.List;
import java.util.logging.Logger;

import java.util.Scanner;

public class Main {

    public static Logger logger = Logger.getGlobal();
    public static Scanner scanner = new Scanner(System.in);
    public static Saver loader=new Saver();
    private static boolean isEnd=false;

    public static void main(String[] args) {
        Students studentList;
        studentList=loader.readFile();
        if(studentList==null) {
            studentList = new Students();
        }
        while (!isEnd){
            mainMenuText();
            mainMenuFunction(studentList);
        }
        loader.writeFile(studentList);
    }
    public static void mainMenuText(){
        System.out.println("Main menu");
        System.out.println("1. Add new Student");
        System.out.println("2. Remove Student");
        System.out.println("3. Generate a report");
        System.out.println("4. Search for Student");
        System.out.println("5.Exit");
    }
    public static void mainMenuFunction(Students studentList){
        String input;
        List<String> possibleInputs= Arrays.asList("1", "2", "3", "4","5");
        scanner=new Scanner(System.in);
        while(true) {
            input = Main.scanner.nextLine();
            if ((possibleInputs.contains(input))) {
                break;
            }
            else{
                System.out.println("Enter a number from 1 to 5");
            }
        }
        switch (input){
            case "1":
                studentList.add();
                break;
            case "2":
                studentList.remove();
                break;
            case "3":
                Main.loader.createReport(studentList);
                break;
            case "4":
                studentList.searchStudent();
                break;
            case "5":
                isEnd=true;
                break;
        }
    }

}