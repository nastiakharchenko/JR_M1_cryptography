package com.module_one.cryptography_module_one.constants;

public class RegExConstants {
    public static final String UKRAINIAN_LANGUAGE = "[а-яіїєА-ЯІЇЄ]+";
    public static final String END_SENTENCE_UKRAINIAN = "[а-яіїєА-ЯІЇЄ0-9]\\. [А-ЯІЇЄ0-9]";
    public static final String DASH_IN_SENTENCE_UKRAINIAN = "[а-яіїєА-ЯІЇЄ0-9] \\- [а-яіїєА-ЯІЇЄ0-9]";
    public static final String COMMA_SENTENCE_UKRAINIAN = "[а-яіїєА-ЯІЇЄ0-9]\\, ";
    public static final String COLON_SENTENCE_UKRAINIAN = "[а-яіїєА-ЯІЇЄ0-9]\\: ";
    public static final String EXCLAMATION_MARK_SENTENCE_UKRAINIAN = "[а-яіїєА-ЯІЇЄ0-9]\\! ";
    public static final String QUESTION_MARK_SENTENCE_UKRAINIAN = "[а-яіїєА-ЯІЇЄ0-9]\\? ";
    public static final String END_SENTENCE_ENGLISH = "[a-zA-Z0-9]\\. ";
    public static final String DASH_IN_SENTENCE_ENGLISH = "[a-zA-Z0-9] \\- [a-zA-Z0-9]";
    public static final String COMMA_SENTENCE_ENGLISH = "[a-zA-Z0-9]\\, ";
    public static final String COLON_SENTENCE_ENGLISH = "[a-zA-Z0-9]\\: ";
    public static final String EXCLAMATION_MARK_SENTENCE_ENGLISH = "[a-zA-Z0-9]\\! ";
    public static final String QUESTION_MARK_SENTENCE_ENGLISH = "[a-zA-Z0-9]\\? ";
}
