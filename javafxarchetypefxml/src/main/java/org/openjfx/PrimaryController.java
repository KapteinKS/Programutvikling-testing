package org.openjfx;

import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

import javafx.scene.control.MenuItem;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.stage.FileChooser;
import javafx.stage.Stage;


public class PrimaryController {
    Register register = new Register();
    @FXML
    private Button btsVisReg;

    @FXML
    private Button btnRegistrer;

    @FXML
    private TextField lblNavn;

    @FXML
    private TextField lblAlder;

    @FXML
    private TextField lblMM;

    @FXML
    private TextField lblYYYY;

    @FXML
    private TextField lblDD;

    @FXML
    private TextField txtEPost;

    @FXML
    private TextField txtTelefon;

    @FXML
    private Label warninglbl;

    @FXML
    private Label txtRegister;

    @FXML
    private MenuBar fileMenu;

    @FXML
    private MenuItem openFile;

    @FXML
    private MenuItem lukkFil;

    @FXML
    void chooseFile(ActionEvent event) throws IOException {
        FileChooser fileChooser = new FileChooser();
        Stage mainStage = new Stage();
        fileChooser.setTitle("Open resource file");
        fileChooser.getExtensionFilters().addAll(new FileChooser.ExtensionFilter("Text Files", "*.txt"));
        File selectedFile = fileChooser.showOpenDialog(mainStage);
        if(selectedFile != null) {
            String path = selectedFile.getAbsolutePath();
            Path paths = Paths.get(path);
            List<Person> personer = FileOpenerTxt.lesFil(paths);
            for (Person p : personer) {
                register.leggTil(p);
            }
            warninglbl.setText("Person(er) lagt inn fra fil");
        }
    }

   @FXML
    void saveRegistry(ActionEvent event) throws IOException {
        FileChooser saver = new FileChooser();
        Stage mainStage = new Stage();
        saver.setTitle("Save to which file?");
        saver.getExtensionFilters().addAll(new FileChooser.ExtensionFilter("Text Files", "*.txt"));
        File selectedFile = saver.showSaveDialog(mainStage);
        if(selectedFile != null) {
            String paths = selectedFile.getAbsolutePath();
            var path = Paths.get(paths);
            FileSaverTxt.skrivTilFil(register.liste, path);
        }
    }

    @FXML
    void regPers(ActionEvent event) {
        if(!lblNavn.getText().isEmpty()) {
                warninglbl.setText(register.registrerPerson(lblNavn.getText(), lblAlder.getText(),
                        lblDD.getText(), lblMM.getText(), lblYYYY.getText(), txtEPost.getText(), txtTelefon.getText()));
        }
    }

    @FXML
    void visReg(ActionEvent event) {
        txtRegister.setText(register.skrivUtListe());
    }
}

