@file:Suppress("DSL_SCOPE_VIOLATION")
plugins {
    alias(libs.plugins.android.library)
    alias(libs.plugins.android.kotlin)
    kotlin("kapt")
    alias(libs.plugins.hilt.android)
}

android {
    namespace = "com.kadirkuruca.data"
    compileSdk = 33

    defaultConfig {
        minSdk = 24

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        consumerProguardFiles("consumer-rules.pro")
    }

    buildTypes {
        debug {
            buildConfigField("String", "BASE_URL", "\"https://themealdb.com/api/json/v1/1/\"")
            buildConfigField("String", "DATABASE_NAME", "\"RecipeAppDb\"")
        }
        release {
            buildConfigField("String", "BASE_URL", "\"https://themealdb.com/api/json/v1/1/\"")
            buildConfigField("String", "DATABASE_NAME", "\"RecipeAppDb\"")
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
        buildConfig = true
    }
}

dependencies {
    implementation(project(":core"))

    implementation(libs.androidx.core.ktx)
    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)

    //Retrofit and OkHttp
    implementation(libs.retrofit)
    implementation(libs.converter.gson)
    implementation(libs.okhttps)
    implementation(libs.logging.interceptor)

    //Hilt
    implementation(libs.hilt.android)
    kapt(libs.hilt.compiler)

    //Room
    implementation(libs.androidx.room.runtime)
    annotationProcessor(libs.androidx.room.compiler)

    //Chucker
    debugImplementation(libs.chucker.debug.library)
}
kapt {
    correctErrorTypes = true
}