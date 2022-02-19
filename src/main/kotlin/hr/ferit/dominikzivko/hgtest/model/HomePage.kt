package hr.ferit.dominikzivko.hgtest.model

import org.openqa.selenium.By
import org.openqa.selenium.Keys
import org.openqa.selenium.WebDriver

class HomePage(private val driver: WebDriver) {

    private val searchBarBy = By.name("q")
    private val featuredArticleLinksBy = By.cssSelector(".product-name a")

    val firstFeaturedArticleName get() = driver.findElement(featuredArticleLinksBy).text

    fun searchArticles(query: String): ResultsPage {
        driver.findElement(searchBarBy).run {
            sendKeys(query)
            submit()
        }
        return ResultsPage(driver)
    }

    fun goToFirstFeaturedArticle(): ArticlePage {
        driver.findElement(featuredArticleLinksBy).sendKeys(Keys.RETURN)
        return ArticlePage(driver)
    }

    companion object {
        const val URL = "https://www.hgspot.hr/"
    }
}