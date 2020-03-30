public class MoodAnalysisException extends Exception {
    // enum for declaring constants
    enum ExceptionType
    {
        EMPTY_EXCEPTION,
        NULL_EXCEPTION,
        CLASS_NOT_FOUND,
        METHOD_NOT_FOUND,
        FIELD_NOT_FOUND,
        ILLEGAL_ACCESS_EXCEPTION,
    }
    ExceptionType exceptionTypeObject;
    // Parameterized Constructor
    public MoodAnalysisException(String message,ExceptionType exceptionTypeObject) {
        super(message);
        this.exceptionTypeObject=exceptionTypeObject;
    }
}
