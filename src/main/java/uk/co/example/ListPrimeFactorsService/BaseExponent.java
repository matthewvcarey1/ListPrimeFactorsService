package uk.co.example.ListPrimeFactorsService;

/**
 * A base and exponent class that knows how to turn itself into a readable string
 */
public class BaseExponent {
    long base;
    long exponent;

    public BaseExponent(long base, long exponent){
        this.base = base;
        this.exponent = exponent;
    }

    private static final String superscriptDigits[] = new String[] {
            "\u2070",
            "\u00B9",
            "\u00B2",
            "\u00B3",
            "\u2074",
            "\u2075",
            "\u2076",
            "\u2077",
            "\u2078",
            "\u2079", };

    private void appendExponentStringBuffer(long n, StringBuffer s){
        if (n < 1){
            return;
        }
        int val  = (int)n % 10;
        appendExponentStringBuffer(n/10, s);
        s.append(superscriptDigits[val]);
    }

    /**
     * Does what it says on the tin
     * @return a string readable by humans
     */
    public String toString(){
        StringBuffer buff = new StringBuffer();
        buff.append(base);
        if(exponent > 1){
            appendExponentStringBuffer(exponent, buff);
        }
        return buff.toString();
    }

}
