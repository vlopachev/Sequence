package com.epam.sequence;

import java.util.*;

public class Sequence {
    static String sequence1 = "1100010101";
    static String sequence2 = "1010001101";

    public static void main(String[] args) {

        if (checkSequences(sequence1, sequence2, "0+") &&
                checkSequences(sequence1, sequence2, "1+")){
            System.out.println("массивы равны");
            if (sequence1.equals(reverse(sequence2))){
                System.out.println("Последовательности равны");
            }

            SortedMap<Integer, String[]> variants =
                    getOptimalReversingSequence(sequence1, sequence2);

            String var1 = variants.get(variants.firstKey())[0];
            String var2 = variants.get(variants.firstKey())[1];

            int key = variants.firstKey();

            System.out.println(var1);
            System.out.println(var2);
            System.out.println(key);

        } else {
            System.out.println("Последовательности не могут быть приведены, " +
                    "т.к. последовательности 0 и 1 не совпадают");
        }
    }

    private static String reverse(String message){
        StringBuilder sb = new StringBuilder(message);
        return sb.reverse().toString();
    }

    private static SortedMap<Integer, String[]> getOptimalReversingSequence(String sequence1, String sequence2){
        SortedMap<Integer, String[]> variants = new TreeMap<>();
        String[] sequences = {sequence1, sequence2};
        variants.put(subtractionSequences(sequences), sequences);
        sequences = new String[] {reverse(sequences[0]), reverse(sequences[1])};
        variants.put(subtractionSequences(sequences), sequences);
        sequences = new String[] {reverse(sequence1), sequence2};
        variants.put(subtractionSequences(sequences), sequences);
        sequences = new String[] {sequence1, reverse(sequence2)};
        variants.put(subtractionSequences(sequences),sequences);
        return variants;
    }

    private static int subtractionSequences(String[] sequences){
        return Math.abs(Integer.parseInt(sequences[0]) -
                Integer.parseInt(sequences[1]));
    }

    private static boolean checkSequences(String sequence1, String sequence2, String regex){
        String[] seq1 = sequence1.split(regex);
        String[] seq2 = sequence2.split(regex);
        Arrays.sort(seq1);
        Arrays.sort(seq2);
        return Arrays.equals(seq1, seq2);
    }
}

// Если последовательности нулей не совпадают, то не совпадают и основные последовательности
// Переворачиваем только там, где между единицами есть единицы
// Переворачием только одну, переворачиваем и сравниваем


