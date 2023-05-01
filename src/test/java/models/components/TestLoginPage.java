package models.components;

public class TestLoginPage {
    public static void main(String[] args) {
        LoginPage internalPage = new InternalLoginPage();
        //internalPage.login();
        LoginPage externalPage = new ExternalLoginPage();
        //externalPage.login();
        TestLoginPage testLoginPage = new TestLoginPage();
        testLoginPage.login(internalPage);
        testLoginPage.login(externalPage);
    }

    public void login(LoginPage loginPage){
        loginPage.login();
    }
}
