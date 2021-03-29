package gui;

import javafx.application.*;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.text.Text;
import javafx.stage.*;

public class FxPuntApp extends Application
{
    public void start( Stage primaryStage ) {
        GridPane pane = new GridPane();
        Label xcoord = new Label("X-Coordinaat: ");
        TextField xCoordIn = new TextField();
        Label ycoord = new Label("y-Coordinaat: ");
        TextField yCoordIn = new TextField();
        Text uitvoer = new Text();

        pane.add(xcoord,0,0);
        pane.add(xCoordIn,1,0);
        pane.add(ycoord,0,1);
        pane.add(yCoordIn,1,1);
        pane.add(uitvoer,0,2);

        yCoordIn.setOnAction(eventInvoer -> {
            uitvoer.setText("(" + xCoordIn.getText() + ", " + yCoordIn.getText() + ")");
        });



        Scene scene = new Scene(pane,500,350);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Punt App");
        primaryStage.show();
    }

    public static void main( String[] args ) {
        launch();
    }
}