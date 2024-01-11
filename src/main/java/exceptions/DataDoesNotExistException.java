package exceptions;

public class DataDoesNotExistException extends RuntimeException {

    public DataDoesNotExistException(){
        super("Such data doesn't exist");
    }
}
