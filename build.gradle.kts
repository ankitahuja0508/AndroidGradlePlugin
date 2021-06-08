import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    // Apply the Java Gradle plugin development plugin to add support for developing Gradle plugins
    kotlin("jvm") version "1.4.32"
    `java-gradle-plugin`
    `kotlin-dsl`
    `maven-publish`
    id("com.gradle.plugin-publish") version "0.14.0"
}

group = "com.github.ankitahuja0508"
version = "1.1.7"

pluginBundle {
    website = "https://github.com/ankitahuja0508"
    vcsUrl = "https://github.com/ankitahuja0508/AndroidGradlePlugin.git"
    tags = listOf("android", "kotlin", "common dependencies")
}

repositories {
    google()
    // Use Maven Central for resolving dependencies
    mavenCentral()
}

dependencies {
    compileOnly(gradleApi())

    implementation("com.android.tools.build:gradle:4.2.1")
    implementation(kotlin("gradle-plugin", "1.4.32"))
    implementation("androidx.navigation:navigation-safe-args-gradle-plugin:2.3.5")
    implementation("com.google.dagger:hilt-android-gradle-plugin:2.36")

}

gradlePlugin {
    // Define the plugin
    val plugin by plugins.creating {
        id = "com.github.ankitahuja0508"
        displayName = "Android general Plugin"
        //description = "This plugin contains most general dependencies that can be used in an AndroidProject. Now includes retrofit, moshi, okhttp, flipper"
        description = "This plugin contains most general dependencies that can be used in an AndroidProject with retrofit. Added function to include retrofit."
        implementationClass = "AexynAndroidPlugin"
    }
}

publishing {
    repositories {
        maven {
            name = "aexynAndroidPlugin"
            url = uri("aexyn-android-plugin")
        }
    }
}


tasks.withType<KotlinCompile>() {
    kotlinOptions.jvmTarget = "1.8"
}