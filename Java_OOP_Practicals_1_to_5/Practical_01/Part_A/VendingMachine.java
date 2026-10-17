    import java.util.Scanner;

    public class VendingMachine {
        enum Coin { ONE, TWO, FIVE, TEN }

        public static void main(String[] args) {
            Scanner sc = new Scanner(System.in);
            int total = 0;

            while (total < 15) {
                System.out.println("Coins: ONE, TWO, FIVE, TEN");
                System.out.print("Enter coin: ");
                String input = sc.next().toUpperCase();

                try {
                    Coin coin = Coin.valueOf(input);
                    int value = switch (coin) {
                        case ONE -> 1;
                        case TWO -> 2;
                        case FIVE -> 5;
                        case TEN -> 10;
                    };
                    total += value;
                    System.out.println("Total = Rs. " + total);
                } catch (IllegalArgumentException e) {
                    System.out.println("Invalid coin. Try again.");
                }
            }

            System.out.println("Item purchased!");
            System.out.println("Change = Rs. " + (total - 15));
            sc.close();
        }
    }
