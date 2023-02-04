package uk.co.example.ListPrimeFactorsService;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
;

public class ListPrimeFactors {

    static long[] primes;
    public static long limit;
    static {
        String path = "src/main/resources/primes/primes3.dat";
        BufferedReader reader;
        ArrayList<Long> al = new ArrayList<>();
        try {
            reader = new BufferedReader(new FileReader(path));
            String line = reader.readLine();
            while (line != null) {
                String[] numberStrings = line.split(",");
                for (String numStr : numberStrings){
                    al.add(Long.parseLong(numStr));
                }
                line = reader.readLine();
            }
            reader.close();
            primes = new long[al.size()];
            Arrays.setAll(primes, al::get);
            limit = primes[al.size() -1] * 2;
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public String ListFactorsString(long num) {
        ArrayList<Long> factorsIn = new ArrayList<>();
        ArrayList<Long> factors	= Factors.listFactors(num, primes, factorsIn);
        ArrayList<BaseExponent> lbe = BuildBaseExponentList.build(factors);
        return generateBaseExponentFactorsString(lbe);
    }

    public static String generateBaseExponentFactorsString(ArrayList<BaseExponent> lbe) {
        StringBuffer sb = new StringBuffer();
        for (BaseExponent be : lbe) {
            if(!sb.isEmpty()) {
                sb.append(" \u00D7 ");
            }
            sb.append(be);
        }
        return sb.toString();
    }


}
