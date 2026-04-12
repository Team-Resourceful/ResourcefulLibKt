import com.teamresourceful.publishing.GitHubPom
import com.teamresourceful.publishing.javaPublishing
import com.teamresourceful.utils.Platform
import com.teamresourceful.utils.getPlatform

plugins {
    java
    kotlin("jvm") version "2.3.0"
    id("maven-publish")
    alias(libs.plugins.resourceful.gradle)
    alias(libs.plugins.resourceful.minecraft) apply false
}

subprojects {
    apply(plugin = "maven-publish")
    apply(plugin = "org.jetbrains.kotlin.jvm")

    version = rootProject.libs.versions.mod.version.get()

    val platform = getPlatform()

    when (platform) {
        Platform.COMMON -> apply(plugin = "com.teamresourceful.plugins.minecraft-platform-common")
        Platform.FABRIC -> apply(plugin = "com.teamresourceful.plugins.minecraft-platform-fabric")
        Platform.NEOFORGE -> apply(plugin = "com.teamresourceful.plugins.minecraft-platform-neoforge")
    }

    repositories {
        mavenCentral()
    }

    dependencies {
        compileOnly("org.jetbrains.kotlin:kotlin-reflect:2.2.0")

        compileOnly("com.teamresourceful.resourcefullib:resourcefullib-${platform.id}-${rootProject.libs.versions.minecraft.get()}:${rootProject.libs.versions.resourceful.lib.get()}")
    }

   if (platform == Platform.COMMON) {
       javaPublishing {
           artifactId = "${rootProject.name}-${rootProject.libs.versions.minecraft.get()}".lowercase()

           pom = GitHubPom(
               "ResourcefulLibKt",
               "The library behind Team Resourceful mods and more.",
               "MIT",
               "https://github.com/Team-Resourceful/ResourcefulLibKt"
           )

           repo = "https://maven.teamresourceful.com/repository/maven-releases/"
       }
   }
}

resourcefulGradle {
    templates {
        register("readme") {
            source = file("templates/README.md.template")
            injectedValues = mapOf(
                "version" to libs.versions.mod.version.get(),
                "minecraft" to libs.versions.minecraft.get(),
            )
        }
    }
}