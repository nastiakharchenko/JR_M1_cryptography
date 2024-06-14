package com.module_one.cryptography_module_one.constants;

public class CryptoAlphabetConstants {
    private static final String LETTERS_UPPER_CASE_ENGLISH = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    private static final String LETTERS_LOWER_CASE_ENGLISH = "abcdefghijklmnopqrstuvwxyz";
    private static final String LETTERS_UPPER_CASE_UKRAINIAN = "АБВГҐДЕЄЖЗИІЇЙКЛМНОПРСТУФХЦЧШЩЬЮЯ";
    private static final String LETTERS_LOWER_CASE_UKRAINIAN = "абвгґдеєжзиіїйклмнопрстуфхцчшщьюя";
    private static final String NUMBERS = "0123456789";
    private static final String SYMBOLS = ".,\"':!? ";

    public static final String ALPHABET_ENGLISH = LETTERS_UPPER_CASE_ENGLISH + LETTERS_LOWER_CASE_ENGLISH + NUMBERS + SYMBOLS;
    public static final String ALPHABET_UKRAINIAN = LETTERS_UPPER_CASE_UKRAINIAN + LETTERS_LOWER_CASE_UKRAINIAN + NUMBERS + SYMBOLS;
}
