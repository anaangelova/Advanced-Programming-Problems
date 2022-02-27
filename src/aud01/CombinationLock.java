package aud01;

public class CombinationLock {
    private int combination;
    private boolean isOpen;

    public CombinationLock(int combination) {
        this.combination = combination;
    }
    public boolean isOpen(int tryCombination){
        this.isOpen=(tryCombination==this.combination);
        return this.isOpen;
    }
    public boolean changeComb(int oldComb, int newComb){
        if(oldComb==this.combination){
            this.combination=newComb;
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
        CombinationLock combinationLock=new CombinationLock(123);
        System.out.println(combinationLock.isOpen(123));
        System.out.println(combinationLock.changeComb(123,222));
    }
}