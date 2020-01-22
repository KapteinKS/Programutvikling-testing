package org.openjfx;

import java.io.IOException;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;


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

