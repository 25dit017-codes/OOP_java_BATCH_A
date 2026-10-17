public class Driver {
    public static void main(String[] args) {
        Fraction a = new Fraction(2, 4);
        Fraction b = new Fraction(1, 2);
        Fraction c = new Fraction(3, 4);
        System.out.println("a = " + a);
        System.out.println("b = " + b);
        System.out.println("a equals b: " + a.equals(b));
        System.out.println("a equals c: " + a.equals(c));
    }
}
