package math;

public class FibonacciSeries {
    public int[] fibo(int num){
            int[] f = new int[num+2];
            f[0] = 0;
            f[1] = 1;
            for(int i = 2; i < num; i++){
                f[i] = f[i-2] + f[i-1];
            }
            return f;
    }

    public int fiboRecurse(int n) {
        if (n < 1) {
            return 1;
        }
        return fiboRecurse(n - 1) + fiboRecurse(n - 2);
    }
}
