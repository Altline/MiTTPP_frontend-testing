package hr.ferit.dominikzivko.hgtest.model

import org.openqa.selenium.By
import org.openqa.selenium.Keys
import org.openqa.selenium.WebDriver

class ResultsPage(private val driver: WebDriver) {

    private val resultsBy = By.className("product-hg-horinzontal-view")
    private val priceSortBy = By.id("sort-by-price")

    fun findResults(): List<ArticleResult> {
        return driver.findElements(resultsBy).map {
            ArticleResult(it)
        }
    }

    fun sortByPrice() {
        driver.findElement(priceSortBy).sendKeys(Keys.ENTER)
    }

    companion object {
        const val SAMPLE_CATEGORY_URL = "https://www.hgspot.hr/racunala/prijenosna-racunala/laptopi?page=0"

        fun navigateToSampleCategory(driver: WebDriver): ResultsPage {
            driver.navigate().to(SAMPLE_CATEGORY_URL)
            return ResultsPage(driver)
        }
    }
}
