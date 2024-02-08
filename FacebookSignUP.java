package task18;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class FacebookSignUP {

	public static void main(String[] args) {

		WebDriver driver = new ChromeDriver();

		// load URL
		driver.get("https://www.facebook.com/");

		// maximize browser
		driver.manage().window().maximize();

		// Verify that the website has been redirected to the Facebook homepage
		String title = driver.getTitle();
		System.out.println(title);

		String title1 = "Facebook – log in or sign up";

		if (title.equals(title1)) {

			System.out.println("Successfully redirected to the Facebook homepage.");

		} else {

			System.out.println("Failed to redirect to the Facebook homepage");

		}

		// adding waits
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

		driver.findElement(By.xpath("//a[text()='Create new account']")).click();

		// Fill in the sign-up form fields
		driver.findElement(By.name("firstname")).sendKeys("Ram");
		driver.findElement(By.name("lastname")).sendKeys("Kumar");
		driver.findElement(By.name("reg_email__")).sendKeys("xaytedvoolmvawhtma@ckptr.com");
		driver.findElement(By.name("reg_email_confirmation__")).sendKeys("xaytedvoolmvawhtma@ckptr.com");
		driver.findElement(By.name("reg_passwd__")).sendKeys("StrongPassword123");
		driver.findElement(By.name("birthday_day")).sendKeys("11");
		driver.findElement(By.name("birthday_month")).sendKeys("May");
		driver.findElement(By.name("birthday_year")).sendKeys("1985");
		driver.findElement(By.name("sex")).click();

		// Step 11: Click on the "Sign Up" button
		driver.findElement(By.name("websubmit")).click();

	}

}
