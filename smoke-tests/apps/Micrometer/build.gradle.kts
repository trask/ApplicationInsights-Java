plugins {
  id("ai.smoke-test-jar")
}

dependencies {
  implementation("org.springframework.boot:spring-boot-starter-web:2.7.18")
  implementation("io.micrometer:micrometer-core:1.4.1")
}
