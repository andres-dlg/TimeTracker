plugins {
  id("com.android.application")
  id("org.jetbrains.kotlin.android")
  id("com.google.dagger.hilt.android")
  kotlin("kapt")
}

android {
  namespace = "com.dlgsoft.timetracker"
  compileSdk = 34

  defaultConfig {
    applicationId = "com.dlgsoft.timetracker"
    minSdk = 23
    targetSdk = 34
    versionCode = 1
    versionName = "1.0"

    testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    vectorDrawables {
      useSupportLibrary = true
    }

    // Room config
    javaCompileOptions {
      annotationProcessorOptions {
        arguments += mapOf(
            "room.schemaLocation" to "$projectDir/schemas",
            "room.incremental" to "true"
        )
      }
    }
  }

  buildTypes {
    release {
      isMinifyEnabled = false
      proguardFiles(getDefaultProguardFile("proguard-android-optimize.txt"), "proguard-rules.pro")
    }
  }
  kotlin {
    jvmToolchain(17)
  }
  buildFeatures {
    compose = true
  }
  composeOptions {
    kotlinCompilerExtensionVersion = "1.4.3"
  }
  packaging {
    resources {
      excludes += "/META-INF/{AL2.0,LGPL2.1}"
    }
  }
}

// Allow references to generated code
kapt {
  correctErrorTypes = true
}

dependencies {

  // Android core libraries
  val androidCoreVersion = "1.12.0"
  val androidLifecycleVersion = "2.6.2"
  val composeActivityVersion = "1.7.2"
  val composeBomVersion = "2023.03.00"
  implementation("androidx.core:core-ktx:$androidCoreVersion")
  implementation("androidx.lifecycle:lifecycle-runtime-ktx:$androidLifecycleVersion")
  implementation("androidx.lifecycle:lifecycle-viewmodel-compose:$androidLifecycleVersion")
  implementation("androidx.activity:activity-compose:$composeActivityVersion")
  implementation(platform("androidx.compose:compose-bom:$composeBomVersion"))
  implementation("androidx.compose.ui:ui")
  implementation("androidx.compose.ui:ui-graphics")
  implementation("androidx.compose.ui:ui-tooling-preview")
  implementation("androidx.compose.material3:material3")
  androidTestImplementation(platform("androidx.compose:compose-bom:$composeBomVersion"))
  androidTestImplementation("androidx.compose.ui:ui-test-junit4")
  debugImplementation("androidx.compose.ui:ui-tooling")
  debugImplementation("androidx.compose.ui:ui-test-manifest")

  // Room
  val roomVersion = "2.5.2"
  implementation("androidx.room:room-runtime:$roomVersion")
  kapt("androidx.room:room-compiler:$roomVersion")

  // Hilt
  val hiltVersion = "2.48"
  val hiltComposeVersion = "1.0.0"
  implementation("com.google.dagger:hilt-android:$hiltVersion")
  kapt("com.google.dagger:hilt-android-compiler:$hiltVersion")
  implementation("androidx.hilt:hilt-navigation-compose:$hiltComposeVersion")

  // Testing
  val jUnitVersion = "4.13.2"
  val jUnitExtVersion = "1.1.5"
  val espressoVersion = "3.5.1"
  testImplementation("junit:junit:$jUnitVersion")
  androidTestImplementation("androidx.test.ext:junit:$jUnitExtVersion")
  androidTestImplementation("androidx.test.espresso:espresso-core:$espressoVersion")
}