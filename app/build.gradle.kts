plugins {
    id("com.android.application")
    id("org.jetbrains.kotlin.android")
}

android {
    namespace = "com.example.task"
    compileSdk = 34

    defaultConfig {
        applicationId = "com.example.task"
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
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
    kotlinOptions {
        jvmTarget = "1.8"
    }
}

dependencies {
    //drawer
    implementation ("com.google.android.material:material:1.3.0-alpha03")


    implementation ("androidx.appcompat:appcompat:1.3.1")
    implementation ("androidx.core:core-ktx:1.7.0")
    implementation ("com.google.android.material:material:1.5.0")

    implementation ("com.github.bumptech.glide:glide:4.12.0")

    // retrofit
    implementation ("com.google.code.gson:gson:2.8.9")
    implementation ("androidx.recyclerview:recyclerview:1.2.1")

    implementation("com.squareup.retrofit2:retrofit:2.9.0")

// GSON

    implementation("com.squareup.retrofit2:converter-gson:2.9.0")

// coroutine
    // for adding recyclerview
    implementation ("androidx.recyclerview:recyclerview:1.2.0")

    // for adding cardview
    implementation ("androidx.cardview:cardview:1.0.0")

    implementation("androidx.core:core-ktx:1.9.0")
    implementation("androidx.appcompat:appcompat:1.6.1")
    implementation("com.google.android.material:material:1.10.0")
    implementation("androidx.constraintlayout:constraintlayout:2.1.4")
    implementation("androidx.navigation:navigation-fragment:2.7.6")
    testImplementation("junit:junit:4.13.2")
    androidTestImplementation("androidx.test.ext:junit:1.1.5")
    androidTestImplementation("androidx.test.espresso:espresso-core:3.5.1")
}