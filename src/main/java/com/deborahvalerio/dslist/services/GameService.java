package com.deborahvalerio.dslist.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PathVariable;

import com.deborahvalerio.dslist.dto.GameDTO;
import com.deborahvalerio.dslist.dto.GameMinDTO;
import com.deborahvalerio.dslist.entities.Game;
import com.deborahvalerio.dslist.projections.GameMinProjection;
import com.deborahvalerio.dslist.repositories.GameListRepository;
import com.deborahvalerio.dslist.repositories.GameRepository;
import com.deborahvalerio.dslist.services.exceptions.ResourceNotFoundException;

@Service
public class GameService {
	
	@Autowired
	private GameRepository gameRepository;
	
	@Autowired
	private GameListRepository gameListRepository;
	
	@Transactional(readOnly = true)
	public GameDTO findById(@PathVariable Long id) {
		if (gameRepository.existsById(id)) {
			Game result = gameRepository.findById(id).get();
			return new GameDTO(result);
		}
		else {
			throw new ResourceNotFoundException(id);
		}
	}
	
	@Transactional(readOnly = true)
	public List<GameMinDTO> findAll(){
		List<Game> result = gameRepository.findAll();
		return result.stream().map(x-> new GameMinDTO(x)).toList();
	}
	
	@Transactional(readOnly = true)
	public List<GameMinDTO> findByList(Long listId){
		if (gameListRepository.existsById(listId)) {
			List<GameMinProjection> result = gameRepository.searchByList(listId);
			return result.stream().map(x-> new GameMinDTO(x)).toList();
		}
		else {
			throw new ResourceNotFoundException(listId);
		}
	}
}
