import static org.junit.jupiter.api.Assertions.*;

import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.PrintStream;
import java.lang.reflect.Field;
import java.time.LocalDate;
import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.Scanner;

import org.junit.After;
import org.junit.Before;
import org.junit.jupiter.api.Test;

class WriterTest {
	
	private final StandardInputStream in = new StandardInputStream();
	private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
	private final ByteArrayOutputStream errContent = new ByteArrayOutputStream();
	
	@Before
	void setUpStreams() {
		System.setIn(in);
		System.setOut(new PrintStream(outContent));
		System.setErr(new PrintStream(errContent));
	}
	
	@After
	void cleanUpStream() {
		System.setIn(null);
		System.setOut(null);
		System.setErr(null);
	}

	@Test
	void testWriter() throws Exception {
		String name = "a";
		Writer w = new Writer(name);
		
		assertEquals(name, getWriterName(w));
		
	}
	
//	Writerクラスの特定のフィールドを取ってくる
	Field getWriterField(String fieldName) throws Exception {
		Field f = Writer.class.getDeclaredField(fieldName);
		f.setAccessible(true);
		return f;
	}
	
//	指定されたインスタンスのnameの値をとってくる
	String getWriterName(Writer obj) throws Exception {
		Field f = getWriterField("name");
		return (String) f.get(obj);
	}
	
	@Test
	void testGetDoneArticles() throws Exception {
//		fail("未実装");
//		
//		Writer w = new Writer("test") {
//			public void putDoneArticles() {
//				System.out.println("a");
//			}
//		};
	}
//	
//機能せず
//	@Test
//	void testWrite() throws Exception {
//
//		String name = "a";
//		Writer w = new Writer(name);
//		
//		in.inputln("aaaaaa");
//		w.write(new Scanner(System.in));
//		outContent.toString();
//		assertEquals("1文字以上５文字以内に収めてください。\n", outContent.toString());
//	}
	
	@Test
	void testWrite() throws Exception {
		String name = "a";
		Writer w = new Writer(name);
		
		w.write(new Scanner(System.in));
		
		Article a = getDoneArticles(w).get("a");
		
		ArticleTest at = new ArticleTest();
		
//		入力した値と取ってきた値をそれぞれ比べる
//		記事番号
		assertEquals(1, a.getArticleNumber());
//		
		LocalDate now = LocalDate.now();
		assertEquals("a", at.getTitleByReflection(a));
		assertEquals(now, at.getWrittenDateByReflection(a));
		assertEquals(true, at.getLimitedByReflection(a));
		assertEquals("body", at.getBodyByReflection(a));
	}
	
//	指定されたインスタンスのdoneArticlesの値をとってくる
	LinkedHashMap<String, Article> getDoneArticles(Writer obj) throws Exception {
		Field f = getWriterField("doneArticles");
		return (LinkedHashMap<String, Article>) f.get(obj);
	}
	
	

}

class StandardInputStream extends InputStream {
	private StringBuilder sb = new StringBuilder();
	private String lf = System.getProperty("line.separator");
	
	public void inputln(String str) {
		sb.append(str).append(lf);
	}
	
	@Override
	public int read() {
		if(sb.length() == 0) return -1;
		int result = sb.charAt(0);
		sb.deleteCharAt(0);
		return result;
	}
 }
