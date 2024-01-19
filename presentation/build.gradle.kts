@Suppress("DSL_SCOPE_VIOLATION") // TODO: Remove once KTIJ-19369 is fixed
plugins {
    alias(libs.plugins.android.library)
    alias(libs.plugins.android.kotlin)
    kotlin("kapt")
    alias(libs.plugins.hilt.android)
}

android {
    namespace = "com.kadirkuruca.presentation"
    compileSdk = 33

    defaultConfig {
        minSdk = 24

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        consumerProguardFiles("consumer-rules.pro")
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
        sourceCompatibility = JavaVersion.VERSION_17
        targetCompatibility = JavaVersion.VERSION_17
    }
    kotlinOptions {
        jvmTarget = "17"
    }
    buildFeatures {
        compose = true
    }
    composeOptions {
        kotlinCompilerExtensionVersion = "1.4.3"
    }
}

dependencies {

    implementation(libs.androidx.core.ktx)
    implementation(libs.appcompat)
    implementation(libs.material)
    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)

    implementation(project(":core"))
    implementation(project(":data"))
    implementation(project(":domain"))

    implementation(platform(libs.compose.bom))
    implementation(libs.bundles.compose.bundle)
    implementation(libs.compose.material3)

    implementation(libs.androidx.navigation.compose)
    implementation(libs.androidx.core.splashscreen)

    //Hilt
    implementation(libs.hilt.android)
    kapt(libs.hilt.compiler)

    //Coil
    implementation(libs.coil)
}
kapt {
    correctErrorTypes = true
}