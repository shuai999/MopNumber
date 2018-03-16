package com.jackchen.mao;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

/**
 * Email: 2185134304@qq.com
 * Created by JackChen 2018/3/16 9:13
 * Version 1.0
 * Params:
 * Description:  猫扑素数
*/
public class MainActivity extends AppCompatActivity {

    private String str = "abcdef" ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        test() ;

        // 单词反转
        Log.e("TAG" , reverseStr(str)+"-->") ;   // fedcba-->

    }


    /**
     * 单词反转      abcdef -> fedcba-->
     * @param str
     * @return
     */
    private String reverseStr(String str){
        return new StringBuilder(str).reverse().toString() ;
    }


    /**
     * 判断 i 是否是猫扑素数
     *
     * 猫扑数：指的是以2开头，后面跟任意个3的十进制数，比如：2、23、233...
     * 素数：指的是在大于1的自然数中，除了1和它本身以外不再有其他因数，这样的数称为素数；
     *
     * 因此，猫扑素数就是上边两种概念的交集，即表示该集合中的数字既是猫扑数、又是素数；
     *
     */
    private boolean isMopNumber(int i){
        if (i < 10){
            return i ==2 ;
        }else{   // 很巧妙的算法，根据猫扑数特点：最开头是2，后面是任意个3，利用递归进行判断
            return (i % 10 ==3) && isMopNumber(i / 10) ;
        }
    }


    /**
     * 判断 i 是否是素数
     */
    private boolean isPrime(int i){
        if (i < 2) {
            return false;
        }else{
            for (int j = 2; j < Math.sqrt(i); j++) {   // Math.sqrt(i): 表示求i的平方根
                if (i % j == 0){
                    return false ;
                }

            }
            return true ;
        }
    }


    /**
     * 测试：1- 1000 之间的猫扑素数
     */
    private void test(){
        for (int i = 0; i < 1000; i++) {
            if (isMopNumber(i) && isPrime(i)){
                Log.e("TAG" , i + "is mopNumber and primeNumber !") ;  // 2、23、233
            }
        }
    }
}
