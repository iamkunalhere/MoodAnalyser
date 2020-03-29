public class MoodAnalyser {
    String message;
    public static void main(String args[]) {
        System.out.println("Mood Analyser");
    }
    // Method for analyzing the mood
    public String moodAnalyserMethod(String message) {
        if (message.contains("happy")) {
            return "HAPPY";
        }
        else {
            return "SAD";
        }
    }
}
