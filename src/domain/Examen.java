package domain;

import java.time.DateTimeException;
import java.time.LocalDate;
import java.time.chrono.ChronoLocalDate;

public class Examen {
    private Vak vak;
    private LocalDate datum;
    public Examen(LocalDate datum, Vak vak)
    {setDatum(datum);
        setVak(vak);
    }
    private void setVak(Vak vak)
    {
        if (vak == null) {
            throw new IllegalArgumentException();
        }
        this.vak = vak;
    }
    public Examen(Vak vak, int dag, int maand, int jaar) {
        if (dag > 31 || maand > 12 || jaar < 2022) {
            throw new DateTimeException("The date is incorrect");
        }
        datum = LocalDate.of(jaar,maand,dag);
        setVak(vak);
    }
    public void setDatum(LocalDate datum) {
        if (datum == null) {
            throw new IllegalArgumentException();
        }
        this.datum = datum;
    }

    public Vak getVak() {
        return vak;
    }

    public LocalDate getDatum() {
        return datum;
    }
    public boolean equalsName(Examen examen)
    {
        if (examen == null) {
            throw new IllegalArgumentException();
        }
        return this.vak.isZelfde(examen.getVak());
    }

    public boolean sameDate(Examen examen) {
       if(examen.getDatum().getYear() == this.datum.getYear() && examen.getDatum().getMonth() == this.datum.getMonth() && examen.getDatum().getDayOfMonth() == this.datum.getDayOfMonth())
           return true;
       return false;
    }
    public boolean before(Examen examen)
    {
        if(examen == null)
            throw new IllegalArgumentException();
        return examen.getDatum().isBefore(this.datum);
    }

    @Override
    public String toString() {
        return datum.getYear() + " - " + datum.getMonthValue() + " - "+ datum.getDayOfMonth() + " "+vak.geefInfo();
    }

}
