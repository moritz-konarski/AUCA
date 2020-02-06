//if the rational is not in the correct form
class NotARationalException extends Exception {

    private String message = "This is not a valid Rational!";

    NotARationalException() {
    }

    public String getMessage() {
        return message;
    }
}

//if the denominator is zero
class DenominatorZeroException extends Exception {

    private String message = "Denominator can not be zero!";

    DenominatorZeroException() {
    }

    public String getMessage() {
        return message;
    }
}

//if there is division by zero
class DivisionByZeroException extends Exception {

    private String message = "Can not divide by zero!";

    DivisionByZeroException() {
    }

    public String getMessage() {
        return message;
    }
}

//if Ctrl-D or Ctrl-Z are pressed and a scanner reads it
class EndOfFileException extends Exception {

    private String message = "Exiting program.";

    EndOfFileException() {
    }

    public String getMessage() {
        return message;
    }
}