
import com.codeborne.selenide.SelenideElement;
import com.codeborne.selenide.WebDriverRunner;
import org.junit.Assert;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.URL;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selectors.byAttribute;
import static com.codeborne.selenide.Selectors.byCssSelector;
import static com.codeborne.selenide.Selectors.byXpath;
import static com.codeborne.selenide.Selenide.*;


public class SampleSauceTest {

    public static final String USERNAME = "testn323";
    public static final String ACCESS_KEY = "20307c3e-48e5-4047-9706-9b7fa4b9675b";
    public static final String URL = "https://" + USERNAME + ":" + ACCESS_KEY + "@ondemand.saucelabs.com:443/wd/hub";

    public static void main(String[] args) throws Exception {

        DesiredCapabilities caps = DesiredCapabilities.chrome();
        caps.setCapability("platform", "Windows XP");
        caps.setCapability("version", "43.0");

        WebDriver driver = new RemoteWebDriver(new URL(URL), caps);
        WebDriverRunner.setWebDriver(driver);

//тестируем создание нового элемента
        open("http://samples.gwtproject.org/samples/Showcase/Showcase.html#!CwCellList");
        $(byCssSelector(".middleCenterInner > div:nth-child(1) > table:nth-child(1) > tbody:nth-child(1) > tr:nth-child(2) > td:nth-child(2) > input:nth-child(1)")).setValue("John");
        $(byCssSelector(".middleCenterInner > div:nth-child(1) > table:nth-child(1) > tbody:nth-child(1) > tr:nth-child(3) > td:nth-child(2) > input:nth-child(1)")).setValue("Wayne");
        $(byCssSelector(".middleCenterInner > div:nth-child(1) > table:nth-child(1) > tbody:nth-child(1) > tr:nth-child(4) > td:nth-child(2) > select:nth-child(1)")).selectOption("Friends");
        $(byCssSelector(".gwt-DateBox")).setValue("May 26, 1907");
        $(".gwt-DateBox").pressTab();
        $(byCssSelector(".gwt-TextArea")).setValue("31546 Olive-Tree Heaven");
        $(byCssSelector("button.gwt-Button:nth-child(2)")).click();
        $("div.GNHGC04CCB:nth-child(1)").sendKeys(Keys.chord(Keys.END));
        $("div.GNHGC04CCB:nth-child(251)").shouldHave(text("John Wayne"));
        $("div.GNHGC04CCB:nth-child(251)").shouldHave(text("31546 Olive-Tree Heaven"));


//тестируем работу кнопки "Создать +50"
        open("http://samples.gwtproject.org/samples/Showcase/Showcase.html#!CwCellList");
        $("button.gwt-Button:nth-child(3)").click();
        $("div.GNHGC04CCB:nth-child(1)").sendKeys(Keys.chord(Keys.END));
        $("div.GNHGC04CCB:nth-child(300)").exists();
        $("#gwt-debug-contentPanel > div:nth-child(2) > div:nth-child(1) > div:nth-child(2) > div:nth-child(1) > div:nth-child(3) > div:nth-child(1) > div:nth-child(1) > div:nth-child(1) > table:nth-child(1) > tbody:nth-child(1) > tr:nth-child(1) > td:nth-child(1) > div:nth-child(2)").shouldHave(text("300"));

//тестируем редактирование
        open("http://samples.gwtproject.org/samples/Showcase/Showcase.html#!CwCellList");
        $("div.GNHGC04CCB:nth-child(1)").click();
        $(byCssSelector(".middleCenterInner > div:nth-child(1) > table:nth-child(1) > tbody:nth-child(1) > tr:nth-child(2) > td:nth-child(2) > input:nth-child(1)")).setValue("John");
        $(byCssSelector(".middleCenterInner > div:nth-child(1) > table:nth-child(1) > tbody:nth-child(1) > tr:nth-child(3) > td:nth-child(2) > input:nth-child(1)")).setValue("Wayne");
        $(byCssSelector(".middleCenterInner > div:nth-child(1) > table:nth-child(1) > tbody:nth-child(1) > tr:nth-child(4) > td:nth-child(2) > select:nth-child(1)")).selectOption("Friends");
        $(byCssSelector(".gwt-DateBox")).setValue("May 26, 1907");
        $(".gwt-DateBox").pressTab();
        $(byCssSelector(".gwt-TextArea")).setValue("31546 Olive-Tree Heaven");
        $(byCssSelector("button.gwt-Button:nth-child(1)")).click();



//тестируем Недобавление пустой записи
        open("http://samples.gwtproject.org/samples/Showcase/Showcase.html#!CwCellList");
        $(byCssSelector(".middleCenterInner > div:nth-child(1) > table:nth-child(1) > tbody:nth-child(1) > tr:nth-child(2) > td:nth-child(2) > input:nth-child(1)")).setValue(" ");
        $(byCssSelector(".middleCenterInner > div:nth-child(1) > table:nth-child(1) > tbody:nth-child(1) > tr:nth-child(3) > td:nth-child(2) > input:nth-child(1)")).setValue(" ");
        $(byCssSelector(".gwt-TextArea")).setValue(" ");
        $(byCssSelector("button.gwt-Button:nth-child(2)")).click();
        $("div.GNHGC04CCB:nth-child(1)").sendKeys(Keys.chord(Keys.END));
        $("div.GNHGC04CCB:nth-child(251)").shouldNot(exist);





//тестируем редактирование в строке
        open("http://samples.gwtproject.org/samples/Showcase/Showcase.html#!CwCellTable");
        $(byCssSelector("tr.GNHGC04CBD:nth-child(1) > td:nth-child(2) > div:nth-child(1)")).doubleClick();
        $(byCssSelector("tr.GNHGC04CBD:nth-child(1) > td:nth-child(2) > div:nth-child(1)")).$(byXpath("./input")).setValue("John");
        $(byCssSelector("tr.GNHGC04CBD:nth-child(1) > td:nth-child(2) > div:nth-child(1)")).pressTab();
        $(byCssSelector("tr.GNHGC04CBD:nth-child(1) > td:nth-child(3) > div:nth-child(1)")).doubleClick();
        $(byCssSelector("tr.GNHGC04CBD:nth-child(1) > td:nth-child(3) > div:nth-child(1)")).$(byXpath("./input")).setValue("Wayne");
        $(byCssSelector("tr.GNHGC04CBD:nth-child(1) > td:nth-child(3) > div:nth-child(1)")).pressTab();
        $(byCssSelector("tr.GNHGC04CBD:nth-child(1) > td:nth-child(2) > div:nth-child(1)")).shouldHave(exactText("John"));
        $(byCssSelector("tr.GNHGC04CBD:nth-child(1) > td:nth-child(3) > div:nth-child(1)")).shouldHave(exactText("Wayne"));



//тестируем переходы по страницам
        open("http://samples.gwtproject.org/samples/Showcase/Showcase.html#!CwCellTable");
        //вперед
        $(byCssSelector("td.GNHGC04CLH:nth-child(4) > img:nth-child(1)")).click();
        $(byCssSelector("div.gwt-HTML:nth-child(1)")).shouldHave(text("16-30 of 250"));
        $(byCssSelector("td.GNHGC04CLH:nth-child(5) > img:nth-child(1)")).click();
        $(byCssSelector("div.gwt-HTML:nth-child(1)")).shouldHave(text("241-250 of 250"));
        //назад
        $(byCssSelector("td.GNHGC04CLH:nth-child(2) > img:nth-child(1)")).click();
        $(byCssSelector("div.gwt-HTML:nth-child(1)")).shouldHave(text("226-240 of 250"));
        $(byCssSelector("td.GNHGC04CLH:nth-child(1) > img:nth-child(1)")).click();
        $(byCssSelector("div.gwt-HTML:nth-child(1)")).shouldHave(text("1-15 of 250"));


//тестируем сохранение состояния чекбокса при смене страниц и сортировки
        open("http://samples.gwtproject.org/samples/Showcase/Showcase.html#!CwCellTable");
        $(byCssSelector("th.GNHGC04CHD:nth-child(2)")).click();
        $(byCssSelector("tr.GNHGC04CBD:nth-child(1) > td:nth-child(1) > div:nth-child(1) > input:nth-child(1)")).click();
        $(byCssSelector("th.GNHGC04CHD:nth-child(2)")).click();
        $(byCssSelector("th.GNHGC04CHD:nth-child(2)")).click();
        $(byCssSelector("tr.GNHGC04CBD:nth-child(1) > td:nth-child(1) > div:nth-child(1) > input:nth-child(1)")).isSelected();
        $(byCssSelector("td.GNHGC04CLH:nth-child(4) > img:nth-child(1)")).click();
        $(byCssSelector("td.GNHGC04CLH:nth-child(2) > img:nth-child(1)")).click();
        $(byCssSelector("tr.GNHGC04CBD:nth-child(1) > td:nth-child(1) > div:nth-child(1) > input:nth-child(1)")).isSelected();
        $(byCssSelector("td.GNHGC04CLH:nth-child(5) > img:nth-child(1)")).click();
        $(byCssSelector("td.GNHGC04CLH:nth-child(1) > img:nth-child(1)")).click();
        $(byCssSelector("tr.GNHGC04CBD:nth-child(1) > td:nth-child(1) > div:nth-child(1) > input:nth-child(1)")).isSelected();

// тестируем сортировку
        open("http://samples.gwtproject.org/samples/Showcase/Showcase.html#!CwCellTable");
        $(byCssSelector("th.GNHGC04CHD:nth-child(2)")).click();
        String txt1,txt2;
        $(byCssSelector("tr.GNHGC04CBD:nth-child(1) > td:nth-child(2) > div:nth-child(1)")).doubleClick();
        txt1 = $(byCssSelector("tr.GNHGC04CBD:nth-child(1) > td:nth-child(2) > div:nth-child(1)")).$(byXpath("./input")).getValue();
        $(byCssSelector("tr.GNHGC04CBD:nth-child(1) > td:nth-child(2) > div:nth-child(1)")).pressEscape();
        $(byCssSelector("tr.GNHGC04CBE:nth-child(4) > td:nth-child(2) > div:nth-child(1)")).doubleClick();
        txt2 = $(byCssSelector("tr.GNHGC04CBE:nth-child(4) > td:nth-child(2) > div:nth-child(1)")).$(byXpath("./input")).getValue();
        int res = 0;
        res =  txt1.compareTo(txt2);
        if (res >0) Assert.fail();


        driver.quit();

    }
}