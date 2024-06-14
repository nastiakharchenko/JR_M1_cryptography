package com.module_one.cryptography_module_one.entity;

import lombok.Getter;
import lombok.Setter;
import lombok.extern.log4j.Log4j;

import java.nio.file.Path;

import static com.module_one.cryptography_module_one.constants.CryptoAlphabetConstants.ALPHABET_ENGLISH;
import static com.module_one.cryptography_module_one.constants.ExeptionConstants.KEY_IS_INVALID;

@Getter
@Setter
@Log4j
public class InformationFile {
    private String dataCryptography;
    private Path pathFile;
    private Boolean modeCryptography = false;       //false - CaesarCipher, true - brute-force
    private Boolean modeEncrypted = false;          //false - delete symbols, true - skip symbols
    private int keyCode;

    public InformationFile() {}

    public Boolean setKeyCode(String keyCodeStr) {
        try{
            int key = Integer.parseInt(keyCodeStr);
            if(key >= ALPHABET_ENGLISH.length()){
                key = key % ALPHABET_ENGLISH.length();
            }
            this.keyCode = key;
            return true;
        }catch(NumberFormatException e){
            log.error(e.getMessage() + KEY_IS_INVALID);
            return false;
        }
    }

    public void setKeyCode(int keyCode) {
        this.keyCode = keyCode;
    }
}
