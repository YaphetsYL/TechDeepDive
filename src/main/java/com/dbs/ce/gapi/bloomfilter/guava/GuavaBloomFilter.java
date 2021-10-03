package com.dbs.ce.gapi.bloomfilter.guava;

import com.google.common.hash.BloomFilter;
import com.google.common.hash.Funnels;
import lombok.extern.slf4j.Slf4j;

/**
 * @author Lei
 * @version 1.0
 * @date 2021/10/2 - 10 - 02 - 19:07
 */
@Slf4j
public class GuavaBloomFilter {
    public static void main(String[] args) {

        //unstable
        BloomFilter<Integer> filter = BloomFilter.create(
                Funnels.integerFunnel(),
                1000,
                0.01);

        filter.put(1);
        filter.put(2);
        filter.put(3);
        log.info("Filter contains 1 is " + filter.mightContain(1));
        log.info("Filter contains 2 is " + filter.mightContain(2));
        log.info("Filter contains 3 is " + filter.mightContain(3));
        log.info("Filter contains 5 is " + filter.mightContain(4));
        log.info("Filter contains 100 is " + filter.mightContain(100));
    }
}
