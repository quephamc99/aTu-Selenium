package models.components;

public class ExternalLoginPage extends LoginPage{
    @Override
    protected String usernameLocator() {
        return  "External Login page | usernameLocator";
    }

    @Override
    protected String passwordLocator() {
        return "External Login page | passwordLocator";
    }

    @Override
    protected String loginButtonLocator() {
        return "External Login page | loginButtonLocator";
    }
}
