package com.nemoisbae.plantsalletest.model

import java.io.Serializable

data class Note(
		var localNoteId: Long? = null,

		var transactionId: Long? = null, // no id when first created

		var groupingDisplay: String? = null,

		var tableNumber: Int? = null,

		var waiterNumber: Long? = null,

		var profitCenterId: Long? = null,

		var profitCenterName: String? = null,

		var totalIncludingTaxes: Long? = null,

		var billNumber: Long? = null,

		var numberOfOfficialReceipts: Int? = null,

		var siteId: Long? = null,

		var stationId: Long? = null,

		var stationName: String? = null,

		var operatingMode: Int? = null,

		var workDay: String? = null,

		var displayUserName: String? = null,

		var userId: Long? = null,

		var remainingAmount: Long = 0,

		var maxPaymentLineNumber: Int = 0,

		var guestNumber: Int = 0,

		var closingStatus: Int = 0,

		var backChange: Double = 0.0,

		var groupingSubdivision: Int? = 0,

		var tagNote: String? = null,

		var customerName: String? = null,

		val nextCount: Int = 0,

		val callCount: Int = 0,

		val alert: Boolean = false
) : Serializable {
	override fun toString(): String {
		return "transactionId=$transactionId, groupingDisplay=$groupingDisplay, profitCenterName=$profitCenterName, numberOfOfficialReceipts=$numberOfOfficialReceipts, totalIncludingTaxes=$totalIncludingTaxes, billNumber=$billNumber"
	}
}