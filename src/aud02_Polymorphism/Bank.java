package aud02_Polymorphism;

import java.util.ArrayList;
import java.util.List;

public class Bank {
    private List<Account> accounts;
    private int totalAccounts;

    public Bank(){
        accounts=new ArrayList<>();
        totalAccounts=0;
    }

    public boolean addAccount(Account account){
        //prvo proverka dali account postoi
        boolean doesNotExists= accounts.stream().noneMatch(a -> a.equals(account));
        if(doesNotExists){
            accounts.add(account);
            return true;
        }
        return false;

    }
    public double totalAssets(){
        return accounts.stream().mapToDouble(a -> a.getCurrentAmount()).sum();
    }
    public void addInterestToInterestAccounts(){
        for(Account a: accounts){
            if(a instanceof InterestBearingAccount){
                InterestBearingAccount iba=(InterestBearingAccount) a;
                iba.addInterest();
            }
        }
    }
}
