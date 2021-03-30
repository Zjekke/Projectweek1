package ui;


import domain.Punt;
import domain.Rechthoek;
import domain.Tekening;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Text;

import java.awt.*;

public class RechthoekApp {

    private Label invoerHoogteLabel, invoerBreedteLabel, invoerXLabel, invoerYLabel;
    private TextField invoerHoogte, invoerBreedte, invoerX, invoerY;
    private Alert foutenboodschap = new Alert(Alert.AlertType.WARNING);
    private Punt punt;
    private Rechthoek rechthoek;

    public RechthoekApp(GridPane root, Tekening tekening) {
        invoerXLabel =  new javafx.scene.control.Label("Geef de x-coördinaat van de linkerbovenhoek ");
        invoerX= new javafx.scene.control.TextField();
        invoerYLabel = new javafx.scene.control.Label("Geef de y-coördinaat van de linkerbovenhoek ");
        invoerY = new javafx.scene.control.TextField();

        invoerBreedteLabel =  new javafx.scene.control.Label("Geef de breedte van de rechthoek ");
        invoerBreedte = new javafx.scene.control.TextField();
        invoerHoogteLabel = new javafx.scene.control.Label("Geef de hoogte van de lengte ");
        invoerHoogte = new javafx.scene.control.TextField();

        root.add(invoerXLabel, 0, 0);
        root.add(invoerX, 1, 0);

        invoerX.setOnAction(eventIngaveX ->{
            try {
                Integer.parseInt(invoerX.getText());
                root.add(invoerYLabel, 0, 1);
                root.add(invoerY, 1, 1);
            }
            catch(NumberFormatException e){
                invoerX.clear();
                foutenboodschap.setTitle("Warning");
                foutenboodschap.setContentText("x coördinaat moet een geheel getal zijn");
                foutenboodschap.showAndWait();
            }
        });

        invoerY.setOnAction(eventIngaveY ->{
            try {
                Integer.parseInt(invoerY.getText());
                root.add(invoerBreedteLabel, 0, 2);
                root.add(invoerBreedte, 1, 2);

            }
            catch(NumberFormatException e){
                invoerY.clear();
                foutenboodschap.setTitle("Warning");
                foutenboodschap.setContentText("y coördinaat moet een geheel getal zijn");
                foutenboodschap.showAndWait();
            }
        });

        invoerBreedte.setOnAction(eventIngaveBreedte ->{
            try {
                Integer.parseInt(invoerBreedte.getText());
                root.add(invoerHoogteLabel, 0, 3);
                root.add(invoerHoogte, 1, 3);

            }
            catch(NumberFormatException e){
                invoerBreedte.clear();
                foutenboodschap.setTitle("Warning");
                foutenboodschap.setContentText("Breedte moet een geheel getal zijn");
                foutenboodschap.showAndWait();
            }
        });

        invoerHoogte.setOnAction(eventIngaveHoogte ->{
            try {
                Integer.parseInt(invoerHoogte.getText());

                punt = new Punt(Integer.parseInt(invoerX.getText()), Integer.parseInt(invoerY.getText()));
                root.getChildren().clear();

                rechthoek = new Rechthoek(punt, Integer.parseInt(invoerHoogte.getText()), Integer.parseInt(invoerBreedte.getText()));
                root.getChildren().clear();

                Text uitvoer = new Text();
                uitvoer.setText(rechthoek.toString());
                root.add(uitvoer, 0, 0);

            }
            catch(NumberFormatException e){
                invoerHoogte.clear();
                foutenboodschap.setTitle("Warning");
                foutenboodschap.setContentText("Hoogte moet een geheel getal zijn");
                foutenboodschap.showAndWait();
            }
        });


    }




}
