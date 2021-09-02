package ec.edu.espe.oauth2.dto;

public class UserDTO {

	private Integer code;

	private String name;

	private String password;

	private String username;

	public UserDTO(Integer code, String name, String password, String username) {
		super();
		this.code = code;
		this.name = name;
		this.password = password;
		this.username = username;
	}

	public UserDTO() {
		super();
	}

	public Integer getCode() {
		return code;
	}

	public void setCode(Integer code) {
		this.code = code;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	
	
}
