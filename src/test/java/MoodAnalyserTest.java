import org.junit.Assert;
import org.junit.Test;

import java.lang.reflect.Constructor;

public class MoodAnalyserTest {

    // Test for testing Happy mood
    @Test
    public void givenMessage_whenHappy_shouldReturnHappy() throws MoodAnalysisException {
        MoodAnalyser moodAnalyserObject = new MoodAnalyser("I'm in happy mood");
        Assert.assertEquals("HAPPY", moodAnalyserObject.moodAnalyserMethod());
    }

    // Test for testing Sad mood
    @Test
    public void givenMessage_whenSad_shouldReturnSad() throws MoodAnalysisException {
        MoodAnalyser moodAnalyserObject = new MoodAnalyser("I'm in sad mood");
        Assert.assertEquals("SAD", moodAnalyserObject.moodAnalyserMethod());
    }

    // Test for empty mood using custom exception
    @Test
    public void givenMessage_whenEmpty_shouldThrowException() {
        try {
            MoodAnalyser moodAnalyserObject = new MoodAnalyser(" ");
            moodAnalyserObject.moodAnalyserMethod();
        }
        catch (MoodAnalysisException e) {
            Assert.assertEquals(e.exceptionTypeObject,MoodAnalysisException.ExceptionType.EMPTY_EXCEPTION);
        }
    }
    // Test for null mood using custom exception
    @Test
    public void givenMessage_whenNull_shouldThrowException() {
        try {
            MoodAnalyser moodAnalyserObject = new MoodAnalyser(null);
            moodAnalyserObject.moodAnalyserMethod();
        }
        catch (MoodAnalysisException e) {
            Assert.assertEquals(e.exceptionTypeObject,MoodAnalysisException.ExceptionType.NULL_EXCEPTION);
        }
    }
    // Test for checking if two objects are equal or not
    @Test
    public void givenMessage_whenObjectsAreEqual_shouldReturnTrue() throws MoodAnalysisException {
        MoodAnalyser moodAnalyserObject1 = new MoodAnalyser();
        Constructor constructor = MoodAnalyserFactory.getConstructor("MoodAnalyser");
        MoodAnalyser moodAnalyserObject2 = MoodAnalyserFactory.createMoodAnalyserObject(constructor);
        boolean result = moodAnalyserObject1.equals(moodAnalyserObject2);
        Assert.assertTrue("true",result);
    }
}