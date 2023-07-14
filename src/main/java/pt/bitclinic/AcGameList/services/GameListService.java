package pt.bitclinic.AcGameList.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import pt.bitclinic.AcGameList.dto.GameListDTO;
import pt.bitclinic.AcGameList.entities.GameList;
import pt.bitclinic.AcGameList.projections.GameMinProjection;
import pt.bitclinic.AcGameList.repositories.GameListRepository;
import pt.bitclinic.AcGameList.repositories.GameRepository;

@Service
public class GameListService {
	@Autowired
	private GameListRepository gameListRepository;
	
	@Autowired
	private GameRepository gameRepository;
	
	@Transactional(readOnly = true)	
	public List<GameListDTO> findAll() {
		List<GameList> result =  gameListRepository.findAll();
		
		List<GameListDTO> gamesList = result.stream().map(x -> new GameListDTO(x)).toList();
		
		return gamesList;
	}

	@Transactional
	public void move(Long gameListId, int sourceIndex, int destinationIndex) {
		List<GameMinProjection> list =  gameRepository.searchByList(gameListId);
		
		GameMinProjection removedObj = list.remove(sourceIndex);
		list.add(destinationIndex, removedObj);
		
		int min = sourceIndex < destinationIndex ? sourceIndex : destinationIndex;
		int max = sourceIndex < destinationIndex ? destinationIndex : sourceIndex;
		
		for(int i = min; i <= max; i++) {
			gameListRepository.updateBelongingPosition(gameListId, list.get(i).getId(), i);	
		}	
		
		
		
	}	
	
}
