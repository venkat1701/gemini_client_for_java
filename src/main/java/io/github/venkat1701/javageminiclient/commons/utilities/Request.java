package io.github.venkat1701.javageminiclient.commons.utilities;

import io.github.venkat1701.javageminiclient.commons.utilities.request.RequestBody;

import java.util.Map;

public interface Request {

    String getURI();
    Map<String, String> getHeaders();
    RequestBody getBody();
    String getMethod();
    boolean validate();
    String getEndpoint();
}
