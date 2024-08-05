package multithreading;

import java.util.Random;

public class MatrixMultipliction {
    static final int max_size=3;
    static final int max_thread=3;
    static int[][] matrixA=new int[max_size][max_size];
    static int[][] matrixB=new int[max_size][max_size];
    static int[][] matrixC=new int[max_size][max_size];
    static int step_i=0;

    static class Multiply implements Runnable{
        int i;
        Multiply(int i){
            this.i=i;
        }
        @Override
        public void run(){
            for(int j=0;j<max_size;j++){
                for(int k=0;k<max_size;k++){
                    matrixC[i][j]+=matrixA[i][k]*matrixB[k][j];
                }
            }
        }
    }
    static void display(int[][] matrix){
        for(int i=0;i<max_size;i++){
            for(int j=0;j<max_size;j++){
                System.out.print(matrix[i][j]+" ");
            }
            System.out.println();
        }
    }
    public static void main(String[] args) {
        Random random=new Random();
        for(int i=0;i<max_size;i++){
            for (int j=0;j<max_size;j++){
                matrixA[i][j]=random.nextInt(10);
                matrixB[i][j]=random.nextInt(10);
            }
        }
        System.out.println("Matrix A");
        display(matrixA);
        System.out.println("Matrix B");
        display(matrixB);

        Thread[] threads=new Thread[max_thread];

        for(int i=0;i<max_thread;i++){
            threads[i]=new Thread(new Multiply(step_i++));
            threads[i].start();
        }
        for(int i=0;i<max_thread;i++){
            try{
                threads[i].join();
            }catch (InterruptedException e)
            {
                System.out.println(e);
            }
        }
        System.out.println("Result");
        display(matrixC);
    }
}
