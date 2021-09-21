import static org.junit.jupiter.api.Assertions.*;

import java.lang.reflect.Field;

import org.junit.jupiter.api.Test;

class NonePaidMemberTest {

//	name fieldが適切に初期化されているか確かめるためのメソッド。
	@Test
	public void testNonePaidMember() throws Exception {
		
		Articles articles = Articles.getInstance();
		Member npm = new NonePaidMember(articles);
		
		assertEquals("ゲスト", getMemberName(npm));
	}
	
	 //	Memberクラスの特定のフィールドを取ってくる
		Field getMemberField(String fieldName) throws Exception {
			Field f = Member.class.getDeclaredField(fieldName);
			f.setAccessible(true);
			return f;
		}
		
	     //	指定されたインスタンスのnameをとってくる
		String getMemberName(Member obj) throws Exception {
			Field f = getMemberField("name");
			return (String) f.get(obj);
		}
		
// TODO articles field に初期化されたシングルトンと事前に取得したシングルトンが一致するか確かめる	
	@Test
	void test() throws Exception {
		
		Articles articles = Articles.getInstance();
		NonePaidMember npm = new NonePaidMember(articles);
		
		assertEquals(articles, getNonePaidMemberArticles(npm));
	}
	
//	指定されたインスタンスのarticlesをとってくる
	Articles getNonePaidMemberArticles(Member obj) throws Exception {
		Field f = getNonePaidMemberField("articles");
		return (Articles) f.get(obj);
	}
	
//	NonePaidMemberクラスの特定のフィールドを取ってくる
		Field getNonePaidMemberField(String fieldName) throws Exception {
			Field f = NonePaidMember.class.getDeclaredField(fieldName);
			f.setAccessible(true);
			return f;
		}

}
