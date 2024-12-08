

# Chat API Client for Java

[![License](https://img.shields.io/badge/license-MIT-blue.svg)](LICENSE)
[![Build Status](https://img.shields.io/badge/build-passing-brightgreen.svg)](#)
[![Java Version](https://img.shields.io/badge/java-17%2B-orange.svg)](https://www.oracle.com/java/)

A lightweight and flexible Java library for constructing, sending, and handling HTTP requests and responses to chat-based APIs. This library is designed to simplify interaction with RESTful services, with features like request validation, response parsing, and extensibility.

## Features

- **Encapsulation of HTTP Requests**: Easily build HTTP requests with methods, headers, parameters, and body.
- **Response Parsing**: Simplified parsing of response data using JSON mapping.
- **Validation**: Automatic request validation based on method and content.
- **Immutable Constructs**: Use of unmodifiable maps for headers and parameters.
- **Extensibility**: Designed with interfaces like `Request` and `Response` to enable extensible implementations.

## Installation

You can include the library in your project by cloning this repository or using the provided JAR file.

### Requirements

- Java 11 or higher
- Dependencies:
  - [Jackson Databind](https://github.com/FasterXML/jackson-databind)

### Adding dependency to your Project
Add Jitpack repository to your project.
```maven
<repositories>
  <repository>
    <id>jitpack.io</id>
    <url>https://jitpack.io</url>
  </repository>
</repositories>
```
and then add the dependency 
```maven
<dependency>
  <groupId>io.github.venkat1701</groupId>
  <artifactId>gemini_client_for_java</artifactId>
  <version>1.0.0</version>
</dependency>
```

## Usage
```java
public class ChatModelExample {
    public static void main(String[] args) {
        // Step 1: Build the ChatRequest
        ChatRequest request = new ChatRequest(
                "https://api.example.com/generate", // API URL
                "YOUR_API_KEY",                    // API Key
                new RequestBody("{ \"prompt\": \"Generate some meaningful content.\" }") // Request Body
        ).withHeader("Content-Type", "application/json");

        // Step 2: Execute the Request
        try {
            ChatModel chatModel = new ChatModel(new RestTemplate(), new BasicRequestValidator());

            // Validate the request before execution
            if (!request.validate()) {
                throw new IllegalArgumentException("Invalid request parameters");
            }

            ChatResponse response = chatModel.call(request);

            // Step 3: Handle the Response
            if (response.isSuccessfull()) {
                // Extract and process the body content
                String rawJson = response.getBody().getContent();
                System.out.println("Raw Response: " + rawJson);

                // Parse the response using Gson or another library
                Gson gson = new Gson();
                ResponseData parsedData = gson.fromJson(rawJson, ResponseData.class);

                System.out.println("Parsed Response: " + parsedData);
            } else {
                System.err.println("API call failed with status: " + response.getStatusCode());
            }
        } catch (Exception e) {
            // Step 4: Handle Exceptions
            System.err.println("An error occurred: " + e.getMessage());
        }
    }
}
```

### Advanced Usage

#### Custom Request/Response Implementations
You can create custom implementations of the `Request` and `Response` interfaces to extend the library's functionality for specialized use cases.

## API Documentation

### `ChatRequest`
- `getURI()`: Returns the URI of the request.
- `getHeaders()`: Returns an unmodifiable map of request headers.
- `getMethod()`: Returns the HTTP method.
- `validate()`: Validates the request based on its method type.
- `withHeader(String key, String value)`: Adds a new header to the request.
- `withParameter(String key, String value)`: Adds a new parameter to the request.

### `ChatResponse`
- `getStatusCode()`: Returns the HTTP status code.
- `getHeaders()`: Returns an unmodifiable map of response headers.
- `getBody()`: Returns the response body.
- `isSuccessfull()`: Checks if the request was successful.

## Contributing

We welcome contributions! To contribute:

1. Fork the repository.
2. Create a new branch (`git checkout -b feature/your-feature`).
3. Commit your changes (`git commit -m 'Add your feature'`).
4. Push to the branch (`git push origin feature/your-feature`).
5. Open a pull request.

## License

This project is licensed under the MIT License - see the [LICENSE](LICENSE) file for details.

## Author

**Venkat**
- Email: [krishjaiswal1701@gmail.com](mailto:krishjaiswal1701@gmail.com)
- LinkedIn: [Krish Jaiswal](https://linkedin.com/in/jaiswal-krish)

---

Feel free to edit and add more sections as per your preferences!