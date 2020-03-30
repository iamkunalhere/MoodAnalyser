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
        } catch (MoodAnalysisException e) {
            Assert.assertEquals(e.exceptionTypeObject, MoodAnalysisException.ExceptionType.EMPTY_EXCEPTION);
        }
    }

    // Test for null mood using custom exception
    @Test
    public void givenMessage_whenNull_shouldThrowException() {
        try {
            MoodAnalyser moodAnalyserObject = new MoodAnalyser(null);
            moodAnalyserObject.moodAnalyserMethod();
        } catch (MoodAnalysisException e) {
            Assert.assertEquals(e.exceptionTypeObject, MoodAnalysisException.ExceptionType.NULL_EXCEPTION);
        }
    }

    // Test for checking if two objects with parameter are equal or not
    @Test
    public void ObjectsAreEqual_withParameter_shouldReturnTrue() throws MoodAnalysisException {
        MoodAnalyser moodAnalyserObject1 = new MoodAnalyser("Hi");
        Constructor constructor = MoodAnalyserFactory.getConstructor("MoodAnalyser",String.class);
        MoodAnalyser moodAnalyserObject2 = MoodAnalyserFactory.createMoodAnalyserObject(constructor,"Hi");
        boolean result = moodAnalyserObject1.equals(moodAnalyserObject2);
        Assert.assertTrue("true", result);
    }

    // Test for checking improper class name
    @Test
    public void givenClassName_whenImproper_shouldThrowException() {
        try {
            MoodAnalyserFactory.getConstructor("Analyser");
        } catch (MoodAnalysisException e) {
            Assert.assertEquals(e.exceptionTypeObject, MoodAnalysisException.ExceptionType.CLASS_NOT_FOUND);
        }
    }

    // Test for checking not proper constructor
    @Test
    public void givenConstructor_whenImproper_shouldThrowExeption() {
        try {
            MoodAnalyserFactory.getConstructor("MoodAnalyser", Integer.class);
        } catch (MoodAnalysisException e) {
            Assert.assertEquals(MoodAnalysisException.ExceptionType.METHOD_NOT_FOUND, e.exceptionTypeObject);
        }
    }
}