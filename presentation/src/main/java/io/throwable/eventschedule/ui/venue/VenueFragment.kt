package io.throwable.eventschedule.ui.venue

import android.content.Context
import android.os.Bundle
import android.support.design.widget.BottomSheetBehavior
import android.support.v4.app.Fragment
import android.support.v4.content.ContextCompat
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.model.*
import com.google.maps.android.PolyUtil
import io.throwable.eventschedule.R
import io.throwable.eventschedule.model.Venue
import io.throwable.eventschedule.toBitmapDescriptor
import io.throwable.eventschedule.toMarkerBitmap
import kotlinx.android.synthetic.main.layout_venue_bottom_navigation.*


class VenueFragment: Fragment(), OnMapReadyCallback {

    private lateinit var map: GoogleMap
    private lateinit var sheetBehavior: BottomSheetBehavior<View>
    private lateinit var venue:Venue


    companion object {
        const val key = "event"
        /**
         * provides the fragment and initialises the data it needs
         * @param venue - venue details
         */
        fun getFragment(venue: Venue):Fragment{
            val fragment = VenueFragment()
            val bundle = Bundle()
            bundle.putParcelable(key, venue)
            fragment.arguments = bundle
            return fragment
        }

    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        venue = arguments!!.getParcelable(key)
        return inflater.inflate(R.layout.fragment_venue, container, false)

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initViews()
    }

    private fun initViews(){
        initMaps()
        initBottomSheets()
    }

    private fun initMaps(){
        val mapFragment = childFragmentManager
                ?.findFragmentById(R.id.map) as SupportMapFragment
        mapFragment.getMapAsync(this)
    }

    private fun initBottomSheets(){
        sheetBehavior = BottomSheetBehavior.from(bottom_sheet)

        sheetBehavior.setBottomSheetCallback(object : BottomSheetBehavior.BottomSheetCallback() {
            override fun onStateChanged(bottomSheet: View, newState: Int) {
                when (newState) {
                    BottomSheetBehavior.STATE_HIDDEN -> {
                    }
                    BottomSheetBehavior.STATE_EXPANDED -> {

                    }
                    BottomSheetBehavior.STATE_COLLAPSED -> {

                    }
                    BottomSheetBehavior.STATE_DRAGGING -> {
                    }
                    BottomSheetBehavior.STATE_SETTLING -> {
                    }
                }
            }

            override fun onSlide(bottomSheet: View, slideOffset: Float) {

            }
        })
    }

    override fun onMapReady(map: GoogleMap?) {
        this.map = map!!
        map.setMinZoomPreference(6.0f)

        val destLatLng = LatLng(venue.lat, venue.lng)
        addDestinationMarker(destLatLng, venue.name)

        addPolyLineFromOriginToDestination(DummyData.generatePolylineLatLngs())
        this.map.moveCamera(CameraUpdateFactory.newLatLngZoom(destLatLng, 12.0f/*initial zoom*/))

    }

    /**
     * adds a custom destination marker to the map
     * @param destLat - destination latlng value
     * @param venue - name of the venue of event
     */
    private fun addDestinationMarker(destLat:LatLng, venue:String){
        val balloonMarker = ( activity?.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as (LayoutInflater))
                .inflate(R.layout.layout_venue_marker, null)
        map.addMarker(MarkerOptions()
                .position(destLat)
                .icon(BitmapDescriptorFactory.fromBitmap(balloonMarker.toMarkerBitmap(venue))))

    }

    /**
     * draws a polyline from origin to destination
     * @param latLngs - decode list of latlngs from origin to destination
     */
    private fun addPolyLineFromOriginToDestination(latLngs: List<LatLng>?){
        val polyline = map.addPolyline(PolylineOptions()
                .clickable(true)
                .addAll(latLngs))

        val vectorDrawable = ContextCompat.getDrawable(activity!!, R.drawable.ic_circle_small_16dp)
        polyline.startCap = CustomCap(vectorDrawable!!.toBitmapDescriptor())
        polyline.endCap = SquareCap()
        polyline.width = 7.0f
        polyline.color = ContextCompat.getColor(activity!!, R.color.colorPrimary)
    }


    object DummyData {

        fun generatePolylineLatLngs():List<LatLng>{

            val encodedPolyline = "wsx]_rho@z@i@^QdBe@`C_@fB_@?i@F[P{@LYR_@`@y@Ji@?YjB]hCStBO`@BfFhArD`AjBd@LB@EhBmHxAeGzBmJfEeQ\\eBHUH?FANKBQCSGECCVcAlCsKfBmHLW\\_@JAHGFIDYKQQKE?]]SWUU_DiEsD}F_BlAu@_AKM"
            return PolyUtil.decode(encodedPolyline)
        }

        fun generateEventVenue():Venue{
            return Venue("Emerald Event Center",
                    "Four Lane Edet Akpan Avenue Uyo", 5.037690755266097,7.930806241929531)
        }
    }
}