package com.home.androidgooglemapkmldemo2.activity

import android.util.Log
import android.widget.Toast
import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.model.LatLngBounds
import com.home.androidgooglemapkmldemo2.R
import com.home.androidgooglemapkmldemo2.kml.KmlPolygon
import com.home.androidgooglemapkmldemo2.kml.Renderer
import org.xmlpull.v1.XmlPullParserException
import java.io.IOException

class MainActivity : BaseActivity() {

    private var mMap: GoogleMap? = null

    override fun getLayoutId(): Int {
        return R.layout.activity_main
    }

    override fun startMap() {
        try {
            mMap = getMap()
            retrieveFileFromResource()
        } catch (e: Exception) {
            Log.e("Exception caught", e.toString())
        }
    }

    private fun retrieveFileFromResource() {
        try {
            val kmlLayer = Renderer.KmlLayer(
                mMap,
                R.raw.taiwan,
                applicationContext
            )
            kmlLayer.addLayerToMap()
            kmlLayer.setOnFeatureClickListener{
                val id = it.getId()
                Toast.makeText(
                    this@MainActivity,
                    id.replace("#", ""),
                    Toast.LENGTH_SHORT
                ).show()
            }
            moveCameraToKml(kmlLayer)
        } catch (e: IOException) {
            e.printStackTrace()
        } catch (e: XmlPullParserException) {
            e.printStackTrace()
        }
    }

    private fun moveCameraToKml(kmlLayer: Renderer.KmlLayer) {
        var container = kmlLayer.containers.iterator().next() // 檢索KML層中的第一個容器
        container = container.containers.iterator().next() // 檢索第一個容器中的嵌套容器
        val placemark = container.placemarks.iterator().next() // 檢索嵌套容器中的第一個地標
        val polygon = placemark.geometry as KmlPolygon // 檢索地標中的多邊形對象
        val builder = LatLngBounds.Builder() // 創建多邊形外部坐標的LatLngBounds
        for (latLng in polygon.outerBoundaryCoordinates) {
            builder.include(latLng)
        }
        val width = resources.displayMetrics.widthPixels
        val height = resources.displayMetrics.heightPixels
        getMap()?.moveCamera(CameraUpdateFactory.newLatLngBounds(builder.build(), width, height, 1))
    }
}
