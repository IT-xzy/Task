package task07.pojo;


import org.hibernate.validator.constraints.Email;
import org.springframework.context.annotation.Configuration;

import javax.validation.constraints.Size;
import java.io.Serializable;


@Configuration
public class UserLogin implements Serializable {
	private int id;

	@Size(min = 3, max = 20, groups = {UserLoginGroup1.class})
	private String name;

	@Size(min = 6, max = 20, groups = {UserLoginGroup1.class})
	private String password;

	private String salt;

	private String despassword;

	// @Pattern(regexp = "^((13[0-9])|(15[^4])|(18[0-9])|(17[0-9])|(147))\\\\d{8}$"
	// 	,groups = {UserLoginGroup1.class} )

	private String phone_number;


	private String head_photo;

	// @Email(message = "{请输入正确的邮箱}",groups = {UserLoginGroup1.class} )
	@Email(groups = {UserLoginGroup1.class})
	private String email;


	public int getId() {
		return id;
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

	public String getSalt() {
		return salt;
	}

	public void setSalt(String salt) {
		this.salt = salt;
	}

	public String getDespassword() {
		return despassword;
	}

	public void setDespassword(String despassword) {
		this.despassword = despassword;
	}

	public String getPhone_number() {
		return phone_number;
	}

	public void setPhone_number(String phone_number) {
		this.phone_number = phone_number;
	}

	public String getHead_photo() {
		return head_photo;
	}

	public void setHead_photo(String head_photo) {
		this.head_photo = head_photo;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Override
	public String toString() {
		return "UserLogin{" +
				"id=" + id +
				", name='" + name + '\'' +
				", password='" + password + '\'' +
				", salt='" + salt + '\'' +
				", despassword='" + despassword + '\'' +
				", phone_number='" + phone_number + '\'' +
				", head_photo='" + head_photo + '\'' +
				", email='" + email + '\'' +
				'}';
	}
}
