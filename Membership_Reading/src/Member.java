
public abstract class Member {
	public static final int NAME_LENGTH = 5;
	public static final int PASSWORD_LEGTH = 1;
	private final String name;
	
	/**
	 * コンストラクタ
	 * @param name
	 */
	public Member(String name) {
		this.name = name;
	}
	
	abstract void read(int articleNum);
	
	abstract void browseAllArticles();
	
	public void a() {
		
	}
}
