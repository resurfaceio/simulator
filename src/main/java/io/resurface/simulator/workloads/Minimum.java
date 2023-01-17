// © 2016-2023 Resurface Labs Inc.

package io.resurface.simulator.workloads;

import io.resurface.ndjson.HttpMessage;
import io.resurface.simulator.Clock;
import io.resurface.simulator.Workload;

import java.util.List;

/**
 * Generates static messages with the minimum number of required fields, as documented here: https://resurface.io/docs#capturing-api-calls
 */
public class Minimum implements Workload {

    /**
     * Adds a single message to the batch without any stop conditions.
     */
    public void add(List<String> batch, Clock clock) throws Exception {
        HttpMessage m = new HttpMessage();
        m.set_request_method("GET");
        m.set_request_url("http://myurl");
        m.set_response_code("200");
        m.set_response_time_millis(clock.now());
        batch.add(m.toString());
    }

}
