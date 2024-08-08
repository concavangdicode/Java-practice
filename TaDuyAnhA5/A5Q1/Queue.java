/*
*
* [Queue.java]
*
* COMP 1020 SECTION [A01]
* INSTRUCTOR: [Lauren Himbeaul]
* NAME: [Duy Anh Ta]
* ASSIGNMENT: [Assignment 5]
* QUESTION: [question 1]
*
* PURPOSE: [Queue interface]
*/
public interface Queue {

    /**
     * Adds a person to the end of the queue.
     *
     * @param personName The name of the person to be added to the queue.
     */
    void enqueue(String personName);

    /**
     * Removes and returns the person from the front of the queue.
     *
     * @return The name of the person at the front of the queue.
     */
    String dequeue();

    /**
     * Checks if the queue is empty.
     *
     * @return true if the queue is empty, false otherwise.
     */
    boolean isEmpty();

    /**
     * Returns the number of people in the queue.
     *
     * @return The size of the queue.
     */
    int size();

    // Additional optional methods can be added, such as:
    String peek(); // Returns the name of the person at the front without dequeuing.
    void displayQueue(); // Displays the names of all people in the queue.
}
