package com.dbs.ce.gapi.bloomfilter.mybloomfilter;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

import java.util.UUID;

import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * @author Lei
 * @version 1.0
 * @date 2021/10/4 - 10 - 04 - 21:31
 */
@Slf4j
class BloomFilterUtilsTest {

    @Test
    void testMyBloomFilter1() {
        boolean[] bitArray = new boolean[256];
        int count = 0;
        for (int i = 0; i < 100; i++) {
            if (BloomFilterUtils.insert(bitArray, UUID.randomUUID().toString())) {
                count++;
            }
        }
        log.info("No of insertions: " + count);
        log.info("insert percentage: " + count + "%");
        assertTrue(70 <= count);
    }

    @Test
    void testMyBloomFilter2() {
        boolean[] bitArray = new boolean[480];
        int count = 0;
        for (int i = 0; i < 100; i++) {
            if (BloomFilterUtils.insert(bitArray, UUID.randomUUID().toString())) {
                count++;
            }
        }
        log.info("No of insertions: " + count);
        log.info("insert percentage: " + count + "%");
        assertTrue(90 <= count);
    }


}