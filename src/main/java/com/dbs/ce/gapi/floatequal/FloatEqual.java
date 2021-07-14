package com.dbs.ce.gapi.floatequal;

import lombok.extern.slf4j.Slf4j;

/**
 * @author Lei
 * @version 1.0
 */
@Slf4j
public class FloatEqual {

    public static void main(String[] args) {
        float f1 = 3.4F;
        float f2 = 3.5F;
        double e = 3.4;

        log.info("f1 is " + f1);
        if (f1 == 3.4F) {
            log.info("float f1 == 3.4F is true");
        } else {
            log.info("float f1 == 3.4F is false");
        }

        if (f1 == 3.4) {
            log.info("float f1 == 3.4 is true");
        } else {
            log.info("float f1 == 3.4 is false");
        }

        log.info("f2 is " + f2);
        if (f2 == 3.5F) {
            log.info("float f2== 3.5F is true");
        } else {
            log.info("float f2== 3.5F is false");
        }

        if (f2 == 3.5) {
            log.info("float f2 == 3.5F is true");
        } else {
            log.info("float f2== 3.5F is false");
        }


        if (e == 3.4) {
            log.info("double e == 3.4 is true");
        } else {
            log.info("double e == 3.4 is false");
        }
    }
}
