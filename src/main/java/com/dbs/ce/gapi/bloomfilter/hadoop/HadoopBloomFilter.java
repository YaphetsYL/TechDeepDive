package com.dbs.ce.gapi.bloomfilter.hadoop;


import lombok.extern.slf4j.Slf4j;
import org.apache.hadoop.util.bloom.BloomFilter;
import org.apache.hadoop.util.bloom.CountingBloomFilter;
import org.apache.hadoop.util.bloom.Key;

/**
 * @author Lei
 * @version 1.0
 * @date 2021/10/4 - 10 - 04 - 22:23
 */

@Slf4j
public class HadoopBloomFilter {
    public static void main(String[] args) {

        String[] strings = {"Lei", "CheeSing", "Mike", "Jagath", "ZhouRui", "Sidd", "Mridul"};

        log.info("------Bloom Filter ------");
        BloomFilter bloomFilter = new BloomFilter(256, 3, 1);
        for (String string : strings) {
            Key key = new Key(string.getBytes());
            bloomFilter.add(key);
        }

        for (String string : strings) {
            Key key = new Key(string.getBytes());
            log.info(string + " is in the bloom filter: " + bloomFilter.membershipTest(key));
        }

        log.info("------Counting Bloom Filter ------");
        CountingBloomFilter countingBloomFilter = new CountingBloomFilter(256, 3, 1);
        for (String string : strings) {
            Key key = new Key(string.getBytes());
            countingBloomFilter.add(key);
        }

        for (String string : strings) {
            Key key = new Key(string.getBytes());
            log.info(string + " is in the counting bloom filter: " + countingBloomFilter.membershipTest(key));
        }

        Key leiKey = new Key("Lei".getBytes());
        countingBloomFilter.delete(leiKey);

        log.info("------after delete one key ------");
        for (String string : strings) {
            Key key = new Key(string.getBytes());
            log.info(string + " is in the counting bloom filter: " + countingBloomFilter.membershipTest(key));
        }


    }
}
