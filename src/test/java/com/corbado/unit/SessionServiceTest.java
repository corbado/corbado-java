package com.corbado.unit;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import com.auth0.jwk.JwkProvider;
import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.corbado.services.SessionService;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.security.KeyFactory;
import java.security.NoSuchAlgorithmException;
import java.security.interfaces.RSAPrivateKey;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.PKCS8EncodedKeySpec;
import java.util.ArrayList;
import java.util.Base64;
import java.util.Date;
import java.util.List;
import java.util.stream.Stream;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class SessionServiceTest {

  /** The Constant PRIVATE_KEY_PATH. */
  private static final String PRIVATE_KEY_PATH = "src/test/java/com/corbado/unit/data/rsakey.pem";

  /** The Constant JWKS_PATH. */
  private static final String JWKS_PATH = "src/test/java/com/corbado/unit/data/jwks.json";

  /** The Constant TEST_NAME. */
  private static final String TEST_NAME = "Test Name";

  /** The Constant TEST_EMAIL. */
  private static final String TEST_EMAIL = "test@email.com";

  /** The Constant TEST_PHONE_NUMBER. */
  private static final String TEST_PHONE_NUMBER = "+012345678";

  /** The Constant TEST_USER_ID. */
  private static final String TEST_USER_ID = "12345";

  /** The jwk provider. */
  @Mock private JwkProvider jwkProvider;

  /** The session service. */
  @InjectMocks private static SessionService sessionService;

  /** The jwks. */
  private static byte[] jwks;

  /** The private key. */
  private static RSAPrivateKey privateKey;

  // ------------------ Set up --------------------- //
  /**
   * Sets the up class.
   *
   * @throws IOException Signals that an I/O exception has occurred.
   * @throws NoSuchAlgorithmException
   * @throws InvalidKeySpecException
   */
  @BeforeAll
  public static void setUpClass()
      throws IOException, NoSuchAlgorithmException, InvalidKeySpecException {
    sessionService = createSessionService();
    jwks = Files.readAllBytes(Paths.get(JWKS_PATH));

    privateKey = readPrivateKey(PRIVATE_KEY_PATH);
  }

  /**
   * Sets the up.
   *
   * @throws IOException Signals that an I/O exception has occurred.
   */
  @BeforeEach
  public void setUp() throws IOException {}

  // ------------------ Tests --------------------- //

  /**
   * Test test data is present.
   *
   * @throws InvalidKeySpecException the invalid key spec exception
   * @throws NoSuchAlgorithmException the no such algorithm exception
   */
  @Test
  void test_testDataIsPresent() throws InvalidKeySpecException, NoSuchAlgorithmException {
    assertNotNull(sessionService);
    assertNotNull(jwks);
    assertNotNull(privateKey);
  }

  /**
   * Test test generate gwt.
   *
   * @throws InvalidKeySpecException the invalid key spec exception
   * @throws NoSuchAlgorithmException the no such algorithm exception
   */
  @Test
  void test_testGenerateGwt() throws InvalidKeySpecException, NoSuchAlgorithmException {
    assertNotNull(generateJwt("1", 3, 4));
  }

  /**
   * Test init parameters validation.
   *
   * @param issuer the issuer
   * @param jwksUri the jwks uri
   * @param shortSessionCookieName the short session cookie name
   * @param expectValid the expect valid
   */
  @ParameterizedTest
  @MethodSource("initParametersTestData")
  void testInitParametersValidation(
      final String issuer,
      final String jwksUri,
      final String shortSessionCookieName,
      final boolean expectValid) {
    if (expectValid) {
      // No exception should be raised
      assertDoesNotThrow(
          () -> new SessionService(shortSessionCookieName, issuer, jwksUri, 0, false));
    } else {
      // ValidationError should be raised
      assertThrows(
          IllegalArgumentException.class,
          () -> new SessionService(shortSessionCookieName, issuer, jwksUri, 0, false));
    }
  }

  /**
   * Test get and validate short session value.
   *
   * @param issuer the issuer
   * @param jwksUri the jwks uri
   * @param shortSessionCookieName the short session cookie name
   * @param expectValid the expect valid
   */
  @ParameterizedTest
  @MethodSource("provideJwts")
  void test_GetAndValidateShortSessionValue(final boolean expectValid, final String jwt) {
    assertEquals(
        expectValid, sessionService.getAndValidateShortSessionValue(jwt).isAuthenticated());
  }

  // ------------------ Test data --------------------- //

  /**
   * Inits the parameters test data.
   *
   * @return the stream
   */
  static Stream<Object[]> initParametersTestData() {
    return Stream.of(
        // Valid session service
        new Object[] {"s", "2", "name", true},
        // Test empty issuer
        new Object[] {"", "2", "name", false},
        // Test empty jwks_uri
        new Object[] {"s", "", "name", false},
        // Test empty short_session_cookie_name
        new Object[] {"s", "2", "", false});
  }

  /**
   * Provide jwts.
   *
   * @return the list
   * @throws NoSuchAlgorithmException
   * @throws InvalidKeySpecException
   */
  static List<Object[]> provideJwts() throws InvalidKeySpecException, NoSuchAlgorithmException {
    final List<Object[]> testData = new ArrayList<>();

    // JWT with invalid format
    testData.add(new Object[] {false, "invalid"});

    // JWT signed with wrong algorithm (HS256 instead of RS256)
    final String jwtWithWrongAlgorithm =
        "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJzdWIiOiIxMjM0NTY3ODkwIiwibmFtZSI6Ik"
            + "pvaG4gRG9lIiwiYWRtaW4iOnRydWV9.dyt0CoTl4WoVjAHI9Q_CwSKhl6d_9rhM3NrXuJttkao";
    testData.add(new Object[] {false, jwtWithWrongAlgorithm});

    // Not before (nbf) in future
    testData.add(
        new Object[] {
          false,
          generateJwt(
              "https://auth.acme.com",
              System.currentTimeMillis() / 1000 + 100,
              System.currentTimeMillis() / 1000 + 100)
        });

    // Expired (exp)
    testData.add(
        new Object[] {
          false,
          generateJwt(
              "https://auth.acme.com",
              System.currentTimeMillis() / 1000 - 100,
              System.currentTimeMillis() / 1000 - 100)
        });

    // Invalid issuer (iss)
    testData.add(
        new Object[] {
          false,
          generateJwt(
              "https://invalid.com",
              System.currentTimeMillis() / 1000 + 100,
              System.currentTimeMillis() / 1000 - 100)
        });

    // Success
    testData.add(
        new Object[] {
          true,
          generateJwt(
              "https://auth.acme.com",
              System.currentTimeMillis() / 1000 + 100,
              System.currentTimeMillis() / 1000 - 100)
        });

    return testData;
  }

  // ------------------ Utility functions--------------------- //

  /**
   * Read private key.
   *
   * @param privateKeyPath the private key path
   * @throws IOException Signals that an I/O exception has occurred.
   * @throws NoSuchAlgorithmException the no such algorithm exception
   * @throws InvalidKeySpecException the invalid key spec exception
   */
  private static RSAPrivateKey readPrivateKey(final String privateKeyPath)
      throws IOException, NoSuchAlgorithmException, InvalidKeySpecException {
    String privateKeyString =
        new String(Files.readAllBytes(Paths.get(privateKeyPath)), Charset.defaultCharset());

    privateKeyString =
        privateKeyString
            .replace("-----BEGIN PRIVATE KEY-----", "")
            .replaceAll(System.lineSeparator(), "")
            .replace("\n", "")
            .replace("-----END PRIVATE KEY-----", "");
    final byte[] encoded = Base64.getDecoder().decode(privateKeyString);
    final KeyFactory keyFactory = KeyFactory.getInstance("RSA");
    final PKCS8EncodedKeySpec keySpec = new PKCS8EncodedKeySpec(encoded);
    return (RSAPrivateKey) keyFactory.generatePrivate(keySpec);
  }

  /**
   * Generate jwt.
   *
   * @param iss the iss
   * @param exp the exp
   * @param nbf the nbf
   * @return the string
   * @throws InvalidKeySpecException
   * @throws NoSuchAlgorithmException
   */
  private static String generateJwt(final String iss, final long exp, final long nbf)
      throws InvalidKeySpecException, NoSuchAlgorithmException {

    // Now you have RSAPrivateKey, you can use it as needed
    final Algorithm algorithm = Algorithm.RSA256(privateKey);
    return JWT.create()
        .withIssuer(iss)
        .withIssuedAt(new Date())
        .withExpiresAt(new Date(exp * 1000L))
        .withNotBefore(new Date(nbf * 1000L))
        .withSubject(TEST_USER_ID)
        .withClaim("name", TEST_NAME)
        .withClaim("email", TEST_EMAIL)
        .withClaim("phone_number", TEST_PHONE_NUMBER)
        .sign(algorithm);
  }

  /**
   * Creates the session service. Warning! You should normally use SessionInterface from CorbadoSDK
   * for non-test purposes.
   */
  private static SessionService createSessionService() {
    return new SessionService(
        "cbo_short_session",
        "https://auth.acme.com",
        "https://example_uri.com",
        10,
        false); // URLs do not matter, url access is mocked
  }
}