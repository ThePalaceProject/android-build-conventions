plugins {
    `kotlin-dsl`
}

repositories {
    google()
    mavenCentral()
}

dependencies {
    implementation("com.android.tools.build:gradle:9.2.1")
}

gradlePlugin {
    plugins {
        register("PalaceAAR") {
            id = "org.thepalaceproject.build.aar"
            implementationClass = "PalaceAAR"
        }
        register("PalaceAPK") {
            id = "org.thepalaceproject.build.apk"
            implementationClass = "PalaceAPK"
        }
        register("PalaceJAR") {
            id = "org.thepalaceproject.build.jar"
            implementationClass = "PalaceJAR"
        }
        register("PalaceKtLint") {
            id = "org.thepalaceproject.ktlint"
            implementationClass = "PalaceKtLint"
        }
    }
}
