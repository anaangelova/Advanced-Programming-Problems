package aud02_Polymorphism;

public class InterestCheckingAccount extends Account implements InterestBearingAccount{

    public static double INTEREST_RATE=0.03;

    public InterestCheckingAccount(String accountOwner, int accountId, double currentAmount) {
        super(accountOwner, accountId, currentAmount);
    }

    @Override
    public void addInterest() {
        super.addAmount(super.getCurrentAmount()*INTEREST_RATE);
    }
}
