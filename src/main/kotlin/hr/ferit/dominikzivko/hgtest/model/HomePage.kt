package hr.ferit.dominikzivko.hgtest.model

import org.openqa.selenium.By
import org.openqa.selenium.Keys
import org.openqa.selenium.WebDriver

class HomePage(private val driver: WebDriver) {

    private val searchBarBy = By.name("q")
    private val featuredArticleLinksBy = By.cssSelector(".product-name a")

    fun findFeaturedArticleName(index: Int): String =
        driver.findElements(featuredArticleLinksBy)[index].text

    fun searchArticles(query: String): ResultsPage {
        driver.findElement(searchBarBy).run {
            sendKeys(query)
            submit()
        }
        return ResultsPage(driver)
    }

    fun goToFeaturedArticle(index: Int): ArticlePage {
        driver.findElements(featuredArticleLinksBy)[index].sendKeys(Keys.ENTER)
        return ArticlePage(driver)
    }

    companion object {
        const val URL = "https://www.hgspot.hr/"

        fun navigate(driver: WebDriver): HomePage {
            driver.navigate().to(URL)
            return HomePage(driver)
        }
    }
}