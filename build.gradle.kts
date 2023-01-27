val ktorVersion: String by project
val kotlinVersion: String by project
val logbackVersion: String by project
val koinVersion: String by project

plugins {
  application
  kotlin("jvm") version "1.8.0"
  id("org.jetbrains.kotlin.plugin.serialization") version "1.8.0"
}

group = "in.gullak"
version = "0.0.1"
application {
  mainClass.set("in.gullak.ApplicationKt")
}

repositories {
  mavenLocal()
  mavenCentral()
  maven { url = uri("https://maven.pkg.jetbrains.space/public/p/ktor/eap") }
}

dependencies {
  // Ktor
  implementation("io.ktor:ktor-server-core:$ktorVersion")
  implementation("io.ktor:ktor-server-host-common:$ktorVersion")
  implementation("io.ktor:ktor-server-status-pages:$ktorVersion")
  implementation("io.ktor:ktor-server-cors:$ktorVersion")
  implementation("io.ktor:ktor-server-call-logging:$ktorVersion")
  implementation("io.ktor:ktor-server-tomcat:$ktorVersion")
  implementation("io.ktor:ktor-server-locations:$ktorVersion")

  // Serialization
  implementation("io.ktor:ktor-server-content-negotiation:$ktorVersion")
  implementation("io.ktor:ktor-serialization-kotlinx-json:$ktorVersion")

  // Logging
  implementation("ch.qos.logback:logback-classic:$logbackVersion")

  // Kotlin Date Time
  implementation("org.jetbrains.kotlinx:kotlinx-datetime:0.3.2")

  // Koin for Ktor
  implementation("io.insert-koin:koin-ktor:$koinVersion")
  // SLF4J Logger for Koin
  implementation("io.insert-koin:koin-logger-slf4j:$koinVersion")

  testImplementation("io.ktor:ktor-server-tests:$ktorVersion")
  testImplementation("org.jetbrains.kotlin:kotlin-test-junit:$kotlinVersion")
}

tasks.withType<org.jetbrains.kotlin.gradle.tasks.KotlinCompile>() {
  kotlinOptions.jvmTarget = "11"
}