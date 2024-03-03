plugins {
    id("com.android.application")
    id("org.jetbrains.kotlin.android")
}

android {
    namespace = "com.ling.commonlib"
    compileSdk = 34

    defaultConfig {
        applicationId = "com.ling.commonlib"
        minSdk = 28
        targetSdk = 34
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
    kotlinOptions {
        jvmTarget = "1.8"
    }
}

dependencies {

    implementation("androidx.core:core-ktx:1.12.0")
    implementation("androidx.appcompat:appcompat:1.6.1")
    implementation("com.google.android.material:material:1.11.0")
    testImplementation("junit:junit:4.13.2")
    androidTestImplementation("androidx.test.ext:junit:1.1.5")
    androidTestImplementation("androidx.test.espresso:espresso-core:3.5.1")
    //rxjava
    implementation("io.reactivex.rxjava2:rxjava:2.1.16")
    implementation("io.reactivex.rxjava2:rxandroid:2.0.2 ")
    //打印日志
    implementation("com.orhanobut:logger:2.2.0 ")
    //gson
    implementation("com.google.code.gson:gson:2.10")
    //okhttp
    implementation("com.squareup.okhttp3:okhttp:3.11.0 ")
    //retrofit
    implementation("com.squareup.retrofit2:retrofit:2.3.0 ")
    implementation("com.squareup.retrofit2:converter-gson:2.3.0 ")
}