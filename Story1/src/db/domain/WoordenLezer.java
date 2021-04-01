package db.domain;

import domain.WoordenLijst;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.io.FileNotFoundException;

public class WoordenLezer {
    private List<String> woorden;

    public WoordenLezer(String fileName) {
        this.woorden = new ArrayList<String>();
        Scanner scannerFile = null;
        try {
            scannerFile = new Scanner(new File("C:\\Users\\Gebruiker\\Desktop\\Projectweek1\\Story1\\src\\" + fileName));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        while (scannerFile != null && scannerFile.hasNextLine()) {
            String s = scannerFile.nextLine();
            this.woorden.add(s);
        }
    }

    public WoordenLijst lees() {
        WoordenLijst woordenLijst = new WoordenLijst();
        for (String woord : this.woorden) {
            woordenLijst.voegToe(woord);
        }
        return woordenLijst;
    }
//test
}
