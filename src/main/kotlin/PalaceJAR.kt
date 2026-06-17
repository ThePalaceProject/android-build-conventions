import PalaceConfiguration.PackagingType.JAR
import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.api.plugins.JavaPluginExtension
import org.gradle.internal.extensions.core.extra

class PalaceJAR : Plugin<Project> {
  override fun apply(project: Project) {
    val properties = PalaceProjectProperties.fromMap(project.extra.properties)

    project.version = properties.versionName
    project.pluginManager.apply("java")
    project.extensions.configure(JavaPluginExtension::class.java) {
      PalaceConfiguration.configureJava(this, properties)
    }
    PalaceConfiguration.configureDisableTransitiveDependencies(project)
    PalaceConfiguration.configureDisableTests(project)
    PalaceConfiguration.configurePublishing(properties, project, JAR)
  }
}
