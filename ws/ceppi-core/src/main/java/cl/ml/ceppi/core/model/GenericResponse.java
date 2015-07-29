package cl.ml.ceppi.core.model;

import java.io.Serializable;

/**
 * 
 * @author Maldonado León
 *
 */
public class GenericResponse implements Serializable 
{
	private static final long serialVersionUID = 913772306944545458L;
	
	private String code;
	private Object data;
	private String desc;

	public GenericResponse() {
		super();
		// TODO Auto-generated constructor stub
	}

	public GenericResponse(String code, Object data, String desc) {
		super();
		this.code = code;
		this.data = data;
		this.desc = desc;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public Object getData() {
		return data;
	}

	public void setData(Object data) {
		this.data = data;
	}

	public String getDesc() {
		return desc;
	}

	public void setDesc(String desc) {
		this.desc = desc;
	}

}
