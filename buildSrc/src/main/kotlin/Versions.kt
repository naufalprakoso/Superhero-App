object Versions {
    // App dependencies
    const val kotlin = "1.3.72"
    const val androidxTest = "1.1.0"
    const val androidxAnnotations = "1.0.1"
    const val androidxLegacySupport = "1.0.0"
    const val appCompat = "1.1.0"
    const val constraintLayout = "1.1.3"
    const val room = "2.2.5"
    const val archLifecycle = "2.1.0"
    const val junit = "4.12"
    const val glide = "4.10.0"
    const val glideCompiler = "4.9.0"
    const val material = "1.2.0-alpha06"
    const val retrofit2 = "2.6.0"
    const val coroutinesCore = "1.2.1"
    const val coroutinesAndroid = "1.1.1"
    const val gson = "2.8.6"
    const val shimmer = "0.5.0"
    const val hilt = "2.28-alpha"
    const val hiltLifeCycle = "1.0.0-alpha01"
    const val fragmentKtx = "1.2.5"
    const val stetho = "1.5.1"
}

object AppConfiguration {
    const val applicationId = "com.naufalprakoso.superheroapp"
    const val versionName = "1.0"
    const val versionCode = 1
    const val minSdkVersion = 21
    const val targetSdkVersion = 29
}

object Dependencies {
    const val gradle = "com.android.tools.build:gradle:4.0.0"
    const val kotlin = "org.jetbrains.kotlin:kotlin-gradle-plugin:${Versions.kotlin}"
    const val appCompat = "androidx.appcompat:appcompat:${Versions.appCompat}"
    const val materialDesign = "com.google.android.material:material:${Versions.material}"
    const val constraintLayout = "androidx.constraintlayout:constraintlayout:${Versions.constraintLayout}"
    const val annotation = "androidx.annotation:annotation:${Versions.androidxAnnotations}"
    const val legacySupport = "androidx.legacy:legacy-support-v4:${Versions.androidxLegacySupport}"
    const val lifeCycleExtension = "androidx.lifecycle:lifecycle-extensions:2.2.0"
    const val lifeCycleCommonJava = "androidx.lifecycle:lifecycle-common-java8:${Versions.archLifecycle}"

    const val shimmer = "com.facebook.shimmer:shimmer:${Versions.shimmer}"
    const val tagGroup = "me.gujun.android.taggroup:library:1.4@aar"
    const val gson = "com.google.code.gson:gson:${Versions.gson}"

    const val fragmentKtx = "androidx.fragment:fragment-ktx:${Versions.fragmentKtx}"
}

object Coroutines {
    const val core = "org.jetbrains.kotlinx:kotlinx-coroutines-core:${Versions.coroutinesCore}"
    const val android = "org.jetbrains.kotlinx:kotlinx-coroutines-android:${Versions.coroutinesAndroid}"
}

object Retrofit {
    const val retrofit = "com.squareup.retrofit2:retrofit:${Versions.retrofit2}"
    const val converterGson = "com.squareup.retrofit2:converter-gson:${Versions.retrofit2}"
}

object Room {
    const val runtime = "androidx.room:room-runtime:${Versions.room}"
    const val ktx = "androidx.room:room-ktx:${Versions.room}"
    const val compiler = "androidx.room:room-compiler:${Versions.room}"
}

object Hilt {
    const val hilt = "com.google.dagger:hilt-android:${Versions.hilt}"
    const val compiler = "com.google.dagger:hilt-android-compiler:${Versions.hilt}"
    const val plugin = "com.google.dagger:hilt-android-gradle-plugin:${Versions.hilt}"
    const val viewModel = "androidx.hilt:hilt-lifecycle-viewmodel:${Versions.hiltLifeCycle}"
    const val viewModelCompiler = "androidx.hilt:hilt-compiler:${Versions.hiltLifeCycle}"
}

object Stetho {
    const val stetho = "com.facebook.stetho:stetho:${Versions.stetho}"
    const val okHttp = "com.facebook.stetho:stetho-okhttp3:${Versions.stetho}"
}

object Glide {
    const val glide = "com.github.bumptech.glide:glide:${Versions.glide}"
    const val compiler = "com.github.bumptech.glide:compiler:${Versions.glideCompiler}"
}

object Testing {
    const val jUnit = "junit:junit:${Versions.junit}"
    const val extJUnit = "androidx.test.ext:junit:${Versions.androidxTest}"
}