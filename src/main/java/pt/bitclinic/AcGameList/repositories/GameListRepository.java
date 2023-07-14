package pt.bitclinic.AcGameList.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import pt.bitclinic.AcGameList.entities.GameList;

//using JpaRepository to retrieve data from database

//Object responsible for querying the database
//JpaRepository<entity type, entity id type>

public interface GameListRepository extends JpaRepository<GameList, Long>
{
	@Modifying
	@Query(nativeQuery = true, value = "UPDATE tb_belonging SET position = :newPosition WHERE gamelist_id = :gameListId AND game_id = :gameId")
	void updateBelongingPosition(Long gameListId, Long gameId, Integer newPosition);
}
