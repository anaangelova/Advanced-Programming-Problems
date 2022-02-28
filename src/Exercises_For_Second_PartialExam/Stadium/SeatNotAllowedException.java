package Exercises_For_Second_PartialExam.Stadium;

public class SeatNotAllowedException extends Exception {
    String message;

    public SeatNotAllowedException(String message) {
        this.message = message;
    }

    @Override
    public String getMessage() {
        return message;
    }
}