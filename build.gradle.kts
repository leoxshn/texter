plugins {
    kotlin("multiplatform") version "1.3.71"
}

group = "posidon.texter"
version = "0.0.1"

repositories {
    mavenCentral()
}

kotlin {
    linuxX64("linux") {
        binaries { executable { entryPoint = "posidon.texter.main" } }
        compilations["main"].cinterops {
            val gtk3 by creating {
                listOf("/opt/local/include", "/usr/include", "/usr/local/include").forEach {
                    includeDirs("$it/atk-1.0", "$it/gdk-pixbuf-2.0", "$it/cairo", "$it/harfbuzz", "$it/pango-1.0", "$it/gtk-3.0", "$it/glib-2.0")
                }
                includeDirs("/opt/local/lib/glib-2.0/include", "/usr/lib/x86_64-linux-gnu/glib-2.0/include", "/usr/local/lib/glib-2.0/include")
            }
        }
    }

    sourceSets {
        commonMain {
            dependencies {
                implementation(kotlin("stdlib-common"))
            }
        }
    }
}