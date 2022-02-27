package aud02_Polymorphism;

public class PlatinumCheckingAccount extends Account implements InterestBearingAccount{

    public PlatinumCheckingAccount(String accountOwner, int accountId, double currentAmount) {
        super(accountOwner, accountId, currentAmount);
    }

    @Override
    public void addInterest() {
        super.addAmount(super.getCurrentAmount()*InterestCheckingAccount.INTEREST_RATE*2);

    }
}
