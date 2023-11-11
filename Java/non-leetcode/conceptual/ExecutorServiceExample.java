package sample;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class ExecutorServiceExample {

    public static void main(String[] args) {

        // スレッドプールの最大値を3スレッドに設定。
        final int MAX_THREADS = 3;

        // ファクトリメソッド「newFixedThreadPool」を使って、スレッドプールを持つExecutorServiceを生成。
        ExecutorService executor = Executors.newFixedThreadPool(MAX_THREADS);

        // スレッドを10本立ててみる
        for (int i = 0; i < 10; i++) {

            // スレッドに番号を振る。
            int no = i;

            // スレッドの生存時間を1〜10秒でランダムに決める。
            int lifeTime = (int)(Math.random() * 9 + 1);

            // スレッドを起動する。
            executor.submit(new SampleThread(no, lifeTime));
        }
        // ExecutorServiceを閉じる。
        System.out.println("executor.shutdown();");
        executor.shutdown();
    }
}

public class SampleThread implements Runnable {

    private int no;
    private int time;

    SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");

    SampleThread(int no, int time) {
        this.no = no;
        this.time = time;
    }

    @Override
    public void run() {
        System.out.println(" No." + no + " start  id:" + Thread.currentThread().threadId( + "  生存時間:" + time + " 現在時刻:" + sdf.format(Calendar.getInstance().getTime()));
        try {
            // 何かの処理が行われていると見せかけるため、スリープさせる。
            Thread.sleep(time * 1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(" No." + no + " end    id:" + Thread.currentThread().threadId() + "  生存時間:" + time + " 現在時刻:" + sdf.format(Calendar.getInstance().getTime()));
    }
}