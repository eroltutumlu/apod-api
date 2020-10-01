package com.astronomy.nasa.util;

import java.util.Collection;
import java.util.Map;

public final class CollectionUtils {

    private CollectionUtils() {

    }

    public static boolean isNullOrEmpty( final Collection< ? > c ) {
        return c == null || c.isEmpty();
    }

    public static boolean isNullOrEmpty( final Map< ?, ? > m ) {
        return m == null || m.isEmpty();
    }

}
