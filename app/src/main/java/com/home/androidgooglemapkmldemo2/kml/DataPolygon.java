package com.home.androidgooglemapkmldemo2.kml;

import com.google.android.gms.maps.model.LatLng;

import java.util.List;

public interface DataPolygon<T> extends Geometry {

    /**
     * Gets an array of outer boundary coordinates
     *
     * @return array of outer boundary coordinates
     */
    List<LatLng> getOuterBoundaryCoordinates();

    /**
     * Gets an array of arrays of inner boundary coordinates
     *
     * @return array of arrays of inner boundary coordinates
     */
    List<List<LatLng>> getInnerBoundaryCoordinates();
}
