package pt.bitclinic.AcGameList.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import pt.bitclinic.AcGameList.entities.Game;


//Object responsible for querying the database
//JpaRepository<entity type, entity id type>

public interface GameRepository extends JpaRepository<Game, Long>
{

}
