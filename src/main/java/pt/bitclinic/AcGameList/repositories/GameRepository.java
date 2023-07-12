package pt.bitclinic.AcGameList.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import pt.bitclinic.AcGameList.entities.Game;

//using JpaRepository to retrieve data from database

//Object responsible for querying the database
//JpaRepository<entity type, entity id type>

public interface GameRepository extends JpaRepository<Game, Long>
{

}
