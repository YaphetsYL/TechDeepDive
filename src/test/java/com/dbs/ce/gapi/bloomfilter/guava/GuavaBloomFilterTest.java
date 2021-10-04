package com.dbs.ce.gapi.bloomfilter.guava;

import com.google.common.hash.BloomFilter;
import com.google.common.hash.Funnels;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

import java.nio.charset.StandardCharsets;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.assertTrue;


/**
 * @author Lei
 * @version 1.0
 * @date 2021/10/4 - 10 - 04 - 11:12
 */
@Slf4j
class GuavaBloomFilterTest {


    /*
      insertion: size of data to be inserted,
      fpp: false positive probability
      expected bitmap:  (-1 * insertion) * Math.log(fpp) / ((Math.log(2) * (Math.log(2))))
    */
    @Test
    void GetBitMap() {
        int insertion = 1_000_000;
        double fpp = 0.01;
        log.info("expected bitmap" + (-1 * insertion) * Math.log(fpp) / ((Math.log(2) * (Math.log(2)))));
    }

    /*
     for 1 million insertions, 0.01 false positive probability
     bitmap is 9585058
    */
    @Test
    void TestGuavaBloomFilter1() {
        BloomFilter<CharSequence> filter = BloomFilter.create(
                Funnels.stringFunnel(StandardCharsets.UTF_8),
                1_000_000,
                0.01);

        for (int i = 0; i < 1_000_000; i++) {
            filter.put(UUID.randomUUID().toString());
        }

        int exist = 0;
        int notExist = 0;
        for (int i = 0; i < 1_000_000; i++) {
            if (filter.mightContain(UUID.randomUUID().toString())) {
                exist++;
            } else {
                notExist++;
            }
        }

        log.info("exist: " + exist);
        log.info("not exist: " + notExist);
        //sometimes more than 10000 record exists
        assertTrue(10000 >= exist);

    }

    /*
    for 1 million insertions, 0.0001 false positive probability
    bitmap is 19170116
   */
    @Test
    void TestGuavaBloomFilter2() {
        BloomFilter<CharSequence> filter = BloomFilter.create(
                Funnels.stringFunnel(StandardCharsets.UTF_8),
                1_000_000,
                0.0001);

        for (int i = 0; i < 1_000_000; i++) {
            filter.put(UUID.randomUUID().toString());
        }

        int exist = 0;
        int notExist = 0;
        for (int i = 0; i < 1_000_000; i++) {
            if (filter.mightContain(UUID.randomUUID().toString())) {
                exist++;
            } else {
                notExist++;
            }
        }

        log.info("exist: " + exist);
        log.info("not exist: " + notExist);
        //sometimes more than 100 record exists
        assertTrue(100 >= exist);

    }

    /*
    for 1 million insertions, 0.000001 false positive probability
    bitmap is 28755175
   */
    @Test
    void TestGuavaBloomFilter3() {
        BloomFilter<CharSequence> filter = BloomFilter.create(
                Funnels.stringFunnel(StandardCharsets.UTF_8),
                1_000_000,
                0.000001);

        for (int i = 0; i < 1_000_000; i++) {
            filter.put(UUID.randomUUID().toString());
        }

        int exist = 0;
        int notExist = 0;
        for (int i = 0; i < 1_000_000; i++) {
            if (filter.mightContain(UUID.randomUUID().toString())) {
                exist++;
            } else {
                notExist++;
            }
        }

        log.info("exist: " + exist);
        log.info("not exist: " + notExist);
        //sometimes more than 1 record exists
        assertTrue(2 >= exist);

    }

}