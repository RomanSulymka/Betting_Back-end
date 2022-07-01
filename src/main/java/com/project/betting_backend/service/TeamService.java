package com.project.betting_backend.service;

import com.project.betting_backend.domain.Game;
import com.project.betting_backend.domain.Team;

import java.util.List;

public interface TeamService {
    Team createNewTeam(Team team);
    Team updateTeamInfo(Team team);
    void deleteTeam(Long id);
    Team getTeamById(Long id);
    List<Team> getAllTeams();
}
