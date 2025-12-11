@file:Suppress("TooManyFunctions")

package ch.admin.foitt.avwrapper

import android.content.Intent
import android.view.SurfaceView
import androidx.appcompat.app.AppCompatActivity
import ch.admin.foitt.avwrapper.config.AVBeamCaptureFaceConfig
import ch.admin.foitt.avwrapper.config.AVBeamRecordDocumentConfig
import ch.admin.foitt.avwrapper.config.AVBeamScanDocumentConfig
import ch.admin.foitt.avwrapper.config.AVBeamScanNfcConfig
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

class AVBeamImpl : AVBeam {
    override fun init(
        config: AVBeamInitConfig,
        activity: AppCompatActivity
    ) {
        // No-op
    }

    override fun shutDown() {
        // No-op
    }

    override suspend fun startScanDocument(config: AVBeamScanDocumentConfig) {
        // No-op
    }

    override fun stopScanDocument() {
        // No-op
    }

    override suspend fun startRecordingDocument(config: AVBeamRecordDocumentConfig) {
        // No-op
    }

    override fun stopRecordingDocument() {
        // No-op
    }

    override suspend fun startCaptureFace(config: AVBeamCaptureFaceConfig) {
        // No-op
    }

    override fun stopCaptureFace() {
        // No-op
    }

    override suspend fun startScanNfc(
        documentScanPackageResult: DocumentScanPackageResult,
        config: AVBeamScanNfcConfig
    ) {
        // No-op
    }

    override fun stopScanNfc() {
        // No-op
    }

    override fun getMetadata(inputFiles: List<ByteArray>): AVBeamFileData {
        // No-op
        return AVBeamFileData(
            fileType = AvBeamFileType.UNKNOWN,
            fileDescription = "",
            fileData = byteArrayOf()
        )
    }

    override val scanDocumentFlow: StateFlow<AvBeamScanDocumentNotification> =
        MutableStateFlow(AvBeamNotification.Empty)
    override val recordDocumentFlow: StateFlow<AvBeamRecordDocumentNotification> =
        MutableStateFlow(AvBeamNotification.Empty)
    override val captureFaceFlow: StateFlow<AvBeamCaptureFaceNotification> = MutableStateFlow(AvBeamNotification.Empty)
    override val scanNfcFlow: StateFlow<AvBeamScanNfcNotification> = MutableStateFlow(AvBeamNotification.Empty)
    override val errorFlow: StateFlow<AVBeamError> = MutableStateFlow(AVBeamError.None)
    override val statusFlow: StateFlow<AVBeamStatus> = MutableStateFlow(AVBeamStatus.Empty)
    override val initializedFlow: StateFlow<Boolean> = MutableStateFlow(false)

    override fun setActivity(activity: AppCompatActivity) {
        // No-op
    }

    override fun getGLView(width: Int, height: Int): SurfaceView {
        // No-op
        return SurfaceView(null)
    }

    override fun stopCamera() {
        // No-op
    }

    override fun startCamera() {
        // No-op
    }

    override fun startFrontCamera() {
        // No-op
    }

    override fun initNfcCardReader(
        activity: AppCompatActivity,
        nfcServerDockerUrl: String
    ) {
        // No-op
    }

    override fun onNewIntentNfc(intent: Intent) {
        // No-op
    }

    override fun onResumeNfc() {
        // No-op
    }

    override fun onPauseNfc() {
        // No-op
    }
}
