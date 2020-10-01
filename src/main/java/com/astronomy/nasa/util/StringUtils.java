package com.astronomy.nasa.util;

public final class StringUtils {

    private StringUtils() {

    }

    public static boolean isNullOrEmpty(final String str) {
        return (str != null && !str.trim().isEmpty());
    }

}
