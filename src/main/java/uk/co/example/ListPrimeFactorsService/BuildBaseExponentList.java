package uk.co.example.ListPrimeFactorsService;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

public class BuildBaseExponentList {
    public static ArrayList<BaseExponent> build(ArrayList<Long> factors){
        // Dedupe in to a TreeMap
        Map<Long,Long> factorCountMap = factors.stream()
                .collect(Collectors.toMap(Function.identity(), v -> 1L, Long::sum, TreeMap::new));
        ArrayList<BaseExponent> lbe = new ArrayList<BaseExponent>();
        // build the list of base exponents in the correct order because a tree map is sorted.
        for (Map.Entry<Long, Long> entry : factorCountMap.entrySet()) {
            lbe.add(new BaseExponent(entry.getKey(), entry.getValue()));
        }
        return lbe;
    }
}
