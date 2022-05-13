package com.nemoisbae.plantsalletest.model

import com.google.gson.annotations.SerializedName
import java.io.Serializable

data class PosDayTransactionExtraData (
        @SerializedName(NEVER_USE_IT)
        var neverUseIt: String? = null
): Serializable