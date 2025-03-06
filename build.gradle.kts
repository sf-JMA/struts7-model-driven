import java.net.URI

plugins {
    java
    id("org.springframework.boot") version "3.4.3"
    id("io.spring.dependency-management") version "1.1.7"
}

group = "com.steadforce.aek"
version = "0.0.1-SNAPSHOT"

java {
    toolchain {
        languageVersion = JavaLanguageVersion.of(21)
    }
}

repositories {
    mavenCentral()
    maven { url = URI("https://repository.apache.org/content/groups/snapshots/") }
}

dependencies {
    implementation("org.springframework.boot:spring-boot-starter-web")
    implementation("org.springframework.boot:spring-boot-starter-data-jpa")
    implementation("org.apache.struts:struts2-core:7.0.4-SNAPSHOT")
    implementation("org.apache.struts:struts2-spring-plugin:7.0.4-SNAPSHOT")
    implementation("org.apache.struts:struts2-convention-plugin:7.0.4-SNAPSHOT")

    runtimeOnly("jakarta.servlet:jakarta.servlet-api:6.1.0")
    runtimeOnly("org.apache.tomcat.embed:tomcat-embed-jasper")

    runtimeOnly("com.h2database:h2")

    testImplementation("org.springframework.boot:spring-boot-starter-test")
    testRuntimeOnly("org.junit.platform:junit-platform-launcher")
}

tasks.withType<Test> {
    useJUnitPlatform()
}
