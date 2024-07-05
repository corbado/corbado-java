package integration;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;

import com.corbado.exceptions.CorbadoServerException;
import com.corbado.exceptions.StandardException;
import com.corbado.generated.model.GenericRsp;
import com.corbado.generated.model.UserCreateReq;
import com.corbado.generated.model.UserCreateRsp;
import com.corbado.generated.model.UserDeleteReq;
import com.corbado.generated.model.UserGetRsp;
import com.corbado.generated.model.UserListRsp;
import com.corbado.sdk.CorbadoSdk;
import com.corbado.services.UserService;

import util.TestUtils;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class UserServiceIT {

  protected CorbadoSdk sdk;
  protected UserService fixture;

  @BeforeAll
  public void setUpClass() throws StandardException {
    sdk = TestUtils.instantiateSDK();
    fixture = sdk.getUsers();
  }

  @Test
  void test_InstantiateSdkExpectNotNull() {
    assertNotNull(sdk);
  }

  @Test
  /** Test case for user creation with validation error. * */
  void test_UserCreateBlankNameExpectValidationError() {
    final UserCreateReq req = new UserCreateReq().name("").email("");

    final CorbadoServerException e =
        assertThrows(CorbadoServerException.class, () -> fixture.create(req));
    assertNotNull(e);
    assertEquals(400, e.getHttpStatusCode());
    // TODO: complete
    // assertArrayEquals(new String[] {"name: cannot be blank"},
    // e.getValidationMessages().toArray());
  }

  @Test
  /** Test case for successful user creation. * */
  void test_UserCreateExpectSuccess() throws CorbadoServerException {
    final UserCreateReq req =
        new UserCreateReq()
            .name(TestUtils.createRandomTestName())
            .email(TestUtils.createRandomTestEmail());

    final UserCreateRsp rsp = fixture.create(req);
    assertEquals(200, rsp.getHttpStatusCode());
  }

  @Test
  /** Test for retrieving a user that does not exist. * */
  void test_UserGetExpectNotFound() {
    final CorbadoServerException e =
        assertThrows(
            CorbadoServerException.class,
            () -> {
              final UserGetRsp ret = fixture.get("usr-1234567890");
              System.out.println(ret.toString());
            });
    assertNotNull(e);
    assertEquals(404, e.getHttpStatusCode());
  }

  @Test
  /** Test for successfully retrieving a user. * */
  void test_UserGetExpectSuccess() throws CorbadoServerException, StandardException {
    final String userId = TestUtils.createUser();
    final UserGetRsp rsp = fixture.get(userId);
    assertEquals(200, rsp.getHttpStatusCode());
  }

  @Test
  /** Test for successfully deleting a user. * */
  void test_UserDeleteExpectSuccess() throws CorbadoServerException, StandardException {
    final String userId = TestUtils.createUser();
    final GenericRsp rsp = fixture.delete(userId, new UserDeleteReq());
    assertEquals(200, rsp.getHttpStatusCode());
  }

  @Test
  void test_UserListInvalidSortExpectValidationError() {
    /** Test for listing users with validation error. * */
    final CorbadoServerException e =
        assertThrows(
            CorbadoServerException.class, () -> fixture.listUsers("", "", "foo:bar", null, 0, 0));
    assertNotNull(e);
    assertEquals(422, e.getHttpStatusCode());
    // TODO
    //    assertArrayEquals(
    //        new String[] {"sort: Invalid order direction 'bar'"},
    // e.getValidationMessages().toArray());
  }

  @Test
  void test_UserListSuccess() throws CorbadoServerException, StandardException {
    /** Test for successfully listing users. * */
    final String userId = TestUtils.createUser();
    final UserListRsp rsp = fixture.listUsers(null, null, "created:desc", null, null, null);

    final boolean found =
        rsp.getData().getUsers().stream().anyMatch(user -> user.getID().equals(userId));
    assertTrue(found);
  }
}
