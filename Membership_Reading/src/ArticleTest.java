
import static org.junit.jupiter.api.Assertions.*;

import java.lang.reflect.Field;
import java.time.LocalDate;

import org.junit.jupiter.api.Test;

class ArticleTest {
	
	@Test
	void testArticle1() throws Exception {
		String title = "a";
		LocalDate now = LocalDate.now();
		boolean isLimited = true;
		String body = "";
		Article a = new Article(title, now, isLimited, body);
		
//		以下、期待した値と等しいかどうか　記事番号、タイトル、記事作製時間、有料記事か、本文　の順
		assertEquals(1, getArticleNumber(a));
		
		assertEquals(title, getTitleByReflection(a));
		
		assertEquals(now, getWrittenDateByReflection(a));
		
		assertEquals(isLimited, getLimitedByReflection(a));
		
		assertEquals(body, getBodyByReflection(a));
//		ここまで
	}
	
//	Articleクラスの特定のフィールドを取ってくる
	Field getArticleField(String fieldName) throws Exception {
		Field f = Article.class.getDeclaredField(fieldName);
		f.setAccessible(true);
		return f;
	}
	
//	指定されたインスタンスの記事番号をとってくる
	int getArticleNumber(Article obj) throws Exception {
		Field f = getArticleField("article_number");
		return (int) f.get(obj);
	}
	
//	指定されたインスタンスのタイトルを取ってくる
	String getTitleByReflection(Article obj) throws Exception {
		Field f = getArticleField("title");
		return (String) f.get(obj);
	}
	
//	指定されたインスタンスの記事作成時を取ってくる
	LocalDate getWrittenDateByReflection(Article obj) throws Exception {
		Field f = getArticleField("written_date");
		return (LocalDate) f.get(obj);
	}
	
//	指定されたインスタンスの有料記事かどうかの判定をとってくる
	boolean getLimitedByReflection(Article obj) throws Exception {
		Field f = getArticleField("limited");
		return (boolean) f.get(obj);
	}
	
//	指定されたインスタンスの本文を取ってくる
	String getBodyByReflection(Article obj) throws Exception {
		Field f = getArticleField("body");
		return (String) f.get(obj);
	}
	
	public void testGetArtcleNumber() throws Exception {
		String title = "a";
		LocalDate now = LocalDate.now();
		boolean isLimited = true;
		String body = "";
		Article a = new Article(title, now, isLimited, body);
		
		assertEquals(1, a.getArticleNumber());
	}
	
	public void testGetSummaryArticle01() throws Exception {
		String title = "a";
		LocalDate now = LocalDate.now();
		boolean isLimited = true;
		String body = "";
		Article a = new Article(title, now, isLimited, body);
		
		a.getSummaryArticle();
	}
	
	public void testGetSummaryArticle02() throws Exception {
		String title = "a";
		LocalDate now = LocalDate.now();
		boolean isLimited = false;
		String body = "";
		Article a = new Article(title, now, isLimited, body);
		
		a.getSummaryArticle();
	}
	
	public void testIsLimited() throws Exception {
		String title = "a";
		LocalDate now = LocalDate.now();
		boolean isLimited = false;
		String body = "";
		Article a = new Article(title, now, isLimited, body);
		
		assertFalse(a.isLimited());
	}
	
	public void testDisplayArticles01() throws Exception {
		String title = "a";
		LocalDate now = LocalDate.now();
		boolean isLimited = true;
		String body = "";
		Article a = new Article(title, now, isLimited, body);
		
		a.displayArticle();
	}
	
	public void testDisplayArticles02() throws Exception {
		String title = "a";
		LocalDate now = LocalDate.now();
		boolean isLimited = false;
		String body = "";
		Article a = new Article(title, now, isLimited, body);
		
		a.displayArticle();
	}
	
	
	
	
	

}
