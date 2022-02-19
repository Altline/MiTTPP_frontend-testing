package hr.ferit.dominikzivko.hgtest

import hr.ferit.dominikzivko.hgtest.model.HomePage
import org.testng.annotations.Test
import kotlin.test.assertEquals
import kotlin.test.assertTrue

class GenericTests : HgShopTests(HomePage.URL) {

    @Test
    fun `Search returns result`() {
        val searchQuery = "kabel apple usb-c"
        val homePage = HomePage(driver)
        val resultsPage = homePage.searchArticles(searchQuery)
        val firstResult = resultsPage.searchResults.first()
        assertTrue(firstResult.name.startsWith("kabel apple usb-c", ignoreCase = true))
    }

    @Test
    fun `Featured articles accessible from home page`() {
        val homePage = HomePage(driver)
        val articleName = homePage.firstFeaturedArticleName
        val articlePage = homePage.goToFirstFeaturedArticle()
        assertEquals(articleName, articlePage.articleName)
    }
}