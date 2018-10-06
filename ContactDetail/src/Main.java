import jdk.management.resource.internal.inst.SocketOutputStreamRMHooks;
import jdk.nashorn.internal.runtime.OptimisticReturnFilters;

import javax.sound.midi.Soundbank;
import java.util.Scanner;

public class Main {
    private static Scanner sc = new Scanner(System.in);
    private static MobilePone mobilePone = new MobilePone("9956932125");
    public static void main(String[] args) {

        boolean quit = false;

        startPhone();
        showAction();
        while (!quit){
            int action = sc.nextInt();
            sc.nextLine();

            switch (action){
                case 0:
                    System.out.println("Sutting down");
                    quit = true;
                    break;
                case 1:
                    mobilePone.printContacts();
                    break;
                case 2:
                    createContact();
                    break;
                case 3:
                    updateContact();
                    break;
                case 4:
                    removeContact();
                    break;
                case 5:
                    queryContact();
                    break;
                case 6:
                    showAction();
                    break;
            }

        }

    }

    private static void createContact(){
        System.out.print("Enter name of Contact : ");
        String name = sc.nextLine();
        System.out.print("Enter phone number : ");
        String phoneNumber = sc.nextLine();
        Contacts contacts = Contacts.createContact(name, phoneNumber);
        if (mobilePone.addNewContact(contacts)){
            System.out.println("New contact added : Name = " + name + "  Phone = " + phoneNumber);
        }else {
            System.out.println("Cannot add, "  + name + " Already exist");
        }
    }

    private static void updateContact(){
        System.out.print("Enter old contact name : ");
        String oldContactName = sc.nextLine();
        Contacts existingContact = mobilePone.queryContact(oldContactName);
        if (existingContact == null){
            System.out.println("Contact not found");
            return;
        }
        System.out.print("Enter new Contact name : ");
        String newName = sc.nextLine();
        System.out.print("Enter new phone number : ");
        String newPhone = sc.nextLine();
        Contacts contacts = Contacts.createContact(newName, newPhone);
        if (mobilePone.updateNewContact(existingContact, contacts)){
            System.out.println("Succesfully updated..");
        }
        else {
            System.out.println("Error updating record");
        }
    }

    private static void removeContact(){
        System.out.print("Enter old contact name : ");
        String oldContactName = sc.nextLine();
        Contacts existingContact = mobilePone.queryContact(oldContactName);
        if (existingContact == null){
            System.out.println("Contact not found");
            return;
        }

        if (mobilePone.removeContact(existingContact)){
            System.out.println("Succesfully updated..");
        }
        else {
            System.out.println("Error updating record");
        }
    }

    private static void queryContact(){
        System.out.print("Enter old contact name : ");
        String oldContactName = sc.nextLine();
        Contacts existingContact = mobilePone.queryContact(oldContactName);
        if (existingContact == null){
            System.out.println("Contact not found");
            return;
        }

        System.out.println("Nmae : " + existingContact.getName() + " Phone : " + existingContact.getPhoneNumber());
    }

    private static void startPhone(){
        System.out.println("Strating Phone.....");
    }
    private static void showAction(){
        System.out.println( "0 - to Shutdown\n" +
                            "1 - to print contacts\n" +
                            "2 - to create new contact\n" +
                            "3 - to update existing contact\n" +
                            "4 - to remove existing contact\n" +
                            "5 - query if any existing contact exist\n" +
                            "6 - to show Action menu"
        );
        System.out.print("Choose an action .... ");
    }


}
