<img width="1070" alt="GitHub Repo Cover" src="https://github.com/corbado/corbado-php/assets/18458907/aa4f9df6-980b-4b24-bb2f-d71c0f480971">

# Corbado Java SDK

[![License](https://img.shields.io/badge/license-MIT-green)](./LICENSE)
[![documentation](https://img.shields.io/badge/documentation-Corbado_Backend_API_Reference-blue.svg)](https://apireference.cloud.corbado.io/backendapi/)
[![Slack](https://img.shields.io/badge/slack-join%20chat-brightgreen.svg)](https://join.slack.com/t/corbado/shared_invite/zt-1b7867yz8-V~Xr~ngmSGbt7IA~g16ZsQ)

The [Corbado](https://www.corbado.com) Java SDK provides convenient access to the [Corbado Backend API](https://apireference.cloud.corbado.io/backendapi/) from applications written in the Java language.

:warning: The Corbado Java SDK is commonly referred to as a private client, specifically designed for usage within closed backend applications. This particular SDK should exclusively be utilized in such environments, as it is crucial to ensure that the API secret remains strictly confidential and is never shared.

:rocket: [Getting started](#rocket-getting-started) | :hammer_and_wrench: [Services](#hammer_and_wrench-services) | :books: [Advanced](#books-advanced) | :speech_balloon: [Support & Feedback](#speech_balloon-support--feedback)

## :rocket: Getting started

### Requirements

- Java 8 or later

### Installation

#### Gradle users

Add this dependency to your project's build file:

```groovy
implementation "com.corbado:corbado-java:1.0.0"
```

#### Maven users

Add this dependency to your project's POM:

```xml
<dependency>
  <groupId>com.corbado</groupId>
  <artifactId>corbado-java</artifactId>
  <version>1.0.0</version>
</dependency>
```

### Usage

To create a Corbado Java SDK instance you need to provide your `Project ID` and `API secret` which can be found at the [Developer Panel](https://app.corbado.com).

```Java
 final Config config = new Config(projectId, apiSecret);
 CorbadoSdk sdk = new CorbadoSDK(config);
```

### Examples

A list of examples can be found in the integration tests [here](/src/test/java/com/corbado/integration/).

## :hammer_and_wrench: Services

The Corbado Java SDK provides the following services:

- `sessions` for managing sessions ([example spring boot application](https://github.com/corbado/example-passkeys-java-spring-boot))
- `users` for managing users ([examples](/src/test/java/com/corbado/integration/UserServiceIT.java))
- `identifiers` for managing identifiers ([examples](/src/test/java/com/corbado/integration/IdentifierServiceIT.java))

To use a specific service, such as `users`, invoke it as shown below:

```Java
UserService users = sdk.getUsers();
``` 

## :books: Advanced

### Error handling

The Corbado Java SDK throws exceptions for all errors. The following exceptions are thrown:

- `CorbadoServerException` for server errors (server side)
- `StandardException` for everything else (client side)

If the Backend API returns a HTTP status code other than 200, the Corbado Java SDK throws a `CorbadoServerException`. The `CorbadoServerException`class parses the server response to access all important data. One of the test cases:
```Java
    UserService users = sdk.getUsers();
    final UserEntity user = TestUtils.createUser();
    users.delete(user.getUserID());
    final CorbadoServerException e =
        assertThrows(
            CorbadoServerException.class,
            () -> {
              final UserEntity ret = users.get(user.getUserID());
            });
    assertNotNull(e);
    assertEquals(400, e.getHttpStatusCode());
    assertEquals("does not exist", e.getValidationMessages().get(0).getMessage());
    assertEquals("userID", e.getValidationMessages().get(0).getField());
```
Take a look at the `CorbadoServerException` class, if you need get more information out of exception.


## :speech_balloon: Support & Feedback

### Report an issue

If you encounter any bugs or have suggestions, please [open an issue](https://github.com/corbado/corbado-java/issues/new).

### Slack channel

Join our Slack channel to discuss questions or ideas with the Corbado team and other developers.

[![Slack](https://img.shields.io/badge/slack-join%20chat-brightgreen.svg)](https://join.slack.com/t/corbado/shared_invite/zt-1b7867yz8-V~Xr~ngmSGbt7IA~g16ZsQ)

### Email

You can also reach out to us via email at vincent.delitz@corbado.com.

### Vulnerability reporting

Please report suspected security vulnerabilities in private to security@corbado.com. Please do NOT create publicly viewable issues for suspected security vulnerabilities.
