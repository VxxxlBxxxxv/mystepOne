
import com.codeborne.selenide.WebDriverRunner;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import sun.awt.SunHints;

import java.net.URL;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selectors.byCssSelector;
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



        open("http://samples.gwtproject.org/samples/Showcase/Showcase.html#!CwCellList");
        $("button.gwt-Button:nth-child(3)").click();
        $("div.GNHGC04CCB:nth-child(1)").sendKeys(Keys.chord(Keys.END));
        $("div.GNHGC04CCB:nth-child(300)").exists();
        $("#gwt-debug-contentPanel > div:nth-child(2) > div:nth-child(1) > div:nth-child(2) > div:nth-child(1) > div:nth-child(3) > div:nth-child(1) > div:nth-child(1) > div:nth-child(1) > table:nth-child(1) > tbody:nth-child(1) > tr:nth-child(1) > td:nth-child(1) > div:nth-child(2)").shouldHave(text("300"));


        open("http://samples.gwtproject.org/samples/Showcase/Showcase.html#!CwCellList");
        $("div.GNHGC04CCB:nth-child(1)").click();
        $(byCssSelector(".middleCenterInner > div:nth-child(1) > table:nth-child(1) > tbody:nth-child(1) > tr:nth-child(2) > td:nth-child(2) > input:nth-child(1)")).setValue("John");
        $(byCssSelector(".middleCenterInner > div:nth-child(1) > table:nth-child(1) > tbody:nth-child(1) > tr:nth-child(3) > td:nth-child(2) > input:nth-child(1)")).setValue("Wayne");
        $(byCssSelector(".middleCenterInner > div:nth-child(1) > table:nth-child(1) > tbody:nth-child(1) > tr:nth-child(4) > td:nth-child(2) > select:nth-child(1)")).selectOption("Friends");
        $(byCssSelector(".gwt-DateBox")).setValue("May 26, 1907");
        $(".gwt-DateBox").pressTab();
        $(byCssSelector(".gwt-TextArea")).setValue("31546 Olive-Tree Heaven");
        $(byCssSelector("button.gwt-Button:nth-child(1)")).click();




        open("http://samples.gwtproject.org/samples/Showcase/Showcase.html#!CwCellList");
        $(byCssSelector(".middleCenterInner > div:nth-child(1) > table:nth-child(1) > tbody:nth-child(1) > tr:nth-child(2) > td:nth-child(2) > input:nth-child(1)")).setValue(" ");
        $(byCssSelector(".middleCenterInner > div:nth-child(1) > table:nth-child(1) > tbody:nth-child(1) > tr:nth-child(3) > td:nth-child(2) > input:nth-child(1)")).setValue(" ");
        $(byCssSelector(".gwt-TextArea")).setValue(" ");
        $(byCssSelector("button.gwt-Button:nth-child(2)")).click();
        $("div.GNHGC04CCB:nth-child(1)").sendKeys(Keys.chord(Keys.END));
        $("div.GNHGC04CCB:nth-child(251)").shouldNot(exist);




        driver.quit();

    }
}