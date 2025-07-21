plugins {
  id("ai.smoke-test-jar")
}

dependencies {
  implementation("org.springframework.boot:spring-boot-starter:2.7.18")

  // jetty 10 is compiled against Java 11
  implementation("org.eclipse.jetty:jetty-server:9.4.49.v20220914")
}
