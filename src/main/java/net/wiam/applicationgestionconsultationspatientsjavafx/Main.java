package net.wiam.applicationgestionconsultationspatientsjavafx;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.net.URL;

public class Main extends Application {

    @Override
    public void start(Stage stage) throws Exception {
        // Load the FXML file from the resources folder using the full path
        URL fxmlUrl = getClass().getResource("/net/wiam/applicationgestionconsultationspatientsjavafx/consultation_view.fxml");
        System.out.println("FXML URL: " + fxmlUrl);

        if (fxmlUrl == null) {
            throw new RuntimeException("Le fichier consultation_view.fxml est introuvable !");
        }

        Parent root = FXMLLoader.load(fxmlUrl);
        Scene scene = new Scene(root, 600, 400);
        stage.setScene(scene);
        stage.setTitle("Gestion des Consultations");
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}
