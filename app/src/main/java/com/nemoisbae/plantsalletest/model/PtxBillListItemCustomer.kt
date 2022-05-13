package com.nemoisbae.plantsalletest.model

import com.google.gson.annotations.SerializedName
import java.io.Serializable

data class PtxBillListItemCustomer (
       @SerializedName(FIRST_NAME)
        val firstName: String,

        @SerializedName(LAST_NAME)
        val lastName: String
): Serializable
