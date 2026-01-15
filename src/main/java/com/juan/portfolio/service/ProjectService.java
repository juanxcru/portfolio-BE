package com.juan.portfolio.service;


import com.juan.portfolio.client.GitHubClient;
import com.juan.portfolio.model.dto.ProjectDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProjectService {

    @Autowired
    GitHubClient gitHubClient;

    public List<ProjectDto> listProjects(){

        return null;
    }

}
