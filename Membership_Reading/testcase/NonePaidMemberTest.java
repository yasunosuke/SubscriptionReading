import static org.junit.jupiter.api.Assertions.*;

import java.lang.reflect.Field;

import org.junit.jupiter.api.Test;

class NonePaidMemberTest {

	@Test
	public void testNonePaidMember() throws Exception {
		Articles articles = Articles.getInstance();
		Member npm = new NonePaidMember(articles);
		
		assertEquals("�Q�X�g", getMemberName(npm));
		assertEquals(articles, )
	}
	
	 //	Hoge�N���X�̓���̃t�B�[���h������Ă���
		Field getMemberField(String fieldName) throws Exception {
			Field f = Member.class.getDeclaredField(fieldName);
			f.setAccessible(true);
			return f;
		}
		
	     //	�w�肳�ꂽ�C���X�^���X��something���Ƃ��Ă���
		String getMemberName(Member obj) throws Exception {
			Field f = getMemberField("name");
			return (String) f.get(obj);
		}
		
		
	
	@Test
	void test() throws Exception {
		
	}

}
