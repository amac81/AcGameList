package pt.bitclinic.AcGameList.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import pt.bitclinic.AcGameList.dto.GameDTO;
import pt.bitclinic.AcGameList.dto.GameMinDTO;
import pt.bitclinic.AcGameList.services.GameService;

//the controller is the object that "implements" the API
//is the "front door" to our backend

@RestController
@RequestMapping(value = "games")
public class GameController {

	@Autowired
	private GameService gameService;
	
	@GetMapping(value = "/{id}")
	public GameDTO getByID(@PathVariable Long id) {
		return gameService.findById(id);
	}

	@GetMapping
	public List<GameMinDTO> getObjects() {
		return gameService.findAll();
	}
}
