package ch.admin.foitt.avwrapper

data class DocumentScanPackageResult(
    val serializedPackage: String,
    val errorType: AVBeamErrorType = AVBeamErrorType.None,
    val errorCode: AVBeamError = AVBeamError.Empty,
    val status: Int = 0,
    val activeScenario: Int = 0,
    val dataLength: Int = 0,
    val files: AVBeamFilesDataList? = null,
    val mrzValues: List<String>,
)
