package Story1.test.domain;

import Story1.src.domain.Cirkel;
import Story1.src.domain.Punt;
import junit.framework.TestCase;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class CirkelTest {
    private Punt geldigpunt;
    private int geldigestraal;
    private Cirkel cirkel;


    @Before
    public void setUp() throws Exception {
        geldigestraal = 4;
        geldigpunt = new Punt(6,3);
        cirkel = new Cirkel(geldigpunt, geldigestraal);
    }

    
    @Test(expected =IllegalArgumentException.class)
    public void cirkel_met_geldig_middelpunt_en_straal(){
        Cirkel cirkel = new Cirkel(geldigpunt, geldigestraal);
    }
    @Test(expected =IllegalArgumentException.class)
    public void cirkel_met_middelpunt_null_gooit_exception() throws Exception{
        geldigpunt = null;
        Cirkel cirkel = new Cirkel(geldigpunt, geldigestraal);
    }
    @Test(expected =IllegalArgumentException.class)
    public void cirkel_met_straal_kleiner_dan_nul_gooit_exception() throws Exception{
        new Cirkel(geldigpunt, -3);
    }
    @Test(expected =IllegalArgumentException.class)
    public void cirkel_met_straal_gelijk_aan_nul_gooit_exception() throws Exception{
        new Cirkel(geldigpunt, 0);
    }

    @Test
    public void gelijke_cirkels_geeft_true(){
        Assert.assertTrue(cirkel.isZelfde(new Cirkel(geldigpunt, geldigestraal)));
    }

    @Test
    public void tweedecirkel_met_null_geeft_false(){
        Assert.assertFalse(cirkel.isZelfde(null));
    }
    @Test
    public void cirkel_is_verschillend_met_verschillend_middelpunt(){
        Punt punt1 = new Punt(2,2);
        Punt punt2 = geldigpunt;
        Cirkel cirkel1 = new Cirkel(punt1, 6);
        Cirkel cirkel2 = new Cirkel(punt1, 6);
        Assert.assertFalse(cirkel1.isZelfde(cirkel2));
    }

    @Test
    public void cirkel_is_verschillend_met_verschillend_straal(){
        Punt punt = geldigpunt;
        Cirkel cirkel1 = new Cirkel(punt, geldigestraal);
        Cirkel cirkel2 = new Cirkel(punt, geldigestraal + 1);
        Assert.assertFalse(cirkel1.isZelfde(cirkel2));
    }
}

