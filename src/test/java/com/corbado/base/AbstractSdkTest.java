package com.corbado.base;

import com.corbado.exceptions.StandardException;
import com.corbado.sdk.CorbadoSdk;
import com.corbado.util.TestUtils;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.TestInstance;

/** The Class AbstractSdkTest. */
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class AbstractSdkTest {
  /** The sdk. */
  protected CorbadoSdk sdk;

  /**
   * Sets the sdk up.
   *
   * @throws StandardException the standard exception
   */
  @BeforeAll
  public void setUpSdk() throws StandardException {
    sdk = TestUtils.instantiateSDK();
  }
}
