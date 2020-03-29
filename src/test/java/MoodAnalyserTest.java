import org.junit.Assert;
import org.junit.Test;
public class MoodAnalyserTest {
   MoodAnalyser moodAnalyserObject = new MoodAnalyser();
    // Test for testing Happy mood
   @Test
    public void givenMessage_whenHappy_shouldReturnHappy() {
       String mood=moodAnalyserObject.moodAnalyserMethod("I'm in happy mood");
       Assert.assertEquals("HAPPY",mood);
   }
   // Test for testing Sad mood
   @Test
    public void givenMessage_whenSad_shouldReturnSad() {
       String mood=moodAnalyserObject.moodAnalyserMethod("I'm in sad mood");
       Assert.assertEquals("SAD",mood);
   }
}
