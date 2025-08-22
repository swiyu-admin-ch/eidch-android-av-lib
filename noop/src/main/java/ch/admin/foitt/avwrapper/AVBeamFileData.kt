package ch.admin.foitt.avwrapper

data class AVBeamFileData(
    val fileType: AvBeamFileType,
    val fileDescription: String,
    val fileData: ByteArray,
)
