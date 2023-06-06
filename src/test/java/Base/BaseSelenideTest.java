package Base;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.github.bonigarcia.wdm.WebDriverManager;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.extension.ExtendWith;

import static io.qameta.allure.Allure.step;

@ExtendWith(AllureListener.class)
public abstract class BaseSelenideTest {

    @BeforeAll
    public static void setUp(){
        SelenideLogger.addListener("AllureSelenide", new AllureSelenide());

        WebDriverManager.chromedriver().setup();
        Configuration.browser = "chrome";
        Configuration.browserSize = "1920x1080";
        Configuration.driverManagerEnabled = true;
        Configuration.reportsFolder = "/build/allure-results";
    }

//    @AfterEach
//    public void tearDown(){
//        step("Закрываем", Selenide::closeWebDriver);
//    }

}
