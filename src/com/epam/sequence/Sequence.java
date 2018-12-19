package com.epam.sequence;

import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Sequence {
    private final static String SEQUENCE_1 = "1100010101100111000101011001";
    private final static String SEQUENCE_2 = "1010001101100111000101011001";
    private final static Pattern PATTERN = Pattern.compile("10.+11+");

    private static String changeableSequence = "";

    public static void main(String[] args) {

        if (checkSequences(SEQUENCE_1, SEQUENCE_2, "1+")){
            offsetUnitsLeft(SEQUENCE_1);
            System.out.println(changeableSequence);
            offsetUnitsLeft(SEQUENCE_2);
            System.out.println(changeableSequence);
        } else {
            System.out.println("Последовательности не могут быть приведены, " +
                    "т.к. последовательности 0 и 1 не совпадают");
        }
    }

    private static void offsetUnitsLeft(String sequence){
        Matcher matcher = PATTERN.matcher(sequence);
        if (matcher.find()){
            changeableSequence = matcher.replaceFirst(reverse(matcher.group()));
        }
        if (!changeableSequence.equals(sequence)){
            offsetUnitsLeft(changeableSequence);
        }
    }

    private static String reverse(String message){
        StringBuilder sb = new StringBuilder(message);
        return sb.reverse().toString();
    }

    private static boolean checkSequences(String sequence1, String sequence2, String regex){
        String[] seq1 = sequence1.split(regex);
        String[] seq2 = sequence2.split(regex);
        Arrays.sort(seq1);
        Arrays.sort(seq2);
        return Arrays.equals(seq1, seq2);
    }
}