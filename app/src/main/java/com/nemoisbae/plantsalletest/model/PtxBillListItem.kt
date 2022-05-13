package com.nemoisbae.plantsalletest.model

import com.google.gson.annotations.SerializedName

data class PtxBillListItem (
    @SerializedName(TRANSACTION_ID)
    val transactionId: Long = 0,

    @SerializedName(GROUPING_DISPLAY)
    val groupingDisplay: String,

    @SerializedName(PROFIT_CENTER_ID)
    val profitCenterId: Long,

    @SerializedName(PROFIT_CENTER_NAME)
    val profitCenterName: String,

    @SerializedName(POS_NUMBER)
    val posNumber: Int,

    @SerializedName(STATION_ID)
    val stationId: Long,

    @SerializedName(STATION_NAME)
    val stationName: String,

    @SerializedName(WAITER_NUMBER)
    val waiterNumber: Long,

    @SerializedName(NUMBER_OF_BILLS)
    val numberOfBills: Long,

    @SerializedName(GUESTS)
    val guests: Int,

    @SerializedName(TOTAL_INCLUDING_TAXES)
    val totalIncludingTaxes: Long,

    @SerializedName(MAX_PAYMENT_LINE_NUMBER)
    val maxPaymentLineNumber: Int,

    @SerializedName(CUSTOMER)
    val customer: PtxBillListItemCustomer? = null,

    @SerializedName(BUSY_GROUPING)
    val busyGrouping: BusyGrouping? = null,

    @SerializedName(POS_DAY_TRANSACTION)
    val posDayTransaction: PosDayTransaction? = null,

    @SerializedName(TAG)
    val tag: String? = null
) {
    fun toNote(): Note {
        return Note(
                transactionId = this.transactionId,
                groupingDisplay = this.groupingDisplay,
                profitCenterId = this.profitCenterId,
                profitCenterName = this.profitCenterName,
                stationId = this.stationId,
                stationName = this.stationName,
                waiterNumber = this.waiterNumber,
                billNumber = this.numberOfBills,
                guestNumber = this.guests,
                totalIncludingTaxes = this.totalIncludingTaxes,
                tagNote = this.tag,
                customerName = if (this.customer != null) this.customer!!.lastName + " " + this.customer!!.firstName else "",
                nextCount = this.busyGrouping?.nextCount ?: 0,
                callCount = this.busyGrouping?.callCount ?: 0,
                alert = this.busyGrouping?.alert ?: false
        )
    }
}