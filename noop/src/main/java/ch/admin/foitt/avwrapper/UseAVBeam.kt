package ch.admin.foitt.avwrapper

class UseAVBeam {
    fun something() {
        val avBeam: AVBeam = AVBeamImpl()
        avBeam.init(AVBeamInitConfig("anything"))
    }
}