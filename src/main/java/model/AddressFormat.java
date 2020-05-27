package model;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.regex.Pattern;

/**
 * Enum that contains different known address formats and information on how to parse
 * them via regex.
 */
public enum AddressFormat {
    SIMPLE_GERMAN(
            new RegexInfo(
                    Pattern.compile("^([A-zäÄüÜÖö]*)\\s([0-9]*\\s?[A-z]*)$"),
                    1, 2
            )),

    ADVANCED_GERMAN(
            new RegexInfo(
                    Pattern.compile("^(([A-zäÄüÜÖö]*\\s)*)([0-9]*\\s?[A-z]*)$"),
                    1, 3
            )),

    FRENCH(
            new RegexInfo(
                    Pattern.compile("^([0-9]*)(,?)\\s(([A-z]*\\s*)*)"),
                    3, 1
            )
    ),

    SPANISH(
            new RegexInfo(
                    Pattern.compile("^(([A-z]|\\s)*),\\s([0-9]*\\s?[A-z]*)$"),
                    1, 3
            )
    ),

    SPANISH_WITH_NO(
            new RegexInfo(
                    Pattern.compile("^(([A-z]*\\s)*[0-9]*)\\s(No\\s([0-9]*))$"),
                    1, 3
            ));

    public final RegexInfo regexInfo;

    AddressFormat(RegexInfo regexInfo) {
        this.regexInfo = regexInfo;
    }

    /**
     *  Container class that contains the regex pattern as well as information on
     *  which group of the matched pattern corresponds to street name and street
     *  number, should a match occur.
     */
    @Data
    @AllArgsConstructor
    public static class RegexInfo {
        private Pattern pattern;
        private int streetGroup;
        private int streetNumberGroup;
    }

}
