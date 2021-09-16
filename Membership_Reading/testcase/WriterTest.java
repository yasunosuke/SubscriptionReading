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
	
//	Writer�N���X�̓���̃t�B�[���h������Ă���
	Field getWriterField(String fieldName) throws Exception {
		Field f = Writer.class.getDeclaredField(fieldName);
		f.setAccessible(true);
		return f;
	}
	
//	�w�肳�ꂽ�C���X�^���X��name�̒l���Ƃ��Ă���
	String getWriterName(Writer obj) throws Exception {
		Field f = getWriterField("name");
		return (String) f.get(obj);
	}
	
	@Test
	void testGetDoneArticles() throws Exception {
//		fail("������");
//		
//		Writer w = new Writer("test") {
//			public void putDoneArticles() {
//				System.out.println("a");
//			}
//		};
	}
//	
//�@�\����
//	@Test
//	void testWrite() throws Exception {
//
//		String name = "a";
//		Writer w = new Writer(name);
//		
//		in.inputln("aaaaaa");
//		w.write(new Scanner(System.in));
//		outContent.toString();
//		assertEquals("1�����ȏ�T�����ȓ��Ɏ��߂Ă��������B\n", outContent.toString());
//	}
	
	@Test
	void testWrite() throws Exception {
		String name = "a";
		Writer w = new Writer(name);
		
		w.write(new Scanner(System.in));
		
		Article a = getDoneArticles(w).get("a");
		
		ArticleTest at = new ArticleTest();
		
//		���͂����l�Ǝ���Ă����l�����ꂼ���ׂ�
//		�L���ԍ�
		assertEquals(1, a.getArticleNumber());
//		
		LocalDate now = LocalDate.now();
		assertEquals("a", at.getTitleByReflection(a));
		assertEquals(now, at.getWrittenDateByReflection(a));
		assertEquals(true, at.getLimitedByReflection(a));
		assertEquals("body", at.getBodyByReflection(a));
	}
	
//	�w�肳�ꂽ�C���X�^���X��doneArticles�̒l���Ƃ��Ă���
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
