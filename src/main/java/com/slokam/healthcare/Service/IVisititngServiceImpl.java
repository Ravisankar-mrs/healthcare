package com.slokam.healthcare.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.slokam.healthcare.Repo.IVisitingRepo;

@Service
public class IVisititngServiceImpl implements IVisitingService{
	@Autowired
     private IVisitingRepo visitingRepo;
	@Override
	public List<Object[]> getVisitingsBypaitentId(Integer id) {
		
		return visitingRepo.getVisitingByPatientId(id);
	}

}
