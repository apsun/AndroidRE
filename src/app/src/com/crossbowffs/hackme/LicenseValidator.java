package com.crossbowffs.hackme;

import java.util.Random;

public class LicenseValidator {
    private final Random mRandom;

    public LicenseValidator(int seed) {
        mRandom = new Random(seed);
    }

    public boolean validateLicense(String license) {
        license = license.trim().toUpperCase();
        boolean ok = true;
        if (license.length() != 10) ok = false;
        for (int i = 0; i < 10; ++i) {
            char c = 'A';
            if (i < license.length()) {
                c = license.charAt(i);
            }
            double sum = 0;
            for (int j = 0; j < 1000; ++j) {
                sum += i * c * j;
                sum = Math.sqrt(sum);
                sum -= j * mRandom.nextInt(32);
            }
            if (((int)sum) % 10 != 5) ok = false;
        }
        return ok;
    }
}
