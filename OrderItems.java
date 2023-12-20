import java.time.Duration;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import io.opentelemetry.exporter.logging.SystemOutLogRecordExporter;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class OrderItems {
    public static void addingItemsAtCart(WebDriver driver) {
        String[] inputData = {"Carrot", "Tomato", "Cucumber", "Brocolli", "Cauliflower"}; // Array save memory as compared to array list(we can convert array but during the run time will convert into array list
        List<WebElement> productName = driver.findElements(By.cssSelector("h4.product-name"));
        int count = 0;
        for (int i = 0; i < productName.size(); i++) {
            String[] options = productName.get(i).getText().split("-");
            String purItemName = options[0].trim();
            System.out.println(purItemName);
            List<String> itemName = Arrays.asList(inputData);
//            List<String> itemsNeededList= Collections.singletonList(pureData[0]); //! If you need a list with a single element, and you want the list to be immutable (not allow modifications),
//            List<String> itemsNeededList= Arrays.asList(pureData[0]); //!If you need a more flexible list that allows modifications and reflects changes to the original array, you can use Arrays.asList.
            if (itemName.contains(purItemName)) {
                count++;
                driver.findElements(By.xpath("//button[text()='ADD TO CART']")).get(i).click();
                if (count == 5) {
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
        //! calling methods:-
        addingItemsAtCart(driver);
    }
}
