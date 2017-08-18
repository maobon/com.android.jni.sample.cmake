package com.xin.bob.fibonacci.utils;

/**
 * Created by bob on 2017/8/18.
 * Fibonacci
 */

public class Fibonacci {

    // 递推实现方式
    public static int fibonacciNormal(int n) {
        if (n <= 2) {
            return 1;
        }
        int n1 = 1, n2 = 1, sn = 0;
        for (int i = 0; i < n - 2; i++) {
            sn = n1 + n2;
            n1 = n2;
            n2 = sn;
        }
        return sn;
    }
}
