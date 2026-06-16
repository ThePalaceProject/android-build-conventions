palace-build-conventions
===

This repository contains the shared Gradle build scripts for all Palace Android projects.

## Usage

Projects should:

```
$ git submodule add https://github.com/ThePalaceProject/android-build-conventions palace-build-conventions
```

Then, in the project's `settings.gradle.kts`:

```
pluginManagement {
    repositories {
        mavenCentral()
        gradlePluginPortal()
        google()
    }
}

dependencyResolutionManagement {
    ...
}

rootProject.name = "..."

includeBuild("palace-build-conventions")
```

Then, for a module that publishes an Android AAR:

```
$ cat example-module/build.gradle.kts

plugins {
    id("org.thepalaceproject.build.aar")
}

dependencies {
    coreLibraryDesugaring(libs.android.desugaring)
    ...
}
```

Modules are expected to include `gradle.properties` files with metadata sufficient for publishing
to Maven Central:

```
$ cat gradle.properties 
GROUP=org.thepalaceproject.http
POM_AUTOMATIC_MODULE_NAME=org.librarysimplified.http
POM_ARTIFACT_ID=org.librarysimplified.http
POM_DESCRIPTION=HTTP client
POM_INCEPTION_YEAR=2020
POM_LICENCE_DIST=repo
POM_LICENCE_NAME=Apache 2.0 License
POM_LICENCE_URL=https://opensource.org/licenses/Apache-2.0
POM_NAME=org.librarysimplified.http
POM_SCM_CONNECTION=scm:git:git://github.com/ThePalaceProject/android-http
POM_SCM_DEV_CONNECTION=scm:git:ssh://git@github.com/ThePalaceProject/android-http
POM_SCM_URL=http://github.com/ThePalaceProject/android-http
POM_URL=http://github.com/ThePalaceProject/android-http
VERSION_NAME=2.3.0-SNAPSHOT
VERSION_PREVIOUS=2.2.0

android.useAndroidX=true
org.gradle.jvmargs=-Xmx4096m

org.thepalaceproject.build.androidSDKCompile=36
org.thepalaceproject.build.androidSDKTarget=36
org.thepalaceproject.build.androidSDKMinimum=24
org.thepalaceproject.build.checkSemanticVersioning=true
org.thepalaceproject.build.enableKtLint=true
org.thepalaceproject.build.jdkBytecodeTarget=11
org.thepalaceproject.build.jdkBuild=17
org.thepalaceproject.build.publishSources=true
```

See the `PalaceConfiguration` class for the properties that are required.
