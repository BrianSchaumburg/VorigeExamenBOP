package domain;

import java.awt.image.AreaAveragingScaleFilter;
import java.nio.channels.FileLockInterruptionException;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.Arrays;

public class Student {
    private String studentcode, voornaam, naam;
    ArrayList<Examen> examens;

    public Student(String studentcode, String voornaam, String naam) {
       setCode(studentcode);
       setVoornaam(voornaam);
       setNaam(naam);
       examens =new ArrayList<>();
    }

    private void setCode(String naam) {
        if(naam == null || naam.trim().isEmpty())
            throw new IllegalArgumentException();
        this.studentcode =naam;
    }
    private void setVoornaam(String naam)
    { if(naam == null || naam.trim().isEmpty())
        throw new IllegalArgumentException();
        this.voornaam =naam;

    }

    private void setNaam(String naam) {
        if(naam == null || naam.trim().isEmpty())
            throw new IllegalArgumentException();
        this.naam =naam;
    }

    public void addExamen(Examen examen) {
        if(examen == null)
            throw new IllegalArgumentException();

        if(examens.size()!=0)
        {for(Examen examen1 : examens)
        {
            if (examen1.equalsName(examen) || examen1.sameDate(examen)) {
                throw new IllegalStateException();
            }
        }
            int index=0;
            for (int i = 0; i < examens.size(); i++) {
                 if(examens.get(i).getDatum().isBefore(examen.getDatum()))
                     index = i;
            }
            if(index==examens.size()-1)
                examens.add(examen);
            else examens.add(index+1,examen);
        }
        else
            examens.add(examen);


    }

    @Override
    public String toString() {
        String result = "";
        result+="Examenrooster van " + this.studentcode + " " + this.naam+ " "+this.voornaam +" \n";
        for(Examen examen: examens)
        {
            result+=examen.toString()+"\n";
        }
        result+="Spreiding = [";
        for(Integer i : spreiding())
        {
            result+=i+" dagen, ";

        }
        result+="]";
        return result;
    }
    public void changeDate(LocalDate datum, String vaknaam)
    {   if(vaknaam==null || datum== null)
        throw new IllegalArgumentException();
        boolean result =false;
        int index =0 ;
        for(Examen e: examens)
        {
            if(e.getDatum().equals(datum))
                throw new IllegalArgumentException(this.voornaam + " heeft al een examen op "+ datum.toString());
        }
        for (int i = 0; i < examens.size(); i++) {
            if (examens.get(i).getVak().getNaam().equals(vaknaam)) {
                result = true;
                index=  i;
                break;
            }
        }
        if(!result)
            throw new IllegalArgumentException();
        examens.get(index).setDatum(datum);
    }
    public int[] spreiding()
    {   if(examens.size()<2)
    {
        throw new IllegalArgumentException();
    }
        ArrayList<Integer> daysb = new ArrayList<>();
        for(int i = 0; i< examens.size() ; i++)
        {   if(i!=examens.size()-1) {
            Long days = ChronoUnit.DAYS.between(examens.get(i).getDatum(), examens.get(i + 1).getDatum());
            daysb.add(days.intValue());
        }
        }
        int[] result = new int[daysb.size()];
        for(int i = 0; i< result.length; i ++ )
        {
            result[i]= daysb.get(i);
        }
        return result;

    }



}
