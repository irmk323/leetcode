package conceptual.MultiThread;

public class MultiThreadSample {
    
    public static void main(String[] args) {
        
        for(int i = 0; i< 6 ; i++){
            MultiThreading mything = new MultiThreading(i);
            Thread mythread = new Thread(mything);
            mythread.start();
            try {
                mythread.join();
            } catch (Exception e) {
                // TODO: handle exception
            }
        }      
    }
}

public class MultiThreading implements Runnable{
    private int threadNumber;
    public MultiThreading(int threadNumber){
        this.threadNumber = threadNumber;

    }
    @Override
    public void run(){
        for(int i = 0; i< 6 ; i++){
            System.out.println(i + " from thread" + threadNumber);
            try {
                Thread.sleep(1000);
            } catch (Exception e) {
                // TODO: handle exception
            }
        }

    }
}
