package com.nemoisbae.plantsalletest.model

import com.google.gson.annotations.SerializedName

data class BusyGrouping (
        @SerializedName(NEXT_COUNT)
        val nextCount: Int = 0,

        @SerializedName(CALL_COUNT)
        val callCount: Int,

        @SerializedName(ALERT)
        val alert: Boolean
)