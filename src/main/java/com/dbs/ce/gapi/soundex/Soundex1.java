package com.dbs.ce.gapi.soundex;

/**
 * @author Lei
 * @version 1.0
 * @date 2022/3/6 - 03 - 06 - 13:41
 * @Description com.dbs.ce.gapi.soundex
 */
public class Soundex1 {
    public static void main(String[] args) {
        System.out.println(getCode("Knuth"));

        System.out.println(getCode("Kant"));
        System.out.println(getCode("Jarovski"));
        System.out.println(getCode("Resnik"));
        System.out.println(getCode("Reznick"));
        System.out.println(getCode("Euler"));
        System.out.println(getCode("Peterson"));
        System.out.println(getCode("Jefferson"));


        System.out.println(getCode("Ashcraft"));
        System.out.println(getCode("Ashcroft"));
    }

    private static String getCode(String s) {
        char[] x = s.toUpperCase().toCharArray();
        char firstLetter = x[0];

        for (int i = 0; i < x.length; i++) {
            switch (x[i]) {
                case 'B':
                case 'F':
                case 'P':
                case 'V':
                    x[i] = '1';
                    break;
                case 'C':
                case 'G':
                case 'J':
                case 'K':
                case 'Q':
                case 'S':
                case 'X':
                case 'Z':
                    x[i] = '2';
                    break;
                case 'D':
                case 'T':
                    x[i] = '3';
                    break;
                case 'L':
                    x[i] = '4';
                    break;
                case 'M':
                case 'N':
                    x[i] = '5';
                    break;
                case 'R':
                    x[i] = '6';
                    break;
                default:
                    x[i] = '0';
                    break;
            }
        }

        String output = "" + firstLetter;

        for (int i = 1; i < x.length; i++) {
            if (x[i] != x[i - 1] && x[i] != '0') {
                output += x[i];
            }
        }

        output = output + "0000";
        return output.substring(0, 4);

    }
}
