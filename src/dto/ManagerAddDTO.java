package dto;

/**
 * 添加管理员的dto
 * @author NewBies
 *
 */
public class ManagerAddDTO {
	
	private String managerId;
	
	private String name;
	
	private String password;
	
	private String passwordRepeat;

	public String getManagerId() {
		return managerId;
	}

	public String getName() {
		return name;
	}

	public String getPassword() {
		return password;
	}

	public String getPasswordRepeat() {
		return passwordRepeat;
	}

	public void setManagerId(String managerId) {
		this.managerId = managerId;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public void setPasswordRepeat(String passwordRepeat) {
		this.passwordRepeat = passwordRepeat;
	}
	
	
}
