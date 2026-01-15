package com.juan.portfolio.client;

import com.juan.portfolio.model.dto.GitHubRepoDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestClient;

import java.util.Arrays;
import java.util.List;

@Component
public class GitHubClient {
    @Autowired
    GitHubClientProps props;

    private final RestClient restClient;
    public GitHubClient (){

        this.restClient = RestClient.builder()
                            .baseUrl(props.baseUrl())
                            .defaultHeader(HttpHeaders.ACCEPT, "application/vnd.github+json")
                            .defaultHeader(HttpHeaders.USER_AGENT, props.userAgent())
                            .defaultHeader(HttpHeaders.AUTHORIZATION, "Bearer " + props.token())
                            .build();

    }

    //ToDo: Verify this jeje
    public List<GitHubRepoDTO> listUserRepos(String username) {
        GitHubRepoDTO[] repos = restClient.get()
                                .uri("/users/{user}/repos?per_page=100&sort=updated", username)
                                .retrieve()
                                .body(GitHubRepoDTO[].class);

        return repos == null ? List.of() : Arrays.asList(repos);
    }


}
