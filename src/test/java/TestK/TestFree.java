package TestK;

import Base.AllureListener;
import Base.BaseSelenideTest;
import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Selenide;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.openqa.selenium.Keys;

import static com.codeborne.selenide.Selenide.$x;

public class TestFree extends BaseSelenideTest {

    @Test
    public void passedTest(){
        Selenide.open("https://hd.kinopoisk.ru/");
        $x("//*[@id='subscriptions']").shouldHave(Condition.text("Главное"));
    }

    @Test
    public void falseTest(){
//        Selenide.open("https://appleinsider.ru/");
        Selenide.open("https://hd.kinopoisk.ru/");
//        $x("//*[@name ='s']").setValue("iphone 13").sendKeys(Keys.ENTER);
//        String res = $x("//h2//a").getAttribute("href");
//        System.out.println(res);
//        Assertions.assertTrue(res.contains("iphone-11"));
//        $x("//*[@id='subscriptions']").shouldHave(Condition.text("Главное"));
        Assertions.assertTrue(3>5);
    }

}
