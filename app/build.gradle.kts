plugins {
    alias(libs.plugins.androidApplication)
}

android {
    namespace = "com.example.junit"
    compileSdk = 34

    packagingOptions {
        resources.excludes.add("META-INF/*")
        resources.excludes.add("NOTICES/libcore-NOTICES.txt")
    }

    defaultConfig {
        applicationId = "com.example.junit"
        minSdk = 26
        targetSdk = 34
        versionCode = 1
        versionName = "1.0"
        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    buildTypes {
        debug {
            matchingFallbacks += listOf("release")
        }
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
        isCoreLibraryDesugaringEnabled = true
    }

    buildFeatures {
        viewBinding = true
    }
}

dependencies {
    coreLibraryDesugaring("com.android.tools:desugar_jdk_libs:2.0.3")
    implementation(libs.appcompat)
    implementation(libs.material)
    implementation(libs.constraintlayout)
    implementation(libs.navigation.fragment)
    implementation(libs.navigation.ui)

    androidTestImplementation ("androidx.test.ext:junit:1.1.5")// For JUnit4
    androidTestImplementation ("androidx.test.espresso:espresso-core:3.5.1")

    testImplementation ("junit:junit:4.13.2")
    testImplementation ("org.robolectric:robolectric:4.9.1")
    testImplementation ("'org.mockito:mockito-core:4.6.1' ")


}
