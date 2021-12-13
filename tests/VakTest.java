import domain.Vak;
import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class VakTest {
    private Vak vak, vakZonderNaam, vakMetZelfdeNaam, vakMetAndereNaam;
    private Vak vak2ZonderNaam;

    @org.junit.Before
    public void setUp() throws Exception {
        vak = new Vak("Bop",5);
        vakZonderNaam = new Vak(null, 4);
        vakMetZelfdeNaam = new Vak("Bop",7);
        vakMetAndereNaam = new Vak("BOP",5);
        vak2ZonderNaam = new Vak(null,7);
    }

    @org.junit.Test
    public void isZelfde_Met_vak_met_andere_naam_Geeft_False() {
        Assert.assertFalse(vak.isZelfde(vakMetAndereNaam));
    }

    @Test
    public void isZelfde_Met_vak_met_zelfde_naam_Geeft_true(){
        Assert.assertTrue(vak.isZelfde(vakMetZelfdeNaam));
    }

    @Test(expected = IllegalArgumentException.class)
    public void isZelfde_Met_null_Gooit_exception(){
        vak.isZelfde(null);
    }

    @Test
    public void isZelfde_Vak_met_niet_null_als_naam_met_vak_met_null_als_naam_Geeft_false(){
        Assert.assertFalse(vak.isZelfde(vakZonderNaam));
    }

    @Test
    public void isZelfde_Vak_met_null_als_naam_met_vak_met_niet_null_als_naam_Geeft_false(){
        Assert.assertFalse(vakZonderNaam.isZelfde(vak));
    }

    @Test
    public void isZelfde_Vak_met_null_als_naam_met_vak_met_null_als_naam_Geeft_true(){
        Assert.assertTrue(vak2ZonderNaam.isZelfde(vakZonderNaam));

    }



}