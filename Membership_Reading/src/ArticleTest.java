
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
		
//		�ȉ��A���҂����l�Ɠ��������ǂ����@�L���ԍ��A�^�C�g���A�L���쐻���ԁA�L���L�����A�{���@�̏�
		assertEquals(1, getArticleNumber(a));
		
		assertEquals(title, getTitleByReflection(a));
		
		assertEquals(now, getWrittenDateByReflection(a));
		
		assertEquals(isLimited, getLimitedByReflection(a));
		
		assertEquals(body, getBodyByReflection(a));
//		�����܂�
	}
	
//	Article�N���X�̓���̃t�B�[���h������Ă���
	Field getArticleField(String fieldName) throws Exception {
		Field f = Article.class.getDeclaredField(fieldName);
		f.setAccessible(true);
		return f;
	}
	
//	�w�肳�ꂽ�C���X�^���X�̋L���ԍ����Ƃ��Ă���
	int getArticleNumber(Article obj) throws Exception {
		Field f = getArticleField("article_number");
		return (int) f.get(obj);
	}
	
//	�w�肳�ꂽ�C���X�^���X�̃^�C�g��������Ă���
	String getTitleByReflection(Article obj) throws Exception {
		Field f = getArticleField("title");
		return (String) f.get(obj);
	}
	
//	�w�肳�ꂽ�C���X�^���X�̋L���쐬��������Ă���
	LocalDate getWrittenDateByReflection(Article obj) throws Exception {
		Field f = getArticleField("written_date");
		return (LocalDate) f.get(obj);
	}
	
//	�w�肳�ꂽ�C���X�^���X�̗L���L�����ǂ����̔�����Ƃ��Ă���
	boolean getLimitedByReflection(Article obj) throws Exception {
		Field f = getArticleField("limited");
		return (boolean) f.get(obj);
	}
	
//	�w�肳�ꂽ�C���X�^���X�̖{��������Ă���
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
