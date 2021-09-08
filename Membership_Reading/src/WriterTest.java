import static org.junit.jupiter.api.Assertions.*;

import java.lang.reflect.Field;

import org.junit.jupiter.api.Test;

class WriterTest {

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

}
