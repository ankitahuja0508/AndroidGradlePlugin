import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.kotlin.dsl.create
import org.gradle.kotlin.dsl.dependencies

class AexynAndroidPlugin : Plugin<Project> {
    override fun apply(project: Project) {
        // Adds your configuration code here.
        project.plugins.apply("kotlin-android")
        project.plugins.apply("kotlin-kapt")
        project.plugins.apply("kotlin-parcelize")
        project.plugins.apply("androidx.navigation.safeargs.kotlin")

        project.extensions.create<GeneralPluginOptionExtension>("generalPluginOptions")

        project.addRetrofitDependencies()

        project.addHiltDependencies()

        // Adds required dependencies for all modules.

        project.dependencies {

            add("implementation" , "org.jetbrains.kotlin:kotlin-stdlib:1.4.32")
            add("implementation" , "androidx.core:core-ktx:1.3.2")
            add("implementation" , "androidx.appcompat:appcompat:1.2.0")
            add("implementation" , "com.google.android.material:material:1.3.0")
            add("implementation" , "androidx.constraintlayout:constraintlayout:2.0.4")
            add("implementation" , "androidx.annotation:annotation:1.2.0")
            add("implementation" , "androidx.lifecycle:lifecycle-livedata-ktx:2.3.1")
            add("implementation" , "androidx.lifecycle:lifecycle-viewmodel-ktx:2.3.1")
            add("implementation" , "androidx.legacy:legacy-support-v4:1.0.0")

            add("implementation" , "androidx.activity:activity-ktx:1.2.3")

            add("implementation" , "androidx.fragment:fragment-ktx:1.3.3")

            add("implementation" , "androidx.lifecycle:lifecycle-viewmodel-ktx:2.3.1")

            add("implementation" , "androidx.navigation:navigation-fragment-ktx:2.3.5")
            add("implementation" , "androidx.navigation:navigation-ui-ktx:2.3.5")
            // Feature module Support
            add("implementation" , "androidx.navigation:navigation-dynamic-features-fragment:2.3.5")

            // Coroutines
            add("implementation" , "org.jetbrains.kotlinx:kotlinx-coroutines-core:1.4.3")
            add("implementation" , "org.jetbrains.kotlinx:kotlinx-coroutines-android:1.4.3")

            //Epoxy
            add("kapt" , "com.airbnb.android:epoxy-processor:4.4.4")
            add("implementation" , "com.airbnb.android:epoxy:4.4.4")
            add("implementation" , "com.airbnb.android:epoxy-databinding:4.4.4")

            add("implementation" , "com.github.bumptech.glide:glide:4.12.0")
            add("kapt" , "com.github.bumptech.glide:compiler:4.12.0")

            add("implementation" , "androidx.preference:preference-ktx:1.1.1")

            add("implementation" , "com.google.code.gson:gson:2.8.7")

            add("implementation" , "com.squareup.moshi:moshi-kotlin:1.12.0")
            add("implementation" , "com.squareup.moshi:moshi-adapters:1.12.0")
            add("kapt" , "com.squareup.moshi:moshi-kotlin-codegen:1.12.0")

            add("testImplementation", "junit:junit:4.12")
            add("androidTestImplementation", "androidx.test.ext:junit:1.1.2")
            add("androidTestImplementation", "androidx.test.espresso:espresso-core:3.3.0")
        }
    }
}