// © 2016-2023 Graylog, Inc.

package io.resurface.simulator.workloads;

import com.fasterxml.jackson.databind.node.ObjectNode;

/**
 * Generates large randomized REST messages.
 */
public class RestLarge2 extends RestSmall2 {

    @Override
    ObjectNode get_request_body() throws Exception {
        ObjectNode b = super.get_request_body();
        b.put("api_token", faker.random().hex(512));
        b.put("public_key", faker.random().hex(2048));
        return b;
    }

    @Override
    ObjectNode get_response_body() throws Exception {
        ObjectNode b = super.get_response_body();
        b.put("one_time_key", faker.random().hex(2048));
        b.put("contract_plaintext", faker.lorem().paragraph(35));
        return b;
    }

}
