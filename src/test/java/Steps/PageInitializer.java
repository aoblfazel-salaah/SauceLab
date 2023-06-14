package Steps;

import Pages.HomePage;
import Pages.LoginPage;

public class PageInitializer {
    public static LoginPage loginPage;
    public static HomePage homePage;

    public static void initializePageObjects (){
        loginPage = new LoginPage();
        homePage = new HomePage();
    }
}
