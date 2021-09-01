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
	 *会員情報を登録するためのメソッド 
	 */
	public void register(String password, PaidMember pm) {
//		パスワードが被っていないか確認
		confirmPassword(password);
		memberList.put(password, pm);
	}
	
	/**
	 * ログイン
	 * @return
	 */
	public PaidMember login(String password) {
		return memberList.get(password);
	}

}
