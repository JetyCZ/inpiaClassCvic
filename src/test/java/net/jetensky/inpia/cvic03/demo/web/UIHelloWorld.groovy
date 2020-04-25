package net.jetensky.inpia.cvic03.demo.web;

import geb.Browser
import org.junit.jupiter.api.Test
import org.openqa.selenium.By

import static org.junit.jupiter.api.Assertions.assertEquals

class UIHelloWorld {

@Test
void testUpce() {
    System.setProperty("webdriver.firefox.bin",
      "/apps/vyvoj/sit/firefox54/firefox-bin")

    Browser.drive {
      go 'https://www.upce.cz'
      assertEquals(title, "Univerzita Pardubice")
      driver.findElement(
        By.linkText("Studium")
      ).click()
      assertEquals(
        driver.findElements(
          By.linkText("Stipendia"))
                .size(),1)
    }
}


}