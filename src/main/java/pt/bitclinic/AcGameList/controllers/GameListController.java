package pt.bitclinic.AcGameList.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import pt.bitclinic.AcGameList.dto.GameListDTO;
import pt.bitclinic.AcGameList.dto.GameMinDTO;
import pt.bitclinic.AcGameList.services.GameListService;
import pt.bitclinic.AcGameList.services.GameService;

//the controller is the object that "implements" the API
//is the "front door" to our backend

@RestController
@RequestMapping(value = "lists")
public class GameListController {

	@Autowired
	private GameListService gameListService;
	@Autowired
	private GameService gameService;


	@GetMapping
	public List<GameListDTO> getObjects() {
		return gameListService.findAll();
	}
	
	@GetMapping(value = "/{listId}/games")
	public List<GameMinDTO> findByList(@PathVariable Long listId) {
		
		return gameService.findByGameList(listId);
	}
}
