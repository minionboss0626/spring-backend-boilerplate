package in.clouthink.daas.sbb.account.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import io.swagger.annotations.ApiModel;

/**
 * @author dz
 */
@JsonIgnoreProperties(ignoreUnknown = true)
@ApiModel
public class ForgetPasswordParameter {

	private String cellphone;

	private String passcode;

	private String newPassword;

	private String renewPassword;

	public String getCellphone() {
		return cellphone;
	}

	public void setCellphone(String cellphone) {
		this.cellphone = cellphone;
	}

	public String getPasscode() {
		return passcode;
	}

	public void setPasscode(String passcode) {
		this.passcode = passcode;
	}

	public String getNewPassword() {
		return newPassword;
	}

	public void setNewPassword(String newPassword) {
		this.newPassword = newPassword;
	}

	public String getRenewPassword() {
		return renewPassword;
	}

	public void setRenewPassword(String renewPassword) {
		this.renewPassword = renewPassword;
	}
}
