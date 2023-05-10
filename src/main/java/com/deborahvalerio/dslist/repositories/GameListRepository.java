package com.deborahvalerio.dslist.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.deborahvalerio.dslist.entities.GameList;

public interface GameListRepository extends JpaRepository<GameList, Long>  {

}
