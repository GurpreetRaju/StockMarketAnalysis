package Model;

public class Login {
	//private String UsrName;
	private String UserID = "myusername";
	private String password = "abc123";
	
	public boolean authenticate(String uid, String pwd){
		System.out.println(uid);
		System.out.println(pwd);
		if(uid.equals(UserID) && pwd.equals(password)){
			return true;
        }
        return false;
	}
}
