package hr.ferit.dominikzivko.hgtest

import hr.ferit.dominikzivko.hgtest.model.CartPage
import hr.ferit.dominikzivko.hgtest.model.HomePage
import org.testng.annotations.Test
import kotlin.test.assertEquals
import kotlin.test.assertFalse
import kotlin.test.assertTrue

class CartTests : HgShopTests() {

    @Test
    fun `Add article to cart`() {
        val homePage = HomePage.navigate(driver)
        val featuredArticlePage = homePage.goToAvailableFeaturedArticle(0)
        val articleName = featuredArticlePage.findArticleName()
        featuredArticlePage.addToCart()
        val cartPage = CartPage.navigate(driver)
        assertTrue(cartPage.hasItem(articleName))
    }

    @Test
    fun `Remove article from cart`() {
        addSampleArticleToCart()
        val cartPage = CartPage.navigate(driver)
        val cartItem = cartPage.findCartItems().first()
        val articleName = cartItem.findName()
        cartItem.removeFromCart()
        assertFalse(cartPage.hasItem(articleName))
    }

    @Test
    fun `Modify article amount`() {
        addSampleArticleToCart()
        val cartPage = CartPage.navigate(driver)
        var cartItem = cartPage.findCartItems().first()
        val startingAmount = cartItem.findAmount()

        cartItem.increaseAmount()
        cartItem = cartPage.findCartItems().first()
        val increasedAmount = cartItem.findAmount()
        assertEquals(startingAmount + 1, increasedAmount)

        cartItem.decreaseAmount()
        cartItem = cartPage.findCartItems().first()
        val decreasedAmount = cartItem.findAmount()
        assertEquals(startingAmount, decreasedAmount)
    }

    private fun addSampleArticleToCart() {
        val homePage = HomePage.navigate(driver)
        val featuredArticlePage = homePage.goToAvailableFeaturedArticle(0)
        featuredArticlePage.addToCart()
    }
}