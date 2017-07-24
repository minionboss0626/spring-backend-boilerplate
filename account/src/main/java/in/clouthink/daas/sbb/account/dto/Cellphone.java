package in.clouthink.daas.sbb.account.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import io.swagger.annotations.ApiModel;

/**
 * @author dz
 */
@JsonIgnoreProperties(ignoreUnknown = true)
@ApiModel("电话号码")
public class Cellphone {

	private String cellphone;

	public String getCellphone() {
		return cellphone;
	}

	public void setCellphone(String cellphone) {
		this.cellphone = cellphone;
	}

}
