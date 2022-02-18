package hr.ferit.dominikzivko.hgtest

import hr.ferit.dominikzivko.hgtest.model.HomePage
import org.testng.annotations.Test

class GenericTests : HgShopTests(HomePage.URL) {

    @Test
    fun `Search returns result`() {
        val searchQuery = "kabel apple usb-c"
        val homePage = HomePage(driver)
        val resultsPage = homePage.searchArticles(searchQuery)
        val firstResult = resultsPage.searchResults.first()
        assert(firstResult.name.startsWith("kabel apple usb-c", ignoreCase = true))
    }
}