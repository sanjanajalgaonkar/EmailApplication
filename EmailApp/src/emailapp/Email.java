package emailapp;

import java.util.Locale;
import java.util.Scanner;

public class Email {
    private String firstName;
    private String lastName;
    private String password;  //encapsulation using private access specifier
    private String department;  //later access this information using class APIs
    private String email;
    private int mailboxCapacity = 500;
    private int defaultPasswordLength = 10;
    private String alternateEmail;
    private String companySuffix = "onecompany.com";

    //Constructor to receive first and last name //Set Method
    public Email(String firstName, String lastName){
        this.firstName = firstName;
        this.lastName = lastName;

        //Calling a method asking for the department - return the department
        this.department = setDepartment();


        //Calling a method to return a random password
        this.password = randomPassword(defaultPasswordLength);
        System.out.println("Your password is: " + this.password); //concatenation

        //Combine elements to generate password
        email = firstName.toLowerCase() + "." + lastName.toLowerCase() + "@" + department + "." + companySuffix;
    }


    //Ask for department //Set Method
    private String setDepartment() {
        System.out.println("New worker: " + firstName + "\nDepartment Codes\n1 for Sales\n2 for Development\n3 for Accounting\n0 for None\nEnter Department code: ");
        Scanner in = new Scanner(System.in);
        int depChoice = in.nextInt();
        if (depChoice == 1 ){
            return "sales";
        }
        else if (depChoice == 2){
            return "dev";
        }
        else if (depChoice == 3){
            return "acct";
        }
        else{
            return "";
        }
    }

    //Generate a random password //Set Method
    private String randomPassword(int length) {
        String passwordSet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789!@#$%"; //Array
        char[] password = new char[length];
        for (int i=0; i<length; i++){
            int rand = (int) (Math.random() * passwordSet.length()); //casting
            password[i] = passwordSet.charAt(rand);
        }
        return new String(password);

    }


    //Set mailbox capacity //Set Method
    public void setMailboxCapacity(int capacity) { //Encapsulation
        this.mailboxCapacity = capacity;
    }

    //Set alternate email //Set Method
    public void setAlternateEmail(String altEmail){
        this.alternateEmail = altEmail;
    }

    //Change password //Set Method
    public void changePassword (String password){
        this.password = password;
    }

    public int getMailboxCapacity() { //get method //data binding and data hiding
        return mailboxCapacity;
    }
    public String getAlternateEmail() {
        return getAlternateEmail();
    }
    public String getPassword(){
        return password;
    }

    public String showInfo(){
        return "Display Name: "+ firstName + " " + lastName +
                "\nCompany Email: " + email +
                "\nMailbox Capacity: " + mailboxCapacity + "mb";
    }
}
