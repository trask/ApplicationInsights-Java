plugins {
  `java-library`
}

val sdkVersionDir = layout.buildDirectory.dir("generated/resources/sdk-version")

abstract class GenerateVersionResourceTask : DefaultTask() {
  @get:Input
  abstract val projectVersion: Property<String>
  
  @get:OutputDirectory
  abstract val outputDirectory: DirectoryProperty
  
  @TaskAction
  fun generateVersionFile() {
    val outputDir = outputDirectory.asFile.get()
    outputDir.mkdirs()
    File(outputDir, "ai.sdk-version.properties").writeText("version=${projectVersion.get()}")
  }
}

tasks {
  register<GenerateVersionResourceTask>("generateVersionResource") {
    projectVersion.set(project.version.toString())
    outputDirectory.set(sdkVersionDir)
  }
}

sourceSets {
  main {
    output.dir(sdkVersionDir, "builtBy" to "generateVersionResource")
  }
}
