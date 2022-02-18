package hr.ferit.dominikzivko.hgtest

import io.github.bonigarcia.wdm.WebDriverManager
import org.openqa.selenium.WebDriver
import org.openqa.selenium.chrome.ChromeDriver
import org.openqa.selenium.edge.EdgeDriver
import org.openqa.selenium.firefox.FirefoxDriver
import org.testng.annotations.*
import java.time.Duration

abstract class HgShopTests(
    val baseUrl: String
) {
    protected lateinit var browserType: Browser
    protected lateinit var driver: WebDriver

    @BeforeTest
    @Parameters("browser")
    fun setupBrowser(browser: String) {
        browserType = when (browser.lowercase()) {
            "chrome" -> {
                WebDriverManager.chromedriver().setup()
                Browser.CHROME
            }
            "firefox" -> {
                WebDriverManager.firefoxdriver().setup()
                Browser.FIREFOX
            }
            "edge" -> {
                WebDriverManager.edgedriver().setup()
                Browser.EDGE
            }
            else -> throw UnsupportedBrowserException(browser)
        }
    }

    @BeforeMethod
    fun setupPage() {
        driver = when (browserType) {
            Browser.CHROME -> ChromeDriver()
            Browser.FIREFOX -> FirefoxDriver()
            Browser.EDGE -> EdgeDriver()
        }.apply {
            manage().timeouts().implicitlyWait(Duration.ofSeconds(10))
            navigate().to(baseUrl)
        }
    }

    @AfterMethod
    fun cleanup() {
        driver.quit()
    }
}