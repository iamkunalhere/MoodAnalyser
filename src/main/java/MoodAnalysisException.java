public class MoodAnalysisException extends Exception {
    // enum for declaring constants
    enum ExceptionType
    {
        EMPTY_EXCEPTION,
        NULL_EXCEPTION
    }
    ExceptionType exceptionTypeObject;
    // Parameterized Constructor
    public MoodAnalysisException(String message,ExceptionType exceptionTypeObject) {
        super(message);
        this.exceptionTypeObject=exceptionTypeObject;
    }
}
