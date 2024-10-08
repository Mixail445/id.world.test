plugins {
    alias(libs.plugins.android.application)
    alias(libs.plugins.jetbrains.kotlin.android)
    kotlin("kapt")
    id("com.google.dagger.hilt.android")
}

android {
    namespace = "com.example.idworldtest"
    compileSdk = 34

    defaultConfig {
        applicationId = "com.example.idworldtest"
        minSdk = 26
        targetSdk = 34
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        vectorDrawables {
            useSupportLibrary = true
        }
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

    flavorDimensions += "client"

    productFlavors {

        create("operatorA") {
            dimension = "client"
            applicationIdSuffix = ".operatorA"
            versionNameSuffix = "-OperatorA"
            resValue("string", "client_name", "OperatorA")
            resValue("color", "client_color", "#FF5733")
        }
        create("operatorB") {
            dimension = "client"
            applicationIdSuffix = ".operatorB"
            versionNameSuffix = "-OperatorB"
            resValue("string", "client_name", "OperatorB")
            resValue("color", "client_color", "#33FF57")
        }
        create("operatorC") {
            dimension = "client"
            applicationIdSuffix = ".operatorC"
            versionNameSuffix = "-OperatorC"
            resValue("string", "client_name", "OperatorC")
            resValue("color", "client_color", "#3357FF")
        }
        create("operatorD") {
            dimension = "client"
            applicationIdSuffix = ".operatorD"
            versionNameSuffix = "-OperatorD"
            resValue("string", "client_name", "OperatorD")
            resValue("color", "client_color", "#FF33A1")
        }
        create("operatorE") {
            dimension = "client"
            applicationIdSuffix = ".operatorE"
            versionNameSuffix = "-OperatorE"
            resValue("string", "client_name", "OperatorE")
            resValue("color", "client_color", "#A133FF")
        }
        create("operatorF") {
            dimension = "client"
            applicationIdSuffix = ".operatorF"
            versionNameSuffix = "-OperatorF"
            resValue("string", "client_name", "OperatorF")
            resValue("color", "client_color", "#FF8C33")
        }
        create("operatorG") {
            dimension = "client"
            applicationIdSuffix = ".operatorG"
            versionNameSuffix = "-OperatorG"
            resValue("string", "client_name", "OperatorG")
            resValue("color", "client_color", "#33FF8C")
        }
        create("operatorH") {
            dimension = "client"
            applicationIdSuffix = ".operatorH"
            versionNameSuffix = "-OperatorH"
            resValue("string", "client_name", "OperatorH")
            resValue("color", "client_color", "#8C33FF")
        }
        create("operatorI") {
            dimension = "client"
            applicationIdSuffix = ".operatorI"
            versionNameSuffix = "-OperatorI"
            resValue("string", "client_name", "OperatorI")
            resValue("color", "client_color", "#FF3333")
        }
        create("operatorJ") {
            dimension = "client"
            applicationIdSuffix = ".operatorJ"
            versionNameSuffix = "-OperatorJ"
            resValue("string", "client_name", "OperatorJ")
            resValue("color", "client_color", "#33FFA1")
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
    kotlinOptions {
        jvmTarget = "1.8"
    }
    buildFeatures {
        compose = true
    }
    composeOptions {
        kotlinCompilerExtensionVersion = "1.5.1"
    }
    packaging {
        resources {
            excludes += "/META-INF/{AL2.0,LGPL2.1}"
        }
    }
}

dependencies {

    implementation(libs.hilt.android)
    implementation(libs.androidx.hilt.navigation.compose)
    kapt(libs.hilt.compiler)

    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.lifecycle.runtime.ktx)
    implementation(libs.androidx.activity.compose)
    implementation(platform(libs.androidx.compose.bom))
    implementation(libs.androidx.ui)
    implementation(libs.androidx.ui.graphics)
    implementation(libs.androidx.ui.tooling.preview)
    implementation(libs.androidx.material3)
    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)
    androidTestImplementation(platform(libs.androidx.compose.bom))
    androidTestImplementation(libs.androidx.ui.test.junit4)
    debugImplementation(libs.androidx.ui.tooling)
    debugImplementation(libs.androidx.ui.test.manifest)
}