package com.home.androidgooglemapkmldemo2.kml;

/**
 * Utility class to help parse Kml boolean entities.
 */
public class KmlBoolean {
    public static boolean parseBoolean(String text) {
        return "1".equals(text) || "true".equals(text);
    }
}
