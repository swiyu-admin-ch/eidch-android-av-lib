package ch.admin.foitt.avwrapper.config

data class AVBeamScanDocumentConfig(
    val rectWidth: Int = 0,
    val rectHeight: Int = 0,
    val timeout: Int = 10,
    val expectSecondScanNotification: Boolean = false
)
