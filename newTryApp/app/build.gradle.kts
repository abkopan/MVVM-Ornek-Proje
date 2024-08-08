plugins {
    alias(libs.plugins.android.application)
    alias(libs.plugins.jetbrains.kotlin.android)
    id("androidx.navigation.safeargs.kotlin")
    id("com.google.dagger.hilt.android")
    id("com.google.devtools.ksp")
}

android {
    namespace = "com.example.newtryapp"
    compileSdk = 34

    defaultConfig {
        applicationId = "com.example.newtryapp"
        minSdk = 24
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

    buildFeatures {
        viewBinding = true
        dataBinding = true
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_11
        targetCompatibility = JavaVersion.VERSION_11
    }
    kotlinOptions {
        jvmTarget = JavaVersion.VERSION_11.toString()
    }
}

dependencies {
    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.appcompat)
    implementation(libs.material)
    implementation(libs.androidx.activity)
    implementation(libs.androidx.constraintlayout)
    implementation(libs.androidx.navigation.fragment.ktx)
    implementation(libs.androidx.navigation.ui.ktx)
    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)
    implementation(libs.androidx.lifecycle.runtime.ktx)
    implementation(libs.androidx.lifecycle.livedata.ktx)
    implementation(libs.androidx.lifecycle.viewmodel.ktx)
    implementation(libs.hilt.android)
    ksp(libs.hilt.android.compiler)
    implementation("androidx.room:room-runtime:2.5.0-alpha02")
    ksp("androidx.room:room-compiler:2.5.0-alpha02")
    implementation("androidx.room:room-ktx:2.4.0")
    implementation("androidx.lifecycle:lifecycle-runtime-ktx:2.8.4")
    implementation (libs.retrofit)
    implementation ("com.squareup.retrofit2:converter-gson:2.9.0")

    testImplementation ("junit:junit:4.13.2")

    testImplementation ("org.mockito:mockito-core:4.0.0")
    testImplementation ("org.mockito:mockito-inline:4.0.0")

    androidTestImplementation ("com.google.dagger:hilt-android-testing:2.28-alpha")
    kspAndroidTest ("com.google.dagger:hilt-android-compiler:2.28-alpha")
    testImplementation ("com.google.dagger:hilt-android-testing:2.28-alpha")
    kspTest ("com.google.dagger:hilt-android-compiler:2.28-alpha")
    androidTestImplementation ("androidx.arch.core:core-testing:2.1.0")
    testImplementation ("androidx.arch.core:core-testing:2.1.0")
    androidTestImplementation ("androidx.test.espresso:espresso-core:3.4.0")
    androidTestImplementation ("androidx.test.espresso:espresso-intents:3.4.0")
    androidTestImplementation ("androidx.fragment:fragment-testing:1.3.6")
    androidTestImplementation ("org.mockito:mockito-android:4.0.0")
    testImplementation("androidx.room:room-testing:2.5.0-alpha02")

    testImplementation("net.bytebuddy:byte-buddy:1.10.22")
    testImplementation("net.bytebuddy:byte-buddy-agent:1.10.22")


}

ksp {
    arg("room.schemaLocation", "$projectDir/schemas")
}
