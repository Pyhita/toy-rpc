package com.yangtao.irpc.core.router;

/**
 * @Author: pyhita
 * @Date: 2022/4/12
 * @Descrption: com.yangtao.irpc.core.router
 * @Version: 1.0
 */
public class MyRandom {

    private long seed;

    private int mod;

    private long last;

    public MyRandom(int end) {
        this.seed = System.currentTimeMillis();
        this.mod = end;

    }

    public long randomCount() {
        if (last == 0) {
            last = (int) (System.currentTimeMillis() % mod);
        }
        long n1 = (last * seed + 11) % mod;
        last = n1;
        return n1;
    }

    public static void main(String[] args) {
        MyRandom myRandom = new MyRandom(13);
        for (int i = 0; i < 100; i++) {
//            long result = myRandom.randomCount();
//            System.out.println(result);
            System.out.println(System.nanoTime());
        }
    }
}