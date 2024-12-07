package io.github.bhavuklabs.javageminiclient;

import io.github.bhavuklabs.javageminiclient.basic.BasicRequestValidator;
import io.github.bhavuklabs.javageminiclient.commons.exceptions.ValidationException;
import io.github.bhavuklabs.javageminiclient.commons.prompt.RequestPrompt;
import io.github.bhavuklabs.javageminiclient.commons.utilities.commons.Content;
import io.github.bhavuklabs.javageminiclient.commons.utilities.commons.Part;
import io.github.bhavuklabs.javageminiclient.commons.utilities.request.RequestBody;
import io.github.bhavuklabs.javageminiclient.models.ChatModel;
import io.github.bhavuklabs.javageminiclient.request.ChatRequest;
import io.github.bhavuklabs.javageminiclient.response.ChatResponse;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        ChatModel chatModel = new ChatModel(new RestTemplate(), new BasicRequestValidator());
        Part<String> part = new Part<>(new RequestPrompt<>("Hello, can you assist me?"));
        Content content = new Content(List.of(part));
        RequestBody requestBody = new RequestBody(List.of(content));
        // Configure the request
        ChatRequest chatRequest = new ChatRequest(
                "https://generativelanguage.googleapis.com/v1beta/models/gemini-1.5-flash:generateContent?key=",
                "API KEY",
                requestBody
        ).withHeader("Content-Type", "application/json");
        try {
            ChatResponse chatResponse = chatModel.call(chatRequest);
            System.out.println(chatResponse. getBody());
        } catch (Exception | ValidationException e) {
            System.out.println(Arrays.toString(e.getStackTrace()));
            System.err.println("Error: " + e. getMessage());
        }
    }
}