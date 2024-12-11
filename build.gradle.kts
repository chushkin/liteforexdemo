plugins {
    id("java")
}

repositories {
    mavenCentral()
    google()
}

dependencies {
    // JUnit 5
    testImplementation("org.junit.jupiter:junit-jupiter:5.9.3")
    // Appium
    testImplementation("io.appium:java-client:8.4.0")
    // AssertJ
    testImplementation("org.assertj:assertj-core:3.23.1")
}

tasks.test {
    useJUnitPlatform()
}
