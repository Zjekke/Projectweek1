package ui;

import domain.HintWoord;
import domain.Speler;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Text;

public class WoordRadenApp {
    private Text rarara, geefLetter, woordToString;
    private TextField letterInvoer;
    private HintWoord hintWoord;

    public WoordRadenApp(GridPane root, Speler speler){
        hintWoord = new HintWoord("testwoord");
        rarara = new Text("Rarara, welk woord zoeken we?");
        geefLetter = new Text("\nGeef een letter:\n");
        letterInvoer = new TextField();
        woordToString = new Text(hintWoord.toString());

        root.add(rarara,0,0);
        root.add(woordToString,0,1);
        root.add(geefLetter,0,2);
        root.add(letterInvoer,0,3);

        letterInvoer.setOnAction(event -> {
            hintWoord.raad(letterInvoer.getText().charAt(0));
            woordToString.setText(hintWoord.toString());
            letterInvoer.clear();

            if(hintWoord.isGeraden()){
                root.getChildren().clear();
                root.add(new Text("Goed gedaan " + speler.getNaam() + "! Je hebt het woord geraden!"),0,0);
            }
        });
    }
}
