package minibank.model;
public class PremiumAccount extends Account implements Premium {
    public PremiumAccount(String number, long balance) { super(number, balance); }
}
