package ch.admin.foitt.avwrapper

@Suppress(
    "FunctionOnlyReturningConstant",
    "UnusedParameter",
)
enum class AvBeamFileType {
    UNKNOWN;

    fun toMimeType(): String = ""

    companion object {
        internal fun fromCode(code: Int): AvBeamFileType = UNKNOWN
        fun fromMimeType(mimeType: String): AvBeamFileType = UNKNOWN
    }
}
