/**
 * Project Name: sequence-spring-boot-starter
 * File Name:    SequenceAutoConfigure.java
 * Package Name: com.github.sixinyiyu.sequence.spring.boot.autoconfigure
 * Date:         2020年5月28日下午11:17:36
 * Copyright (c) 2020, sixinyiyu All Rights Reserved.
*/

package com.github.sixinyiyu.sequence.spring.boot.autoconfigure;

import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.github.sixinyiyu.sequence.spring.boot.autoconfigure.itf.ISequenceService;

import lombok.extern.java.Log;


/**
 * ClassName: SequenceAutoConfigure
 * Function:  TODO ADD FUNCTION
 * Reason:    TODO ADD REASON
 * Date:      2020年5月28日 下午11:17:36
 * @author    sixinyiyu@gmail.com
 * @version   1.0
 * @since     JDK 1.8
 */

@Configuration
@ConditionalOnClass(value = ISequenceService.class)
@EnableConfigurationProperties(SequenceProperties.class)
@Log
public class SequenceAutoConfigure {

	@Autowired
	private SequenceProperties sequenceProperties;
	
	@Bean("snowflakeSequence")
    @ConditionalOnMissingBean
    public ISequenceService sequenceService() {
		checkArgus();
        return new SnowflakeSequence(sequenceProperties.getDatacenterId(), sequenceProperties.getMachineId());
    }
	
	private void checkArgus() {
		
		if (Objects.isNull(sequenceProperties.getDatacenterId()) || sequenceProperties.getDatacenterId().longValue() <=0) {
			throw new IllegalArgumentException(" Sequence service Configuration parameter datacenterId can't be less than 0 ");
		}
		
		if (Objects.isNull(sequenceProperties.getMachineId()) || sequenceProperties.getMachineId().longValue() <=0) {
			throw new IllegalArgumentException(" Sequence service Configuration parameter machineId can't be less than 0 ");
		}
		
		log.info("Initializing sequence service client");
	}
}

