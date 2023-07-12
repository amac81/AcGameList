package pt.bitclinic.AcGameList.services;

import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import pt.bitclinic.AcGameList.dto.GameDTO;
import pt.bitclinic.AcGameList.dto.GameMinDTO;
import pt.bitclinic.AcGameList.entities.Game;
import pt.bitclinic.AcGameList.projections.GameMinProjection;
import pt.bitclinic.AcGameList.repositories.GameRepository;

@Service
public class GameService {
	@Autowired
	private GameRepository gameRepository;

	
	@Transactional(readOnly = true)	
	public List<GameMinDTO> findAll() {
		List<Game> result =  gameRepository.findAll();
		
		/*List<GameMinDTO> games = new ArrayList<> () ;
		
		for(Game g: result) {
			games.add(new GameMinDTO(g));
		}*/
		
		List<GameMinDTO> games = result.stream().map(x -> new GameMinDTO(x)).toList();
		
		
		return games;
	}

	@Transactional(readOnly = true)	
	public GameDTO findById(Long id) {	
		GameDTO gameDto = null;
		try {
			Game result = gameRepository.findById(id).get();
			gameDto = new GameDTO(result);
			 
		}
		catch (NoSuchElementException e) {
			System.out.printf("Error: no such GameList with id [%d]", id);
		}
		
		return gameDto;
	}	
	
	
	@Transactional(readOnly = true)	
	public List<GameMinDTO> findByGameList(long gameListId) {
		List<GameMinProjection> result =  gameRepository.searchByList(gameListId);
		
		List<GameMinDTO> games = result.stream().map(x -> new GameMinDTO(x)).toList();
		
		return games;
	}
	
}
