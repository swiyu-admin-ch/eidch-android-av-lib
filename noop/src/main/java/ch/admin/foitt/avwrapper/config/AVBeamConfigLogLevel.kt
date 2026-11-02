package ch.admin.foitt.avwrapper.config

enum class AVBeamConfigLogLevel(val value: Int) {
    NONE(0),
    ERRORS(1),
    WARNINGS(2),
    INFORMATION(4),
    DEBUG(8),
    VERBOSE(16),
}
