package com.juan.portfolio.controller;

import com.juan.portfolio.model.dto.ProjectDto;
import com.juan.portfolio.model.dto.ResponseDTO;
import com.juan.portfolio.service.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController("/project")
public class ProjectsController {

    @Autowired
    ProjectService projectService;

    @GetMapping("/")
    public ResponseEntity<ResponseDTO> getProjects(){

        return ResponseEntity.status(201).body(mapProjectsToResponseDTO(projectService.listProjects()));

    }


    public static ResponseDTO mapProjectsToResponseDTO(List<ProjectDto> projects){

        return new ResponseDTO();
    }
}
