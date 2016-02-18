/**
 * Created by Admin on 18.02.2016.
 */
public class CounterThread implements Runnable{
    private int data;
    private boolean isValid=false;
    private boolean hasEnded = false;
    private Thread nabourThread;

    public void setData(int data) {
        this.data = data;
        isValid = true;
    }

    public void setNabourThread(Thread nabourThread) {
        this.nabourThread = nabourThread;
    }

    @Override
    public void run() {
        while(!hasEnded){

        if (isValid){
            System.out.println(data);
            isValid=false;
            try {
                nabourThread.join(50);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    }

    }
}
