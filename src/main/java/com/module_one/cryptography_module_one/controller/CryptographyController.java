package com.module_one.cryptography_module_one.controller;

import com.module_one.cryptography_module_one.entity.InformationFile;
import com.module_one.cryptography_module_one.repository.CryptographyMode;
import com.module_one.cryptography_module_one.services.*;
import com.module_one.cryptography_module_one.view.DialogToUser;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import static com.module_one.cryptography_module_one.constants.ExeptionConstants.*;

public class CryptographyController {
    @FXML
    private TextField pathFile;
    @FXML
    private TextField keyCode;
    @FXML
    private RadioButton deleteSymbols;
    @FXML
    private RadioButton skipSymbols;
    @FXML
    private RadioButton cipherCaesar;
    @FXML
    private RadioButton bruteForce;
    @FXML
    private Button encryptButton;

    private InformationFile dataFromFile;

    @FXML
    private void initialize() {
        dataFromFile = new InformationFile();

        pathFile.setDisable(true);
        keyCode.setDisable(true);
        deleteSymbols.setDisable(true);
        skipSymbols.setDisable(true);

        ToggleGroup groupForCheckAlgorithm = new ToggleGroup();
        cipherCaesar.setToggleGroup(groupForCheckAlgorithm);
        bruteForce.setToggleGroup(groupForCheckAlgorithm);

        cipherCaesar.setOnAction(event -> {
            dataFromFile.setModeCryptography(false);
            keyCode.setDisable(false);
            deleteSymbols.setDisable(false);
            deleteSymbols.setSelected(true);
            skipSymbols.setDisable(false);
            encryptButton.setDisable(false);
        });
        bruteForce.setOnAction(event -> {
            dataFromFile.setModeCryptography(true);
            keyCode.setDisable(true);
            deleteSymbols.setDisable(true);
            skipSymbols.setDisable(true);
            encryptButton.setDisable(true);
        });

        ToggleGroup groupForCheckMode = new ToggleGroup();
        deleteSymbols.setToggleGroup(groupForCheckMode);
        skipSymbols.setToggleGroup(groupForCheckMode);

        deleteSymbols.setOnAction(event -> dataFromFile.setModeEncrypted(false));
        skipSymbols.setOnAction(event -> dataFromFile.setModeEncrypted(true));
    }

    @FXML
    private void handleLoadFile() {
        FileService.openFileTxt(dataFromFile);
        dataFromFile.setDataCryptography(FileService.importFromTxt(dataFromFile.getPathFile().toString()));
        pathFile.setText(dataFromFile.getPathFile().toString());
    }

    @FXML
    private void handleEncrypt() {
        if(! dataFromFile.getModeCryptography()){
            if(dataFromFile.getPathFile() != null) {
                if (!dataFromFile.setKeyCode(keyCode.getText())) {
                    DialogToUser.exceptionShow(EXCEPTION, ATTENTION, ENTER_CORRECT_INTEGER_VALUE);
                } else {
                    CryptographyAlgorithm caesarCipherEncrypt = new CaesarCipherEncrypt();
                    caesarCipherEncrypt.runCryptographicAlgorithm(dataFromFile);
                    FileService.saveToFile(caesarCipherEncrypt.getResultCryptographicAlgorithm()
                            , dataFromFile.getPathFile()
                            , CryptographyMode.ENCRYPT.name());
                }
            }
        }
    }

    @FXML
    private void handleDecrypt() {
        if(dataFromFile.getPathFile() != null) {
            if(! dataFromFile.getModeCryptography()){
                if(! dataFromFile.setKeyCode(keyCode.getText())){
                    DialogToUser.exceptionShow(EXCEPTION, ATTENTION, ENTER_CORRECT_INTEGER_VALUE);
                } else {
                    CryptographyAlgorithm caesarCipherDecrypt = new CaesarCipherDecrypt();
                    caesarCipherDecrypt.runCryptographicAlgorithm(dataFromFile);
                    FileService.saveToFile(caesarCipherDecrypt.getResultCryptographicAlgorithm()
                            , dataFromFile.getPathFile()
                            ,CryptographyMode.DECRYPT.name());
                }
            } else{
                BruteForce bruteForce = new BruteForce();
                bruteForce.runCryptographicAlgorithm(dataFromFile);
                FileService.saveToFile(bruteForce.getResultCryptographicAlgorithm()
                        , dataFromFile.getPathFile()
                        ,CryptographyMode.DECRYPT_BRUTE_FORCE.name());
            }
        }
    }
}
