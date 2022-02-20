package hr.ferit.dominikzivko.hgtest

import hr.ferit.dominikzivko.hgtest.model.HomePage
import hr.ferit.dominikzivko.hgtest.model.ResultsPage
import org.testng.annotations.Test
import kotlin.test.assertContentEquals
import kotlin.test.assertTrue

class ResultsTests : HgShopTests() {

    @Test
    fun `Category page accessible from home page`() {
        val homePage = HomePage.navigate(driver)
        val resultsPage = homePage.goToFirstCategory()
        val results = resultsPage.findResults()
        assertTrue(results.isNotEmpty())
    }

    @Test
    fun `Price sorting can be changed`() {
        val resultsPage = ResultsPage.navigateToSampleCategory(driver)
        val results = resultsPage.findResults()
        val ascendingResults = results.sortedBy { it.findPrice() }
        assertContentEquals(ascendingResults, results)

        resultsPage.sortByPrice()
        val resultsAfterSort = resultsPage.findResults()
        val descendingResults = resultsAfterSort.sortedByDescending { it.findPrice() }
        assertContentEquals(descendingResults, resultsAfterSort)
    }
}