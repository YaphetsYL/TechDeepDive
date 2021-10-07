package com.dbs.ce.gapi.bloomfilter.mybloomfilter;

import lombok.extern.slf4j.Slf4j;

import static java.lang.Math.pow;

/**
 * @author Lei
 * @version 1.0
 * @date 2021/10/3 - 10 - 03 - 14:22
 */

@Slf4j
class BloomFilterUtils {

    private BloomFilterUtils() {
        throw new UnsupportedOperationException("This is a util class");
    }

    /**
     * @param s:       String
     * @param arrSize: size of the bit array
     * @return int
     */
    private static int h1(String s, int arrSize) {
        long hash = 3;
        for (int i = 0; i < s.length(); i++) {
            hash = hash + ((int) s.charAt(i));
            hash = hash % arrSize;
        }
        return (int) hash;
    }

    /**
     * @param s:       String
     * @param arrSize: size of the bit array
     * @return int
     */
    private static int h2(String s, int arrSize) {
        long hash = 5;
        for (int i = 0; i < s.length(); i++) {
            hash = (long) (hash + pow(19, i) * s.charAt(i));
            hash = hash % arrSize;
        }
        return (int) hash;
    }

    /**
     * @param s:       String
     * @param arrSize: size of the bit array
     * @return int
     */
    private static int h3(String s, int arrSize) {
        long hash = 7;
        for (int i = 0; i < s.length(); i++) {
            hash = (hash * 31 + s.charAt(i)) % arrSize;
        }
        return (int) (hash % arrSize);
    }

    /**
     * @param bitArray: bit array
     * @param s:        string
     * @return boolean
     */
    static boolean lookup(boolean[] bitArray, String s) {
        int a = h1(s, bitArray.length);
        int b = h2(s, bitArray.length);
        int c = h3(s, bitArray.length);

        return bitArray[a] && bitArray[b] && bitArray[c];
    }


    /**
     * @param bitArray: bit array
     * @param s:        string
     * @return boolean: false when insert fail; true when insert successfully
     */
    static boolean insert(boolean[] bitArray, String s) {
        // check if the element exists
        if (lookup(bitArray, s)) {
            //log.info(s + " is Probably already present");
            return false;
        } else {
            int a = h1(s, bitArray.length);
            int b = h2(s, bitArray.length);
            int c = h3(s, bitArray.length);

            bitArray[a] = true;
            bitArray[b] = true;
            bitArray[c] = true;
            //log.info(s + " has been inserted");

            return true;
        }
    }


}
