import java.util.Objects;

public class Fraction {
    private final int numerator;
    private final int denominator;

    public Fraction(int numerator, int denominator) {
        if (denominator == 0) throw new IllegalArgumentException("Denominator cannot be zero");
        int n = numerator, d = denominator;
        int gcd = gcd(Math.abs(n), Math.abs(d));
        n /= gcd;
        d /= gcd;
        if (d < 0) { n = -n; d = -d; }
        this.numerator = n;
        this.denominator = d;
    }

    private static int gcd(int a, int b) {
        while (b != 0) {
            int temp = b;
            b = a % b;
            a = temp;
        }
        return a == 0 ? 1 : a;
    }

    @Override
    public String toString() { return numerator + "/" + denominator; }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof Fraction other)) return false;
        return numerator == other.numerator && denominator == other.denominator;
    }

    @Override
    public int hashCode() { return Objects.hash(numerator, denominator); }
}
