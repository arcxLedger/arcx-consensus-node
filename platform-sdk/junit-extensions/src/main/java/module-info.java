open module io.github.arcxLedger.junit.extensions {
    exports io.github.arcxLedger.junit.extensions;

    requires transitive org.junit.jupiter.api;
    requires com.google.common;
    requires static transitive com.github.spotbugs.annotations;
}