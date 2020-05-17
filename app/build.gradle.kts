plugins {
    id("com.android.application")
    id("kotlin-android")
    id("kotlin-android-extensions")
    id("kotlin-kapt")
}
apply(from = "$rootDir/ktlint.gradle.kts")

android {
    compileSdkVersion(29)
    buildToolsVersion("29.0.3")

    defaultConfig {
        applicationId = "com.naufalprakoso.superheroapp"
        minSdkVersion(21)
        targetSdkVersion(29)
        versionCode = 1
        versionName = "1.0"
        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    buildTypes {
        getByName("release") {
            isMinifyEnabled = false
            proguardFiles(getDefaultProguardFile("proguard-android-optimize.txt"), "proguard-rules.pro")
        }
        getByName("debug") {
            applicationIdSuffix = ".debug"
            isDebuggable = true
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }

}

dependencies {
    implementation(fileTree(mapOf("dir" to "libs", "include" to listOf("*.jar"))))

    // Dependencies for Android Support
    implementation("androidx.appcompat:appcompat:${Versions.appCompatVersion}")
    implementation("com.google.android.material:material:${Versions.materialVersion}")
    implementation("androidx.constraintlayout:constraintlayout:${Versions.constraintLayoutVersion}")
    implementation("androidx.annotation:annotation:${Versions.androidxAnnotations}")
    implementation("androidx.legacy:legacy-support-v4:${Versions.androidxLegacySupport}")

    // Dependencies for Architecture Component
    implementation("androidx.appcompat:appcompat:${Versions.appCompatVersion}")
    implementation("androidx.lifecycle:lifecycle-extensions:2.2.0")
    implementation("androidx.legacy:legacy-support-v4:1.0.0")
    kapt("androidx.lifecycle:lifecycle-common-java8:${Versions.archLifecycleVersion}")

    // Dependencies for Room
    implementation("androidx.room:room-runtime:${Versions.roomVersion}")
    implementation("androidx.room:room-ktx:${Versions.roomVersion}")
    kapt("androidx.room:room-compiler:${Versions.roomVersion}")

    // Dependencies for Dagger
    implementation("com.google.dagger:dagger:${Versions.daggerVersion}")
    implementation("com.google.dagger:dagger-android:${Versions.daggerVersion}")
    implementation("com.google.dagger:dagger-android-support:${Versions.daggerVersion}")
    kapt("com.google.dagger:dagger-compiler:${Versions.daggerVersion}")
    kapt("com.google.dagger:dagger-android-processor:${Versions.daggerVersion}")

    // Dependencies for Paging
    implementation("androidx.paging:paging-runtime:${Versions.pagingVersion}")

    // Dependencies for Glide
    implementation("com.github.bumptech.glide:glide:4.10.0")
    kapt("com.github.bumptech.glide:compiler:${Versions.glideVersion}")

    // Dependencies for Testing
    testImplementation("junit:junit:${Versions.junitVersion}")
    androidTestImplementation("androidx.test.ext:junit:${Versions.androidxTestVersion}")

    // Retrofit2
    implementation("com.squareup.retrofit2:retrofit:${Versions.retrofit2Version}")
    implementation("com.squareup.retrofit2:converter-gson:${Versions.retrofit2Version}")

    // Coroutines
    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-core:${Versions.coroutinesCoreVersion}")
    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-android:${Versions.coroutinesAndroidVersion}")

    // Gson
    implementation("com.google.code.gson:gson:${Versions.gsonVersion}")

    // Shimmer Loading
    implementation("com.facebook.shimmer:shimmer:${Versions.shimmerVersion}")

    // Tag Group
    implementation("me.gujun.android.taggroup:library:1.4@aar")
}
