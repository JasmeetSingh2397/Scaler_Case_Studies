package Custom_Exceptions;

public class NoParkingSpotFoundException extends Exception{
    public NoParkingSpotFoundException(String message) {
        super(message);
    }

}
