// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.

package com.microsoft.applicationinsights.smoketest;

import static com.microsoft.applicationinsights.smoketest.EnvironmentValue.TOMCAT_8_JAVA_8;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.data.MapEntry.entry;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.RegisterExtension;

@Environment(TOMCAT_8_JAVA_8)
@UseAgent("query_parameters_applicationinsights.json")
class JdbcQueryParametersTest {

  @RegisterExtension static final SmokeTestExtension testing = SmokeTestExtension.create();

  @Test
  @TargetUri("/hsqldbPreparedStatement")
  void hsqldbPreparedStatementCapturesQueryParameters() throws Exception {
    Telemetry telemetry = testing.getTelemetry(1);

    assertThat(telemetry.rd.getProperties())
        .containsExactly(entry("_MS.ProcessedByMetricExtractors", "True"));
    assertThat(telemetry.rd.getSuccess()).isTrue();

    assertThat(telemetry.rdd1.getName()).isEqualTo("SELECT testdb.abc");
    assertThat(telemetry.rdd1.getData()).isEqualTo("select * from abc where xyz = ?");
    assertThat(telemetry.rdd1.getType()).isEqualTo("SQL");
    assertThat(telemetry.rdd1.getTarget()).isEqualTo("hsqldb | testdb");
    // Query parameters should be captured when captureQueryParameters is enabled
    assertThat(telemetry.rdd1.getProperties()).containsEntry("db.query.parameter.0", "y");
    assertThat(telemetry.rdd1.getSuccess()).isTrue();

    SmokeTestExtension.assertParentChild(
        telemetry.rd, telemetry.rdEnvelope, telemetry.rddEnvelope1, "GET /Jdbc/*");
  }
}