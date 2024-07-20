package com.gildedrose.hackerrank;

import java.util.Set;
import java.util.stream.Collectors;

import static java.lang.System.out;

class Solution {

    /*
     * Complete the 'twoStrings' function below.
     *
     * The function is expected to return a STRING.
     * The function accepts following parameters:
     *  1. STRING s1
     *  2. STRING s2
     */

    public static String twoStrings(String s1, String s2) {
        Set<Integer> s1Set = s1.chars().boxed().collect(Collectors.toSet());
        return s2.chars().anyMatch(s1Set::contains) ? "YES" : "NO";
    }

    public static void main(String[] args) {
        out.println(twoStrings("hello", "world")); // YES
        out.println(twoStrings("hi", "world")); // NO
    }
}
