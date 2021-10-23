package com.slokam.healthcare.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.slokam.healthcare.Service.IVisitingService;

@RestController
@RequestMapping("visting")
public class VisitingController {
	@Autowired
	private IVisitingService visitingService;
	@GetMapping("/byPatientId/{id}")
	public ResponseEntity<List<Object[]>> getVisitingByPatientId(@PathVariable Integer id){
		return ResponseEntity.ok(visitingService.getVisitingsBypaitentId(id));
	}

}
//@Autowired
//private IVisitingService visitingService;
//@GetMapping("/byPatientId/{id}")
//public ResponseEntity<List<Object[]>>getVisitingsBypaitentId( @PathVariable Integer id){
//	return ResponseEntity.ok(visitingService.getVisitingsBypaitentId(id));
//}
