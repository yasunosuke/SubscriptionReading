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
		
		Field[] fs = getFields();
		fs[1].setAccessible(true);
		LocalDate exnow = (LocalDate) fs[1].get(a);
		
		assertEquals(now, exnow);
		
		assertEquals(title, getTitleByReflection(a));
		
		
	}
	
	String getTitleByReflection(Article obj) throws Exception {
		Field f = Article.class.getDeclaredField("title");
		f.setAccessible(true);
		return (String) f.get(obj);
		
	}
	
	Field[] getFields() throws Exception {
		Field[] fields = Article.class.getDeclaredFields();
		return fields;
	}
	

}
