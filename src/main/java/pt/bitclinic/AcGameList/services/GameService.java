package pt.bitclinic.AcGameList.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pt.bitclinic.AcGameList.dto.GameMinDTO;
import pt.bitclinic.AcGameList.entities.Game;
import pt.bitclinic.AcGameList.repositories.GameRepository;

@Service
public class GameService {
	@Autowired
	private GameRepository gameRepository;

	// using JpaRepository to retrieve data from database
	public List<GameMinDTO> findAll() {
		List<Game> result =  gameRepository.findAll();
		
		/*List<GameMinDTO> games = new ArrayList<> () ;
		
		for(Game g: result) {
			games.add(new GameMinDTO(g));
		}*/
		
		List<GameMinDTO> games = result.stream().map(x -> new GameMinDTO(x)).toList();
		
		
		return games;
	}

}
