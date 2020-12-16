/*
 * Copyright (c) 2019 by HORNBACH Baumarkt AG
 */
package logintests;

import base.BaseTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LoginTests extends BaseTest {
    @BeforeMethod
    public void initializePages() {

    }

    @Test
    public void successfulLogin() {
        System.out.println("success");
    }

    @Test
    public void emptyUserNameLoginTest() {

    }

    @Test
    public void invalidUserNameLoginTest() {

    }
}
