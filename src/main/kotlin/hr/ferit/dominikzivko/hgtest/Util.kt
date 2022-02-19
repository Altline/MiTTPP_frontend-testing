package hr.ferit.dominikzivko.hgtest

import org.openqa.selenium.WebDriver
import org.openqa.selenium.support.ui.ExpectedCondition
import org.openqa.selenium.support.ui.WebDriverWait
import java.time.Duration

fun <T> WebDriver.wait(timeout: Duration, expectedCondition: ExpectedCondition<T>) =
    WebDriverWait(this, timeout).until(expectedCondition)