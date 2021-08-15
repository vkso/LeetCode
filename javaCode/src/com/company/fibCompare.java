package com.company;

import java.util.HashMap;

public class fibCompare {
    /**
     * 使用递归实现的斐波那契数列
     * @param n: 斐波那契数列第 n 个数的值
     * @return
     */
    public static long fib_normal(int n) {
        if (n == 1 || n == 2) {
            return 1;
        } else {
            return fib_normal(n - 1) + fib_normal(n - 2);
        }
    }

    /**
     * 使用递归实现的斐波那契数列，带有减枝操作，使用map记录已经出现过的值
     * @param n：斐波你起数列的第n个数的值是多少
     * @param mMap：存储已经出现过的值的 hashmap
     * @return
     */
    public static long fib(int n, HashMap<Integer, Long> mMap) {
        if (mMap.containsKey(n)) {
            return mMap.get(n);
        } else {
            if (n == 1 || n == 2) {
                return 1;
            } else {
                Long sum =  fib(n - 1, mMap) + fib(n - 2, mMap);
                mMap.put(n, sum);
                return sum;
            }
        }
    }
}
