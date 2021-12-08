package com.hiepDH7.SpingBootService1.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.hiepDH7.SpingBootService1.resopitory.LibraryResopitory;
import org.slf4j.LoggerFactory;
import org.slf4j.Logger;



@RestController
public class LibraryController {
	Logger logger = LoggerFactory.getLogger(LibraryController.class);
	@Autowired
	Library lib;
	@Autowired
	LibraryResopitory libra;
	@GetMapping("/getBookss/{id}")
	public List<Library> getBookByID(@PathVariable(value = "id") String id) {
		
		return libra.getLib();
	}
	@GetMapping("/test")
	public String test() {
		logger.trace("FATAL ERROR");
		return "test";
	}
	@GetMapping(value = "/{id}")
	public ResponseEntity<?> getUser(@PathVariable("id") String id  ) {
		Library library = libra.findById(id);
		if(library == null) {
			return new ResponseEntity<String>("No user found with this" + id,HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<Library>(library,HttpStatus.OK);
	}
	@PostMapping("/addLib")
	public ResponseEntity<String> createLib(@RequestBody Library library) {
		if(libra.findById(library.getID()) != null) {
			return new ResponseEntity<String> ("Duplicate entry" + library.getID(),HttpStatus.IM_USED);
		}
		libra.saveLib(library);
		return ResponseEntity.status(HttpStatus.CREATED).build();
	}
	@PutMapping("/update/{id}")
	public ResponseEntity<String> updateLib(@PathVariable(value = "id") String id) {
		Library lib = libra.findById(id);
		lib.setISBN("Yes");
		if(libra.findById(id) == null) {
			return new ResponseEntity<String> ("can not found" + id,HttpStatus.IM_USED);
		}
		libra.updateLib(lib);
		return ResponseEntity.status(HttpStatus.CREATED).build();
	}
	@DeleteMapping("/deleteLib/{id}")
	public ResponseEntity<?> deleteLib(@PathVariable(value = "id") String id) {
		Library library = libra.findById(id);
		if(library == null) {
			return new ResponseEntity<String>("No user found with this" + id,HttpStatus.NOT_FOUND);
		}
		libra.deletebyId(id);
		return new ResponseEntity<Library>(HttpStatus.NO_CONTENT);
	}
}
