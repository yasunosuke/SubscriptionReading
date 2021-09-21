import static org.junit.jupiter.api.Assertions.*;

import java.lang.reflect.Field;

import org.junit.jupiter.api.Test;

class NonePaidMemberTest {

	@Test
	public void testNonePaidMember() throws Exception {
		Articles articles = Articles.getInstance();
		Member npm = new NonePaidMember(articles);
		
		assertEquals("ゲスト", getMemberName(npm));
		assertEquals(articles, )
	}
	
	 //	Hogeクラスの特定のフィールドを取ってくる
		Field getMemberField(String fieldName) throws Exception {
			Field f = Member.class.getDeclaredField(fieldName);
			f.setAccessible(true);
			return f;
		}
		
	     //	指定されたインスタンスのsomethingをとってくる
		String getMemberName(Member obj) throws Exception {
			Field f = getMemberField("name");
			return (String) f.get(obj);
		}
		
		
	
	@Test
	void test() throws Exception {
		
	}

}
