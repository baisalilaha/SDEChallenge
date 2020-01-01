package average.calculations;


import org.apache.log4j.Logger;

/**
 * This class implements the data structure DataEntry, this is used to calculate and return Simple Moving Average
 * for last N number of entries in a data set. Where, N is the user given value or limit which is used as the divisor for
 * calculating average. Example : (n1+n2+n3+..nn)/N
 * Every elements of this data set is an Object of the subclass Entry.
 * N is set by the user while initializing this class.
 * Size of N determines the number of nodes, that is going to be persisted. Value of N has to be greater than 0
 * Value for any entry cannot be null or non-numerical.
 */
public class DataEntryImpl implements DataEntry{
    private static final Logger logger = Logger.getLogger(DataEntryImpl.class);

    private int size;
    private double avg;
    private int limit;
    private double sum = 0.0;
    private Entry entryList;

    DataEntryImpl(int numbers){
        size = 0;
        limit = numbers;
        entryList = new Entry();
    }

    /*
     *Basic entry Node used to save data for all entries
     */
    final class Entry implements DataEntry.Entry{
        private Object val;
        private Entry right;

        Entry(Object value) {
            this.val = value;
            this.right = null;
        }

        Entry(){}

        /**
         * @return Returns value corresponding to every node
         * dataType Double
         */
        @Override
        public Object getValue() {
            return this.val;
        }

        @Override
        public Entry getRight() {
            return this.right;
        }

        private void setRight(Entry node){
            this.right = node;
        }

        @Override
        public boolean isEmpty(){
            return size == 0;
        }
    }

    /**
     * This method is used to insert given value using the data structure DataEntry. A basic node of type is created 
     * "DataEntry.Entry" with user given data. And a list of multiple nodes are created, where each of them are 
     * accessible by it's previous node via object "right", which is a DataEntry.Entry type object. A private variable
     * "size" is used to keep track if the given limit numbers has reached. When size is same as given limit, first Node
     * from the entryList is removed from the created list. And a new node is added at the end of the list.
     * @throws IllegalArgumentException - When limit is not greater than 0
     * @throws ClassCastException - If given value is cannot be casted to Double, as SMA calculation cannot be done with
     * non-double values.
     * @throws NullPointerException - This exception is thrown in case of Null pointerException
     * @throws RuntimeException - For any type of exception other than above
     * @param value - Given value for which SMA has to be calculated
     */
    @Override
    public void put(Object value) {
        if(limit <= 0){
            throw  new IllegalArgumentException("Invalid input : to calculate moving average, " +
                    "size of the window has to be greater than 0");
        }
        /*
         * Since we have to calculate moving average for all the element that has been added, a validity check
         * is needed to see if the input object is numeric, if not, then this method will throw an ClassFormatError
         */
        if(!(value instanceof Number)){
            throw new ClassCastException("Invalid input : to calculate moving average, " +
                    "this object has to be numerical");
        }
        try {
            //Convert given numerical
            Double val = Double.parseDouble(value.toString());
            Entry data = new Entry(val);

            //entryList points to first element in the list
            if(entryList.isEmpty()){
                entryList.setRight(data);
                sum = val;
                size++;
            }else {
                /*
                 *Check if the number of given elements is equal to N( limit for calculating moving average), if so,
                 *one element from the beginning of the entryList has to be removed, and to do that "entryList" object
                 *can be moved to pint to the right node of the one it is currently pointing,
                 *so that a new element can be added at the end of the list, and simple moving average can be
                 *calculated for all these elements including the new one again.
                 */
                if(size == limit) {
                    Entry removeNode = entryList.getRight();
                    double deductValue = Double.parseDouble(removeNode.getValue().toString());
                    entryList.setRight(removeNode.right);
                    removeNode.right = null;
                    size--;
                    if(logger.isDebugEnabled()) logger.debug("Data To be removed : " + deductValue);
                    sum = sum - deductValue;
                    if(logger.isDebugEnabled()) logger.debug("sum after deduction " + sum);
                }

                //Add newly created node on the right of existing last node
                Entry next = entryList;
                while (next != null){
                    if (next.getRight() == null) {
                        next.setRight(data);
                        break;
                    }else next = next.getRight();
                }

                //calculate sum all given values
                sum = sum + val;

                //increase number of the linked nodes. This will keep track if first node of the list has to be deleted
                size++;
            }
            if(logger.isDebugEnabled()) logger.debug("sum after adding " + data.getValue() + " " + sum);

            //Calculate and Set Simple Moving Average
            this.avg = sum / size;

        }catch(ClassCastException cast){
            throw new ClassCastException(cast.getMessage());
        }catch(NullPointerException nullEx) {
            throw new NullPointerException(nullEx.getMessage());
        }catch(Exception ex){
            throw new RuntimeException(ex.getMessage());
        }
    }

    /*
     * Returns simple  moving average for last N number of entries in a given data set.
     */
    @Override
    public Double getMovingAverage() {
        return this.avg;
    }
}
