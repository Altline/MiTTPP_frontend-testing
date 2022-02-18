package hr.ferit.dominikzivko.hgtest.model

import org.openqa.selenium.By
import org.openqa.selenium.WebDriver

class HomePage(private val driver: WebDriver) {

    private val searchBarBy = By.name("q")

    fun searchArticles(query: String): ResultsPage {
        driver.findElement(searchBarBy).run {
            sendKeys(query)
            submit()
        }
        return ResultsPage(driver)
    }

    companion object {
        const val URL = "https://www.hgspot.hr/"
    }
}