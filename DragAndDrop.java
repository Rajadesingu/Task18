package task18;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class DragAndDrop {

	public static void main(String[] args) {

		WebDriver driver = new ChromeDriver();

		// load URL
		driver.get("https://jqueryui.com/droppable/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

		// Switch to the iframe
		driver.switchTo().frame(0);

		// Find the source and target elements
		WebElement sourceElement = driver.findElement(By.id("draggable"));
		WebElement targetElement = driver.findElement(By.id("droppable"));

		// Perform the drag and drop operation
		Actions mouse = new Actions(driver);

		mouse.dragAndDrop(sourceElement, targetElement).perform();

		// Verify the color property
		String targetElementColor = targetElement.getCssValue("color");

		if (targetElementColor.equals("rgba(119, 118, 32, 1)")) {
			System.out.println("Drag and drop operation is successful");
		} else {
			System.out.println("Drag and drop operation failed.");
		}

		// Verify the text of the target element
		String targetElementText = targetElement.getText();
		if (targetElementText.equals("Dropped!")) {
			System.out.println("Text of the target element has changed to Dropped");
		} else {
			System.out.println("Text of the target element has not changed to Dropped");
		}

	}

}
