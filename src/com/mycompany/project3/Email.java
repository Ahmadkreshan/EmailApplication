package com.mycompany.project3;

import java.util.Locale;
import java.util.Scanner;

public class Email {

    private String firstName;
    private String lastName;
    private String password;
    private String department;
    private String email;
    private int mailboxCapacity =500;
    private int defaultPasswordLength = 8;
    private String alternateEmail;
    private String companySuffix = "AAKcompany.com";

    // Constructor to receive the first name and last name
    public Email(String firstName, String lastName){
        this.firstName=firstName;
        this.lastName=lastName;

        // Call a method asking for the department - return the department
        this.department= setDepartment();

        // Call a method that returns a random  password
        this.password = randomPassword(defaultPasswordLength);
        System.out.println("Your password is: "+this.password);

        // Combine element to generate email
        this.email = this.firstName.toLowerCase() + "."+ this.lastName.toLowerCase() + "@" + this.department + "." + this.companySuffix;
    }

    // Ask for the department
    private String setDepartment(){
        Scanner scanner = new Scanner(System.in);
        System.out.print("New worker: " + this.firstName + "\nDepartment Codes:\n[1] for Sales\n[2] for Development\n[3] for Accounting\n[4] for none\n Enter Department Code:\n");
        int depChoice = scanner.nextInt();
        if(depChoice == 1){
            return "sales";
        }else if(depChoice == 2){
            return "dev";
        }else if(depChoice == 3){
            return "acct";
        }else{
            return "";
        }
    }

    // Generate a random password
    private String randomPassword(int length){
        String passwordSet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789!@#$%";
        char[] password = new char[length];
        for(int i=0;i<length;i++){
            int rand = (int) (Math.random()*passwordSet.length());
            password[i] = passwordSet.charAt(rand);
        }
        return new String(password);
    }

    // Set the mailbox capacity
    public void setMailboxCapacity(int capacity){
        this.mailboxCapacity = capacity;
    }

    // Set the alternate email
    public void setAlternateEmail(String altEmail){
        this.alternateEmail=altEmail;
    }

    // Change the password
    public void changePassword(String password){
        this.password = password;
    }

    public int getMailboxCapacity(){
        return this.mailboxCapacity;
    }

    public String getAlternateEmail(){
        return this.alternateEmail;
    }

    public String getPassword(){
        return this.password;
    }

    public String showInfo(){
        return "Name: " + this.firstName + " " + lastName
                +"\nCompany Email: " + this.email
                +"\nMailBox Capacity: " + this.mailboxCapacity + "mb";
    }
}
