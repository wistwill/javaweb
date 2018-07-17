package com.ian.commons.utils;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @className: JsonObject
 * @description: 响应参数
 * @author: Ian
 * @create: 2018-07-02 17:39
 **/
@Data @AllArgsConstructor @NoArgsConstructor public class JsonObject {

	/**
	 * 描述信息
	 */
	private String message;

	/**
	 * 状态码
	 */
	private String resultCode;

	/**
	 * 对象
	 */
	private Object data;

}