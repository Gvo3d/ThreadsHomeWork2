import java.util.*;

/**
 * Created by Admin on 18.02.2016.
 */
public class CounterClass {
    private int startingpoint;
    private int endingpoint;
    private CounterThread counter1;
    private CounterThread counter2;
    private Thread counter1t;
    private Thread counter2t;

    public CounterClass(int startingpoint, int endingpoint) {
        this.startingpoint = startingpoint;
        this.endingpoint = endingpoint;

            counter1 = new CounterThread();
            counter2 = new CounterThread();


        counter1t = new Thread(counter1);
        counter2t = new Thread(counter2);
        counter2.setNabourThread(counter1t);
        counter1.setNabourThread(counter2t);
    }

    public void calculate() throws InterruptedException {
        boolean firstThread=true;
counter1t.start();
counter2t.start();


            for (int i=startingpoint; i<endingpoint; i++){
            if (firstThread){
                counter1.setData(i);
                firstThread=false;

            } else {
                counter2.setData(i);
                firstThread=true;
            }
        }
        System.out.println("That's all");
    }
}
