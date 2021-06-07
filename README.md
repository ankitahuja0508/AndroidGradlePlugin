# Android Gradle Plugin

This plugin has all the dependencies which are generally added while developing **Android Project**.

```groovy
"org.jetbrains.kotlin:kotlin-stdlib:1.4.32"
"androidx.core:core-ktx:1.3.2"
"androidx.appcompat:appcompat:1.2.0"
"com.google.android.material:material:1.3.0"
"androidx.constraintlayout:constraintlayout:2.0.4"
"androidx.annotation:annotation:1.2.0"
"androidx.lifecycle:lifecycle-livedata-ktx:2.3.1"
"androidx.lifecycle:lifecycle-viewmodel-ktx:2.3.1"
"androidx.legacy:legacy-support-v4:1.0.0"

"androidx.activity:activity-ktx:1.2.3"

"androidx.fragment:fragment-ktx:1.3.3"

"androidx.lifecycle:lifecycle-viewmodel-ktx:2.3.1"

"androidx.navigation:navigation-fragment-ktx:2.3.5"
"androidx.navigation:navigation-ui-ktx:2.3.5"

// Feature module Support
"androidx.navigation:navigation-dynamic-features-fragment:2.3.5"

// Coroutines
"org.jetbrains.kotlinx:kotlinx-coroutines-core:1.4.3"
"org.jetbrains.kotlinx:kotlinx-coroutines-android:1.4.3"

//Epoxy
"com.airbnb.android:epoxy-processor:4.4.4"
"com.airbnb.android:epoxy:4.4.4"
"com.airbnb.android:epoxy-databinding:4.4.4"

"com.github.bumptech.glide:glide:4.12.0"
"com.github.bumptech.glide:compiler:4.12.0"

"androidx.preference:preference-ktx:1.1.1"

"com.google.code.gson:gson:2.8.7"

"com.squareup.moshi:moshi-kotlin:1.12.0"
"com.squareup.moshi:moshi-adapters:1.12.0"
"com.squareup.moshi:moshi-kotlin-codegen:1.12.0"

"junit:junit:4.12"
"androidx.test.ext:junit:1.1.2"
"androidx.test.espresso:espresso-core:3.3.0"
```

##### Retrofit and flipper if enabled in gradle

```groovy
add("debugImplementation", "com.facebook.flipper:flipper:0.90.2")
add("debugImplementation", "com.facebook.flipper:flipper-network-plugin:0.90.2")
add("debugImplementation", "com.facebook.soloader:soloader:0.10.1")

add("implementation", "com.squareup.okhttp3:okhttp:4.9.1")
add("implementation", "com.squareup.okio:okio:2.10.0")
add("implementation", "com.squareup.retrofit2:retrofit:2.9.0")
add("implementation", "com.squareup.retrofit2:converter-moshi:2.9.0")
```

#### Hilt if enabled in gradle

```groovy
//Dagger - Hilt
add("implementation", "com.google.dagger:hilt-android:2.35.1")
add("kapt", "com.google.dagger:hilt-android-compiler:2.35.1")
add("implementation", "androidx.hilt:hilt-lifecycle-viewmodel:1.0.0-alpha03")
add("kapt", "androidx.hilt:hilt-compiler:1.0.0")
```

## Adding to project

Add below code

```groovy
maven {
    url = uri("https://plugins.gradle.org/m2/")
}
```

in **repositories** block of top level **build.gradle**.

```groovy
repositories {
    google()
    mavenCentral()
    // Copy Here
}
```

Add below classpath in **dependencies** block of top level **build.gradle**.

```groovy
classpath("com.github.ankitahuja0508:AndroidPlugin:1.1.5")
```

Lastly, add below plugin id in plugins block of app level **build.gradle**.

```groovy
id "com.github.ankitahuja0508"
```

### Enable/Disable Retrofit & Flipper , Hilt, kapt
To enable/disable **retrofit, flipper and hilt** add following code in app level **build.gradle**. By default both are enabled.
```groovy
generalPluginOptions{
    // to enable/disable retrofit and flipper
    retrofit{
        isEnabled = true
    }
    // to enable/disable hilt (dagger) dependency injection
    hilt{
        isEnabled = true
    }
    // to enable/disable kapt dependency
    dependencyOption{
        addKapt = true
    }
}
```

And then sync gradle. Plugin will be installed in your Android Project and you can use all these dependencies.