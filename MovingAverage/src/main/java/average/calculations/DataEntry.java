package average.calculations;

/**
 * An Interface which calculates and returns Simple Moving Average for last N number of entries in a data set. Where N
 * is a variable set by the implementation class.
 * Value for any entry cannot be null.
 * This data structure can be used to create a single linked list, which will have N number of elements.
 */
public interface DataEntry<V> {
    /**
     * Inserts record in a single linked list.
     * @param value - value to be inserted in the data set for Simple Moving Average calculation.
     */
    void put(V value);

    /**
     * @return moving average for last N number of entries in a data set
     */
    Double getMovingAverage();

    /**
     * Basic Node, which is used to save data. As well as, properties of this structure is used to traverse
     * through all inserted elements and their value in order to calculate the SMA.
     */
    interface Entry<V>{

        /**
         * @return inserted value which is saved via this node. This value is used to calculate moving average.
         */
        Object getValue();

        /**
         * @return an object, which can be used to access for the next node
         */
        Entry getRight();

        /**
         * @return returns true if the data structure contains any node, and returns false if no node is available,
         * i.e: size of the structure is 0.
         */
        boolean isEmpty();
    }

    void remove(Object node);
}
