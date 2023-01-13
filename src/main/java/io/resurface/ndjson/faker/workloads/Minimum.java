// © 2016-2023 Resurface Labs Inc.

package io.resurface.ndjson.faker.workloads;

import io.resurface.messages.HttpMessage;
import io.resurface.ndjson.faker.Workload;

import java.util.List;

/**
 * Generates static messages with the minimum number of required fields, as documented here: https://resurface.io/docs#capturing-api-calls
 */
public class Minimum implements Workload {

    /**
     * Create static message to use each time.
     */
    public Minimum() {
        HttpMessage m = new HttpMessage();
        m.set_request_method("GET");
        m.set_request_url("http://myurl");
        m.set_response_code("200");
        cached = m.toString();
    }

    private final String cached;

    /**
     * Adds a single message to the batch without any stop conditions.
     */
    public void add_to(List<String> batch) throws Exception {
        batch.add(cached);
    }

}
