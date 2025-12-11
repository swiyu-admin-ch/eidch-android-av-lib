package ch.admin.foitt.avwrapper

data class AVBeamPackageResult(
    val data: AVBeamExtractDataList? = null,
    val errorType: AVBeamErrorType = AVBeamErrorType.None,
    val errorCode: AVBeamError = AVBeamError.None,
    val files: AVBeamFilesDataList?,
)
