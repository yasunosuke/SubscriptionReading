import java.util.Map;
import java.util.HashMap;
import java.util.Set;
import java.util.HashSet;

public class Members {
	
	private static Members membersSingleton = new Members();
	
	private Map<String, PaidMember> memberList = new HashMap<String, PaidMember>();
	
	private Members() {
		
	}

	public static Members getInstance() {
		return membersSingleton;
	}
	
	public boolean confirmPassword(String password) {
		return memberList.containsKey(password);
	}
	
	/**
	 *�������o�^���邽�߂̃��\�b�h 
	 */
	public void register(String password, PaidMember pm) {
//		�p�X���[�h������Ă��Ȃ����m�F
		confirmPassword(password);
		memberList.put(password, pm);
	}
	
	/**
	 * ���O�C��
	 * @return
	 */
	public PaidMember login(String password) {
		return memberList.get(password);
	}

}
