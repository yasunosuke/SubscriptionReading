import java.time.LocalDate;

public class ArticleStoreTestHelper {
	public static Article instantiateArticle() {
		
		String title = "a";
		LocalDate now = LocalDate.now();
		boolean isLimited = true;
		String body = "body";
		
		Article article = new Article(title, now, isLimited, body);
		
		return article;
	}
}
