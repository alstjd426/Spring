package com.Lect.week03;

import org.springframework.beans.factory.annotation.Autowired;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public abstract class AbstractCommonService {
	@Autowired
	private Animal cat;

	private int defalutValue = 10;
}
