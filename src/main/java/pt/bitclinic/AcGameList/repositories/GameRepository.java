package pt.bitclinic.AcGameList.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import pt.bitclinic.AcGameList.entities.Game;
import pt.bitclinic.AcGameList.projections.GameMinProjection;

//using JpaRepository to retrieve data from database

//Object responsible for querying the database
//JpaRepository<entity type, entity id type>

public interface GameRepository extends JpaRepository<Game, Long>
{
	//custom SQL query
	
	//@Query(nativeQuery = true because we're not using JPQL (from JPA)
	
	@Query(nativeQuery = true, value = """
			SELECT tb_game.id, tb_game.title, tb_game.game_year AS `year`, tb_game.img_url AS imgUrl,
			tb_game.short_description AS shortDescription, tb_belonging.position
			FROM tb_game
			INNER JOIN tb_belonging ON tb_game.id = tb_belonging.game_id
			WHERE tb_belonging.gamelist_id = :listId
			ORDER BY tb_belonging.position
				""")
			List<GameMinProjection> searchByList(Long listId);
	
}






