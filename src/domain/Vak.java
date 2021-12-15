package domain;

public class Vak {
    //TO DO vul instantievariabelen in
    /**
     * Opmaken van de instantievariabelen
     */
    private String naam; private int aantalStudiepunten;

    /**
     *
     * @param naam Ingave van de naam.
     * @param aantalStudiepunten Ingave studiepunten. Mag niet lager zijn dan 0
     */
    public Vak(String naam, int aantalStudiepunten){
        if (aantalStudiepunten < 0) throw new IllegalArgumentException();
        this.naam = naam;
        this.aantalStudiepunten = aantalStudiepunten;
    }

    /**
     *
     * @return Returns the naam of this vak
     */
    public String getNaam() {
        return this.naam;
    }

    //TO DO

    /**
     *
     * @param vak cannot be equal to zero
     * @return true if vak equals this - else returns false
     */
    public boolean isZelfde(Vak vak){
       if(vak == null)
       {
           throw new IllegalArgumentException();
       }
        if(vak.getNaam() ==null && this.getNaam() != null)
            return false;
        else if(vak.getNaam() == null && this.getNaam() ==null)
            return true;
        else if(vak.getNaam().equals(this.getNaam()))
           return true;
       else
           return false;
    }

    /**
     *
     * @return All the information as a String
     */
    public String geefInfo(){
        return this.naam + " " + this.aantalStudiepunten + "STP";
    }


}

