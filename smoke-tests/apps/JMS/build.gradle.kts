plugins {
  id("ai.smoke-test-jar")
}

dependencies {
  implementation("org.springframework.boot:spring-boot-starter-web:2.7.18")
  implementation("org.springframework.boot:spring-boot-starter-activemq:2.7.18")
  implementation("org.apache.httpcomponents:httpclient:4.5.13")
}
