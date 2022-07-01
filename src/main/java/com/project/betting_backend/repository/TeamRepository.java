package com.project.betting_backend.repository;

import com.project.betting_backend.domain.Team;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TeamRepository extends JpaRepository<Team, Integer> {
    void deleteTeamById(Long id);
    Team getTeamById(Long id);
    Boolean findTeamByName(String name);
}
