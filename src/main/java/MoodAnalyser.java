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
    public String moodAnalyserMethod() {
        // Handle Exception if user provides invalid mood
        try {
            if (message.contains("happy")) {
                return "HAPPY";
            }
            else {
                return "SAD";
            }
        }
        catch (NullPointerException e) {
            return "HAPPY";
        }
    }
}