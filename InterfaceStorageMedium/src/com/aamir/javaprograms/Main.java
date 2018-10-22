package com.aamir.javaprograms;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
	    Player aamir = new Player("Aamir", 10, 15);
        System.out.println(aamir.toString());
        saveObject(aamir);

        aamir.setHitPoint(20);
        System.out.println(aamir);

        aamir.setWeapon("Storm");
        saveObject(aamir);

        //loadObject(aamir);

        System.out.println(aamir);

        ISavable warewolf = new Monster("Warewolf", 10, 20);
        System.out.println(warewolf);
        saveObject(warewolf);

    }

    public static ArrayList<String> readValues(){
        ArrayList<String> values = new ArrayList<String>();
        Scanner scanner = new Scanner(System.in);
        boolean quit = false;
        int index = 0;
        System.out.println("Choose\n" +
                "1 - to enter a String\n" +
                "0 - to quit");

        while (!quit){
            System.out.println("Choose an option..");
            int choice = scanner.nextInt();
            scanner.nextLine();
            switch (choice){
                case 0 :
                    quit = true;
                    break;
                case 1:
                    System.out.print("Enter a String : ");
                    String stringInput = scanner.nextLine();
                    values.add(index, stringInput);
                    index++;
                    break;
            }
        }
        return values;
    }

    public static void saveObject(ISavable objectToSave){
        for (int i = 0; i< objectToSave.write().size(); i++){
            System.out.println("Saving " + objectToSave.write().get(i) + " to storage device");
        }
    }

    public static void loadObject(ISavable objectToLoad){
        List<String> values = readValues();
        objectToLoad.read(values);
    }
}
