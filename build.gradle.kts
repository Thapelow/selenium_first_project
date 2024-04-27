plugins {
    id("java")
}

group = "org.example"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    implementation("org.seleniumhq.selenium:selenium-java:3.141.59")
    implementation("io.github.bonigarcia:webdrivermanager:5.8.0")
    implementation("org.slf4j:slf4j-simple:1.7.36")
    implementation("org.junit.jupiter:junit-jupiter:5.7.0")
    testImplementation("org.seleniumhq.selenium:selenium-chrome-driver:4.18.1")
    testImplementation("org.seleniumhq.selenium:selenium-support:4.4.0")

    testImplementation(platform("org.junit:junit-bom:5.10.0"))
    testImplementation("org.junit.jupiter:junit-jupiter")
}

tasks.test {
    useJUnitPlatform()
}
