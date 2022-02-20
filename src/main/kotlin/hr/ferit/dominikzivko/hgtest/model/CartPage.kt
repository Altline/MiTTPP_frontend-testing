package hr.ferit.dominikzivko.hgtest.model

import org.openqa.selenium.By
import org.openqa.selenium.WebDriver

class CartPage(private val driver: WebDriver) {

    private val cartItemsBy = By.cssSelector(".kosarica-list > li")

    fun findCartItems(): List<CartItem> {
        Thread.sleep(500)
        return driver.findElements(cartItemsBy).map {
            CartItem(it, driver)
        }
    }

    fun hasItem(itemName: String): Boolean {
        return findCartItems().any {
            it.findName() == itemName
        }
    }

    companion object {
        const val URL = "https://www.hgspot.hr/naplata/kosarica"

        fun navigate(driver: WebDriver): CartPage {
            driver.navigate().to(URL)
            return CartPage(driver)
        }
    }
}