package com.corbado.integration;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import com.corbado.base.AbstractSdkTest;
import com.corbado.exceptions.CorbadoServerException;
import com.corbado.exceptions.StandardException;
import com.corbado.generated.invoker.ApiException;
import com.corbado.generated.model.Identifier;
import com.corbado.generated.model.IdentifierCreateReq;
import com.corbado.generated.model.IdentifierList;
import com.corbado.generated.model.IdentifierStatus;
import com.corbado.generated.model.IdentifierType;
import com.corbado.services.IdentifierService;
import com.corbado.util.TestUtils;
import java.util.List;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

/** The Class UserServiceIT. */
@Slf4j
class IdentifierServiceIT extends AbstractSdkTest {

  /** The fixture under test. */
  private static IdentifierService fixture;

  /** The test user id. */
  private static String TEST_USER_ID = null;

  /** The test user email. */
  private static String TEST_USER_EMAIL = null;

  /** The test user phone. */
  private static String TEST_USER_PHONE = null;

  /** The test user email id. */
  private static Identifier TEST_USER_EMAIL_IDENTIFIER = null;

  /**
   * Assert validation error equals.
   *
   * @param e the CorbadoServerException
   * @param validatedFieldName the validated field name
   * @param expectedMessage the expected message
   */
  private void assertValidationErrorEquals(
      final CorbadoServerException e,
      final String validatedFieldName,
      final String expectedMessage) {
    assertEquals(1, e.getValidationMessages().size());
    assertEquals(validatedFieldName, e.getValidationMessages().get(0).getField());
    assertEquals(expectedMessage, e.getValidationMessages().get(0).getMessage());
  }

  /**
   * Sets the up class.
   *
   * @throws StandardException the standard exception
   * @throws CorbadoServerException the server side error
   */
  @BeforeAll
  public void setUpClass() throws StandardException, CorbadoServerException {
    fixture = this.sdk.getIdentifiers();
    TEST_USER_ID = TestUtils.createUser().getUserID();
    TEST_USER_EMAIL = TestUtils.createRandomTestEmail();
    TEST_USER_PHONE = TestUtils.createRandomTestPhoneNumber();

    TEST_USER_EMAIL_IDENTIFIER =
        fixture.create(
            TEST_USER_ID,
            new IdentifierCreateReq()
                .identifierType(IdentifierType.EMAIL)
                .identifierValue(TEST_USER_EMAIL)
                .status(IdentifierStatus.PRIMARY));
    fixture.create(
        TEST_USER_ID,
        new IdentifierCreateReq()
            .identifierType(IdentifierType.PHONE)
            .identifierValue(TEST_USER_PHONE)
            .status(IdentifierStatus.PRIMARY));

    log.debug(
        "TEST_USER_ID: {}, TEST_USER_EMAIL: {}, TEST_USER_PHONE: {}",
        TEST_USER_ID,
        TEST_USER_EMAIL,
        TEST_USER_PHONE);
  }

  /**
   * Test get email and get email with false identifier.
   *
   * @throws CorbadoServerException the corbado server exception
   * @throws StandardException the standard exception
   * @throws ApiException the api exception
   */
  @Test
  void test_checkExistingEmailIsPresent_ExpectSuccess()
      throws CorbadoServerException, StandardException, ApiException {

    IdentifierList ret = fixture.listByValueAndType(TEST_USER_EMAIL, IdentifierType.EMAIL);
    assertNotEquals(0, ret.getIdentifiers().size());
    ret = fixture.listByValueAndType(TEST_USER_EMAIL, IdentifierType.PHONE);
    assertTrue(fixture.existsByValueAndType(TEST_USER_EMAIL, IdentifierType.EMAIL));
    assertFalse((fixture.existsByValueAndType(TEST_USER_EMAIL, IdentifierType.PHONE)));
    assertEquals(0, ret.getIdentifiers().size());
  }

  /**
   * Test create empty identifier expect exception.
   *
   * @throws CorbadoServerException the corbado server exception
   * @throws StandardException the standard exception
   */
  @Test
  void test_CreateEmptyIdentifier_ExpectException()
      throws CorbadoServerException, StandardException {
    final String userId = TestUtils.createUser().getUserID();
    final String email = "";
    final CorbadoServerException e =
        assertThrows(
            CorbadoServerException.class,
            () -> {
              fixture.create(
                  userId,
                  new IdentifierCreateReq()
                      .identifierType(IdentifierType.EMAIL)
                      .identifierValue(email)
                      .status(IdentifierStatus.PRIMARY));
            });

    assertValidationErrorEquals(e, "identifierValue", TestUtils.CANNOT_BE_BLANK_MESSAGE);
  }

  /** Test for successfully creating an identifier. * */
  @Test
  void test_CreateIdentifier_ExpectSuccess() throws CorbadoServerException, StandardException {
    final String userId = TestUtils.createUser().getUserID();
    final String email = TestUtils.createRandomTestEmail();
    final Identifier rsp =
        fixture.create(
            userId,
            new IdentifierCreateReq()
                .identifierType(IdentifierType.EMAIL)
                .identifierValue(email)
                .status(IdentifierStatus.PRIMARY));

    assertEquals(userId, rsp.getUserID());
    assertEquals(email, rsp.getValue());
    assertEquals(IdentifierType.EMAIL, rsp.getType());
  }

  /**
   * Test case for search for Identifiers by userId.
   *
   * @throws CorbadoServerException the corbado server exception
   * @throws StandardException the standard exception
   * @throws ApiException the api exception
   */
  @Test
  void test_getIdentifiersForUserId_ExpectListOfIdentifiers()
      throws CorbadoServerException, StandardException, ApiException {

    final IdentifierList ret = fixture.listAllByUserIdWithPaging(TEST_USER_ID, null, null);
    ret.getIdentifiers().stream()
        .map(Identifier::getIdentifierID)
        .anyMatch(x -> x.equals(TEST_USER_EMAIL_IDENTIFIER.getIdentifierID()));
    assertEquals(2, ret.getIdentifiers().size());
  }

  /**
   * Test list expect success.
   *
   * @throws CorbadoServerException the corbado server exception
   * @throws StandardException the standard exception
   */
  @Test
  void test_ListIdentifiersAll_ExpectSuccess() throws CorbadoServerException, StandardException {
    final IdentifierList ret = fixture.list(null, null, null, 100);

    assertNotNull(ret);
  }

  // ----------- Helper functions ------------//

  /**
   * Test get email and get email with false identifier.
   *
   * @throws CorbadoServerException the corbado server exception
   * @throws StandardException the standard exception
   * @throws ApiException the api exception
   */
  @Test
  void test_updateIdentifier_ExpectSuccess()
      throws CorbadoServerException, StandardException, ApiException {
    fixture.updateStatus(
        TEST_USER_EMAIL_IDENTIFIER.getUserID(),
        TEST_USER_EMAIL_IDENTIFIER.getIdentifierID(),
        IdentifierStatus.PENDING);
    IdentifierList ret =
        fixture.listByValueAndType(
            TEST_USER_EMAIL_IDENTIFIER.getValue(), TEST_USER_EMAIL_IDENTIFIER.getType());
    assertEquals(IdentifierStatus.PENDING, ret.getIdentifiers().get(0).getStatus());

    fixture.updateStatus(
        TEST_USER_EMAIL_IDENTIFIER.getUserID(),
        TEST_USER_EMAIL_IDENTIFIER.getIdentifierID(),
        IdentifierStatus.PRIMARY);

    ret =
        fixture.listByValueAndType(
            TEST_USER_EMAIL_IDENTIFIER.getValue(), TEST_USER_EMAIL_IDENTIFIER.getType());
    assertEquals(IdentifierStatus.PRIMARY, ret.getIdentifiers().get(0).getStatus());
  }

  /**
   * Test list all emails by user id expect success.
   *
   * @throws CorbadoServerException the server side error
   */
  @Test
  void test_listAllEmailsByUserId_expectSuccess() throws CorbadoServerException {
    final int testSize = 21;
    for (int i = 0; i < testSize; i++) {
      fixture.create(
          TEST_USER_ID,
          new IdentifierCreateReq()
              .identifierType(IdentifierType.EMAIL)
              .identifierValue(TestUtils.createRandomTestEmail())
              .status(IdentifierStatus.VERIFIED));
    }

    final List<Identifier> ret = fixture.listAllEmailsByUserId(TEST_USER_ID);
    // one email was already created before
    assertEquals(testSize + 1, ret.size());
  }

  /** Test for successfully deleting a user. * */
  @Test
  void test_DeleteIdentifier_ExpectSuccess() throws CorbadoServerException, StandardException {
    final Identifier identifier =
        fixture.create(
            TEST_USER_ID,
            new IdentifierCreateReq()
                .identifierType(IdentifierType.EMAIL)
                .identifierValue(TestUtils.createRandomTestEmail())
                .status(IdentifierStatus.VERIFIED));

    // Success if no exception is thrown
    fixture.delete(identifier.getUserID(), identifier.getIdentifierID());
  }
}
