package com.epam.sequence;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Sequence {
    private final static String SEQUENCE_1 = "1100010101100111000101011001";
    private final static String SEQUENCE_2 = "1010001101100111000101011001";
    private final static Pattern PATTERN = Pattern.compile("10.+11+");

    public static void main(String[] args) {


        Matcher matcher = PATTERN.matcher(SEQUENCE_1);

        while (matcher.find()){
            System.out.println(SEQUENCE_1);
            System.out.println(matcher.replaceFirst(reverse(matcher.group())));
        }



//        if (checkSequences(SEQUENCE_1, SEQUENCE_2, "0+") &&
//                checkSequences(SEQUENCE_1, SEQUENCE_2, "1+")){
//
//
//
//        } else {
//            System.out.println("Последовательности не могут быть приведены, " +
//                    "т.к. последовательности 0 и 1 не совпадают");
//        }
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