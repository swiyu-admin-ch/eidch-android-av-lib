package ch.admin.foitt.avwrapper

@Suppress(
    "FunctionOnlyReturningConstant",
    "UnusedParameter",
)
enum class AvBeamFileType {
    UNKNOWN,
    PDF,
    PDF_CONTRACT,
    XML,
    JSON,
    BMP,
    JPG,
    PNG,
    MP4,
    GIF,
    M4V,
    MOV,
    WEBM,
    DER,
    EF,
    BIN;

    fun toMimeType(): String = ""

    companion object {
        internal fun fromCode(code: Int): AvBeamFileType = UNKNOWN
        fun fromMimeType(mimeType: String): AvBeamFileType = UNKNOWN
    }
}
