package domain;

import junit.framework.TestCase;
import org.junit.Before;
import org.junit.Test;

public class CirkelTest extends TestCase {
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
    @
    @Test
    public void gelijke_cirkels_geeft_true(){
        assertTrue(cirkel.isZelfde(new Cirkel(geldigpunt, geldigestraal)));
    }
    @Test
    public void gelijke_cirkels_geeft_true(){
        assertTrue(cirkel.isZelfde(new Cirkel(geldigpunt, geldigestraal + 1)));
    }
    @Test
    public void tweedecirkel_met_null_geeft_false(){
        assertFalse(cirkel.isZelfde(null));
    }
    @Test
    public void cirkel_is_verschillend_met_verschillend_middelpunt(){
        assertFalse();
    }
}

