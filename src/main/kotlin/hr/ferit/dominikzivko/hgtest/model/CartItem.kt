package hr.ferit.dominikzivko.hgtest.model

import hr.ferit.dominikzivko.hgtest.wait
import org.openqa.selenium.By
import org.openqa.selenium.Keys
import org.openqa.selenium.WebDriver
import org.openqa.selenium.WebElement
import org.openqa.selenium.support.ui.ExpectedConditions
import java.time.Duration

class CartItem(
    private val element: WebElement,
    private val driver: WebDriver
) {

    private val nameBy = By.cssSelector(".text a")
    private val amountBy = By.cssSelector(".mobile-off .quantity-input")
    private val increaseButtonBy = By.cssSelector(".mobile-off .increase")
    private val decreaseButtonBy = By.cssSelector(".mobile-off .decrease")
    private val removeButtonBy = By.cssSelector(".izbaci-desktop button")

    fun findName(): String {
        return element.findElement(nameBy).text
    }

    fun findAmount(): Int {
        return element.findElement(amountBy).getAttribute("value").toInt()
    }

    fun increaseAmount() {
        element.findElement(increaseButtonBy).click()
    }

    fun decreaseAmount() {
        element.findElement(decreaseButtonBy).click()
    }

    fun removeFromCart() {
        element.findElement(removeButtonBy).sendKeys(Keys.ENTER)
        driver.wait(Duration.ofSeconds(2), ExpectedConditions.stalenessOf(element))
    }
}