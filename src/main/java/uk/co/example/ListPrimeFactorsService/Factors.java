package uk.co.example.ListPrimeFactorsService;

import java.util.ArrayList;
import java.util.LinkedList;

public class Factors {
    public static ArrayList<Long> listFactors(long num,  long [] primes, ArrayList<Long> results) {
        if (num < 2) {
            return results;
        }

        for (long prime : primes) {
            if (num % prime == 0) {
                results.add(prime);
                return listFactors(num / prime, primes, results);
            }
        }
        return results;
    }
}
