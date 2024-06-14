package com.module_one.cryptography_module_one.view;

import javafx.scene.control.Alert;

public class DialogToUser {

    public static void exceptionShow(String title, String header, String text){
        Alert alert = new Alert(Alert.AlertType.WARNING);
        alert.setTitle(title);
        alert.setHeaderText(header);
        alert.setContentText(text);
        alert.showAndWait();
    }
}
