package conceptual.MultiThread;


class Multi extends Thread { //run method without parameters
    public void run() {
    for (int i = 0; i < 1000; i++) {
            System.out.println("Running Batting Statistics Thread " + i);
}
    }
    public static void main(String[] args) {
        // Multi multi = new Multi();
        // multi.start();
        long startTime = System.currentTimeMillis();
       
        BowlingStatisticsThread battingInterfaceImpl = new BowlingStatisticsThread(); 
        Thread battingThread2 = new Thread(battingInterfaceImpl); 
        battingThread2.start();
        System.out.println("=======");
        long endTime = System.currentTimeMillis();
        System.out.println("処理時間：" + (endTime - startTime) + " ms");
    }
}


class BowlingStatisticsThread implements Runnable { //run method without parameters
    public void run() {
    for (int i = 0; i < 1000; i++) 
    System.out.println("Running Bowling Statistics Thread " + i);
}
}