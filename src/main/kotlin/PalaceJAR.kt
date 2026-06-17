import PalaceConfiguration.PackagingType.JAR
import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.api.plugins.JavaPluginExtension
import org.gradle.internal.extensions.core.extra
import org.jetbrains.kotlin.gradle.dsl.KotlinJvmExtension

class PalaceJAR : Plugin<Project> {
  override fun apply(project: Project) {
    val properties = PalaceProjectProperties.fromMap(project.extra.properties)

    project.version = properties.versionName
    project.pluginManager.apply("java-library")
    project.pluginManager.apply("org.jetbrains.kotlin.jvm")
    project.extensions.configure(JavaPluginExtension::class.java) {
      PalaceConfiguration.configureJava(this, properties)
    }
    project.extensions.configure(KotlinJvmExtension::class.java) {
      PalaceConfiguration.configureKotlinJVM(this, properties)
    }
    PalaceConfiguration.configureDisableTransitiveDependencies(project)
    PalaceConfiguration.configureDisableTests(project)
    PalaceConfiguration.configurePublishing(properties, project, JAR)
  }
}
