package ch.admin.foitt.avwrapper

import android.view.SurfaceView
import androidx.appcompat.app.AppCompatActivity
import kotlinx.coroutines.flow.StateFlow

class AVBeamImpl: AVBeam{
    override fun init(config: AVBeamInitConfig) {
        //No-op
    }

    override suspend fun startScanDocument(config: AVBeamScanDocumentConfig): Result<AVBeamPackageResult> {
        return Result.success(AVBeamPackageResult("No-op"))
    }

    override fun stopScanDocument() {
        //No-op
    }

    override suspend fun startRecordingDocument(config: AVBeamRecordDocumentConfig): Result<AVBeamPackageResult> {
        return Result.success(AVBeamPackageResult("No-op"))
    }

    override fun stopRecordingDocument() {
        //No-op
    }

    override suspend fun startCaptureFace(config: AVBeamCaptureFaceConfig): Result<AVBeamPackageResult> {
        return Result.success(AVBeamPackageResult("No-op"))
    }

    override fun stopCaptureFace() {
        //No-op
    }

    override suspend fun startScanNfc(config: AVBeamScanNfcConfig): Result<AVBeamPackageResult> {
        return Result.success(AVBeamPackageResult("No-op"))
    }

    override fun stopScanNfc() {
        //No-op
    }

    override val scanDocumentFlow: StateFlow<AvBeamScanDocumentNotification>
        get() = throw NotImplementedError("No-op implementation")
    override val recordDocumentFlow: StateFlow<AvBeamRecordDocumentNotification>
        get() = throw NotImplementedError("No-op implementation")
    override val captureFaceFlow: StateFlow<AvBeamCaptureFaceNotification>
        get() = throw NotImplementedError("No-op implementation")
    override val scanNfcFlow: StateFlow<AvBeamScanNfcNotification>
        get() = throw NotImplementedError("No-op implementation")

    override fun setActivity(activity: AppCompatActivity) {
        //No-op
    }

    override fun getGLView(height: Int, width: Int): SurfaceView {
        throw NotImplementedError("No-op implementation")
    }

    override fun stopCamera() {
        //No-op
    }

    override fun startCamera() {
        //No-op
    }
}