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
    private val removeButtonBy = By.cssSelector(".izbaci-desktop button")

    fun findName(): String = element.findElement(nameBy).text

    fun removeFromCart() {
        val removeButton = element.findElement(removeButtonBy)
        removeButton.sendKeys(Keys.ENTER)
        driver.wait(Duration.ofSeconds(2), ExpectedConditions.stalenessOf(element))
    }
}