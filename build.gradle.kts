val ktorVersion: String by project
val kotlinVersion: String by project
val logbackVersion: String by project
val koinVersion: String by project

plugins {
  application
  kotlin("jvm") version "1.6.10"
  id("org.jetbrains.kotlin.plugin.serialization") version "1.6.10"
}

group = "in.athani"
version = "0.0.1"
application {
  mainClass.set("in.athani.ApplicationKt")
}

repositories {
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

  // Serialization
  implementation("io.ktor:ktor-server-content-negotiation:$ktorVersion")
  implementation("io.ktor:ktor-serialization-kotlinx-json:$ktorVersion")

  // Logging
  implementation("ch.qos.logback:logback-classic:$logbackVersion")

  // Koin for Ktor
  implementation("io.insert-koin:koin-ktor:$koinVersion")
  // SLF4J Logger
  implementation("io.insert-koin:koin-logger-slf4j:$koinVersion")

  testImplementation("io.ktor:ktor-server-tests:$ktorVersion")
  testImplementation("org.jetbrains.kotlin:kotlin-test-junit:$kotlinVersion")
}

tasks.withType<org.jetbrains.kotlin.gradle.tasks.KotlinCompile>() {
  kotlinOptions.jvmTarget = "11"
}