package hr.ferit.dominikzivko.hgtest.model

import org.openqa.selenium.By
import org.openqa.selenium.WebDriver

class ResultsPage(private val driver: WebDriver) {

    private val searchResultsBy = By.cssSelector("#search-results > section")

    val searchResults get() = driver.findElements(searchResultsBy).map {
        ArticleResult(it)
    }
}
