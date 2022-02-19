package hr.ferit.dominikzivko.hgtest.model

import org.openqa.selenium.By
import org.openqa.selenium.WebDriver

class ArticlePage(private val driver: WebDriver) {

    private val articleNameBy = By.cssSelector("#product-info [itemprop=name]")

    val articleName get() = driver.findElement(articleNameBy).text
}