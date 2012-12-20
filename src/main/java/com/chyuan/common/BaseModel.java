package com.chyuan.common;

import java.io.Serializable;

public class BaseModel implements Serializable {
	private static final long serialVersionUID = 5355473924378504526L;

	/**
	 * 主键
	 */
	private Long id;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
}
