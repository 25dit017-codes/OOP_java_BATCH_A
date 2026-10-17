package minibank.model;
public interface InterestBearing {
    default double yearlyInterest(long balance) { return balance * 0.04; }
}
