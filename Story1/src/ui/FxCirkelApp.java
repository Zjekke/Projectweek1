package ui;

import domain.DomainException;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class FxCirkelApp extends Application {

    @Override
    public void start(Stage stage) throws Exception {
        GridPane pane = new GridPane();
        Scene scene = new Scene(pane, 350, 150);

        new CirkelApp(pane);

        stage.setScene(scene);
        stage.setTitle("Cirkel App");
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
