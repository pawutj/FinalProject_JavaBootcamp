package finalproject.cashtracking.rcts.exceptions;

public class TruckNotFoundException extends RuntimeException{
    public TruckNotFoundException(String value){
        super(value);
    }
}
