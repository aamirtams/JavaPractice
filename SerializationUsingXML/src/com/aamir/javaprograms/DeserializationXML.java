package com.aamir.javaprograms;

import java.beans.XMLDecoder;
import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.LinkedList;
import java.util.List;

public class DeserializationXML {
    public static void main(String[] args) {
        try {
            XMLDecoder x = new XMLDecoder(new BufferedInputStream(new FileInputStream("mycollege.xml")));

            College c = (College) x.readObject();

            List<Student> s = c.getStudentList();

            for (Student value : s){
                System.out.println(s);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}
