package com.matchcenter.davidsebestyen.matchcenter.data

import android.os.Parcel
import android.os.Parcelable

data class Player(val name: String = "",
                  val number: Int = 0,
                  val position: String = "",
                  val formationPlace: Int = 0,
                  val substitutedOff: String = "",
                  val substitutedOffBy: String = ""): Parcelable {


    fun getNumberAsString(): String{
        return number.toString()
    }


    constructor(parcel: Parcel) : this(
            parcel.readString(),
            parcel.readInt(),
            parcel.readString(),
            parcel.readInt(),
            parcel.readString(),
            parcel.readString()) {
    }

    override fun writeToParcel(dest: Parcel?, flags: Int) {
        dest?.writeString(name)
        dest?.writeInt(number)
        dest?.writeString(position)
        dest?.writeInt(formationPlace)
        dest?.writeString(substitutedOff)
        dest?.writeString(substitutedOffBy)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<Player> {
        override fun createFromParcel(parcel: Parcel): Player {
            return Player(parcel)
        }

        override fun newArray(size: Int): Array<Player?> {
            return arrayOfNulls(size)
        }
    }
}