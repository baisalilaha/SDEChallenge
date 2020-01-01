package average.calculations;

import org.apache.log4j.Logger;

public class MovingAverage {

    private static final Logger logger = Logger.getLogger(MovingAverage.class);

    public static void main(String[] args){

        DataEntryImpl data = new DataEntryImpl(9);
        data.put(1.2);
        if(logger.isDebugEnabled()) logger.debug("getMovingAverage : " + data.getMovingAverage());
        data.put( 9);
        if(logger.isDebugEnabled()) logger.debug("getMovingAverage : " + data.getMovingAverage());
        data.put( 8.5);
        if(logger.isDebugEnabled()) logger.debug("getMovingAverage : " + data.getMovingAverage());
        data.put( 7.10);
        if(logger.isDebugEnabled()) logger.debug("getMovingAverage : " + data.getMovingAverage());
        data.put( 6.79);
        if(logger.isDebugEnabled()) logger.debug("getMovingAverage : " + data.getMovingAverage());
        data.put( 12);
        if(logger.isDebugEnabled()) logger.debug("getMovingAverage : " + data.getMovingAverage());
        data.put( 7.21);
        if(logger.isDebugEnabled()) logger.debug("getMovingAverage : " + data.getMovingAverage());
        data.put( 8);
        data.put( 9);
        data.put( 10);
        if(logger.isDebugEnabled()) logger.debug("getMovingAverage : " + data.getMovingAverage());
    }
}
