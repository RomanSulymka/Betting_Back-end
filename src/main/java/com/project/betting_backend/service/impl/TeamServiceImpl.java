package com.project.betting_backend.service.impl;

import com.project.betting_backend.domain.Team;
import com.project.betting_backend.exceptions.NullEntityReferenceException;
import com.project.betting_backend.repository.TeamRepository;
import com.project.betting_backend.service.TeamService;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@Transactional
@Service
public class TeamServiceImpl implements TeamService {

    private final TeamRepository teamRepository;

    public TeamServiceImpl(TeamRepository teamRepository) {
        this.teamRepository = teamRepository;
    }

    @Override
    public Team createNewTeam(Team team) {
        if (!teamRepository.findTeamByName(team.getName())) {
            return teamRepository.save(team);
        }
        throw new NullEntityReferenceException("This team is already added");
    }

    @Override
    public Team updateTeamInfo(Team team) {
        if (team != null) {
            Team oldTeam = getTeamById(team.getId());
            if (oldTeam != null) {
                teamRepository.save(team);
            }
        }
        throw new NullEntityReferenceException("Team can't be null");
    }

    @Override
    public void deleteTeam(Long id) {
        Team team = getTeamById(id);
        if (team != null) {
            teamRepository.deleteTeamById(id);
        }
    }

    @Override
    public Team getTeamById(Long id) {
        if (id != null) {
            return teamRepository.getTeamById(id);
        } else throw new NullEntityReferenceException("Team with id: " + id + " is not exist");
    }

    @Override
    public List<Team> getAllTeams() {
        List<Team> teams = teamRepository.findAll();
        return teams.isEmpty() ? new ArrayList<>() : teams;
    }
}
