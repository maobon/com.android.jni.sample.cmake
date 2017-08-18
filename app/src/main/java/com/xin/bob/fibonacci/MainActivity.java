package com.xin.bob.fibonacci;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import com.xin.bob.fibonacci.utils.Fibonacci;

/**
 * Android 使用CMake 初始化的JNI调用clang的模板
 * AndroidStudio new project 新建一个link C++ 的工程 在上面修改即可
 * <p>
 * 推荐使用cmake方式 link C++ 文件 直接RUN一遍 自动将c文件编译后的so文件打包到apk中 直接运行调试了
 * 比传统的ndk-build的方式 更加高效
 */
public class MainActivity extends AppCompatActivity {

    // Used to load the 'native-lib' library on application startup.
    static {
        System.loadLibrary("native-lib");
    }

    private static final int param = 99999999;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TextView tv = (TextView) findViewById(R.id.sample_text);
        TextView tv2 = (TextView) findViewById(R.id.sample_text2);

        // Clang calculate
        long start = System.currentTimeMillis();
        int result = calculate(param);
        long usedTime = System.currentTimeMillis() - start;
        tv.setText(result + " in " + usedTime + "ms");

        // Java calculate
        long start2 = System.currentTimeMillis();
        int result2 = Fibonacci.fibonacciNormal(param);
        long usedTime2 = System.currentTimeMillis() - start2;
        tv2.setText(result2 + " in " + usedTime2 + "ms");
    }

    /**
     * A native method that is implemented by the 'native-lib' native library,
     * which is packaged with this application.
     */
    public native int calculate(int param);
}
