package net.wiam.applicationgestionconsultationspatientsjavafx;

import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.event.ActionEvent;

public class PatientController {

    @FXML private TextField nomField;
    @FXML private TextField prenomField;
    @FXML private ListView<String> listPatients;

    @FXML
    void ajouterPatient(ActionEvent event) {
        String nom = nomField.getText();
        String prenom = prenomField.getText();

        if (!nom.isEmpty() && !prenom.isEmpty()) {
            listPatients.getItems().add(nom + " " + prenom);
            nomField.clear();
            prenomField.clear();
        } else {
            Alert alert = new Alert(Alert.AlertType.WARNING, "Remplissez tous les champs.");
            alert.showAndWait();
        }
    }

    @FXML
    void consulterPatient(ActionEvent event) {
        String selected = listPatients.getSelectionModel().getSelectedItem();
        if (selected != null) {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Consultation");
            alert.setHeaderText("Consultations du patient : " + selected);
            alert.setContentText("Aucune consultation pour l’instant.");
            alert.showAndWait();
        }
    }
}

