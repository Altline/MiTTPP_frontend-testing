package hr.ferit.dominikzivko.hgtest

import hr.ferit.dominikzivko.hgtest.model.CartPage
import hr.ferit.dominikzivko.hgtest.model.HomePage
import org.testng.annotations.Test
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
        val homePage = HomePage.navigate(driver)
        val featuredArticlePage = homePage.goToAvailableFeaturedArticle(0)
        featuredArticlePage.addToCart()
        val cartPage = CartPage.navigate(driver)
        val firstCartItem = cartPage.findCartItems().first()
        val articleName = firstCartItem.findName()
        firstCartItem.removeFromCart()
        assertFalse(cartPage.hasItem(articleName))
    }
}