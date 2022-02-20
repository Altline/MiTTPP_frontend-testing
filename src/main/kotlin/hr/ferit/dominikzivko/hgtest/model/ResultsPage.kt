package hr.ferit.dominikzivko.hgtest.model

import org.openqa.selenium.By
import org.openqa.selenium.WebDriver

class ResultsPage(private val driver: WebDriver) {

    private val resultsBy = By.className("product-hg-horinzontal-view")

    fun findResults(): List<ArticleResult> {
        return driver.findElements(resultsBy).map {
            ArticleResult(it)
        }
    }
}
