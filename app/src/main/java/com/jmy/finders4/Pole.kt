package com.jmy.finders4

import android.os.Parcelable
import com.google.android.gms.maps.model.LatLng
import kotlinx.parcelize.Parcelize

@Parcelize
data class Pole(
    var poleImage: Int,
    var poleName: String,
    var poleAddress: String,
    var poleIntroduction: String,
    var poleDistance: String,
    var poleLatLng: LatLng
):Parcelable
