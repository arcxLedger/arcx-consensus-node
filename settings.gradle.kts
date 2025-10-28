// SPDX-License-Identifier: Apache-2.0
pluginManagement { includeBuild("../arcx-gradle-conventions") }

plugins { id("io.github.arcxLedger.gradle.build") }

rootProject.name = "arcx-consensus-node"

include("platform-sdk")
include("platform-sdk:junit-extensions")
findProject(":platform-sdk:junit-extensions")?.name = "junit-extensions"
