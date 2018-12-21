package com.epam.sequence;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Sequence {
    private final static String FIRST_SEQUENCE = "1100010101100111000101011001";
    private final static String SECOND_SEQUENCE = "1010001101100111000101011001";

    private static StringBuilder stringBuilder = new StringBuilder();
    private static Pattern pattern = Pattern.compile("10.+11+");
    private static String changeableSequence = "";

    public static void main(String[] args) {

        moveUnitsLeft(FIRST_SEQUENCE);
        String var1 = changeableSequence;
        System.out.println(var1);
        moveUnitsLeft(reverse(SECOND_SEQUENCE));
        String var2 = changeableSequence;
        System.out.println(var2);

        pattern = Pattern.compile("1(0+)1(0+)1");
        moveZerosRight(var1);
        System.out.println(changeableSequence);
        moveZerosRight(var2);
        System.out.println(changeableSequence);

    }

    private static void moveUnitsLeft(String sequence) {
        Matcher matcher = pattern.matcher(sequence);
        if (matcher.find()) {
            changeableSequence = matcher.replaceFirst(reverse(matcher.group()));
        }
        if (!changeableSequence.equals(sequence)) {
            moveUnitsLeft(changeableSequence);
        }
    }

    private static void moveZerosRight(String sequence) {
        Matcher matcher = pattern.matcher(sequence);
        if (matcher.find()){
            if (matcher.group(1).length() > matcher.group(2).length()){
                changeableSequence = matcher.replaceFirst(reverse(matcher.group(0)));
            }
        }
        if (!changeableSequence.equals(sequence)) {
            moveZerosRight(changeableSequence);
        }
    }

    private static String reverse(String message) {
        stringBuilder.append(message);
        String result = stringBuilder.reverse().toString();
        stringBuilder.setLength(0);
        return result;
    }
}