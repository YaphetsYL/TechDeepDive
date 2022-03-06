package com.dbs.ce.gapi.soundex;

/**
 * @author Lei
 * @version 1.0
 * @date 2022/3/6 - 03 - 06 - 3:47
 * @Description com.dbs.ce.gapi.soundex
 */
public class Soundex {
    /*
    The correct value can be found as follows:
    1. Retain the first letter of the name and drop all other occurrences of a, e, i, o, u, y, h, w.
    2. Replace consonants with digits as follows (after the first letter):
        b, f, p, v → 1
        c, g, j, k, q, s, x, z → 2
        d, t → 3
        l → 4
        m, n → 5
        r → 6
    3. If two or more letters with the same number are adjacent in the original name (before step 1), only retain the
       first letter; also two letters with the same number separated by 'h' , 'w' or 'y' are coded as a single number,
       whereas such letters separated by a vowel are coded twice. This rule also applies to the first letter.
    4. If you have too few letters in your word that you can't assign three numbers, append with zeros until there are
       three numbers. If you have four or more numbers, retain only the first three.
     */
    public static void main(String[] args) {
        System.out.println(convert("Knuth"));
        System.out.println(convert("Kant"));
        System.out.println(convert("Jarovski"));
        System.out.println(convert("Resnik"));
        System.out.println(convert("Reznick"));
        System.out.println(convert("Euler"));
        System.out.println(convert("Peterson"));
        System.out.println(convert("Jefferson"));

        System.out.println(convert("Robert"));
        System.out.println(convert("Rupert"));
        System.out.println(convert("Rubin"));

        System.out.println(convert("Ashcraft"));
        System.out.println(convert("Ashcroft"));

        System.out.println(convert("Tymczak"));
        System.out.println(convert("Pfister"));
        System.out.println(convert("Honeyman"));


    }

    private static String convert(String str) {
        char[] chars = str.toLowerCase().toCharArray();
        for (int i = 0; i < chars.length; i++) {
            switch (chars[i]) {
                case 'b':
                case 'f':
                case 'p':
                case 'v':
                    chars[i] = '1';
                    break;
                case 'c':
                case 'g':
                case 'j':
                case 'k':
                case 'q':
                case 's':
                case 'x':
                case 'z':
                    chars[i] = '2';
                    break;
                case 'd':
                case 't':
                    chars[i] = '3';
                    break;
                case 'l':
                    chars[i] = '4';
                    break;
                case 'm':
                case 'n':
                    chars[i] = '5';
                    break;
                case 'r':
                    chars[i] = '6';
                    break;
                default:
                    chars[i] = '0';
                    break;
            }

        }
        String result = "" + str.charAt(0);

        for (int i = 1; i < chars.length; i++) {
            if (chars[i] != '0' && chars[i] != chars[i - 1]) {
                result = result + chars[i];
            }
        }

        result = result + "0000";
        return result.substring(0, 4);

    }


}
