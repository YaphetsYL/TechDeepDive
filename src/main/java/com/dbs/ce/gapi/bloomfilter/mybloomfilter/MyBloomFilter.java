package com.dbs.ce.gapi.bloomfilter.mybloomfilter;

import lombok.extern.slf4j.Slf4j;

/**
 * @author Lei
 * @version 1.0
 * @date 2021/10/2 - 10 - 02 - 19:35
 */
@Slf4j
public class MyBloomFilter {

    private static final String EXIST = " exists";
    private static final String NOTEXIST = " doesn't exist";


    public static void main(String[] args) {

        boolean[] bitArray = new boolean[256];
        String[] strings = {"Lei", "CheeSing", "Mike", "Jagath", "ZhouRui", "Sidd", "Mridul"};
        for (String string : strings) {
            BloomFilterUtils.insert(bitArray, string);
        }

        String s1 = "Aditi";
        log.info(BloomFilterUtils.lookup(bitArray, s1) ? s1 + EXIST : s1 + NOTEXIST);

        String s2 = "Lei";
        log.info(BloomFilterUtils.lookup(bitArray, s2) ? s2 + EXIST : s2 + NOTEXIST);

        String s3 = "Lei2";
        log.info(BloomFilterUtils.lookup(bitArray, s3) ? s3 + EXIST : s3 + NOTEXIST);

        String s4 = "Le";
        log.info(BloomFilterUtils.lookup(bitArray, s4) ? s4 + EXIST : s4 + NOTEXIST);

    }

}
