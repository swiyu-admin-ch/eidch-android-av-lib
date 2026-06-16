package ch.admin.foitt.avwrapper

data class AVBeamPackageResult(
    val data: AVBeamExtractDataList? = null,
    val errorType: AVBeamErrorType = AVBeamErrorType.None,
    val errorCode: AVBeamError = AVBeamError.None,
    val status: Int = 0,
    val activeScenario: Int = 0,
    val dataLength: Int = 0,
    val files: AVBeamFilesDataList? = null,
    val errorCodeList: MutableList<Int> = mutableListOf(),
    val nfcErrorCode: AVBeamError = AVBeamError.None,
)
