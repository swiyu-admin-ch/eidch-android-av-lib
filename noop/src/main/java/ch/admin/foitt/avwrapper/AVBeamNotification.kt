package ch.admin.foitt.avwrapper

sealed interface AvBeamNotification {
    data object Empty :
        AvBeamNotification,
        AvBeamScanDocumentNotification,
        AvBeamRecordDocumentNotification,
        AvBeamCaptureFaceNotification,
        AvBeamScanNfcNotification
    data object Initial :
        AvBeamNotification,
        AvBeamScanDocumentNotification,
        AvBeamRecordDocumentNotification,
        AvBeamCaptureFaceNotification,
        AvBeamScanNfcNotification
    data class Error(val packageData: AVBeamPackageResult?) :
        AvBeamNotification,
        AvBeamScanDocumentNotification,
        AvBeamScanNfcNotification
    data class Completed(val packageData: AVBeamPackageResult) :
        AvBeamNotification,
        AvBeamRecordDocumentNotification,
        AvBeamCaptureFaceNotification,
        AvBeamScanNfcNotification
    data class DocumentScanCompleted(
        val packageData: DocumentScanPackageResult,
    ) : AvBeamScanDocumentNotification
    data object Loading :
        AvBeamNotification,
        AvBeamScanDocumentNotification,
        AvBeamScanNfcNotification
}

sealed interface AvBeamScanDocumentNotification
sealed interface AvBeamRecordDocumentNotification
sealed interface AvBeamCaptureFaceNotification
sealed interface AvBeamScanNfcNotification
