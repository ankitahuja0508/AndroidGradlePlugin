import org.gradle.api.Project
import org.gradle.kotlin.dsl.dependencies
import org.gradle.kotlin.dsl.getByType

fun Project.addRetrofitDependencies(configurationName: String = "implementation") {
    val retrofitOption = extensions.getByType<GeneralPluginOptionExtension>().retrofit
    if(retrofitOption.isEnabled) {
        dependencies {
            add("debugImplementation", "com.facebook.flipper:flipper:0.90.2")
            add("debugImplementation", "com.facebook.flipper:flipper-network-plugin:0.90.2")
            add("debugImplementation", "com.facebook.soloader:soloader:0.10.1")

            add(configurationName, "com.squareup.okhttp3:okhttp:4.9.1")
            add(configurationName, "com.squareup.okio:okio:2.10.0")
            add(configurationName, "com.squareup.retrofit2:retrofit:2.9.0")
            add(configurationName, "com.squareup.retrofit2:converter-moshi:2.9.0")
        }
    }
}

fun Project.addHiltDependencies(configurationName: String = "implementation") {
    val hiltOption = extensions.getByType<GeneralPluginOptionExtension>().hilt
    if(hiltOption.isEnabled) {
        project.plugins.apply("dagger.hilt.android.plugin")
        dependencies {
            //Dagger - Hilt
            add("implementation" , "com.google.dagger:hilt-android:2.35.1")
            add("implementation" , "androidx.hilt:hilt-lifecycle-viewmodel:1.0.0-alpha03")
        }
    }
}

fun Project.addKaptDependencies(configurationName: String = "implementation") {
    val dependenciesOption = extensions.getByType<GeneralPluginOptionExtension>().dependencyOption
    if(dependenciesOption.addKapt) {
        dependencies {

            // Hilt kapt
            add("kapt" , "com.google.dagger:hilt-android-compiler:2.35.1")
            add("kapt" , "androidx.hilt:hilt-compiler:1.0.0")

            // Epoxy kapy
            add("kapt" , "com.airbnb.android:epoxy-processor:4.4.4")

            // Glide kapt
            add("kapt" , "com.github.bumptech.glide:compiler:4.12.0")

            // Glide kapt
            add("kapt" , "com.github.bumptech.glide:compiler:4.12.0")

            // Moshi kapt
            add("kapt" , "com.squareup.moshi:moshi-kotlin-codegen:1.12.0")

        }
    }
}