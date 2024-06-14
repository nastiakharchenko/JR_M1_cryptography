package com.module_one.cryptography_module_one.services;

import com.module_one.cryptography_module_one.entity.InformationFile;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static com.module_one.cryptography_module_one.constants.CryptoAlphabetConstants.*;
import static com.module_one.cryptography_module_one.constants.RegExConstants.*;

public class BruteForce implements CryptographyAlgorithm{

    private String dataDecoded;

    public BruteForce() {}

    @Override
    public void runCryptographicAlgorithm(InformationFile data) {
        LanguageCreator languageCreator = new LanguageCreator(data);
        String ALPHABET = languageCreator.getLanguageCode() ? ALPHABET_UKRAINIAN : ALPHABET_ENGLISH;

        CaesarCipherDecrypt caesarCipherDecrypt = new CaesarCipherDecrypt();
        for (int i = 1; i < ALPHABET.length(); i++) {
            data.setKeyCode(i);
            caesarCipherDecrypt.runCryptographicAlgorithm(data);
            if(qualityControlBruteForce(caesarCipherDecrypt.getResultCryptographicAlgorithm(), languageCreator.getLanguageCode())){
                dataDecoded = caesarCipherDecrypt.getResultCryptographicAlgorithm();
                break;
            }
        }
    }

    @Override
    public String getResultCryptographicAlgorithm() {
        return dataDecoded;
    }

    private Boolean qualityControlBruteForce(String dataDecrypt, Boolean languageCode){
        Pattern pattern1 = Pattern.compile(languageCode ? END_SENTENCE_UKRAINIAN : END_SENTENCE_ENGLISH);
        Pattern pattern2 = Pattern.compile(languageCode ? DASH_IN_SENTENCE_UKRAINIAN : DASH_IN_SENTENCE_ENGLISH);
        Pattern pattern3 = Pattern.compile(languageCode ? COMMA_SENTENCE_UKRAINIAN : COMMA_SENTENCE_ENGLISH);
        Pattern pattern4 = Pattern.compile(languageCode ? COLON_SENTENCE_UKRAINIAN : COLON_SENTENCE_ENGLISH);
        Pattern pattern5 = Pattern.compile(languageCode ? EXCLAMATION_MARK_SENTENCE_UKRAINIAN : EXCLAMATION_MARK_SENTENCE_ENGLISH);
        Pattern pattern6 = Pattern.compile(languageCode ? QUESTION_MARK_SENTENCE_UKRAINIAN : QUESTION_MARK_SENTENCE_ENGLISH);
        Matcher matcher1 = pattern1.matcher(dataDecrypt);
        Matcher matcher2 = pattern2.matcher(dataDecrypt);
        Matcher matcher3 = pattern3.matcher(dataDecrypt);
        Matcher matcher4 = pattern4.matcher(dataDecrypt);
        Matcher matcher5 = pattern5.matcher(dataDecrypt);
        Matcher matcher6 = pattern6.matcher(dataDecrypt);
        int count = 0;
        while(matcher1.find() | matcher2.find() | matcher3.find() | matcher4.find() | matcher5.find() | matcher6.find()){
            count++;
        }
        return count >= dataDecrypt.length() * 0.005;
    }
}
