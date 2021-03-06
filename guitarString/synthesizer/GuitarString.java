package synthesizer;

//Make sure this class is public
public class GuitarString {

    private static final int SR = 44100;      // Sampling Rate
    private static final double DECAY = .996; // energy decay factor

    /* Buffer for storing sound data. */
    private BoundedQueue<Double> buffer;

    /* Create a guitar string of the given frequency.  */
    public GuitarString(double frequency) {
        //       cast the result of this divsion operation into an int. For better
        //       accuracy, use the Math.round() function before casting.
        //       Your buffer should be initially filled with zeros.

        int capacity = (int) Math.round(SR / frequency);
        buffer = new ArrayRingBuffer<>(capacity);
        for (int i = 0; i < buffer.capacity(); i++) {
            buffer.enqueue(0.0);
        }
    }


    /* Pluck the guitar string by replacing the buffer with white noise. */
    public void pluck() {
        //       between -0.5 and 0.5. You can get such a number by using:
        //       double r = Math.random() - 0.5;
        //
        //       Make sure that your random numbers are different from each other.
        for (int i = 0; i < buffer.capacity(); i++) {
            buffer.dequeue();
        }
        for (int i = 0; i < buffer.capacity(); i++) {
            double r = Math.random() - 0.5;
            buffer.enqueue(r);
        }
    }

    /* Advance the simulation one time step by performing one iteration of
     * the Karplus-Strong algorithm. 
     */
    public void tic() {
        //       the average of the two multiplied by the DECAY factor.
        //       Do not call StdAudio.play().
        double frontSample = buffer.dequeue();
        double nextSample = buffer.peek();
        double newSample = (frontSample + nextSample) / 2;
        newSample = newSample * DECAY;
        buffer.enqueue(newSample);
    }

    /* Return the double at the front of the buffer. */
    public double sample() {
        //buffer.displayBuffer();//////////////////////////////////////////////////////////////
        return buffer.peek();
    }

}
