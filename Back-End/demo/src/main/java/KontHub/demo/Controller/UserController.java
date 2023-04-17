package KontHub.demo.Controller;

import KontHub.demo.Models.Repositorio;
import KontHub.demo.Models.User;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@RequestMapping("/")
@RestController
@CrossOrigin(origins = "*")
public class UserController {
    RestTemplate restTemplate = new RestTemplate();
    RestTemplateBuilder restTemplateBuilder = new RestTemplateBuilder();
    final String url = "https://api.github.com/users/";
    @GetMapping("/user/{login}")
    public ResponseEntity usuario(@PathVariable String login){
        restTemplate = restTemplateBuilder.build();
        try{
            User user = restTemplate.getForObject(url + login, User.class);
            return ResponseEntity.ok(user);
        }catch (Exception e){
            return ResponseEntity.badRequest().body("Usuario não encontrado");
        }
    }

    @GetMapping("/user/{login}/repos")
    public Page<Repositorio> repoUsuario(@PathVariable String login, Pageable pageable){
        restTemplate = restTemplateBuilder.build();
        try{
            ResponseEntity<Repositorio[]> repositorio = restTemplate.getForEntity(url + login + "/repos", Repositorio[].class);
            List<Repositorio> repositorioList = Arrays.asList(repositorio.getBody());
            return new PageImpl<>(repositorioList, pageable, repositorioList.size());
        }catch (Exception e){
            throw new RuntimeException("Erro ao buscar lista de repositórios");
        }
    }


}
