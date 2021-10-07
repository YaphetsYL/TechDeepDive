package com.dbs.ce.gapi.bloomfilter.hadoop;

import lombok.extern.slf4j.Slf4j;
import org.apache.hadoop.util.bloom.DynamicBloomFilter;
import org.apache.hadoop.util.bloom.Key;

import java.util.UUID;

/**
 * @author Lei
 * @version 1.0
 * @date 2021/10/5 - 10 - 05 - 12:04
 */
@Slf4j
public class DynamicBF {
    public static void main(String[] args) {

        log.info("------Dynamic Bloom Filter ------");
        DynamicBloomFilter dynamicBloomFilter = new DynamicBloomFilter(256, 1, 1, 128);

        for (int i = 0; i < 127; i++) {
            dynamicBloomFilter.add(new Key(UUID.randomUUID().toString().getBytes()));
        }

        log.info(dynamicBloomFilter.toString());

        //for the 2nd element, one a new matrix
        for (int i = 0; i < 2; i++) {
            dynamicBloomFilter.add(new Key(UUID.randomUUID().toString().getBytes()));
        }

        log.info(dynamicBloomFilter.toString());

    }
}
