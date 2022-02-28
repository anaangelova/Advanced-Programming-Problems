package Exercises_For_Second_PartialExam.Stadium;

public class SeatTakenException extends Exception {
    String message;

    public SeatTakenException(String message) {
        this.message = message;
    }

    @Override
    public String getMessage() {
        return message;
    }
}