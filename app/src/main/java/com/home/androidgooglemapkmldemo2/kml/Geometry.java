package com.home.androidgooglemapkmldemo2.kml;

/**
 * An abstraction that represents a Geometry object
 *
 * @param <T> the type of Geometry object
 */
public interface Geometry<T> {
    /**
     * Gets the type of geometry
     *
     * @return type of geometry
     */
    public String getGeometryType();

    /**
     * Gets the stored KML Geometry object
     *
     * @return geometry object
     */
    public T getGeometryObject();
}
