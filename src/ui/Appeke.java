package ui;

import domain.*;

import java.time.LocalDate;
import java.util.Arrays;

public class Appeke {
    public static void main(String[] args)

    {
        Vak algo =new Vak("algo", 3);
        Vak web1 = new Vak("web1",4);
        Vak bop =new Vak("bop", 5);
        Vak computernetwerken =new Vak("computernetwerken", 4);
        Examen examenalgo = new Examen(algo, 4,6,2022);
        Examen examenweb = new Examen(web1, 10,6,2022);
        Examen examenbop = new Examen(bop,18,6,2022 );
        Examen examennetwerken = new Examen(computernetwerken,30,6,2022);
        Student student = new Student("s1234567", "Ann", "Janssens");
        student.addExamen(examenalgo);
       student.addExamen(examenbop);
       student.addExamen(examenweb);
       student.addExamen(examennetwerken);
        System.out.println(student.toString());
        student.changeDate(LocalDate.of(2022,3,20),"bop");
        System.out.println(student.toString());
        try
        {
            student.changeDate(LocalDate.of(2022,6,10),"bop");
        }
        catch(Exception e ){
            System.out.println(e.getMessage());
            System.out.println(student.toString());
        }

    }
}
