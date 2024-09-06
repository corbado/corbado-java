# Introduction

APIs are core components in communication between services in modern software, and the OpenAPI Specification has become the go-to standard for defining them. But while building an API might seem straightforward, offering a smooth developer experience often depends on the availability of SDKs (Software Development Kits). SDKs simplify API integration by providing pre-built, language-specific libraries that developers can use to interact with APIs more efficiently.

Creating and maintaining SDKs manually for multiple programming languages can quickly become a time-consuming task. That's where automating the process as much as possible comes in handy. By leveraging the OpenAPI standard, you can automate the generation of SDKs, reducing maintenance time and ensuring consistency across different platforms.

In this guide, we’ll focus on how to build a **Java SDK** based on an OpenAPI specification. By the end of this tutorial, you’ll have a clear understanding of the following:

-   How to build a Java SDK based on an OpenAPI specification?

-   What are the necessary steps to go from an OpenAPI file to a full functional, deployable Java SDK?

-   What are the best practices for building and maintaining SDKs?

We'll use Corbado’s passkey-first Java SDK as an example, guiding you through the practical steps and considerations involved in creating a professional, user-friendly SDK.

# 2. Use an API Generator to Create a Client

1.  First we use the OpenAPI generator to generate a client SDK from OpenAPI specification.Ideally, it should be moved to a separate project as a dependency to simplify dependency management. This is particularly important since OpenAPI-generated code may include dependencies that you might not want in your main project. For example, the OpenAPI generator for Python will use Pydantic and have it as a dependency that you may not want to have. Alternatively, move it to a designated folder.

    1.  Avoid modifying the generated code

    2.  Try not to expose the generated code to the outer world in the case you want to decouple your generated code from an SDK interface and to hide complexity.

The first step in building a Java SDK from an OpenAPI specification is to use an **OpenAPI generator** to create a client SDK. The OpenAPI generator simplifies the process by automatically generating client-side code that interacts with your API.

Ideally, the generated client SDK should be placed in a **separate project or repository**. This ensures clean separation from your main application, helping to simplify dependency management. Generated SDKs often include third-party libraries that might not align with the dependencies used in your core project. For instance, when generating a Python SDK, the OpenAPI generator includes dependencies like Pydantic, which may not be required in your main project. By isolating the SDK into its own repository or folder, you avoid cluttering your core codebase with unnecessary dependencies.

#### **Best Pracitce: Avoid Modifying Generated Code**

It’s best practice to **avoid manually modifying the generated code**. Once you start editing the generated SDK code, it becomes difficult to keep up with future updates or regenerate the SDK when your OpenAPI specification changes. Instead, any custom functionality should be built on top of the generated code, not directly within it.

You can also add automation around this process by using scripts to generate the SDK. For example, a simple script can call the OpenAPI generator and handle any necessary folder management automatically. This ensures consistency across builds, which is crucial when working with different environments or teams.

*[Code snippet “OPENAPI SKRIPT GENERATOR”]*

If you're concerned about exposing the complexities of the generated code to developers, **decouple** the generated code from your SDK interface. This way, the complexity remains hidden, and your SDK provides a clean, simple interface for developers to use.

By generating the client SDK and isolating it from your core project, you streamline both development and future maintenance. You also ensure that the SDK remains easy to update and integrate without breaking your main codebase.

# 3. Understand the Functionality,structure and Tests of Existing Corbado SDKs

-   For the sake of the tutorial, we take a look at Corbado’s existing SDKs which serve as role model

-   First, we try to understand how this SDK will be later used in production by external developers. Therefore, the following use cases exist:

    -   Session validation

    -   Extracting more user information

1.  What is the purpose of the SDK? How does it benefit the user compared to a simple generated client?

    1.  The SDK should provide a simple, easy to install, configure and understand library to connect to the Corbado backend with meaningful error handling.

        1.  Have simple examples for the available functionality (at least in form of unit tests) .

        2.  Lower the entry barrier for new developers or developers wanting to try out the Corbado Passkeys.

    2.  Familiarize yourself with JWT/JWK concepts and JWT usage in other SDKs.

        1.  You can start your reading here: [JSON Web Token Introduction - jwt.io](https://jwt.io/introduction)

        2.  Search for available JWT libraries for your language. Example: [JSON Web Token Libraries - jwt.io](https://jwt.io/libraries?language=Java)

        3.  How is the JWT validation implemented? [Java JWT Validation code snippet]

        4.  What is being tested in test classes and why? Take a look at the [unit test for session service in Java SDK](https://github.com/corbado/corbado-java/blob/main/src/test/java/com/corbado/unit/SessionServiceTest.java).

        5.  How session service is being used in an example application. [Code snippet Spring Boot request mapping profile]

    3.  How are errors handled?

        1.  CorbadoServerException for server errors (server side) if the Backend API returns a HTTP status code other than 200. It also deserialize the error response to make the additional error information more accessible: [screenshot with example of the try catch block and which information can be accessed from the exception]

        2.  StandardException for everything else (client side)

        3.  JWTVerificationException and its subclasses and JwkException in session service for JWT/JWK errors.

    4.  What parts of inputs are being validated? How can you implement this validation in your language in the most effective/clean way.

        1.  The SDK is trying to validate as much information as possible on the client side.

            1.  URL validation

            2.  Basic constraints on string (e.g. userId cannot be empty)

            3.  Configuration validation (e.g. projectId and apiSecret should begin with “pro-” and “corbado1_” respectfully)

When building a Java SDK from an OpenAPI specification, it’s important to first familiarize yourself with existing SDKs that can serve as role models (if they exist - in other cases you need to define the requirements for the SDK). In this section, we’ll examine Corbado’s existing SDKs to understand their structure, purpose, and how they are used in production by external developers.

#### **Key Use Cases: Session Validation and User Information Extraction**

To better grasp how your SDK will be used in real-world applications, it’s crucial to understand the typical use cases. For Corbado’s SDKs, two key scenarios include **session validation** and **extracting additional user information**. These features are important for developers integrating user authentication into their applications.

#### **Purpose of the SDK: Why Not Just Use a Generated Client?**

The goal of the SDK is to provide more than just a generated client. While a simple client offers basic API interaction, a well-built SDK enhances the developer experience by offering:

-   A **simple, easy-to-install** library for connecting to the backend.

-   Meaningful **error handling**, making it easier for developers to debug and resolve issues.

-   **Easy configuration**, allowing developers to get started with minimal friction.

-   Clear, documented **examples** for all available functionality (often provided through unit tests).

-   A lower entry barrier for developers trying out the service for the first time.

#### **JWT/JWK Handling and Validation**

An essential part of building the Corbado SDK is understanding how JSON Web Tokens (JWT) and JSON Web Keys (JWK) are handled, as these are used for **session validation**. You’ll want to:

-   **Familiarize yourself with JWT/JWK concepts**

-   Search for available JWT libraries for **Java** (or the specific language of your SDK).

In Corbado’s SDK, **JWT validation** is important. For example, session services often validate tokens to ensure they are correctly signed and authorized. It’s helpful to review how this is implemented in Corbado’s existing SDKs, especially the error handling and structure.

Example: A JWT validation process could include validating the signature, checking token expiration, and handling JWK errors with custom exceptions like JWTVerificationException or JwkException.

Providing clear **unit tests** for valid and invalid tokens can demonstrate how these validations work in practice. This not only ensures robustness but also offers developers a clear example of how to handle JWTs in their applications.

#### **Handling Errors in the SDK**

Error handling is crucial to any SDK, and Corbado’s SDKs provide meaningful error responses that make it easier for developers to understand what went wrong. Some of the key exceptions include:

-   **CorbadoServerException**: Thrown when the backend API returns an HTTP status code other than 200, this exception includes deserialized error responses, making additional error information easily accessible.

-   **StandardException**: Used for client-side errors, unrelated to the backend.

-   **JWTVerificationException and JwkException**: Specific to session validation errors related to JWT or JWK.

By providing **robust error handling**, the SDK improves the developer experience, making it clear where an issue arises and how it can be resolved.

#### **Implementing Client-Side Validation**

The SDK also takes care of validating input on the client side to avoid sending invalid data to the server. Common validations include:

-   **URL validation**: Ensuring that provided URLs follow the correct format.

-   **String constraints**: For instance, ensuring that user IDs are not empty.

-   **Configuration validation**: Certain fields, like projectId and apiSecret, should follow specific patterns (e.g., projectId starting with "pro-" and apiSecret starting with "corbado1_").

These validations help prevent common mistakes and improve the reliability of integrations, making the SDK more developer-friendly.

# **4. Identify Best Practices for Your Language**

1.  How should you structure the project to make it standalone and easily importable for users? Examples:

    1.  For Java: [sombriks/how-to-structure-java-projects: sampling some project layouts to present in this article (github.com)](https://github.com/sombriks/how-to-structure-java-projects)

        1.  For Python: [nedbat/pkgsample: A simple example of how to structure a Python project (github.com)](https://github.com/nedbat/pkgsample)

    2.  Use modern formatters and linters for your language to ensure your code is structured, standardized, and more readable. Clean code is crucial, especially in a small project, and these tools can help maintain it.

        1.  For Python I have used:

            1.  Pylance

            2.  Mypy

            3.  flake8 with additional plugins

            4.  isort

            5.  Black Formatter

        2.  For Java I have used:

            1.  Checkstyle with Google Java Style

            2.  SonarLint

            3.  Findbugs

            4.  [google-java-format](https://github.com/google/google-java-format)

When building an SDK, following best practices for project structure and code quality is essential to ensure that your library is easy to use, maintain, and integrate. Below are key recommendations for structuring your SDK project and maintaining clean, readable code, with specific examples for Java and Python.

#### **Structuring Your Project for Ease of Use**

A well-structured project is crucial for making your SDK standalone and easily importable by other developers. Regardless of the language you are working in, the project structure should be intuitive and adhere to community standards. Here are examples for Java and Python:

-   **For Java**: Look at the <https://github.com/sombriks/how-to-structure-java-projects>[sombriks/how-to-structure-java-projects](https://github.com/sombriks/how-to-structure-java-projects) repository on GitHub, which provides sample project layouts that follow best practices. Organizing your SDK into modular components with clear directory structures helps developers navigate the code more easily and import your SDK without hassle.

-   **For Python**: A similar resource can be found in the <https://github.com/nedbat/pkgsample>[nedbat/pkgsample](https://github.com/nedbat/pkgsample) repository on GitHub. It demonstrates how to structure a Python project in a way that simplifies packaging and importing for users.

#### **Use Modern Formatters and Linters**

To maintain clean, standardized code, it’s important to use modern formatters and linters. These tools ensure that your code adheres to established guidelines, making it more readable, consistent, and less prone to errors. Below are recommendations for both Java and Python:

-   **For Python**:  
    Using formatters and linters is crucial for ensuring Python code remains clean and readable. Common tools include:

    -   **Pylance**: A language server for Python that provides type checking and intelligence.

    -   **Mypy**: A static type checker for Python, useful for catching type errors.

    -   **flake8**: A linter that checks your Python code against style guides, with additional plugins for enhanced functionality.

    -   **isort**: Automatically sorts your imports, maintaining clean and organized import statements.

    -   **Black Formatter**: An opinionated code formatter that ensures code is automatically formatted to meet PEP 8 standards.

-   **For Java**:  
    Java projects benefit from tools that enforce best practices and formatting rules. Some commonly used tools include:

    -   **Checkstyle with Google Java Style**: Ensures your code follows Google’s Java style guidelines.

    -   **SonarLint**: Identifies potential bugs and code smells in your Java code, improving overall code quality.

    -   **FindBugs**: Detects potential issues in Java code that could lead to bugs.

    -   **google-java-format**: A tool that reformats your code according to Google’s Java style, ensuring a clean, consistent codebase.

#### **Keep Code Clean and Maintainable**

Clean code is critical for any SDK, but it becomes even more important in smaller projects where every line of code has the potential to impact usability and maintainability. Using formatters and linters not only improves readability but also makes it easier for other developers to contribute to the project and ensures your SDK remains future-proof.

# 5. Identify Best Practices and Established Coding Standards for SDK Development

:

1.  Look at similar projects, like Stripe, to understand what and how they implement their SDKs. As example, I have learned:

    1.  How to make a basic CI/CD structure.

        1.  What do they test in CI/CD.

            1.  Language version compatibility.

            2.  Lint.

            3.  Code static analysis and more.

        2.  How I can improve my README.

        3.  Used some of the linters/formatters they are using.

        4.  How they structure their project.

    2.  Examples:

        1.  I have learned that Stripe is using Builder Pattern for client configuration class. It often makes sense for Java if there are a lot of optional parameters.

        2.  I have also used similar project structure, project configuration tools/files and linters from their Python SDK.

#### **Learning from Established SDKs**

To build a robust SDK, look at how established companies approach SDK development. For example, Stripe is known for having one of the most well-documented and widely used SDKs across multiple languages. Studying their approach can teach you the following:

-   **CI/CD Structure**: Stripe uses an efficient continuous integration and continuous delivery (CI/CD) pipeline to automate tests and deployment. Understanding their setup can help you build a basic CI/CD structure that ensures your SDK is always tested and ready for production.

-   **What to Test in CI/CD**: By observing what major SDKs like Stripe include in their test suite, you’ll learn what is critical for ensuring compatibility, such as unit tests, integration tests, and API contract validation. Testing should cover core functionality, edge cases, and backward compatibility.

-   **Language Version Compatibility**: Ensuring compatibility with multiple versions of your target language is essential for a widely used SDK. For instance, you might support both Java 8 and newer versions or Python 3.7 and above, depending on user requirements.

-   **Linting and Code Static Analysis**: Stripe implements strict linting and code static analysis to maintain high code quality. Tools like **Checkstyle** for Java or **flake8** for Python can be integrated into your CI pipeline to catch potential issues before they reach production.

#### **Code and Project Structure**

Examining how SDKs like Stripe structure their projects can give you insights into creating a clean, modular project architecture. For example, in Java, Stripe uses the **Builder Pattern** for their client configuration classes, which is particularly useful when dealing with many optional parameters. This pattern ensures that your SDK’s API remains flexible while maintaining readability and simplicity for developers. If your SDK has configuration-heavy components, adopting this pattern might be ideal.

Additionally, for Python SDKs, Stripe’s use of project configuration tools and a standardized project layout is something to emulate. They ensure that the structure is modular and easy for developers to follow, with a clear separation of concerns between different components.

#### **Documentation Best Practices**

One of the key takeaways from analyzing successful SDKs is the importance of **comprehensive and accessible documentation**. The README file is often the first interaction a developer has with your SDK, so it should include:

-   **Clear setup instructions**: How to install and configure the SDK with minimal friction.

-   **Code examples**: Demonstrating core use cases, such as authentication, session handling, and error management.

-   **Links to further documentation**: For developers who need more detailed instructions or wish to explore advanced use cases.

Stripe’s SDK READMEs are known for being concise, clear, and actionable, making it easy for developers to get started quickly. Consider including similar detailed examples in your README to reduce the learning curve for your SDK.

#### **Adopting Linters, Formatters, and Tools**

Finally, learning from these established SDKs also involves adopting the same tools that they use for code quality and maintenance. Stripe’s use of formatters and linters in both Java and Python ensures their code remains clean, readable, and consistent across large codebases. By using similar tools in your SDK, you can achieve the same level of professionalism and reliability.

-   For **Java**, using tools like **Checkstyle**, **SonarLint**, and **Findbugs** helps maintain code quality.

-   For **Python**, adopting **flake8**, **Black Formatter**, and **Mypy** ensures that your code adheres to Python’s best practices.

By leveraging these industry-standard tools, you ensure that your SDK remains high-quality, maintainable, and developer-friendly.

# 6. Determine Your Technology Stack and Useful Libraries

:

1.  Technology stack you need define:

    1.  Supported language version (Java 8 and above?)

        1.  Build Tools (Maven or Gradle?)

        2.  Dependency Management and Package Distribution (Maven Central or JCenter?)

        3.  HTTP Client Library

        4.  JSON Parsing (Jackson or Gson?)

        5.  Logging (SLF4J with Logback or Log4j?)

        6.  Testing (Junit? Maybe you need Mockito?)

        7.  Documentation (Javadoc, Markdown)

        8.  CI/CD (GitHub Actions, Jenkins, or Travis CI?)

        9.  Optional Tools (lombok)

    2.  Again, you can examine the code and libraries and technologies used in new and popular projects for your language to help you with your technology stack.

        1.  I have seen that Stripe is using the lombok library to reduce boilerplate code for Java SDK.

        2.  I took a look at

            1.  which dependencies do other projects have

            2.  what are they being used for (may be you will find another logger implementation that suits your needs better)

        3.  At which stages those dependencies are being used. (runtime, compile time, test)

    3.  The SDK should be runnable on most used versions of the used language. The other modern established projects will often mention which versions of the language are supported and why. Make research on the current state of the language.

        1.  As of September 2024 for Python according to [statistics](https://w3techs.com/technologies/history_details/pl-python/3) a lot of websites are still using python 3.6 and 3.7. But that may not be not the versions you want to support if you take into consideration

            1.  which projects would want to use passkeys (probably rather modern than legacy systems)

            2.  older versions do not have security support

            3.  other dependencies you may want to include could (and often will) end the support of EOL language versions.

            4.  You may miss important language features like typing support for Python that will make your code safer and easier to maintain/understand.

        2.  But you could have different opinion on Java versions

            1.  It has much better long term support

            2.  A lot of established systems are still using Java 8, even new projects.

            3.  Java has a strong backwards compatibility.

        3.  Conclusion: you need to make a weighted descition

    4.  Which package manager/project configuration/description/metadata tools do you want to use (if there is one)?

        1.  For example, do you prefer Gradle over Maven?

            1.  I have picked Maven, because I am more familiar with it. It is an already well established tool, I do not need the custom build logic feature of Gradle and its faster build time is not going to be so impactful for a small library.

        2.  Or maybe a lot of established projects are using setup.py to build for a variety of reasons but it will be deprecated soon for pyproject.toml [Is setup.py deprecated? - Python Packaging User Guide](https://packaging.python.org/en/latest/discussions/setup-py-deprecated/).

        3.  Are there any libraries that can speed up your development or improve code readability? As example:

            1.  Lombok in Java can reduce boilerplate code:

                1.  Use annotations to generate getters, setters at compile time.

                2.  Generate Builder on a class with single annotation.

                3.  Generate Constructors.

                4.  Null check with annotations.

            2.  Pydantic can improve typing support for Python, validation and code readability. I have used Pydantic for:

                1.  Type Enforcement.

                2.  Custom Validation**:** By defining custom validation rules for fields using Pydantic’s validator functions.

                3.  Type Annotations for cleaner, more expressive code.

                4.  Data Classes.

    5.  Be cautious with your dependencies.

        1.  The user may not want to have them in their projects.

        2.  Take compatibility and security concerns into account.

            1.  Dependency may support only newer or older versions of the language.

            2.  There may be security vulnerabilities in the version of the dependency you decide to use that your users may not want.

        3.  Separate test, compile and runtime dependencies.

            1.  For example in Maven use \<scope\> and \<target\>

Building an SDK requires selecting the right libraries to ensure compatibility, maintainability, and ease of use. The stack you choose will directly affect how well your SDK integrates into other projects and how easy it is for developers to adopt it. Let’s break down the key components you’ll need to consider based on the insights gathered from previous sections and established best practices.

#### **Supported Language Version**

When developing an SDK, one of the first decisions is which **language versions** to support. For Java, supporting **Java 8 and above** is a common choice, as it remains widely used, with strong backward compatibility. However, depending on your target audience and project goals, you may decide to also support newer versions like Java 11 or 17, which introduce useful language features and performance improvements.

For Python, the landscape is slightly different. While many websites still use **Python 3.6 or 3.7**, it may not make sense to support these older versions if your SDK is designed for **modern systems**. Python 3.8+ introduces helpful features like enhanced typing, making the SDK easier to maintain and more secure. Ultimately, your decision should balance **modern features** with broad compatibility.

#### **Build Tools and Dependency Management**

For **Java**, the two main build tools to consider are **Maven** and **Gradle**. Both are widely used, but your choice depends on the specific needs of your SDK:

-   **Maven**: If you're more familiar with Maven and don't need custom build logic, it’s a solid, well-established option. Maven is known for its simplicity, strong dependency management, and extensive ecosystem. It integrates easily with package distribution platforms like **Maven Central**.

-   **Gradle**: Offers more flexibility and faster build times, especially for larger projects. It can be useful if your SDK requires more advanced build customizations or if you prioritize build performance.

For Python, you'll likely use **pyproject.toml** moving forward, as it’s becoming the standard for Python packaging, replacing the older **setup.py** format.

#### **HTTP Client and JSON Parsing**

Your SDK will need a reliable **HTTP client** to interact with APIs. For Java, consider **HttpClient** from the standard library or popular libraries like **OkHttp** if you need more flexibility.

For **JSON parsing**, both **Jackson** and **Gson** are widely used in Java. **Jackson** is often favored for its extensive features and performance, while **Gson** is lighter and simpler to use. If your SDK needs advanced serialization features or works with complex JSON structures, Jackson is likely the better choice.

#### **Logging and Error Handling**

For logging, Java developers often choose between **SLF4J with Logback** or **Log4j**. SLF4J provides an abstraction layer that allows you to switch between logging implementations without changing your code. Coupled with **Logback**, it offers high performance and flexibility. **Log4j** is another solid option but has become less popular due to past security vulnerabilities.

When handling errors, it's important to consider how your SDK will interact with external systems. For example, using a custom exception like CorbadoServerException can provide meaningful error messages when something goes wrong during API calls. This is especially useful when developers need to debug integrations with your SDK.

#### **Testing Frameworks**

Testing is critical to maintaining the reliability of your SDK. For **Java**, tools like **JUnit** and **Mockito** are standard for unit testing and mocking. JUnit provides a simple, structured way to write tests, while Mockito allows you to mock objects in tests, which is particularly useful for API-driven SDKs where you need to simulate API responses.

For **Python**, common testing tools include **pytest** and **unittest**. Both are widely adopted and allow for writing clear, concise tests. If you’re incorporating type hints, consider using **Mypy** to enforce type checking in your tests.

#### **CI/CD Integration**

Continuous integration and delivery (CI/CD) are essential for ensuring that your SDK is always deployable and free of bugs. Popular options include:

-   **GitHub Actions**: Integrated into GitHub, making it a convenient option if your SDK is hosted there. It’s flexible, highly customizable, and free for open-source projects.

-   **Jenkins**: A self-hosted solution that provides more control but requires additional setup and maintenance.

-   **Travis CI**: A cloud-based CI/CD service that’s particularly popular with open-source projects.

Whichever you choose, make sure your pipeline includes automated testing, linting, and code analysis.

#### **Optional Tools**

Certain libraries can improve development efficiency and reduce boilerplate code:

-   **Lombok (Java)**: This library can greatly reduce boilerplate code by automatically generating getters, setters, constructors, and builders at compile time using annotations. For example, the **Builder Pattern** can simplify client configuration by handling optional parameters cleanly.

-   **Pydantic (Python)**: If you’re working in Python, **Pydantic** offers strong typing support, validation, and more readable code. It allows you to define data models with type enforcement and custom validation rules, making the SDK more robust.

#### **Dependency Management**

Managing dependencies is a key aspect of maintaining a clean, lightweight SDK. Avoid adding unnecessary dependencies, as they can bloat your package and potentially introduce security vulnerabilities. Be mindful of separating **compile-time**, **runtime**, and **test dependencies**. For example, in Maven, use the \<scope\> tag to define when a dependency is required.

Make sure that the libraries you include are widely used and well-maintained. For instance, in Java, libraries like **Jackson** or **SLF4J** are widely trusted, while for Python, libraries like **requests** for HTTP interactions and **pytest** for testing are safe bets.

#### **Security and Compatibility Concerns**

When selecting libraries, also take into account **security vulnerabilities** and **version compatibility**. For example, older versions of dependencies may no longer receive security updates, which can introduce risks to your users. Be cautious with which versions of dependencies you support and ensure that your SDK runs on the most commonly used versions of the language.

#### **Making a Weighted Decision**

Ultimately, the decisions you make about your technology stack should reflect the balance between **compatibility**, **modern language features**, and **developer experience**. For instance, while Java 8 may still be popular, newer versions of Java introduce features that make code safer and easier to maintain. Similarly, while Python 3.6 and 3.7 are still in use, supporting only Python 3.8+ could be a better long-term decision for a modern SDK like Corbado’s Passkeys.

**CI/CD:**

1.  The SDK should be compatible with most used versions of the language. CI/CD can easily do that with matrix feature that allows you to run multiple jobs in parallel with different configurations.[here screenshot for an example]

    1.  This often helps identify compatibility or configuration issues that may not be apparent locally if the build or tests are failing.

    2.  Simplify the deployment process for other developers.

        1.  After build, lint and test you can choose to deploy the application on some events (for example on version tag in Java and Python SDK). No extra steps needed. For Java I needed to:

            1.  [Register](https://central.sonatype.org/register/central-portal/#change-my-full-name-email-address-or-password) at Central Portal.

            2.  Create a GPG Key to sign the build.

            3.  Create a deployment job in the Github Actions workflow.

            4.  Make sure the projects comply with [Central requirements](https://central.sonatype.org/publish/requirements/#supply-javadoc-and-sources).

            5.  Follow Centrals [publishing guide for Maven](https://central.sonatype.org/publish/publish-portal-maven/)

            6.  Configure GPG ![](17258578ab655e51be873e16807ed344.png)

            7.  Make a temporary Maven set up (needed by central publishing plugin)![](64833a817a1225c4e7d0479543b4f53a.png)

            8.  Sign and publish the artifact ![](1f874051e7aef9cede1f7833550b6c1e.png)

# 7. Ease of Collaboration and Development

1.  A full CI/CD pipeline that includes static analysis will require consistent project configuration across all machines. This ensures that all developers use the same coding standards without needing to reconfigure the project or IDE each time. You can see the static analysis tools I have used in the CI/CD pipeline in Chapter “4. Identify Best Practices for Your Language”.

    1.  If possible, share your project/IDE configuration in the most convenient way for your language/IDE.

        1.  For example VSCode lets you share your workspace configuration like typing strictness, maximal code line length etc. and recommended extensions via settings.json and extensions.json respectively.

        2.  If it's possible, make the VERSION file the single source of truth for the SDK version to simplify release preparations.

When building an SDK, ensuring a smooth and collaborative development process is key to long-term success. This requires setting up consistent configurations, automating processes where possible, and simplifying release management to make it easy for teams to work together and ship updates.

#### **Consistent Project Configuration Across All Machines**

A full CI/CD pipeline is essential for ensuring that all code is automatically tested and analyzed before it reaches production. However, to make collaboration as seamless as possible, every developer working on the SDK should use the same coding standards and tools, regardless of their machine or development environment.

To achieve this, ensure that your project’s configuration is consistent and shared across all team members. This includes defining rules for **formatting**, **linting**, and **static code analysis** that are automatically enforced via your CI/CD pipeline. For example:

-   **Java**: Share **Checkstyle** or **SonarLint** configuration files to enforce coding standards across all machines.

-   **Python**: Use a pyproject.toml file to define consistent dependencies, formatters, and linters, such as **Black** for code formatting and **flake8** for linting.

By sharing these configuration files through version control, developers won’t need to reconfigure their IDEs or tools every time they clone the project. This ensures consistency in code quality, reduces friction in onboarding new developers, and prevents errors caused by mismatched environments.

#### **Sharing IDE Configuration**

If possible, provide **IDE-specific configuration files** for your language and preferred IDEs, such as **Eclipse**, **IntelliJ IDEA**, or **VS Code**. This will help ensure that developers are using the same environment settings, making collaboration more efficient. For example:

-   **For Java projects**, you could include an .idea folder for **IntelliJ IDEA** or .project for **Eclipse** in your repository to share project settings.

-   **For Python projects**, a .vscode folder with settings.json can ensure that all team members use the same linters and formatters in **Visual Studio Code**.

Providing pre-configured settings files simplifies the development process by ensuring that all contributors work in an optimized and uniform environment.

#### **Version Management and Simplified Releases**

Managing the SDK version should be straightforward and clear. If your versioning process is complicated or error-prone, it can lead to mistakes during release preparation, resulting in inconsistencies across different environments.

A best practice is to make the **VERSION file** the **single source of truth** for your SDK version. This simplifies the release process by ensuring that all tooling, documentation, and package metadata pull from the same version reference. By keeping the version in one place, you reduce the risk of mismatches between what’s deployed and what’s documented.

For example, you can update the VERSION file automatically during your CI/CD pipeline to reflect the latest release version. This practice can also trigger other actions, such as updating **changelogs** and pushing the latest version to package managers like **Maven Central** or **PyPI**.

#### **Automating Development Workflows**

Automation plays a key role in maintaining ease of collaboration. Set up **pre-commit hooks** that run linters, formatters, and tests before changes are committed to the codebase. This will ensure that only clean, validated code is pushed, reducing the chance of introducing errors into the shared repository.

For example:

-   **Husky** can be used to set up Git hooks that run scripts before code is committed.

-   **Prettier** (for JavaScript) or **Black** (for Python) can automatically format code as part of the commit process, ensuring consistent styling across all commits.

# 8. Testing:

1.  Choose a modern testing framework (again, take a look at reference projects)

    1.  Use existing tests (e.g. PHP SDK) as a baseline and add new ones if needed.

    2.  Set up and use the SDK to gain the perspective of an external developer. Current blog posts can serve as examples and can be adjusted to use the new SDK.

Testing is a critical part of building any SDK, ensuring that it works as expected and is reliable in production environments. By adopting modern testing frameworks and writing thorough tests, you’ll not only catch potential issues early but also improve the developer experience by providing real-world usage examples.

#### **Choose a Modern Testing Framework**

The first step in ensuring robust testing for your SDK is choosing the right testing framework for your language. To do this, look at how other reference projects handle testing, particularly those with high-quality SDKs like Stripe or PayPal. Here are some commonly used frameworks for Java and Python:

-   **For Java**:  
    Use **JUnit** as the primary testing framework. It’s widely adopted in the Java community and integrates seamlessly with build tools like **Maven** and **Gradle**. For mocking API calls or external dependencies, consider using **Mockito**. Together, these tools allow for both unit tests and integration tests, ensuring that your SDK behaves correctly in various scenarios.

-   **For Python**:  
    **pytest** is the go-to framework for writing clean, readable, and efficient tests in Python. It provides a rich feature set for writing unit tests, integration tests, and more. For handling API mocking, libraries like **responses** can be used to simulate API responses without making actual HTTP requests.

By selecting a modern, well-supported testing framework, you ensure that your SDK can be tested comprehensively, and future contributors will have an easier time maintaining the project.

#### **Use Existing Tests as a Baseline**

When building your SDK, it’s efficient to start by referencing existing tests from similar SDKs. For example, if Corbado already has SDKs written in other languages like PHP, use those as a **baseline**. You can adapt and extend the existing test cases to match the language-specific features of your new SDK.

-   Start by examining the **key use cases** covered by the existing tests, such as session validation, error handling, and JWT verification.

-   Replicate those tests in your new SDK, making adjustments for language differences.

-   If your SDK introduces new functionality, be sure to add **additional tests** that cover these features.

By leveraging existing tests, you save time while ensuring that your SDK adheres to the same standards and covers all core functionality.

#### **Gain the Perspective of an External Developer**

To ensure that your SDK delivers a great developer experience, it's essential to approach testing from the perspective of an **external developer** who will be using it. Set up the SDK as if you were an external user, integrating it into a sample application to identify any pain points or unclear areas.

Use current **Corbado blog posts** and examples as starting points, adjusting them to reflect the usage of your new SDK. By working through these examples, you’ll gain insight into how intuitive the SDK is to use and whether the documentation, error messages, or setup process could be improved.

-   Write tests that cover common developer use cases, like session validation or extracting user data, to ensure that they work smoothly.

-   Include tests for edge cases and error handling, verifying that developers receive meaningful feedback when things go wrong.

By simulating the real-world usage of your SDK, you can ensure that it meets the needs of external developers and provides a seamless integration experience.

# 9. Documentation:

1.  Ensure the user understands by looking at the documentation:

    1.  What function arguments, configuration fields are required and

        1.  What constraints apply to those fields (not null, maximal length, etc.) by examining your code documentation (e.g., Javadoc, docstrings, annotations). For example, Pydantic can make field constraint really easy written, compact and readable: [Code snippet Pydantic field constraints example]

    2.  Clearly explain what functions and classes do, and what configurations or parameters they expect.

    3.  Use linters (e.g., flake8 for Python with Google-style docstrings) to ensure consistent documentation formatting across your project according to modern standards.

    4.  Create README based on existing SDK implementations.

    5.  Standard code commenting practices should also be applied.

Clear, concise, and well-structured documentation is crucial to the success of any SDK. It ensures that developers can easily understand how to implement your SDK, use its features, and troubleshoot issues. The documentation should not only provide a comprehensive overview of the SDK's capabilities but also guide developers through its use with real-world examples.

#### **Ensure Users Understand Function Arguments and Configuration Fields**

Your documentation must clearly outline what is required for each function and configuration field. Developers need to know:

-   **Which arguments are required**: Make it clear in the documentation which function parameters or configuration fields are mandatory and which are optional. Specify the **default values** for any optional parameters, if applicable.

-   **What constraints apply to each field**: For example, is the field nullable? Are there maximum or minimum length requirements? Is the field expected to follow a certain format (e.g., email, URL)? These details should be explicitly stated to avoid confusion and potential errors during implementation.

To ensure consistency, the information in your documentation should be automatically generated from your code annotations, such as **Javadoc** for Java or **docstrings** for Python. This ensures that the documentation is always up to date and accurately reflects the SDK’s implementation.

#### **Clearly Explain Functions, Classes, and Configuration Parameters**

Your documentation should provide detailed explanations of **what each function and class does**. This includes:

-   The **purpose** of the function or class.

-   What **parameters** it expects and their types.

-   The **expected output** or return type.

-   Any **side effects** the function may have (e.g., database changes, API calls).

-   Specific **error conditions** or exceptions the user should handle.

By providing clear and descriptive documentation, you lower the barrier to entry for developers who are new to your SDK, making it easier for them to understand how to integrate it into their projects.

#### **Use Linters for Consistent Documentation Formatting**

To maintain consistency and readability, use modern linters that enforce standardized documentation formatting across your project. For example:

-   **Python**: Use **flake8** with **Google-style docstrings** to ensure uniform formatting. These tools help ensure that your docstrings are complete, correctly formatted, and follow industry best practices for Python documentation.

-   **Java**: Use **Checkstyle** to ensure that your **Javadoc** comments follow a consistent style and provide all necessary information. Tools like this catch missing or improperly formatted comments early, keeping your documentation clean and helpful.

Adopting these tools makes your documentation more professional and easier to read, ensuring that users can quickly find the information they need.

#### **Create a Comprehensive README**

The README file is the first piece of documentation many developers will see, so it needs to be clear, concise, and informative. To create an effective README, base it on the structure and content of **existing SDK implementations** from well-established projects. Your README should include:

-   **Installation instructions**: How to install and set up the SDK.

-   **Basic usage examples**: Show simple code snippets that demonstrate how to initialize the SDK and perform common tasks.

-   **Configuration guidelines**: Explain how to configure the SDK, including required fields and any constraints on configuration options.

-   **Links to further documentation**: Provide links to more detailed documentation for advanced use cases or complex configurations.

A well-written README sets the tone for your SDK and makes it easy for developers to get started without needing to dive deep into the full documentation.

#### **Follow Standard Code Commenting Practices**

Beyond formal documentation, clear **code comments** are essential to help future developers (including your team) understand the logic behind certain code decisions. Use standard commenting practices in your codebase to:

-   Explain **complex logic** or edge cases that might not be immediately obvious.

-   Mark **TODOs** or areas that need further attention.

-   Provide additional context when handling errors or exceptions.

Good commenting practices help bridge the gap between the code and its documentation, making the project easier to maintain and extend.

# 10. Conclusion

Building a Java SDK from an OpenAPI specification involves several key steps, from generating the client to ensuring ease of use for developers through proper project structure, best practices, and thorough testing. By focusing on a clean, consistent technology stack, adopting industry-standard tools and libraries, and providing robust documentation, you create an SDK that’s intuitive, reliable, and easy to integrate. Following these best practices not only streamlines development but also positions your SDK as a professional tool that developers can confidently use in production.

**Learnings & Best Practices see doc comment**

