package com.launchacademy.teamrosterwithspring.controllers;

import com.launchacademy.teamrosterwithspring.models.League;
import com.launchacademy.teamrosterwithspring.models.Team;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.server.ResponseStatusException;

@Controller
@RequestMapping("/")
public class TeamsController {

  private League league = League.getLeague();

  @GetMapping("/")
  public String getTeams(Model model){
    model.addAttribute("teams", league.getTeams());
    return "teams/index";
  }

  @GetMapping("/teams/{teamId}")
  public String getTeam(@PathVariable Integer teamId, Model model) {
    if(teamId >= league.getTeams().size() || teamId <0) {
      throw new ResponseStatusException(HttpStatus.NOT_FOUND);
    } else {
      Team team = league.getTeams().get(teamId);
      model.addAttribute("team", team);
      return ("teams/show");
    }
  }
}





















