package com.dbs.ce.gapi.random;

import com.google.common.base.Strings;

/**
 * @author Lei
 * @version 1.0
 * @date 2022/2/7 - 02 - 07 - 0:03
 * @Description com.dbs.ce.gapi.random
 */
public class Random {

    private static void test() {
        int seed = 0b1001;
        int init = seed;
        int i = 1;
        do {
            System.out.print(i + ". lsb is ");
            System.out.print(seed & 1);

            int newBit = (seed ^ (seed >> 1)) & 1;
            //move lsb to msb
            seed = ((newBit << 3) | (seed >> 1));
            System.out.print(", new value is ");
            System.out.println(Strings.padStart(Integer.toBinaryString(seed), 4, '0'));
            i++;

        } while (seed != init);

    }

    public static void main(String[] args) {
        test();
    }
}
