package util;

import java.util.Random;

import com.corbado.exceptions.CorbadoServerException;
import com.corbado.exceptions.StandardException;
import com.corbado.generated.model.UserCreateReq;
import com.corbado.generated.model.UserCreateRsp;
import com.corbado.sdk.Config;
import com.corbado.sdk.CorbadoSdk;

import io.github.cdimascio.dotenv.Dotenv;

public class TestUtils { // Constants for environment variable names
  public static final String CORBADO_API_SECRET = "CORBADO_API_SECRET";
  public static final String CORBADO_PROJECT_ID = "CORBADO_PROJECT_ID";
  public static final String CORBADO_BACKEND_API = "CORBADO_BACKEND_API";

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
   * Create a user and return the user ID.
   *
   * @return user ID of the created user
   * @throws StandardException
   * @throws CorbadoServerException
   */
  public static String createUser() throws CorbadoServerException, StandardException {
    final UserCreateReq req =
        new UserCreateReq().name(createRandomTestName()).email(createRandomTestEmail());
    final UserCreateRsp rsp = instantiateSDK().getUsers().create(req);
    return rsp.getData().getUserID();
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
   * @return CorbadoSdk instance
   * @throws StandardException
   */
  public static CorbadoSdk instantiateSDK() throws StandardException {
    final Dotenv dotenv = Dotenv.load();

    final String apiSecret = dotenv.get(CORBADO_API_SECRET, "missing CORBADO_API_SECRET");
    final String projectId = dotenv.get(CORBADO_PROJECT_ID, "missing CORBADO_PROJECT_ID");
    final String backendApi = dotenv.get(CORBADO_BACKEND_API);

    if (backendApi != null) {
      return new CorbadoSdk(new Config(projectId, apiSecret, backendApi));
    } else {
      return new CorbadoSdk(new Config(projectId, apiSecret));
    }
  }
}
