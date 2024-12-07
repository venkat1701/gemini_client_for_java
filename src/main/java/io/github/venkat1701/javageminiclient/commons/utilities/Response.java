package io.github.venkat1701.javageminiclient.commons.utilities;

import io.github.venkat1701.javageminiclient.commons.utilities.response.ResponseBody;

import java.util.Map;

public interface Response {
    int getStatusCode();
    Map<String, String> getHeaders();
    ResponseBody getBody();
    boolean isSuccessfull();
    String getErrorMessage();
}
