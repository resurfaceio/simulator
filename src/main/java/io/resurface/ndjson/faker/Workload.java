// © 2016-2023 Resurface Labs Inc.

package io.resurface.ndjson.faker;

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
    void add_to(List<String> batch) throws Exception;

    /**
     * JSON content type header.
     */
    String CONTENT_TYPE_JSON = "application/json";

    /**
     * JSON object mapper.
     */
    ObjectMapper MAPPER = JsonMapper.builder().build();
}
