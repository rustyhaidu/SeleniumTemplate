package pageobjects;

import frontend.abstractpage.AbstractPage;
import model.Product;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import java.util.List;

public class ProductListPage extends AbstractPage {

    @FindBy(how = How.CSS, using = "div[class='product-preview-container']")
    private List<WebElement> productList;

    public ProductListPage(WebDriver driver) {
        super(driver);
    }

    public Product clickBuyNow(int index) {
        Product product = new Product();
        WebElement productElement = productList.get(index);
        product.setCode(productElement.findElement(By.className("product_code")).getText());
        product.setName(productElement.findElement(By.className("product_name")).getText());
        String price = productElement.findElement(By.cssSelector("li[class='product_price'] span")).getText();
        if(price.charAt(0) == '0'){
            price = price.substring(1);
            price = price.replace(",", ".");
        }
        product.setPrice(Double.parseDouble(price));

        productElement.findElement(By.cssSelector(".buyNow a")).click();
        return product;
    }

}
