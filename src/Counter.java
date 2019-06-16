public class Counter {
    private int number = 0;
    // add number to current count.
    void increase(int num){
        this.number=this.number+num;
    }

    // subtract number from current count.
    void decrease(int num){
        this.number=this.number-num;
        if (this.number<0){
            this.number=0;
        }
    }
    // get current count.
    int getValue(){
        return this.number;
    }
}
