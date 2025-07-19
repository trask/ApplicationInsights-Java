// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.

package com.microsoft.applicationinsights.telemetry;

import com.microsoft.applicationinsights.internal.schemav2.AvailabilityData;
import java.util.concurrent.ConcurrentMap;

/**
 * Telemetry type used to track availability test results in Azure Application Insights.
 * Represents the execution of an availability test (such as a web test or ping test)
 * and its outcome.
 */
public final class AvailabilityTelemetry extends BaseTelemetry {

  private final AvailabilityData data;

  /** Creates a new instance. */
  public AvailabilityTelemetry() {
    data = new AvailabilityData();
    initialize(data.getProperties());
  }

  /** 
   * Gets the unique identifier for this availability test instance.
   * 
   * @return the test instance ID
   */
  public String getId() {
    return data.getId();
  }

  /** 
   * Sets the unique identifier for this availability test instance.
   * 
   * @param id the test instance ID
   */
  public void setId(String id) {
    data.setId(id);
  }

  /** 
   * Gets the name of the availability test.
   * 
   * @return the test name
   */
  public String getName() {
    return data.getName();
  }

  /** 
   * Sets the name of the availability test.
   * 
   * @param name the test name
   */
  public void setName(String name) {
    data.setName(name);
  }

  /** 
   * Gets the duration of the availability test execution.
   * 
   * @return the test execution duration
   */
  public Duration getDuration() {
    return data.getDuration();
  }

  /** 
   * Sets the duration of the availability test execution.
   * 
   * @param duration the test execution duration
   */
  public void setDuration(Duration duration) {
    data.setDuration(duration);
  }

  /** 
   * Gets whether the availability test passed or failed.
   * 
   * @return true if the test passed, false otherwise
   */
  public boolean getSuccess() {
    return data.getSuccess();
  }

  /** 
   * Sets whether the availability test passed or failed.
   * 
   * @param success true if the test passed, false otherwise
   */
  public void setSuccess(boolean success) {
    data.setSuccess(success);
  }

  /** 
   * Gets the location from which the availability test was executed.
   * 
   * @return the test execution location
   */
  public String getRunLocation() {
    return data.getRunLocation();
  }

  /** 
   * Sets the location from which the availability test was executed.
   * 
   * @param runLocation the test execution location
   */
  public void setRunLocation(String runLocation) {
    data.setRunLocation(runLocation);
  }

  /** 
   * Gets the message associated with the availability test result.
   * 
   * @return the test result message
   */
  public String getMessage() {
    return data.getMessage();
  }

  /** 
   * Sets the message associated with the availability test result.
   * 
   * @param message the test result message
   */
  public void setMessage(String message) {
    data.setMessage(message);
  }

  /** 
   * Gets a map of custom defined metrics.
   * 
   * @return the custom metrics map
   */
  public ConcurrentMap<String, Double> getMetrics() {
    return data.getMeasurements();
  }

  @Override
  protected AvailabilityData getData() {
    return data;
  }
}
