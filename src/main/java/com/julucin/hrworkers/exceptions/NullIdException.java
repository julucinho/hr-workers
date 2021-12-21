package com.julucin.hrworkers.exceptions;

public class NullIdException extends RuntimeException{

    public NullIdException(){
        super("The ID was null.");
    }

}
