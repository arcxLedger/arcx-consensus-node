plugins {
    id("io.github.arcxLedger.gradle.base.lifecycle")
    id("io.github.arcxLedger.gradle.base.version")
    id("io.github.arcxLedger.gradle.report.code-coverage")
    id("io.github.arcxLedger.gradle.check.spotless")
    id("io.github.arcxLedger.gradle.check.spotless-kotlin")
    id("io.github.arcxLedger.gradle.feature.publish-maven-central-aggregation")
}

tasks.testCodeCoverageReport {
    // Redo the setup done in 'JacocoReportAggregationPlugin', but gather the class files in the
    // file tree and filter out selected classes by path.
    val filteredClassFiles =
        configurations.aggregateCodeCoverageReportResults
            .get()
            .incoming
            .artifactView {
                componentFilter { id -> id is ProjectComponentIdentifier }
                attributes.attribute(
                    LibraryElements.LIBRARY_ELEMENTS_ATTRIBUTE,
                    objects.named(LibraryElements.CLASSES),
                )
            }
            .files
            .asFileTree
            .filter { file ->
                listOf("test-clients", "testFixtures", "example-apps").none {
                    file.path.contains(it)
                }
            }
    classDirectories.setFrom(filteredClassFiles)
}