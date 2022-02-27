package aud02_Polymorphism;

import java.util.Objects;

public abstract class Account {
    private String accountOwner;
    private int accountId;
    private double currentAmount;


    public Account(String accountOwner, int accountId, double currentAmount) {
        this.accountOwner = accountOwner;
        this.accountId = accountId;
        this.currentAmount = currentAmount;
    }
    public double getCurrentAmount() {
        return currentAmount;
    }
    public void setCurrentAmount(double currentAmount) {
        this.currentAmount = currentAmount;
    }

    public void addAmount(double amount){ //ja dodava kamatata
        this.currentAmount+=amount;
    }
    public void withdrawAmount(double amount){
        if(this.currentAmount>=amount)
            this.currentAmount-=amount;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Account account = (Account) o;
        return accountId == account.accountId;
    }

    @Override
    public int hashCode() {
        return Objects.hash(accountId);
    }
}
