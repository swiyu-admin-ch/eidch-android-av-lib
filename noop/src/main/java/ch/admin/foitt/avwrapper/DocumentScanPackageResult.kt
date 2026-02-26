package ch.admin.foitt.avwrapper

data class DocumentScanPackageResult(
    val serializedDataList: String,
    val errorType: AVBeamErrorType = AVBeamErrorType.None,
    val errorCode: AVBeamError = AVBeamError.None,
    val status: Int = 0,
    val activeScenario: Int = 0,
    val dataLength: Int = 0,
    val files: AVBeamFilesDataList? = null,
    val mrzValues: List<String>,
) {
    companion object {
        const val MRZ_LINE1 = 64
        const val MRZ_LINE2 = 65
        const val MRZ_LINE3 = 66
        const val FILE_EXTRACT_DATA_LIST = "document_scan_data_list.json"
    }
}

val DocumentScanPackageResult.filesWithExtractDataList: AVBeamFilesDataList? get() = null
