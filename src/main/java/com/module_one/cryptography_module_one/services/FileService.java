package com.module_one.cryptography_module_one.services;

import com.module_one.cryptography_module_one.AppProject;
import com.module_one.cryptography_module_one.entity.InformationFile;
import com.module_one.cryptography_module_one.view.DialogToUser;
import javafx.stage.FileChooser;
import lombok.extern.log4j.Log4j;
import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;

import static com.module_one.cryptography_module_one.constants.ExeptionConstants.*;

@Log4j
public class FileService {

    public static void openFileTxt(InformationFile data){
        FileChooser fileChooser = new FileChooser();
        FileChooser.ExtensionFilter extFilter = new FileChooser.ExtensionFilter(
                "TXT files (*.txt)", "*.txt");
        fileChooser.getExtensionFilters().add(extFilter);
        File file = fileChooser.showOpenDialog(AppProject.getPrimaryStage());
        try{
            data.setPathFile(Path.of(file.getAbsolutePath()));
        }catch(NullPointerException e){
            DialogToUser.exceptionShow(EXCEPTION, ATTENTION, FILE_IS_EMPTY);
            log.error(e.getMessage() + FILE_IS_EMPTY);
        }
    }

    public static String importFromTxt(String filename) {
        StringBuilder inputDataFromFile = new StringBuilder();
        try (BufferedReader buffRead = Files.newBufferedReader(Path.of(filename))) {
            String line = buffRead.readLine();
            if(line == null){
                DialogToUser.exceptionShow(EXCEPTION, ATTENTION, READ_EMPTY_FILE);
                log.error(FILE_IS_EMPTY);
            } else{
                inputDataFromFile.append(line);
                inputDataFromFile.append(System.lineSeparator());
                while((line = buffRead.readLine()) != null){
                    inputDataFromFile.append(line);
                    inputDataFromFile.append(System.lineSeparator());
                }
            }
        } catch (IOException | NullPointerException e) {
            DialogToUser.exceptionShow(EXCEPTION, ATTENTION, ERROR_READ_FILE);
            log.error(e.getMessage() + FILE_IS_INVALID);
        }
        return inputDataFromFile.toString();
    }

    public static void saveToFile(String data, Path pathDirectory, String mode) {
        if(pathDirectory != null){
            String[] fileName = pathDirectory.getFileName().toString().split("\\.");
            String newFileName = fileName[0] + "[" + mode + "]." + fileName[1];
            try(BufferedWriter writer = new BufferedWriter(new FileWriter(pathDirectory.getParent() + "\\" + newFileName))) {
                writer.write(data);
            } catch (IOException | NullPointerException e) {
                DialogToUser.exceptionShow(EXCEPTION, ATTENTION, ERROR_WRITE_FILE);
                log.error(e.getMessage() + ERROR_CORRECT_WRITE_FILE);
            }
        } else{
            DialogToUser.exceptionShow(EXCEPTION, ATTENTION, ERROR_WRITE_FILE);
            log.error(DIRECTORY_IS_NULL);
        }
    }
}
