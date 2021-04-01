package ui;

import domain.LijnStuk;
import domain.Omhullende;
import domain.Punt;
import domain.Vorm;

public class ikWilTesten {
    public static void main(String[] args){
        Vorm galgStaaf = new LijnStuk(new Punt(160, 350), new Punt(160, 50));
        Omhullende omhullende = galgStaaf.getOmhullende();

        System.out.println(omhullende.getMaximumX());
        System.out.println(omhullende.getMinimumX());
        System.out.println(omhullende.getMaximumY());
        System.out.println(omhullende.getMinimumY());
    }
}
