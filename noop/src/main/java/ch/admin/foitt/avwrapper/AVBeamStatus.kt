package ch.admin.foitt.avwrapper

@Suppress("EnumEntryNameCase")
enum class AVBeamStatus {
    Empty,
    Init,
    IdNeedSecondPageForMatching,
    StreamingStarted,
    FaceCapturingStopped,
    NFC_DataReadingStart,
    NFC_ChipClonedDetectionStart,
    NFC_DataReadingEndSuccess
}
