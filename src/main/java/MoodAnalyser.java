public class MoodAnalyser {
    String message;

    public static void main(String[] args) {
        System.out.println("Mood Analyser");
    }

    // Default constructor
    public MoodAnalyser() {

    }
    // Parameterized constructor
    public MoodAnalyser(String message) {
        this.message = message;
    }

    // Method for analyzing the mood
    public String moodAnalyserMethod() throws MoodAnalysisException {
        // Handle Exception if user provides invalid mood
        try {
            if (message.length() == 0) {
                throw new MoodAnalysisException("Enter the message,it cannot be empty", MoodAnalysisException.ExceptionType.EMPTY_EXCEPTION);
            }
            else if (message.contains("happy")) {
                return "HAPPY";
            }
            else  {
                return "SAD";
            }
        }
        catch (NullPointerException e) {
            throw new MoodAnalysisException("Enter the message,it cannot be null", MoodAnalysisException.ExceptionType.NULL_EXCEPTION);
        }
    }
}
