package pt.bitclinic.AcGameList.services;

import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import pt.bitclinic.AcGameList.dto.GameDTO;
import pt.bitclinic.AcGameList.dto.GameListDTO;
import pt.bitclinic.AcGameList.dto.GameMinDTO;
import pt.bitclinic.AcGameList.entities.Game;
import pt.bitclinic.AcGameList.entities.GameList;
import pt.bitclinic.AcGameList.repositories.GameListRepository;

@Service
public class GameListService {
	@Autowired
	private GameListRepository gameListRepository;

	
	@Transactional(readOnly = true)	
	public List<GameListDTO> findAll() {
		List<GameList> result =  gameListRepository.findAll();
		
		List<GameListDTO> gamesList = result.stream().map(x -> new GameListDTO(x)).toList();
		
		return gamesList;
	}

	
}
