package com.nemoisbae.plantsalletest.model

import com.google.gson.annotations.SerializedName

data class PosDayTransaction (

        @SerializedName(TRANSACTION_ID)
        var transactionId: Long? = null,

        @SerializedName(SALES_DOCUMENT_TYPE)
        var salesDocumentType: Int? = null,

        @SerializedName(SALES_DOCUMENT_TYPE_ID)
        var salesDocumentTypeId: Long? = null,

        @SerializedName(WORK_DAY)
        var workday: String? = null,

        @SerializedName(SITE_ID)
        var siteId: Long? = null,

        @SerializedName(STATION_ID)
        var stationId: Long? = null,

        @SerializedName(CUSTOMER_ID)
        var customerId: Long? = null,

        @SerializedName(CUSTOMER_ADDRESS_ID)
        var customerAddressId: Long? = null,

        @SerializedName(PROFIT_CENTER_ID)
        var profitCenterId: Long? = null,

        @SerializedName(CASHING_SETTING_ID)
        var cashingSettingsId: Long? = null,

        @SerializedName(VENDOR_ID)
        var vendorId: Long? = null,

        @SerializedName(CASHIER_ID)
        var cashierId: Long? = null,

        @SerializedName(GROUPING_ID)
        var groupingId: Long? = null,

        @SerializedName(GROUPING_SUBDIVISION)
        var groupingSubdivision: Int? = null,

        @SerializedName(SERVICE_ID)
        var serviceId: Long? = null,

        @SerializedName(HIDE)
        var hide: Int? = null,

        @SerializedName(CREATION_DATETIME)
        var creationDateTime: String? = null,

        @SerializedName(CLOSING_DATE_TIME)
        var closingDateTime: String? = null,

        @SerializedName(CLOSING_STATUS)
        var closingStatus: Int? = null,

        @SerializedName(GUESTS)
        var guests: Int? = null,

        @SerializedName(PURCHASE_ORDER_NUMBER_PREFIX)
        var purchaseOrderNumberPrefix: String? = null,

        @SerializedName(PURCHASE_ORDER_NUMBER)
        var purchaseOrderNumber: Int? = null,

        @SerializedName(BILL_NUMBER_PREFIX)
        var billNumberPrefix: String? = null,

        @SerializedName(BILL_NUMBER)
        var billNumber: Long? = null,

        @SerializedName(NUMBER_OF_BILLS)
        var numberOfBills: Int? = 0,

        @SerializedName(RECEIPT_NUMBER_PREFIX)
        var recepitNumberPrefix: String? = null,

        @SerializedName(RECEIPT_NUMBER)
        var recepitNumber: Int? = null,

        @SerializedName(NUMBER_OF_RECEIPTS)
        var numberOfReceipts: Int? = 0,

        @SerializedName(OFFICIAL_RECEIPT_NUMBER_PREFIX)
        var officialReceiptNumberPrefix: String? = null,

        @SerializedName(OFFICIAL_RECEIPT_NUMBER)
        var officialReceiptNumber: Int? = null,

        @SerializedName(NUMBER_OF_OFFICIAL_RECEIPTS)
        var numberOfOfficialReceipts: Int? = 0,

        @SerializedName(BILL_DURATION)
        var billDuration: String? = null,

        @SerializedName(OVER_PAYMENT)
        var overPayment: Long? = null,

        @SerializedName(BACK_CHANGE)
        var backChange: Long? = null,

        @SerializedName(CURRENCY)
        var currency: Int? = null,

        @SerializedName(NUMBER_OF_ITEMS)
        var numberOfItems: Int? = null,

        @SerializedName(LOYALTY_POINTS)
        var loyaltyPoints: Int? = null,

        @SerializedName(LOYALTY_CARD)
        var loyaltyCard: String? = null,

        @SerializedName(LOYALTY_PARAM)
        var loyaltyParam: Long? = null,

        @SerializedName(COMMENT)
        var comment: String? = null,

        @SerializedName(VERSION)
        var version: Int? = null,

        @SerializedName(TAG)
        var tag: String? = null,

        @SerializedName(ORIGIN_TYPE)
        var originType: Int? = 1,

        @SerializedName(ORIGIN_INFO)
        var originInfo: String? = null,

        @SerializedName(PURCHASE_ORDER_DATE_TIME)
        var purchaseOrderDateTime: String? = null,

        @SerializedName(DELIVERY_DATE_TIME)
        var deliveryDateTime: String? = null,

        @SerializedName(REAL_DELIVERY_DATE_TIME)
        var realDeliveryDateTime: String? = null,

        @SerializedName(TOTAL_INCLUDING_STANDARD_V_A_T)
        var totalIncludingStandardVAT: Long? = 0,

        @SerializedName(STANDARD_V_A_T_RATE)
        var standardVATRate: Long? = 0,

        @SerializedName(TOTAL_INCLUDING_REDUCED_V_A_T)
        var totalIncludingReducedVAT: Long? = 0,

        @SerializedName(REDUCED_V_A_T_RATE)
        var reducedVATRate: Long? = 0,

        @SerializedName(TOTAL_INCLUDING_SECOND_REDUCED_V_A_T)
        var totalIncludingSecondReducedVAT: Long? = 0,

        @SerializedName(SECOND_REDUCED_V_A_T_RATE)
        var secondReducedVATRate: Long? = 0,

        @SerializedName(TOTAL_INCLUDING_THIRD_V_A_T)
        var totalIncludingThirdVAT: Long? = 0,

        @SerializedName(THIRD_V_A_T_RATE)
        var thirdVATRate: Long? = 0,

        @SerializedName(TOTAL_INCLUDING_ZERO_V_A_T)
        var totalIncludingZeroVAT: Long? = 0,

        @SerializedName(ZERO_V_A_T_RATE)
        var zeroVATRate: Long? = 0,

        @SerializedName(TOTAL_INCLUDING_OTHER_V_A_T)
        var totalIncludingOtherVAT: Long? = 0,

        @SerializedName(OTHER_V_A_T_RATES)
        var otherVATRates: Long? = 0,

        @SerializedName(TOTAL_INCLUDING_TAXES)
        var totalIncludingTaxes: Long? = null,

        @SerializedName(USER_INT_VALUE1)
        var userIntValue1: Long? = null,

        @SerializedName(USER_INT_VALUE2)
        var userIntValue2: Long? = null,

        @SerializedName(USER_INT_VALUE3)
        var userIntValue3: Long? = null,

        @SerializedName(USER_VAR_CHAR_VALUE1)
        var userVarCharValue1: String? = null,

        @SerializedName(USER_VAR_CHAR_VALUE2)
        var userVarCharValue2: String? = null,

        @SerializedName(EXTRA_DATA)
        var extraData: PosDayTransactionExtraData? = null,

        @SerializedName(ORIGIN_ID)
        var originId: Long? = null,

        @SerializedName(PTX_N_F_KEY)
        var ptxNFKey: Long? = null,

        @SerializedName(LAST_MODIFY_DATE)
        var lastModifyDate: String? = null,

        @SerializedName(IS_LOCKED)
        var isLocked: Boolean = false, // ne pas remettre a 0 avant d'envoyer

        @SerializedName(LOCKED_STATION_ID)
        var lockedStationId: Long? = null,

        @SerializedName(LICENSE)
        var license: Int? = null,

        @SerializedName(GROUPING_DISPLAY)
        var groupingDisplay: String? = null
)