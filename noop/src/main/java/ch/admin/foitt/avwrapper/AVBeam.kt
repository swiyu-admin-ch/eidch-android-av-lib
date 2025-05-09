package ch.admin.foitt.avwrapper

import android.view.SurfaceView
import androidx.appcompat.app.AppCompatActivity
import kotlinx.coroutines.flow.StateFlow

/**
=============================================
Service(s) interface definition:
=============================================
 */

/// AVBeam Interface
///
/// Defines core functionalities for AV-based services, including
/// document scanning, document recording, face capture, and NFC scanning.

interface AVBeam {

    fun init(config: AVBeamInitConfig)

    suspend fun startScanDocument(config: AVBeamScanDocumentConfig): Result<AVBeamPackageResult>
    fun stopScanDocument()

    suspend fun startRecordingDocument(config: AVBeamRecordDocumentConfig): Result<AVBeamPackageResult>
    fun stopRecordingDocument()

    suspend fun startCaptureFace(config: AVBeamCaptureFaceConfig): Result<AVBeamPackageResult>
    fun stopCaptureFace()

    suspend fun startScanNfc(config: AVBeamScanNfcConfig): Result<AVBeamPackageResult>
    fun stopScanNfc()

    // Dedicated flows for library feedback
    val scanDocumentFlow: StateFlow<AvBeamScanDocumentNotification>
    val recordDocumentFlow: StateFlow<AvBeamRecordDocumentNotification>
    val captureFaceFlow: StateFlow<AvBeamCaptureFaceNotification>
    val scanNfcFlow: StateFlow<AvBeamScanNfcNotification>

    //Android Lifecycle-specific methods
    fun setActivity(activity: AppCompatActivity)
    fun getGLView(height: Int, width: Int): SurfaceView
    fun stopCamera()
    fun startCamera()
}

interface AvBeamNotification {
    data object exampleNotification1 :
        AvBeamScanDocumentNotification,
        AvBeamRecordDocumentNotification,
        AvBeamCaptureFaceNotification

    data object exampleNotification2 :
        AvBeamScanDocumentNotification,
        AvBeamScanNfcNotification
}

sealed interface AvBeamScanDocumentNotification
sealed interface AvBeamRecordDocumentNotification
sealed interface AvBeamCaptureFaceNotification
sealed interface AvBeamScanNfcNotification

// Config classes
data class AVBeamInitConfig(val exampleParam: Any)
data class AVBeamScanDocumentConfig(val exampleParam: Any)
data class AVBeamRecordDocumentConfig(val exampleParam: Any)
data class AVBeamCaptureFaceConfig(val exampleParam: Any)
data class AVBeamScanNfcConfig(val exampleParam: Any)

// Result wrapper
data class AVBeamPackageResult(val exampleParam: Any)
