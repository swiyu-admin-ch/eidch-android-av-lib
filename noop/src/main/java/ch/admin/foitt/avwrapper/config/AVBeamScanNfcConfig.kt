package ch.admin.foitt.avwrapper.config

data class AVBeamScanNfcConfig(
    val processId: String,
    val authToken: String,
    val timeout: Int = 30,
    val saveNfcOnMobile: Boolean = false,
    val saveActiveAuth: Boolean = false,
    val saveAdditionalFiles: Boolean = false,
)
