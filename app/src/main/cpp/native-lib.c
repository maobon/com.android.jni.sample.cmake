#include<jni.h>

/**
 * Fibonacci calculate use C lang
 * @param n
 * @return
 */
jint Java_com_xin_bob_fibonacci_MainActivity_calculate(JNIEnv *env, jobject obj, jint n) {

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