package com.corbado.integration;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import com.corbado.base.AbstractSdkTest;
import com.corbado.entities.UserEntity;
import com.corbado.exceptions.CorbadoServerException;
import com.corbado.exceptions.CorbadoServerException.ValidationMessage;
import com.corbado.exceptions.StandardException;
import com.corbado.generated.model.GenericRsp;
import com.corbado.generated.model.UserCreateReq;
import com.corbado.services.UserService;
import com.corbado.util.TestUtils;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

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
    fixture = sdk.getUsers();
  }

  /** Test instantiate sdk expect not null. */
  @Test
  void test_InstantiateSdk_ExpectNotNull() {
    assertNotNull(sdk);
  }

  /** Test case for user creation with validation error. * */
  @Test
  void test_UserCreateBlankName_ExpectSuccess() {

    final CorbadoServerException e =
        assertThrows(CorbadoServerException.class, () -> fixture.createActiveByName(""));
    assertNotNull(e);
    assertEquals(400, e.getHttpStatusCode());

    assertArrayEquals(
        new ValidationMessage[] {new ValidationMessage("name", "cannot be blank")},
        e.getValidationMessages().toArray());
  }

  /** Test case for successful user creation. * */
  @Test
  void test_UserCreateExpectSuccess() throws CorbadoServerException {
    final String name = TestUtils.createRandomTestName();
    final UserEntity rsp = fixture.createActiveByName(name);
    assertEquals(name, rsp.getFullName());
  }

  /** Test case for missing status on user creation. * */
  @Test
  void test_UserCreateWithoutStatus_ExpectNullPoinerException() throws CorbadoServerException {
    final UserCreateReq req = new UserCreateReq().fullName(TestUtils.createRandomTestName());

    assertThrows(NullPointerException.class, () -> fixture.create(req));
  }

  /** Test for retrieving a user that does not exist. * */
  @Test
  void test_UserGet_ExpectNotFound() {
    final CorbadoServerException e =
        assertThrows(
            CorbadoServerException.class,
            () -> {
              final UserEntity ret = fixture.get("usr-1234567890");
              System.out.println(ret.toString());
            });
    assertNotNull(e);
    assertEquals(404, e.getHttpStatusCode());
  }

  /** Test for successfully retrieving a user. * */
  // TODO fix
  @Test
  void test_UserGet_ExpectSuccess() throws CorbadoServerException, StandardException {
    final String userId = TestUtils.createUser();
    final GenericRsp rsp = fixture.delete(userId);
    assertEquals(200, rsp.getHttpStatusCode());
  }

  /** Test for successfully deleting a user. * */
  @Test
  void test_UserDelete_ExpectSuccess() throws CorbadoServerException, StandardException {
    final String userId = TestUtils.createUser();
    final GenericRsp rsp = fixture.delete(userId);

    assertEquals(200, rsp.getHttpStatusCode());
  }
}
