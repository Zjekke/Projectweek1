package ui;

import domain.LijnStuk;
import domain.Punt;
import domain.Tekening;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Text;

public class LijnstukApp {
    private Label punt1Label, punt2Label;
    private TextField punt1Invoer, punt2Invoer,punt1Invoer2,punt2Invoer2;
    private Alert foutenboodschap = new Alert(Alert.AlertType.WARNING);

    private LijnStuk lijnstuk;
    private Punt punt1;
    private Punt punt2;

    public LijnstukApp(GridPane root, Tekening tekening){
        punt1Label = new Label("Punt 1: ");
        punt2Label = new Label("Punt 2: ");
        punt1Invoer = new TextField();
        punt1Invoer2 = new TextField();
        punt2Invoer = new TextField();
        punt2Invoer2 = new TextField();

        root.add(punt1Label,0,0);
        root.add(punt1Invoer,1,0);
        root.add(punt1Invoer2,2,0);

        punt1Invoer2.setOnAction(event -> {
            try{
                Integer.parseInt(punt1Invoer.getText());
                root.add(punt2Label,0,1);
                root.add(punt2Invoer,1,1);
                root.add(punt2Invoer2,2,1);
            }
            catch (NumberFormatException e){
                //punt1Invoer.clear();
                foutenboodschap.setTitle("Warning");
                foutenboodschap.setContentText("fout punt1");
                foutenboodschap.showAndWait();
            }
        });

        punt2Invoer2.setOnAction(event -> {
            try{
                punt1 = new Punt(Integer.parseInt(punt1Invoer.getText()),Integer.parseInt(punt1Invoer2.getText()));
                punt2 = new Punt(Integer.parseInt(punt2Invoer.getText()),Integer.parseInt(punt2Invoer2.getText()));

                lijnstuk = new LijnStuk(punt1,punt2);
                root.getChildren().clear();

                Text uitvoer = new Text();
                uitvoer.setText(lijnstuk.toString());
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
