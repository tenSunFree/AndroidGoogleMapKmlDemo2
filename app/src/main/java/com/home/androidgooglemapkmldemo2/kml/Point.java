package com.home.androidgooglemapkmldemo2.kml;

import com.google.android.gms.maps.model.LatLng;

import java.util.ArrayList;
import java.util.List;

public class Point implements Geometry {

    private final static String GEOMETRY_TYPE = "Point";

    private final LatLng mCoordinates;

    /**
     * Creates a new Point object
     *
     * @param coordinates coordinates of Point to store
     */
    public Point(LatLng coordinates) {
        if (coordinates == null) {
            throw new IllegalArgumentException("Coordinates cannot be null");
        }
        mCoordinates = coordinates;
    }

    /**
     * Gets the type of geometry
     *
     * @return type of geometry
     */
    public String getGeometryType() {
        return GEOMETRY_TYPE;
    }

    /**
     * Gets the coordinates of the Point
     *
     * @return coordinates of the Point
     */
    public LatLng getGeometryObject() {
        return mCoordinates;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder(GEOMETRY_TYPE).append("{");
        sb.append("\n coordinates=").append(mCoordinates);
        sb.append("\n}\n");
        return sb.toString();
    }

    public static class MultiGeometry implements Geometry {

        private String geometryType = "MultiGeometry";

        private List<Geometry> mGeometries;

        /**
         * Creates a new MultiGeometry object
         *
         * @param geometries contains list of Polygons, Linestrings or Points
         */
        public MultiGeometry(List<? extends Geometry> geometries) {
            if (geometries == null) {
                throw new IllegalArgumentException("Geometries cannot be null");
            }

            //convert unknown geometry type (due to GeoJSON types) to Geometry type
            ArrayList geometriesList = new ArrayList();
            for (Geometry geometry : geometries) {
                geometriesList.add(geometry);
            }

            mGeometries = geometriesList;
        }

        /**
         * Gets the type of geometry
         *
         * @return type of geometry
         */
        public String getGeometryType() {
            return geometryType;
        }

        /**
         * Gets the stored geometry object
         *
         * @return geometry object
         */
        public List<Geometry> getGeometryObject() {
            return mGeometries;
        }

        /**
         * Set the type of geometry
         *
         * @param type String describing type of geometry
         */
        public void setGeometryType(String type) {
            geometryType = type;
        }

        @Override
        public String toString() {
            String typeString = "Geometries=";
            if (geometryType.equals("MultiPoint")) {
                typeString = "LineStrings=";
            }
            if (geometryType.equals("MultiLineString")) {
                typeString = "points=";
            }
            if (geometryType.equals("MultiPolygon")) {
                typeString = "Polygons=";
            }

            StringBuilder sb = new StringBuilder(getGeometryType()).append("{");
            sb.append("\n " + typeString).append(getGeometryObject());
            sb.append("\n}\n");
            return sb.toString();
        }
    }
}

