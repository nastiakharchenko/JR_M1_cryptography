package com.module_one.cryptography_module_one.services;

import com.module_one.cryptography_module_one.entity.InformationFile;
import lombok.Getter;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static com.module_one.cryptography_module_one.constants.RegExConstants.UKRAINIAN_LANGUAGE;

@Getter
public class LanguageCreator {

    private Boolean languageCode = false;       //false - English, true - Ukrainian

    public LanguageCreator(InformationFile data) {
        checkLanguage(data);
    }

    public void checkLanguage(InformationFile data){
        Pattern pattern = Pattern.compile(UKRAINIAN_LANGUAGE);
        Matcher matcher = pattern.matcher(data.getDataCryptography());
        if(matcher.find()){
            languageCode = true;
        }
    }
}
