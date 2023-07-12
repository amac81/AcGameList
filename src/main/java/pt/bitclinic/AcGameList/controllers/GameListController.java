package pt.bitclinic.AcGameList.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import pt.bitclinic.AcGameList.dto.GameListDTO;
import pt.bitclinic.AcGameList.services.GameListService;

//the controller is the object that "implements" the API
//is the "front door" to our backend

@RestController
@RequestMapping(value = "lists")
public class GameListController {

	@Autowired
	private GameListService gameListService;


	@GetMapping
	public List<GameListDTO> getObjects() {
		return gameListService.findAll();
	}
}
