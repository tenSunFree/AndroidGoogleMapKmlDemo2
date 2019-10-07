package com.home.androidgooglemapkmldemo2.kml;

interface GeoJsonStyle {

    /**
     * Gets the type of geometries this style can be applied to
     *
     * @return type of geometries this style can be applied to
     */
    String[] getGeometryType();

    boolean isVisible();

    void setVisible(boolean visible);
}
