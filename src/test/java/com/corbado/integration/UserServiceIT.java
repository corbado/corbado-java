package com.corbado.integration;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import com.corbado.base.AbstractSdkTest;
import com.corbado.entities.UserEntity;
import com.corbado.exceptions.CorbadoServerException;
import com.corbado.exceptions.StandardException;
import com.corbado.generated.model.UserCreateReq;
import com.corbado.services.UserService;
import com.corbado.util.TestUtils;

/** The Class UserServiceIT. */
class UserServiceIT extends AbstractSdkTest {

  /** The fixture under test. */
  protected UserService fixture;

  /**
   * Sets the up class.
   *
   * @throws StandardException the standard exception
   */
  @BeforeAll
  public void setUpClass() throws StandardException {
    this.fixture = this.sdk.getUsers();
  }

  /** Test instantiate sdk expect not null. */
  @Test
  void test_InstantiateSdk_ExpectNotNull() {
    assertNotNull(this.sdk);
  }

  /**
   * Test case for user creation with validation error. *
   *
   * @throws CorbadoServerException
   */
  @Test
  void test_UserCreateBlankName_ExpectSuccess() throws CorbadoServerException {

    this.fixture.createActiveByName("");
  }

  /** Test case for successful user creation. * */
  @Test
  void test_UserCreateExpectSuccess() throws CorbadoServerException {
    final String name = TestUtils.createRandomTestName();
    final UserEntity rsp = this.fixture.createActiveByName(name);
    assertEquals(name, rsp.getFullName());
  }

  /** Test case for missing status on user creation. * */
  @Test
  void test_UserCreateWithoutStatus_ExpectNullPoinerException() throws CorbadoServerException {
    final UserCreateReq req = new UserCreateReq().fullName(TestUtils.createRandomTestName());

    assertThrows(NullPointerException.class, () -> this.fixture.create(req));
  }

  /** Test for successfully deleting a user. * */
  @Test
  void test_UserDelete_ExpectSuccess() throws CorbadoServerException, StandardException {
    final UserEntity user = TestUtils.createUser();
    this.fixture.delete(user.getUserID());
    final CorbadoServerException e =
        assertThrows(
            CorbadoServerException.class,
            () -> {
              final UserEntity ret = this.fixture.get(user.getUserID());
              System.out.println(ret.toString());
            });
    assertNotNull(e);
    assertEquals(400, e.getHttpStatusCode());
    assertEquals("does not exist", e.getValidationMessages().get(0).getMessage());
    assertEquals("userID", e.getValidationMessages().get(0).getField());
  }

  /**
   * Test for retrieving a user that does not exist. Should return a 'Bad request' with validation
   * message "does not exist" on field "userID"
   */
  @Test
  void test_UserGet_ExpectNotFound() {
    final CorbadoServerException e =
        assertThrows(
            CorbadoServerException.class,
            () -> {
              final UserEntity ret = this.fixture.get("usr-1234567890");
              System.out.println(ret.toString());
            });
    assertNotNull(e);
    assertEquals(400, e.getHttpStatusCode());
    assertEquals("does not exist", e.getValidationMessages().get(0).getMessage());
    assertEquals("userID", e.getValidationMessages().get(0).getField());
  }

  /** Test for successfully retrieving a user. * */
  @Test
  void test_UserGet_ExpectSuccess() throws CorbadoServerException, StandardException {
    final UserEntity user = TestUtils.createUser();
    final UserEntity ret = this.fixture.get(user.getUserID());
    assertEquals(user, ret);
    this.fixture.delete(user.getUserID());
  }
}
