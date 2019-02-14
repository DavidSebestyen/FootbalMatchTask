package com.matchcenter.davidsebestyen.matchcenter.data

import android.databinding.ObservableField
import android.os.Parcel
import android.os.Parcelable

data class Stats(val score: Int = 0,
                 val halfTimeScore: Int = 0,
                 val possession: Double = 0.0,
                 val shots: Int = 0,
                 val shotsOnTarget: Int = 0,
                 val corners: Int = 0,
                 val fouls: Int = 0,
                 val yellowCards: Int = 0,
                 val redCards: Int = 0): Parcelable {

    constructor(parcel: Parcel) : this(
            parcel.readInt(),
            parcel.readInt(),
            parcel.readDouble(),
            parcel.readInt(),
            parcel.readInt(),
            parcel.readInt(),
            parcel.readInt(),
            parcel.readInt(),
            parcel.readInt())

    fun getScoreAsString(): String {
        return score.toString()
    }

    fun getHalfTimeScoreAsString(): String {
        return halfTimeScore.toString()
    }

    fun getPossessionAsString(): String{
        return "$possession%"
    }

    fun getShotsOnTargetAsString(): String{
        return shotsOnTarget.toString()
    }

    fun getCornersAsString(): String{
        return corners.toString()
    }

    fun getFoulsAsString(): String{
        return fouls.toString()
    }

    fun getYellowCardsAsString(): String{
        return yellowCards.toString()
    }

    fun getRedCardsAsString(): String{
        return redCards.toString()
    }

    fun getShotsAsString(): String{
        return shots.toString()
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeInt(score)
        parcel.writeInt(halfTimeScore)
        parcel.writeDouble(possession)
        parcel.writeInt(shots)
        parcel.writeInt(shotsOnTarget)
        parcel.writeInt(corners)
        parcel.writeInt(fouls)
        parcel.writeInt(yellowCards)
        parcel.writeInt(redCards)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<Stats> {
        override fun createFromParcel(parcel: Parcel): Stats {
            return Stats(parcel)
        }

        override fun newArray(size: Int): Array<Stats?> {
            return arrayOfNulls(size)
        }
    }


}