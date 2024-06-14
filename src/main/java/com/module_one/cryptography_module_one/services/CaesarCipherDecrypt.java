package com.module_one.cryptography_module_one.services;

import com.module_one.cryptography_module_one.entity.InformationFile;

import static com.module_one.cryptography_module_one.constants.CryptoAlphabetConstants.ALPHABET_ENGLISH;
import static com.module_one.cryptography_module_one.constants.CryptoAlphabetConstants.ALPHABET_UKRAINIAN;

public class CaesarCipherDecrypt implements CryptographyAlgorithm{

    private String dataDecoded;

    public CaesarCipherDecrypt() {}

    @Override
    public void runCryptographicAlgorithm(InformationFile data) {
        LanguageCreator languageCreator = new LanguageCreator(data);
        String ALPHABET = languageCreator.getLanguageCode() ? ALPHABET_UKRAINIAN : ALPHABET_ENGLISH;
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < data.getDataCryptography().length(); i++) {
            int index = ALPHABET.indexOf(data.getDataCryptography().charAt(i));
            if(index != -1){
                if(index - data.getKeyCode() >= 0){
                    result.append(ALPHABET.charAt(index - data.getKeyCode()));
                } else{
                    result.append(ALPHABET.charAt(ALPHABET.length() - Math.abs(index - data.getKeyCode())));
                }
            } else{
                result.append(data.getDataCryptography().charAt(i));
            }
        }
        dataDecoded = result.toString();
    }

    @Override
    public String getResultCryptographicAlgorithm() {
        return dataDecoded;
    }
}
