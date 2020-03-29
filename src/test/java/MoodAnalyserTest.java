import org.junit.Assert;
import org.junit.Test;
public class MoodAnalyserTest {

    // Test for testing Happy mood
   @Test
    public void givenMessage_whenHappy_shouldReturnHappy() {
    MoodAnalyser moodAnalyserObject = new MoodAnalyser("I'm in happy mood");
    Assert.assertEquals("HAPPY",moodAnalyserObject.moodAnalyserMethod());
   }
   // Test for testing Sad mood
   @Test
    public void givenMessage_whenSad_shouldReturnSad() {
       MoodAnalyser moodAnalyserObject = new MoodAnalyser("I'm in sad mood");
       Assert.assertEquals("SAD",moodAnalyserObject.moodAnalyserMethod());
   }
}
