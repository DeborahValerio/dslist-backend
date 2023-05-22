package com.deborahvalerio.dslist.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.deborahvalerio.dslist.dto.GameDTO;
import com.deborahvalerio.dslist.dto.GameMinDTO;
import com.deborahvalerio.dslist.services.GameService;

@RestController
@RequestMapping(value = "/games")
public class GameController {

	@Autowired
	private GameService gameService;	

	@GetMapping(value = "/{id}")
	public ResponseEntity<GameDTO> findById(@PathVariable Long id) {
		GameDTO result = gameService.findById(id);
		return ResponseEntity.ok().body(result);
	}
	
	@GetMapping
	public ResponseEntity<List<GameMinDTO>> findAll() {
		List<GameMinDTO> result = gameService.findAll();
		return ResponseEntity.ok().body(result);
	}
}
