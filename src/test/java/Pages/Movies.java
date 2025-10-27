package Pages;

import java.time.Duration;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import Pages.MovieDetails;
import Utils.CommonUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.google.common.base.Supplier;

public class Movies {

    WebDriver driver;
    CommonUtils cu;

    public Movies(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
        cu = new CommonUtils(driver);
    }

    @FindBy(xpath = "//div[@class='sc-7o7nez-0 elfplV']")
    List<WebElement> moviesList;

    
    public WebElement verifyMovieDispaly(String city) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        String xpath = "//h1[text()='Movies in " + city + "']";
        return wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xpath)));
    }
    
    public List<Map<String, String>> details() { 
        List<Map<String, String>> moviesList = new ArrayList<>(); 
        List<WebElement> movieElements = driver.findElements(By.xpath("//div[@class='sc-7o7nez-0 elfplV']")); 
        
        // Use index instead of direct element reference
        for(int i = 0; i < movieElements.size(); i++) { 
            // Re-find the elements each time to avoid stale reference
            List<WebElement> currentMovies = driver.findElements(By.xpath("//div[@class='sc-7o7nez-0 elfplV']"));
            
            if(i >= currentMovies.size()) break; // Safety check
            
            WebElement movieElement = currentMovies.get(i);
            Map<String, String> movieDetails = new HashMap<>(); 
            String movieTitle = movieElement.getText().trim(); 
            movieElement.click(); 
            
            MovieDetails md = new MovieDetails(driver); 
            
            if(movieTitle.equalsIgnoreCase(md.movieTitle())) {
                movieDetails.put("Title", md.movieTitle()); 
                
                try { 
                    movieDetails.put("Rating", md.movieRating());
                } catch(Exception e) { 
                    movieDetails.put("Rating", "N/A"); 
                }
                
                try { 
                    movieDetails.put("Votes", md.movieVotes());
                } catch(Exception e) { 
                    movieDetails.put("Votes", "N/A"); 
                }
                
                movieDetails.put("About", md.aboutMovie()); 
                moviesList.add(movieDetails); 
                
                // Go back and wait for page to reload
                driver.navigate().back();
                
                // Wait for movies to be visible again
                new WebDriverWait(driver, Duration.ofSeconds(10))
                    .until(ExpectedConditions.visibilityOfElementLocated(
                        By.xpath("//div[@class='sc-7o7nez-0 elfplV']")));
            }
        }
        
        System.out.println("Movies extracted: " + moviesList); 
        return moviesList;
    }

  
}
