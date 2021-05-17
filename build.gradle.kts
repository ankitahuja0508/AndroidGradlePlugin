import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    // Apply the Java Gradle plugin development plugin to add support for developing Gradle plugins
    kotlin("jvm") version "1.4.32"
    `java-gradle-plugin`
    `kotlin-dsl`
    `maven-publish`
    id("com.gradle.plugin-publish") version "0.14.0"
}

group = "aexyn.android"
version = "1.0.0"

pluginBundle {
    website = "http://aexyn.com/"
    vcsUrl = "https://github.com/ankitahuja0508/AndroidGradlePlugin.git"
    tags = listOf("android")
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

}

gradlePlugin {
    // Define the plugin
    val plugin by plugins.creating {
        id = "com.aexyn.plugin.android"
        displayName = "Android general Plugin"
        description = "This plugin contains most general dependencies that can be used in an AndroidProject"
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