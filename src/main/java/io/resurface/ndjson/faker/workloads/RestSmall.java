// © 2016-2023 Resurface Labs Inc.

package io.resurface.ndjson.faker.workloads;

import com.fasterxml.jackson.databind.node.ObjectNode;
import com.github.javafaker.Faker;
import io.resurface.messages.HttpMessage;
import io.resurface.ndjson.faker.Workload;

import java.util.List;

/**
 * Generates small randomized REST messages.
 */
public class RestSmall implements Workload {

    /**
     * Adds a single message to the batch without any stop conditions.
     */
    public void add_to(List<String> batch) throws Exception {
        String user_token = faker.internet().uuid();

        HttpMessage m = new HttpMessage();
        m.set_request_method("GET");
        m.set_request_url(String.format("http://myapi.resurface.io/quotes/%s/", user_token));
        // todo add request body
        // todo add request headers
        ObjectNode response_body = MAPPER.createObjectNode();
        response_body.put("user_token", user_token);
        response_body.put("random_text", faker.lorem().paragraph(80));
        m.set_response_body(MAPPER.writeValueAsString(response_body));
        m.set_response_code("200");
        m.set_response_content_type(CONTENT_TYPE_JSON);
        // todo additional response headers

        batch.add(m.toString());
    }

    private final Faker faker = new Faker();

}
