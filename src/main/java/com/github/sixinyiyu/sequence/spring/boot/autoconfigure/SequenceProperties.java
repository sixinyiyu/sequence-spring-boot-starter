/**
 * Project Name: sequence-spring-boot-starter
 * File Name:    SequenceProperties.java
 * Package Name: com.github.sixinyiyu.sequence.spring.boot.autoconfigure
 * Date:         2020年5月28日下午11:24:02
 * Copyright (c) 2020, sixinyiyu All Rights Reserved.
*/

package com.github.sixinyiyu.sequence.spring.boot.autoconfigure;

import org.springframework.boot.context.properties.ConfigurationProperties;

import lombok.Data;

/**
 * ClassName: SequenceProperties
 * Function:  TODO ADD FUNCTION
 * Reason:    TODO ADD REASON
 * Date:      2020年5月28日 下午11:24:02
 * @author    sixinyiyu@gmail.com
 * @version   1.0
 * @since     JDK 1.8
 */
@ConfigurationProperties("sequence")
@Data
public class SequenceProperties {

	private Long datacenterId;
	
	private Long machineId;
}

