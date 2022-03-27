package com.dbs.ce.gapi.utf8;

import java.util.Arrays;

import static java.nio.charset.StandardCharsets.UTF_8;

/**
 * @author Lei
 * @version 1.0
 * @date 2022/3/26 - 03 - 26 - 0:53
 */
public class UTF8 {
    public static void main(String[] args) {
        /*System.out.println("Hello Java World!");
        System.out.println("\uD83D\uDE00");
        System.out.println("\uD83E\uDD70");
        System.out.println("\uD83E\uDD11");
        System.out.println("\u00E9");*/

        String rawString = "test String";
        byte[] bytes = rawString.getBytes(UTF_8);
        System.out.println(Arrays.toString(bytes));
        String utf8Encoded = new String(bytes, UTF_8);
        System.out.println(utf8Encoded);


    }
}
