package net.wiam.applicationgestionconsultationspatientsjavafx;

import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.*;

import java.time.LocalDate;

public class ConsultationController {

    @FXML private ComboBox<Patient> patientCombo;
    @FXML private DatePicker datePicker;
    @FXML private TextField diagnosticField;
    @FXML private TableView<Consultation> consultationTable;
    @FXML private TableColumn<Consultation, Integer> idCol;
    @FXML private TableColumn<Consultation, String> patientCol;
    @FXML private TableColumn<Consultation, LocalDate> dateCol;
    @FXML private TableColumn<Consultation, String> diagnosticCol;

    private final ObservableList<Patient> patients = FXCollections.observableArrayList();
    private final ObservableList<Consultation> consultations = FXCollections.observableArrayList();

    private int consultationIdCounter = 1;

    @FXML
    public void initialize() {
        patients.addAll(
                new Patient(1, "Aboulouafa", "wiam", 24),
                new Patient(2, "ilan", "fadwa", 30),
                new Patient(3, "atir", "Abdelhadi", 33)
        );
        patientCombo.setItems(patients);

        idCol.setCellValueFactory(cellData -> new SimpleObjectProperty<>(cellData.getValue().getId()));
        patientCol.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getPatient().toString()));
        dateCol.setCellValueFactory(cellData -> new SimpleObjectProperty<>(cellData.getValue().getDate()));
        diagnosticCol.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getDiagnostic()));

        consultationTable.setItems(consultations);
    }

    @FXML
    public void ajouterConsultation() {
        Patient selectedPatient = patientCombo.getValue();
        LocalDate date = datePicker.getValue();
        String diagnostic = diagnosticField.getText();

        if (selectedPatient == null || date == null || diagnostic == null || diagnostic.isEmpty()) {
            Alert alert = new Alert(Alert.AlertType.WARNING, "Veuillez remplir tous les champs !");
            alert.showAndWait();
            return;
        }

        Consultation consultation = new Consultation(consultationIdCounter++, date, diagnostic, selectedPatient);
        consultations.add(consultation);

        patientCombo.getSelectionModel().clearSelection();
        datePicker.setValue(null);
        diagnosticField.clear();
    }

    @FXML
    public void supprimerConsultation() {
        Consultation selected = consultationTable.getSelectionModel().getSelectedItem();
        if (selected != null) {
            consultations.remove(selected);
        } else {
            Alert alert = new Alert(Alert.AlertType.WARNING, "Veuillez sélectionner une consultation à supprimer.");
            alert.showAndWait();
        }
    }
}
