import static org.junit.Assert.*;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class ArticlesTest {

	@Test
	void testGetInstance() throws Exception {
		Articles article1 = Articles.getInstance();
		Articles article2 = Articles.getInstance();
		
		assertSame(article2, article1);
	}
	
	@Test
	void testRegister() throws Exception {
		Articles artciles = Articles.getInstance();
		articles.register()
	}
	
	@Test
	void testDisplayAllArtilces0101() throws Exception {
		
	}
	
	@Test
	void testDisplayAllArtilces0201() throws Exception {
		
	}
	
	@Test
	void testDisplayAnArticle() throws Exception {
		
	}
	
	@Test
	void testGetArticle() throws Exception {
		
	}
	
}
