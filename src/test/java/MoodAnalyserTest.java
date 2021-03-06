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

    // Test for checking improper class name with parameter
    @Test
    public void givenClassWithParameter_whenImproper_shouldThrowException() {
        try {
            MoodAnalyserFactory.getConstructor("Analyser",String.class);
        } catch (MoodAnalysisException e) {
            Assert.assertEquals(e.exceptionTypeObject, MoodAnalysisException.ExceptionType.CLASS_NOT_FOUND);
        }
    }

    // Test for checking not proper constructor with parameter
    @Test
    public void givenConstructorWithParameter_whenImproper_shouldThrowException() {
        try {
            MoodAnalyserFactory.getConstructor("MoodAnalyser", String.class , Integer.class);
        } catch (MoodAnalysisException e) {
            Assert.assertEquals(MoodAnalysisException.ExceptionType.METHOD_NOT_FOUND, e.exceptionTypeObject);
        }
    }
    // Test for return HAPPY message by invoke method using reflection
    @Test
    public void usingReflection_givenMessage_WhenProper_shouldReturnHappy() throws MoodAnalysisException{
        try
        {
            Constructor constructor = MoodAnalyserFactory.getConstructor("MoodAnalyser",Integer.class);
            Object moodObject1 = MoodAnalyserFactory.createMoodAnalyserObject(constructor,"I'm in Happy mood");
            Object moodObject2 = MoodAnalyserFactory.invokeMethod(moodObject1, "analyseMood");
            Assert.assertEquals("HAPPY",moodObject2);
        } catch (MoodAnalysisException e) {
            e.printStackTrace();
        }
    }
    // Test for throw exception if method name is wrong
    @Test
    public void usingReflection_givenMessage_whenImproper_shouldThrowException() {
        try {
            Constructor constructor = MoodAnalyserFactory.getConstructor("MoodAnalyser",String.class);
            Object moodAnalyserObject1 = MoodAnalyserFactory.createMoodAnalyserObject(constructor,"I am in Happy mood");
            Object moodAnalyserObject2 = MoodAnalyserFactory.invokeMethod(moodAnalyserObject1, "AnalyseMood");
            Assert.assertEquals("HAPPPY",moodAnalyserObject2);
        }
        catch (MoodAnalysisException e) {
            Assert.assertEquals(e.exceptionTypeObject , MoodAnalysisException.ExceptionType.METHOD_NOT_FOUND);
        }
    }
    // Test invoke method using reflection and assert happy mood
    @Test
    public void usingReflector_messageSet_Happy_shouldReturnHappy() {
        try {
            Constructor constructor = MoodAnalyserFactory.getConstructor("MoodAnalyser");
            MoodAnalyser moodAnalyserObject = MoodAnalyserFactory.createMoodAnalyserObject(constructor);
            MoodAnalyserFactory.moodAnalyserFieldMethod(moodAnalyserObject,"message","I'm in Happy mood");
            Object moodObject = MoodAnalyserFactory.invokeMethod(moodAnalyserObject, "analyseMood");
            Assert.assertEquals("HAPPY",moodObject);
        }
        catch (MoodAnalysisException e) {
            e.printStackTrace();
        }
    }
    // Test for set the Value on improper Field, catch the exception and throw field not found error
    @Test
    public void field_whenImproper_shouldThrowException() throws MoodAnalysisException {
        try {
            Constructor constructor = MoodAnalyserFactory.getConstructor("MoodAnalyser");
            MoodAnalyser moodAnalyserObject = MoodAnalyserFactory.createMoodAnalyserObject(constructor);
            MoodAnalyserFactory.moodAnalyserFieldMethod(moodAnalyserObject,"Message","I'm Happy ");
            Object moodObject = MoodAnalyserFactory.invokeMethod(moodAnalyserObject, "analyseMood");
        }
        catch (MoodAnalysisException e) {
            Assert.assertEquals(e.exceptionTypeObject,MoodAnalysisException.ExceptionType.FIELD_NOT_FOUND);
        }
    }
    // Test for set the Field Value to null and check exception
    @Test
    public void message_whenNull_shouldThrowException() throws MoodAnalysisException {
        try {
            Constructor constructor = MoodAnalyserFactory.getConstructor("MoodAnalyser");
            MoodAnalyser moodAnalyserObject = MoodAnalyserFactory.createMoodAnalyserObject(constructor);
            MoodAnalyserFactory.moodAnalyserFieldMethod(moodAnalyserObject,"message",null);
            Object moodObject = MoodAnalyserFactory.invokeMethod(moodAnalyserObject, "analyseMood");
        }
        catch (MoodAnalysisException e) {
            Assert.assertEquals(e.exceptionTypeObject,MoodAnalysisException.ExceptionType.METHOD_NOT_FOUND);
        }
    }

}