package Exercises_For_First_Partial_Exam.MojDDV2;

public class AmountNotAllowedException extends Exception{
    Double total;
    public AmountNotAllowedException(Double total){
        this.total=total;
    }

    @Override
    public String getMessage() {
        return String.format("Receipt with amount %d is not allowed to be scanned",total.intValue());
    }
}
