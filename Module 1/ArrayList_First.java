import java.util.NoSuchElementException;

/**
 * Your implementation of an ArrayList.
 */
public class ArrayList_First<T> {

    /*
     * The initial capacity of the ArrayList.
     *
     * DO NOT MODIFY THIS VARIABLE!
     */
    public static final int INITIAL_CAPACITY = 9;

    /*
     * Do not add new instance variables or modify existing ones.
     */
    private T[] backingArray;
    private int size;


    /**
     * This is the constructor that constructs a new ArrayList.
     * 
     * Recall that Java does not allow for regular generic array creation,
     * so instead we cast an Object[] to a T[] to get the generic typing.
     */
    public ArrayList_First() {
        //DO NOT MODIFY THIS METHOD!
        backingArray = (T[]) new Object[INITIAL_CAPACITY];
    }

    /**
     * Adds the data to the front of the list.
     *
     * This add may require elements to be shifted.
     *
     * Method should run in O(n) time.
     *
     * @param data the data to add to the front of the list
     * @throws java.lang.IllegalArgumentException if data is null
     */
    public void addToFront(T data) {
        // WRITE YOUR CODE HERE (DO NOT MODIFY METHOD HEADER)!
        if (data == null) {
            throw new IllegalArgumentException("Data is null!");
        }
        // what if size = 0?
        
        if (size == 0) {
            backingArray[0] = data;
        }
        
        if (size < INITIAL_CAPACITY ) {
            for(int i = size; i > 0; i--) {
                if (backingArray[i-1] != null) {
                    backingArray[i] = backingArray[i-1];                
                }
            }
            backingArray[0] = data;
        }

        if (size >= INITIAL_CAPACITY) {
            T[] newbackingArray = (T[]) new Object[size * 2];
            for (int i = 0; i < size ; i++) {
                newbackingArray[i+1] = backingArray[i];
            }
            newbackingArray[0] = data;
        }
        size +=1;
    }


    /**
     * Adds the data to the back of the list.
     *
     * Method should run in amortized O(1) time.
     *
     * @param data the data to add to the back of the list
     * @throws java.lang.IllegalArgumentException if data is null
     */
    public void addToBack(T data) {
        // WRITE YOUR CODE HERE (DO NOT MODIFY METHOD HEADER)!
        if (data == null) {
            throw new IllegalArgumentException("Data is null!");
        }
        if (size == INITIAL_CAPACITY) {
            T[] newbackingArray = (T[]) new Object[size * 2];
            for (int i=0; i < size; i ++) {
                newbackingArray[i] = backingArray[i];
            }
            newbackingArray[size] = data;
        }
        backingArray[size] = data;
        size +=1; 
        
    }


    /**
     * Removes and returns the first data of the list.
     *
     * Do not shrink the backing array.
     *
     * This remove may require elements to be shifted.
     *
     * Method should run in O(n) time.
     *
     * @return the data formerly located at the front of the list
     * @throws java.util.NoSuchElementException if the list is empty
     */
    public T removeFromFront() {
        // WRITE YOUR CODE HERE (DO NOT MODIFY METHOD HEADER)!
        if (size == 0) {
            throw new NoSuchElementException("The list is empty!");
        }
        T firstValue = backingArray[0];
        for (int i=0; i<size; i++) {
            backingArray[i] = backingArray[i+1];
        }
        size -= 1;
        return firstValue;
        
    }


    /**
     * Removes and returns the last data of the list.
     *
     * Do not shrink the backing array.
     *
     * Method should run in O(1) time.
     *
     * @return the data formerly located at the back of the list
     * @throws java.util.NoSuchElementException if the list is empty
     */
    public T removeFromBack() {
        // WRITE YOUR CODE HERE (DO NOT MODIFY METHOD HEADER)!
        if (size == 0) {
            throw new NoSuchElementException("The list is empty!");
        }
        T last_value = backingArray[size-1]; 
        backingArray[size-1] = null; 
        size -= 1; 
        return last_value;
    }





    /**
     * Returns the backing array of the list.
     *
     * For grading purposes only. You shouldn't need to use this method since
     * you have direct access to the variable.
     *
     * @return the backing array of the list
     */
    public T[] getBackingArray() {
        // DO NOT MODIFY THIS METHOD!
        return backingArray;
    }

    /**
     * Returns the size of the list.
     *
     * For grading purposes only. You shouldn't need to use this method since
     * you have direct access to the variable.
     *
     * @return the size of the list
     */
    public int size() {
        // DO NOT MODIFY THIS METHOD!
        return size;
    }
}


// Tests Passed: 16 / 23

// [Test Failure: addToFront] [-0.43] : Unexpected content after adding once to the front, triggering first resize.
// 	Expected : [0a, 1a, 2a, 3a, 4a, 5a, 6a, 7a, 8a, 9a, null, null, null, null, null, null, null, null]
// 	Actual : [1a, 2a, 3a, 4a, 5a, 6a, 7a, 8a, 9a] 

// [Test Failure: addToFront] [-0.43] : Unexpected content after adding once to the front, triggering second resize.
// 	Expected : [0a, 1a, 2a, 3a, 4a, 5a, 6a, 7a, 8a, 9a, 10a, 11a, 12a, 13a, 14a, 15a, 16a, 17a, 18a, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null]
// 	Actual : [1a, 2a, 3a, 4a, 5a, 6a, 7a, 8a, 9a, 10a, 11a, 12a, 13a, 14a, 15a, 16a, 17a, 18a] 

// [Test Failure: addToBack] [-0.43] : This addToBack test was inconclusive due to: java.lang.ArrayIndexOutOfBoundsException: Index 9 out of bounds for length 9
// Here is the stack trace to help identify the error in your code:
// 	at ArrayList.addToBack, line number: 94 

// [Test Failure: addToBack] [-0.43] : This addToBack test was inconclusive due to: java.lang.ArrayIndexOutOfBoundsException: Index 18 out of bounds for length 18
// Here is the stack trace to help identify the error in your code:
// 	at ArrayList.addToBack, line number: 94 

// [Test Failure: removeFromFront] [-0.43] : This removeFromFront test was inconclusive due to: java.lang.ArrayIndexOutOfBoundsException: Index 9 out of bounds for length 9
// Here is the stack trace to help identify the error in your code:
// 	at ArrayList.removeFromFront, line number: 119 

// [Test Failure: validSize] [-0.43] : Size variable could not be validated for the following method(s) due to early test failure(s): removeFromFront, addToBack. 

// [Test Failure: validData] [-0.43] : Returned data could not be validated for the following method(s) due to early test failure(s): removeFromFront. 