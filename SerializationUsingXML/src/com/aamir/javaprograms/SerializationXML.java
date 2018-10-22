package com.aamir.javaprograms;

import java.beans.XMLEncoder;
import java.io.BufferedOutputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.List;

public class SerializationXML {

    public static void main(String[] args)  {
        Student student1 = new Student();
        student1.setRollno(101);
        student1.setName("Aamir");
        Student student2 = new Student();
        student2.setRollno(102);
        student2.setName("Saleem");

        List<Student> s = new ArrayList<Student>();
        s.add(student1);
        s.add(student2);

        College college = new College();
        college.setStudentList(s);

        try {
            XMLEncoder x = new XMLEncoder(new BufferedOutputStream(new FileOutputStream("mycollege.xml")));
            x.writeObject(college);
            x.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}
