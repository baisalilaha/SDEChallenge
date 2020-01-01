package average.calculations;

import org.apache.log4j.Logger;

public class MovingAverage {

    private static final Logger logger = Logger.getLogger(MovingAverage.class);

    public static void main(String[] args){

        DataEntryImpl data = new DataEntryImpl(4);
        data.put(1);
        if(logger.isDebugEnabled()) logger.debug("getMovingAverage : " + data.getMovingAverage());
        data.put( 3);
        data.put( 4);
        data.put( 6);
        if(logger.isDebugEnabled()) logger.debug("getMovingAverage : " + data.getMovingAverage());
        data.put( 7);
        if(logger.isDebugEnabled()) logger.debug("getMovingAverage : " + data.getMovingAverage());
        data.put( 8.9);
        if(logger.isDebugEnabled()) logger.debug("getMovingAverage : " + data.getMovingAverage());
    }
}
