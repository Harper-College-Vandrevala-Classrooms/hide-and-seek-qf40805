package com.csc;

import java.util.ArrayList;

public class FuzzyFinder {
    public static int linearSearch(ArrayList<Fuzzy> fuzzies) {
        for (int i = 0; i < fuzzies.size(); i++) {
            if (fuzzies.get(i).color.equals("gold")) {
                return i;
            }
        }
        return -1; 
    }

    public static int binarySearch(ArrayList<Fuzzy> fuzzies) {
        int left = 0;
        int right = fuzzies.size() - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (fuzzies.get(mid).color.equals("gold")) {
                return mid;
            } else if (fuzzies.get(mid).color.compareTo("gold") < 0) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        FuzzyListGenerator generator = new FuzzyListGenerator();
        
        ArrayList<Fuzzy> randomizedFuzzies = generator.randomizedRainbowFuzzies();
        int linearResult = linearSearch(randomizedFuzzies);
        System.out.println("Linear Search (Randomized): Found 'gold' at index: " + linearResult);
        
        ArrayList<Fuzzy> sortedFuzzies = generator.sortedRainbowFuzzies();
        int binaryResult = binarySearch(sortedFuzzies);
        System.out.println("Binary Search (Sorted): Found 'gold' at index: " + binaryResult);
    }
}
