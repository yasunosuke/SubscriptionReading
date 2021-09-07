import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class ArticlesTest {

	@Test
	void testGetInstance() throws Exception {
		Articles article1 = Articles.getInstance();
		Articles article2 = Articles.getInstance();
		
		assertSame(article2, article1);
	}
	
	
	
	

}
