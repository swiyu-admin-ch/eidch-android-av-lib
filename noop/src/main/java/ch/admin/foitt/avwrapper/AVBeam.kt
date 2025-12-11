@file:Suppress("TooManyFunctions")

package ch.admin.foitt.avwrapper

import android.content.Intent
import android.view.SurfaceView
import androidx.appcompat.app.AppCompatActivity
import ch.admin.foitt.avwrapper.config.AVBeamCaptureFaceConfig
import ch.admin.foitt.avwrapper.config.AVBeamConfigLogLevel
import ch.admin.foitt.avwrapper.config.AVBeamRecordDocumentConfig
import ch.admin.foitt.avwrapper.config.AVBeamScanDocumentConfig
import ch.admin.foitt.avwrapper.config.AVBeamScanNfcConfig
import kotlinx.coroutines.flow.StateFlow

/**
 * AVBeam Interface
 *
 * Defines core functionalities for AV-based services, including
 * document scanning, document recording, face capture, and NFC scanning.
 */
interface AVBeam {

    fun init(config: AVBeamInitConfig, activity: AppCompatActivity)

    fun shutDown()

    suspend fun startScanDocument(config: AVBeamScanDocumentConfig)
    fun stopScanDocument()

    suspend fun startRecordingDocument(config: AVBeamRecordDocumentConfig)
    fun stopRecordingDocument()

    suspend fun startCaptureFace(config: AVBeamCaptureFaceConfig)
    fun stopCaptureFace()

    suspend fun startScanNfc(
        documentScanPackageResult: DocumentScanPackageResult,
        config: AVBeamScanNfcConfig,
    )
    fun stopScanNfc()

    fun getMetadata(inputFiles: List<ByteArray>): AVBeamFileData

    // Dedicated flows for library feedback
    val scanDocumentFlow: StateFlow<AvBeamScanDocumentNotification>
    val recordDocumentFlow: StateFlow<AvBeamRecordDocumentNotification>
    val captureFaceFlow: StateFlow<AvBeamCaptureFaceNotification>
    val scanNfcFlow: StateFlow<AvBeamScanNfcNotification>
    val errorFlow: StateFlow<AVBeamError>
    val statusFlow: StateFlow<AVBeamStatus>
    val initializedFlow: StateFlow<Boolean>

    // Android Lifecycle-specific methods
    fun setActivity(activity: AppCompatActivity)
    fun getGLView(width: Int, height: Int): SurfaceView
    fun stopCamera()
    fun startCamera()
    fun startFrontCamera()
    fun initNfcCardReader(activity: AppCompatActivity, nfcServerDockerUrl: String)
    fun onNewIntentNfc(intent: Intent)
    fun onResumeNfc()
    fun onPauseNfc()
}

// Config classes
data class AVBeamInitConfig(val logLevel: AVBeamConfigLogLevel)
