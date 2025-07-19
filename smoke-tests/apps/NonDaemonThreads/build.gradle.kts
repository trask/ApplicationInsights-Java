plugins {
  id("ai.smoke-test-jar")
}

dependencies {
  implementation("org.springframework.boot:spring-boot-starter-web:2.7.18")
  implementation("com.squareup.okhttp3:okhttp:3.12.1")
}
