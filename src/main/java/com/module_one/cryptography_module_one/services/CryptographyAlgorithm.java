package com.module_one.cryptography_module_one.services;

import com.module_one.cryptography_module_one.entity.InformationFile;

public interface CryptographyAlgorithm {

    void runCryptographicAlgorithm(InformationFile data);
    String getResultCryptographicAlgorithm();
}
