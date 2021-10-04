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

    @Test
    void TestGuavaBloomFilter() {
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
        //sometimes exist greater than 1
        assertTrue(1 > exist);

    }

}