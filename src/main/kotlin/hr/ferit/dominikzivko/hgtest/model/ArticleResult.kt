package hr.ferit.dominikzivko.hgtest.model

import org.openqa.selenium.By
import org.openqa.selenium.WebElement

class ArticleResult(private val element: WebElement) {

    private val nameBy = By.className("product-name")
    private val priceBy = By.cssSelector(".product-price .value")

    fun findName(): String {
        return element.findElement(nameBy).text
    }

    fun findPrice(): String {
        return element.findElement(priceBy).text
    }
}