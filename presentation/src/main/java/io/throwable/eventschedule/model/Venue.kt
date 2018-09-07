package io.throwable.eventschedule.model

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Venue(val name:String, val address:String, val lat:Double, val lng:Double):Parcelable