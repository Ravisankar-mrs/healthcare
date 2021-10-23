package com.slokam.healthcare.Service;

import java.util.List;

import org.springframework.stereotype.Service;
@Service
public  interface IVisitingService {
	public List<Object[]> getVisitingsBypaitentId(Integer id);

}
