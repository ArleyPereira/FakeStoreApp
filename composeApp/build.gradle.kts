import org.jetbrains.compose.ExperimentalComposeLibrary

plugins {
    alias(libs.plugins.kotlinMultiplatform)
    alias(libs.plugins.androidApplication)
    alias(libs.plugins.jetbrainsCompose)
    alias(libs.plugins.ksp)

    kotlin("plugin.serialization") version "1.9.21"
}

kotlin {
    androidTarget {
        compilations.all {
            kotlinOptions {
                jvmTarget = "1.8"
            }
        }
    }
    
    listOf(
        iosX64(),
        iosArm64(),
        iosSimulatorArm64()
    ).forEach { iosTarget ->
        iosTarget.binaries.framework {
            baseName = "ComposeApp"
            isStatic = true
        }
    }
    
    sourceSets {
        
        androidMain.dependencies {
            implementation(libs.compose.ui.tooling.preview)
            implementation(libs.androidx.activity.compose)

            // Ktor
            implementation(libs.ktor.client.android)

            implementation(project.dependencies.platform("io.insert-koin:koin-bom:3.5.3"))
            implementation("io.insert-koin:koin-core")
            implementation("io.insert-koin:koin-android")
            implementation("io.insert-koin:koin-androidx-compose")
        }

        iosMain.dependencies {
            implementation("io.ktor:ktor-client-darwin:2.3.5")
        }

        commonMain.dependencies {
            implementation(compose.runtime)
            implementation(compose.foundation)
            implementation(compose.material) // Verificar se pode remover depois
            implementation(compose.material3)
            implementation(compose.ui)
            @OptIn(ExperimentalComposeLibrary::class)
            implementation(compose.components.resources)

            implementation(libs.kotlinx.serialization.json)
            implementation(libs.kotlinx.coroutines.core)

            implementation(libs.ktor.client.core)
            implementation(libs.ktor.client.content.negotiation)
            implementation(libs.ktor.serialization.kotlinx.json)

            implementation(libs.mvvm.core)

            // Kamel
            implementation("media.kamel:kamel-image:0.9.1")

            // Koin
            implementation(project.dependencies.platform("io.insert-koin:koin-bom:3.5.3"))
            implementation("io.insert-koin:koin-core")
            implementation("io.insert-koin:koin-compose")

            // Required so we can access the generated KSP files
            //kotlin.srcDir("build/generated/ksp/metadata/commonMain/kotlin")

            // Only required if you want to use koin annotations
            implementation("io.insert-koin:koin-annotations:1.3.0")
        }
    }
}

// Add Koin KSP compiler dependency for code generation in KSP.
// Source: https://github.com/InsertKoinIO/hello-kmp/blob/annotations/shared/build.gradle.kts
dependencies {
    add("kspCommonMainMetadata", "io.insert-koin:koin-ksp-compiler:1.3.0")
}

android {
    namespace = "br.com.hellodev.fakestoreapp"
    compileSdk = libs.versions.android.compileSdk.get().toInt()

    sourceSets["main"].manifest.srcFile("src/androidMain/AndroidManifest.xml")
    sourceSets["main"].res.srcDirs("src/androidMain/res")
    sourceSets["main"].resources.srcDirs("src/commonMain/resources")

    defaultConfig {
        applicationId = "br.com.hellodev.fakestoreapp"
        minSdk = libs.versions.android.minSdk.get().toInt()
        targetSdk = libs.versions.android.targetSdk.get().toInt()
        versionCode = 1
        versionName = "1.0"
    }
    packaging {
        resources {
            excludes += "/META-INF/{AL2.0,LGPL2.1}"
        }
    }
    buildTypes {
        getByName("release") {
            isMinifyEnabled = false
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
    dependencies {
        debugImplementation(libs.compose.ui.tooling)
    }
}

