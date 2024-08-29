package com.corbado.util;

import java.util.Random;

import org.apache.commons.lang3.StringUtils;

import com.corbado.entities.UserEntity;
import com.corbado.exceptions.CorbadoServerException;
import com.corbado.exceptions.StandardException;
import com.corbado.generated.model.UserCreateReq;
import com.corbado.generated.model.UserStatus;
import com.corbado.sdk.Config;
import com.corbado.sdk.CorbadoSdk;

import io.github.cdimascio.dotenv.Dotenv;

/** The Class TestUtils. */
public class TestUtils {
  /** The Constant CORBADO_API_SECRET. */
  // Constants for environment variable names
  public static final String CORBADO_API_SECRET = "CORBADO_API_SECRET";

  /** The Constant CORBADO_PROJECT_ID. */
  public static final String CORBADO_PROJECT_ID = "CORBADO_PROJECT_ID";

  /** The Constant CORBADO_BACKEND_API. */
  public static final String CORBADO_BACKEND_API = "CORBADO_BACKEND_API";

  /** The Constant CANNOT_BE_BLANK_MESSAGE. */
  public static final String CANNOT_BE_BLANK_MESSAGE = "cannot be blank";

  /**
   * Generate a random test email.
   *
   * @return random test email
   */
  public static String createRandomTestEmail() {
    final String characters = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";
    final String randomString = generateString(10, characters);
    return "integration-test+" + randomString + "@corbado.com";
  }

  /**
   * Generate a random test name.
   *
   * @return random test name
   */
  public static String createRandomTestName() {
    final String characters = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";
    return generateString(10, characters);
  }

  /**
   * Generate a random test phone number.
   *
   * @return random test phone number
   */
  public static String createRandomTestPhoneNumber() {
    final String digits = "0123456789";
    return "+491509" + generateString(7, digits);
  }

  /**
   * Creates the user.
   *
   * @return the string
   * @throws CorbadoServerException the corbado server exception
   * @throws StandardException the standard exception
   */
  public static UserEntity createUser() throws CorbadoServerException, StandardException {
    final UserCreateReq req =
        new UserCreateReq().fullName(createRandomTestName()).status(UserStatus.ACTIVE);
    return instantiateSDK().getUsers().create(req);
  }

  /**
   * Generate a random string of specified length using the provided characters.
   *
   * @param length the length of the string to generate
   * @param characters the characters to use for generating the string
   * @return generated random string
   */
  public static String generateString(final int length, final String characters) {
    final Random random = new Random();
    final StringBuilder result = new StringBuilder(length);
    for (int i = 0; i < length; i++) {
      result.append(characters.charAt(random.nextInt(characters.length())));
    }
    return result.toString();
  }

  /**
   * Instantiate SDK with parameters from environment variables.
   *
   * @return the corbado sdk
   * @throws StandardException the standard exception
   */
  public static CorbadoSdk instantiateSDK() throws StandardException {

    final Dotenv dotenv = Dotenv.load();
    String apiSecret = System.getenv(CORBADO_API_SECRET);

    // If the environment variable is not set, then fallback to dotenv
    if (apiSecret == null || apiSecret.isEmpty()) {
      apiSecret = dotenv.get(CORBADO_API_SECRET, "missing CORBADO_API_SECRET");
    }
    // Check for CORBADO_PROJECT_ID
    String projectId = System.getenv(CORBADO_PROJECT_ID);
    if (projectId == null || projectId.isEmpty()) {
      projectId = dotenv.get(CORBADO_PROJECT_ID, "missing CORBADO_PROJECT_ID");
    }

    // Check for CORBADO_BACKEND_API
    String backendApi = System.getenv(CORBADO_BACKEND_API);
    if (StringUtils.isEmpty(backendApi)) {
      backendApi = dotenv.get(CORBADO_BACKEND_API);
    }
    Config config = null;
    if (StringUtils.isEmpty(backendApi)) {
      config = new Config(projectId, apiSecret);
    } else {
      config = new Config(projectId, apiSecret, backendApi);
    }

    return new CorbadoSdk(config);
  }
}
