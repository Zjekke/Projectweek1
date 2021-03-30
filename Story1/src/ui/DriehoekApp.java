package ui;

import domain.DomainException;
import domain.Driehoek;
import domain.Punt;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Text;

public class DriehoekApp {
    private Label punt1Label, punt2Label, punt3Label;
    private TextField punt1Invoer, punt2Invoer, punt3Invoer, punt1Invoer2, punt2Invoer2,punt3Invoer2;
    private Alert foutenboodschap = new Alert(Alert.AlertType.WARNING);

    private Driehoek driehoek;
    private Punt punt1;
    private Punt punt2;
    private Punt punt3;

    public DriehoekApp(GridPane root){
        punt1Label = new Label("punt1: ");
        punt1Invoer = new TextField();
        punt1Invoer2 = new TextField();
        punt2Label = new Label("punt2: ");
        punt2Invoer = new TextField();
        punt2Invoer2 = new TextField();
        punt3Label = new Label("punt3: ");
        punt3Invoer = new TextField();
        punt3Invoer2 = new TextField();

        root.add(punt1Label,0,0);
        root.add(punt1Invoer,1,0);
        root.add(punt1Invoer2,2,0);

        punt1Invoer2.setOnAction(event -> {
            try {
                Integer.parseInt(punt1Invoer.getText());
                Integer.parseInt(punt1Invoer2.getText());
                root.add(punt2Label,0,1);
                root.add(punt2Invoer,1,1);
                root.add(punt2Invoer2,2,1);
            }
            catch (NumberFormatException e){
                punt2Invoer.clear();
                foutenboodschap.setTitle("Warning");
                foutenboodschap.setContentText("fout punt1");
                foutenboodschap.showAndWait();
            }
        });

        punt2Invoer2.setOnAction(event -> {
            try {
                Integer.parseInt(punt2Invoer.getText());
                Integer.parseInt(punt2Invoer2.getText());

                root.add(punt3Label,0,2);
                root.add(punt3Invoer,1,2);
                root.add(punt3Invoer2,2,2);

            }
            catch (NumberFormatException e){
                foutenboodschap.setTitle("Warning");
                foutenboodschap.setContentText("fout punt2");
                foutenboodschap.showAndWait();
            }
        });

        punt3Invoer2.setOnAction(event -> {
            try{
                punt1 = new Punt(Integer.parseInt(punt1Invoer.getText()),Integer.parseInt(punt1Invoer2.getText()));
                punt2 = new Punt(Integer.parseInt(punt2Invoer.getText()),Integer.parseInt(punt2Invoer2.getText()));
                punt3 = new Punt(Integer.parseInt(punt3Invoer.getText()),Integer.parseInt(punt3Invoer2.getText()));

                driehoek = new Driehoek(punt1,punt2,punt3);
                root.getChildren().clear();

                Text uitvoer = new Text();
                uitvoer.setText(driehoek.toString());
                root.add(uitvoer,0,0);
            }
            catch (NumberFormatException e){
                foutenboodschap.setTitle("Warning");
                foutenboodschap.setContentText("fout punt2");
                foutenboodschap.showAndWait();
            }
        });
    }
}
