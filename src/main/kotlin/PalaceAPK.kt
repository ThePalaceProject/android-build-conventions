import com.android.build.api.dsl.ApplicationExtension
import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.api.plugins.JavaPluginExtension
import org.gradle.internal.extensions.core.extra
import org.jetbrains.kotlin.gradle.dsl.KotlinAndroidExtension

class PalaceAPK : Plugin<Project> {
  override fun apply(project: Project) {
    val properties = PalaceProjectProperties.fromMap(project.extra.properties)

    project.version = properties.versionName
    project.pluginManager.apply("com.android.application")
    project.extensions.configure(KotlinAndroidExtension::class.java) {
      PalaceConfiguration.configureKotlin(this, properties)
    }
    project.extensions.configure(JavaPluginExtension::class.java) {
      PalaceConfiguration.configureJava(this, properties)
    }
    project.extensions.configure(ApplicationExtension::class.java) {
      PalaceConfiguration.configureAndroidApplication(this, properties)
    }
    PalaceConfiguration.configureDisableTransitiveDependencies(project)
    PalaceConfiguration.configureDisableTests(project)
    PalaceConfiguration.configurePublishing(
      properties,
      project,
      PalaceConfiguration.PackagingType.APK,
    )
  }
}
