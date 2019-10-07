package com.home.androidgooglemapkmldemo2.activity

import android.os.Build
import android.os.Bundle
import androidx.annotation.RequiresApi
import androidx.fragment.app.FragmentActivity
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.SupportMapFragment
import com.home.androidgooglemapkmldemo2.R

abstract class BaseActivity : FragmentActivity(), OnMapReadyCallback {

    private var mMap: GoogleMap? = null

    protected open fun getLayoutId(): Int {
        return R.layout.activity_base
    }

    protected fun getMap(): GoogleMap? {
        return mMap
    }

    @RequiresApi(api = Build.VERSION_CODES.KITKAT)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(getLayoutId())
        setUpMap()
    }

    @RequiresApi(api = Build.VERSION_CODES.KITKAT)
    override fun onResume() {
        super.onResume()
        setUpMap()
    }

    override fun onMapReady(map: GoogleMap) {
        if (mMap != null) return
        mMap = map
        startMap()
    }

    @RequiresApi(api = Build.VERSION_CODES.KITKAT)
    private fun setUpMap() {
        (supportFragmentManager.findFragmentById(R.id.fragment_map) as SupportMapFragment?)?.getMapAsync(this)
    }

    protected abstract fun startMap()
}
