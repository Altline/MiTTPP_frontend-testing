package hr.ferit.dominikzivko.hgtest.model

import org.openqa.selenium.By
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
            // Firefox for some reason doesn't register the click when done immediately
            Thread.sleep(500)
            it.first().click()
            driver.findElement(continueShoppingButtonBy).click()
        }
    }
}