import java.util.Arrays;
import java.util.Random;

class SharedArray {
    int[] arr;

    SharedArray(int size) {
        arr = new int[size];
    }

    void generateArray() {
        Random r = new Random();
        for (int i = 0; i < arr.length; i++) {
            arr[i] = r.nextInt(100);
        }
        System.out.println("Generated Array: " + Arrays.toString(arr));
    }

    void ascendingSort() {
        int[] temp = arr.clone();
        Arrays.sort(temp);
        System.out.println("Ascending Order: " + Arrays.toString(temp));
    }

    void descendingSort() {
        int[] temp = arr.clone();
        Arrays.sort(temp);
        for (int i = 0; i < temp.length / 2; i++) {
            int t = temp[i];
            temp[i] = temp[temp.length - 1 - i];
            temp[temp.length - 1 - i] = t;
        }
        System.out.println("Descending Order: " + Arrays.toString(temp));
    }
}

class GenerateThread extends Thread {
    SharedArray a;

    GenerateThread(SharedArray a) {
        this.a = a;
    }

    public void run() {
        a.generateArray();
    }
}

class AscendingThread extends Thread {
    SharedArray a;

    AscendingThread(SharedArray a) {
        this.a = a;
    }

    public void run() {
        a.ascendingSort();
    }
}

class DescendingThread extends Thread {
    SharedArray a;

    DescendingThread(SharedArray a) {
        this.a = a;
    }

    public void run() {
        a.descendingSort();
    }
}

public class Ex7_MultiThreadSort {
    public static void main(String[] args) throws InterruptedException {
        SharedArray a = new SharedArray(10);

        GenerateThread t1 = new GenerateThread(a);
        AscendingThread t2 = new AscendingThread(a);
        DescendingThread t3 = new DescendingThread(a);

        t1.start();
        t1.join();

        t2.start();
        t3.start();

        t2.join();
        t3.join();

        System.out.println("All threads completed.");
    }
}
