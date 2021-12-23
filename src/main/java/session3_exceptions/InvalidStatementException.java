package session3_exceptions;

public class InvalidStatementException extends ArrayIndexOutOfBoundsException{
    public InvalidStatementException(String message){
        super(message);
    }
}
