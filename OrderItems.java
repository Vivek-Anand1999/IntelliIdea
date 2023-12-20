import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class OrderItems {
    public static void addingItemsAtCart(WebDriver driver) {
        String[] inputData = {"Carrot", "Tomato", "Cucumber", "Broccoli", "Cauliflower"};
        List<WebElement> productName = driver.findElements(By.cssSelector("h4.product-name"));
        for (String inputDatum : inputData) {
            for (int i = 0; i < productName.size(); i++) {
                String options = productName.get(i).getText();
                if (options.contains(inputDatum)) {
                    // ! need to add cart
                    System.out.println("found");
                    driver.findElements(By.xpath("//button[text()='ADD TO CART']")).get(i).click();
                    break;
                }
            }
        }
    }

    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\vivek\\Downloads\\chromedriver-win64\\chromedriver-win64\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.get("https://rahulshettyacademy.com/seleniumPractise/#/");

    }
}
