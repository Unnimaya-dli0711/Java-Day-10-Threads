package threadslevel1;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class EvenOddNumberPrinter {
    private static final int max_number=10;
    private static final Lock lock=new ReentrantLock();
    private static int current=1;

    public static void main(String[] args) {
        Thread oddThread=new Thread(EvenOddNumberPrinter::printOdd);
        Thread evenThread=new Thread(EvenOddNumberPrinter::printEven);
        oddThread.start();
        evenThread.start();
    }
    private static void printEven(){
        while(current<=max_number){
            try{
                lock.lock();
                if(current%2==0){
                    System.out.println(current);
                    current++;
                }
            }finally {
                lock.unlock();
            }
        }
    }
    private static void printOdd(){
        while (current<=max_number){
            try{
                lock.lock();
                if(current%2!=0){
                    System.out.println(current);
                    current++;
                }
            }finally {
                lock.unlock();
            }
        }
    }
}
//Create two threads: one for printing even numbers and the other for printing odd numbers.
//Synchronize the threads using locks or mutex to ensure that they print the numbers alternately.