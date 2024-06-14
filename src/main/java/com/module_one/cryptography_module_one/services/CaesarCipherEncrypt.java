package com.module_one.cryptography_module_one.services;


import com.module_one.cryptography_module_one.entity.InformationFile;

import static com.module_one.cryptography_module_one.constants.CryptoAlphabetConstants.*;

public class CaesarCipherEncrypt implements CryptographyAlgorithm{

    private String dataEncoded;

    public CaesarCipherEncrypt() {}

    @Override
    public void runCryptographicAlgorithm(InformationFile data) {
        LanguageCreator languageCreator = new LanguageCreator(data);
        String ALPHABET = languageCreator.getLanguageCode() ? ALPHABET_UKRAINIAN : ALPHABET_ENGLISH;
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < data.getDataCryptography().length(); i++) {
            int index = ALPHABET.indexOf(data.getDataCryptography().charAt(i));
            if(index != -1){
                if(index + data.getKeyCode() < ALPHABET.length()){
                    result.append(ALPHABET.charAt(index + data.getKeyCode()));
                } else{
                    result.append(ALPHABET.charAt((index + data.getKeyCode()) - ALPHABET.length()));
                }
            } else{
                if(data.getModeEncrypted()){
                    result.append(data.getDataCryptography().charAt(i));
                }
            }
        }
        dataEncoded = result.toString();
    }

    @Override
    public String getResultCryptographicAlgorithm() {
        return dataEncoded;
    }
}
