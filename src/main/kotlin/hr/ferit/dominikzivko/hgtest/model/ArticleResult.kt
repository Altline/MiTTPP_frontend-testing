package hr.ferit.dominikzivko.hgtest.model

import org.openqa.selenium.By
import org.openqa.selenium.WebElement

class ArticleResult(private val element: WebElement) {

    private val nameBy = By.className("product-name")

    fun findName(): String = element.findElement(nameBy).text
}