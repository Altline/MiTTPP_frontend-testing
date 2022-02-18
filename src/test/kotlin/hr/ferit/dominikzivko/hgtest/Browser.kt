package hr.ferit.dominikzivko.hgtest

enum class Browser {
    CHROME, FIREFOX, EDGE
}

class UnsupportedBrowserException(browserName: String) :
    RuntimeException("Unsupported browser: $browserName")