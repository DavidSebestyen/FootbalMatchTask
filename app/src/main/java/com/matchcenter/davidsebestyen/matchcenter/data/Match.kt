package com.matchcenter.davidsebestyen.matchcenter.data

import java.text.SimpleDateFormat
import java.util.*


data class Match(val matchId: String = "",
                 val homeStats: Stats = Stats(),
                 val awayStats: Stats = Stats(),
                 val time: String = "",
                 val competition: String = "",
                 val venue: String = "",
                 val attendance: Int = 0,
                 val referee: String = "",
                 val timestamp: Long = 0,
                 val home: Team = Team(emptyList()),
                 val away: Team = Team(emptyList())
                 ) {

    fun getTimeStampAsDateString(): String{
        val date = java.util.Date(timestamp)
        val dateFormat = SimpleDateFormat("yyyy-MM-dd, HH:mm", Locale.UK)

        return dateFormat.format(date)

    }

    fun getRefereeString(): String{
        return "Referee: $referee"
    }


}