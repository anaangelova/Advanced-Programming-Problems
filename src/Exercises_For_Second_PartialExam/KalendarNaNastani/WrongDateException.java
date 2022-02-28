package Exercises_For_Second_PartialExam.KalendarNaNastani;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;

public class WrongDateException extends Exception{

    public WrongDateException(LocalDateTime date){
        super(String.format("Wrong date: %s", Date.from(date.atZone(ZoneId.systemDefault()).toInstant()).toString().replace("GMT", "UTC")));
    }
}