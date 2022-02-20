package hr.ferit.dominikzivko.hgtest

import hr.ferit.dominikzivko.hgtest.model.HomePage
import org.testng.annotations.Test
import kotlin.test.assertEquals
import kotlin.test.assertTrue

class GenericTests : HgShopTests() {

    @Test
    fun `Search returns result`() {
        val searchQuery = "kabel apple usb-c"

        val homePage = HomePage.navigate(driver)
        val resultsPage = homePage.searchArticles(searchQuery)
        val firstResult = resultsPage.findResults().first()
        assertTrue(firstResult.findName().startsWith("kabel apple usb-c", ignoreCase = true))
    }

    @Test
    fun `Featured articles accessible from home page`() {
        val homePage = HomePage.navigate(driver)
        val articleName = homePage.findFeaturedArticleName(0)
        val articlePage = homePage.goToFeaturedArticle(0)
        assertEquals(articleName, articlePage.findArticleName())
    }
}