package hr.ferit.dominikzivko.hgtest.model

import org.openqa.selenium.By
import org.openqa.selenium.Keys
import org.openqa.selenium.WebDriver

class ArticlePage(private val driver: WebDriver) {

    private val articleNameBy = By.cssSelector("#product-info [itemprop=name]")
    private val buyButtonBy = By.cssSelector(".buy a")
    private val continueShoppingButtonBy = By.cssSelector("#kosaricaAdd .kupovina")

    fun findArticleName(): String {
        return driver.findElement(articleNameBy).text
    }

    fun addToCart() {
        driver.findElements(buyButtonBy).takeIf { it.isNotEmpty() }?.let {
            // sleeping because firefox for some reason doesn't register the click when done immediately
            // (selenium waits don't seem to work)
            Thread.sleep(500)
            it.first().sendKeys(Keys.ENTER)
            Thread.sleep(100)
            driver.findElement(continueShoppingButtonBy).sendKeys(Keys.ENTER)
            Thread.sleep(100)
        }
    }
}