package average.calculations;

import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.concurrent.*;
import java.util.stream.IntStream;

public class DataEntryImplTests {

    private static final Logger logger = Logger.getLogger(DataEntryImplTests.class);

    @Test
    public void simpleMovingAverageTest() {
        logger.debug("Starting simpleMovingAverageTest");
        DataEntryImpl data = new DataEntryImpl(5);
        data.put(90);
        data.put(15);
        data.put(85);
        data.put(9);
        data.put(10);
        data.put(92);

        double average = data.getMovingAverage();

        Assert.assertEquals(average, 42.2);
    }

    @Test(expectedExceptions = ClassCastException.class)
    public void ClassCastExceptionWithNullValueTest() {
        logger.debug("Starting ClassCastExceptionWithNullValueTest");
        DataEntryImpl data = new DataEntryImpl(3);
        data.put(9);
        data.put(1);
        data.put(null);
    }

    @Test(expectedExceptions = ClassCastException.class)
    public void ClassCastExceptionStringTest() {
        logger.debug("starting ClassCastExceptionWithStringTest");
        DataEntryImpl data = new DataEntryImpl(6);
        data.put(9);
        data.put("One");
    }

    @Test
    public void simpleMovingAverageWithLessThanNEntriesTest() {
        logger.debug("starting simpleMovingAverageWithLessThanNEntries");
        DataEntryImpl data = new DataEntryImpl(15);
        data.put(1.5);
        data.put(7.8);
        data.put(6.3);

        double average = data.getMovingAverage();

        Assert.assertEquals(average, 5.2);
    }

    @Test
    public void simpleMovingAverageWithNegativeEntriesTest() {
        logger.debug("starting simpleMovingAverageWithLessThanNEntries");
        DataEntryImpl data = new DataEntryImpl(5);
        data.put(-8.5);
        data.put(-0.5);
        data.put(-7.8);
        data.put(6.3);

        double average = data.getMovingAverage();

        Assert.assertEquals(average, -2.625);
    }

    @Test
    public void simpleMovingAverageWithEntriesSumToZeroTest() {
        logger.debug("starting simpleMovingAverageWithNegativeEntries");
        DataEntryImpl data = new DataEntryImpl(3);
        data.put(1.5);
        data.put(-7.8);
        data.put(6.3);

        double average = data.getMovingAverage();
        Assert.assertEquals(average, 0.0);
    }

    @Test(expectedExceptions = IllegalArgumentException.class)
    public void IllegalArgumentExceptionForSizeZeroTest() {
        logger.debug("starting IllegalArgumentExceptionForSizeZeroTest");
        DataEntryImpl data = new DataEntryImpl(0);
        data.put(1.5);
    }
}
