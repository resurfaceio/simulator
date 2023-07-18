// © 2016-2023 Graylog, Inc.

package io.resurface.simulator;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.json.JsonMapper;

import java.util.List;

/**
 * Generates small batches of NDJSON messages.
 */
public interface Workload {

    /**
     * Adds one or more messages to the batch, or leaves the batch unchanged to stop.
     */
    void add(List<String> batch, Clock clock) throws Exception;

    /**
     * JSON content type header.
     */
    String CONTENT_TYPE_JSON = "application/json";

    /**
     * JSON object mapper.
     */
    ObjectMapper MAPPER = JsonMapper.builder().build();
}
