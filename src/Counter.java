/**
 * The type Counter.
 */
public class Counter {
    private int number = 0;
    /**
     * Increase.add number to current count.
     *
     * @param num the num
     */
    void increase(int num) {
        this.number = this.number + num;
    }

    /**
     * Decrease.subtract number from current count.
     *
     * @param num the num
     */
    void decrease(int num) {
        this.number = this.number - num;
        if (this.number < 0) {
            this.number = 0;
        }
    }

    /**
     * Get value int.get current count.
     *
     * @return the int
     */
    int getValue() {
        return this.number;
    }
}
