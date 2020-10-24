package epi.done;

import epi.test_framework.EpiTest;
import epi.test_framework.EpiTestComparator;
import epi.test_framework.GenericTest;

import java.util.*;
import java.util.function.BiPredicate;

public class PhoneNumberMnemonic {
    @EpiTest(testDataFile = "phone_number_mnemonic.tsv")

    public static List<String> phoneMnemonic(String phoneNumber) {
        List<String> results = new ArrayList<>();
        Map<Character, List<Character>> map = new HashMap<>();
        map.put('0', List.of('0'));
        map.put('1', List.of('1'));
        map.put('2', List.of('A', 'B', 'C'));
        map.put('3', List.of('D', 'E', 'F'));
        map.put('4', List.of('G', 'H', 'I'));
        map.put('5', List.of('J', 'K', 'L'));
        map.put('6', List.of('M', 'N', 'O'));
        map.put('7', List.of('P', 'Q', 'R', 'S'));
        map.put('8', List.of('T', 'U', 'V'));
        map.put('9', List.of('W', 'X', 'Y', 'Z'));
        computeMnemonics(results, map, phoneNumber, 0, "");
        return results;
    }

    public static void computeMnemonics(List<String> results, Map<Character, List<Character>> map, String phoneNumber, int i, String current) {
        if (i == phoneNumber.length()) {
            results.add(current);
            return;
        }

        for (char c : map.get(phoneNumber.charAt(i))) {
            computeMnemonics(results, map, phoneNumber, i + 1, current + c);
        }

    }


    @EpiTestComparator
    public static boolean comp(List<String> expected, List<String> result) {
        if (result == null) {
            return false;
        }
        Collections.sort(expected);
        Collections.sort(result);
        return expected.equals(result);
    }

    public static void main(String[] args) {
        System.exit(
                GenericTest
                        .runFromAnnotations(args, "PhoneNumberMnemonic.java",
                                new Object() {
                                }.getClass().getEnclosingClass())
                        .ordinal());
    }
}
