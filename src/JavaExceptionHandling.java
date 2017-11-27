public class JavaExceptionHandling {

    public static int power(final int base, final int exponent) throws Exception {
        if (base == 0 && exponent == 0) {
            throw new Exception("n and p should not be zero.");
        } else if (base < 0 || exponent < 0) {
            throw new Exception("n or p should not be negative.");
        }
        return (int) Math.pow(base, exponent);
    }
}
