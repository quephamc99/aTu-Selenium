package models.components;

public class InternalLoginPage extends LoginPage{

    //k can override hàm login

    @Override
    protected String usernameLocator() {
        return "Internal Login page | usernameLocator";
    }

    @Override
    protected String passwordLocator() {
        return "Internal Login page | passwordLocator";
    }

    @Override
    protected String loginButtonLocator() {
        return "Internal Login page | loginButtonLocator";
    }
}
