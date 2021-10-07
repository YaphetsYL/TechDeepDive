package com.dbs.ce.gapi.bloomfilter.guava;

import com.carrotsearch.sizeof.RamUsageEstimator;
import com.google.common.hash.BloomFilter;
import com.google.common.hash.Funnels;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.nio.charset.StandardCharsets;
import java.util.HashSet;
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

    for 1 million insertions:
    0.01 false positive probability --> bitmap is 9585058
    0.0001 false positive probability --> bitmap is 19170116
    0.000001 false positive probability --> bitmap is 28755175
   */

    @ParameterizedTest
    @ValueSource(doubles = {0.01, 0.0001, 0.000001})
    void TestGuavaBloomFilter4(double fpp) {
        BloomFilter<CharSequence> filter = BloomFilter.create(
                Funnels.stringFunnel(StandardCharsets.UTF_8),
                1_000_000,
                fpp);

        for (int i = 0; i < 1_000_000; i++) {
            filter.put(UUID.randomUUID().toString());
        }

        int falsePositive = 0;
        for (int i = 0; i < 1_000_000; i++) {
            if (filter.mightContain(UUID.randomUUID().toString())) {
                falsePositive++;
            }
        }

        log.info("No of false positive: " + falsePositive);
        //sometimes more records reported
        assertTrue((1000000 * fpp) >= falsePositive);

    }

    @ParameterizedTest
    @ValueSource(ints = {100, 10_000, 1_000_000})
    void compareBloomFilterAndHashMap(int insertions) {
        BloomFilter<CharSequence> filter = BloomFilter.create(
                Funnels.stringFunnel(StandardCharsets.UTF_8),
                insertions,
                0.000001);

        HashSet<String> hashSet = new HashSet<>();

        for (int i = 0; i < insertions; i++) {
            String tempString = UUID.randomUUID().toString();
            filter.put(tempString);
            hashSet.add(tempString);
        }

        log.info("Bloom Filter size: " + RamUsageEstimator.sizeOf(filter));
        log.info("HashSet size: " + RamUsageEstimator.sizeOf(hashSet));
        assertTrue(RamUsageEstimator.sizeOf(filter) < RamUsageEstimator.sizeOf(hashSet));
    }

}