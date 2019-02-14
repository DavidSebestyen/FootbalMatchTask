package com.matchcenter.davidsebestyen.matchcenter.data

data class MatchEvent(val type: String = "",
                      val time: String = "",
                      val heading: String = "",
                      val description: String = "",
                      val minute: Int = 0,
                      val seconds: Int = 0) {


}