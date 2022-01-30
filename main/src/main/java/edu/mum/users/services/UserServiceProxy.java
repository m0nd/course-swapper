package edu.mum.users.services;

import edu.mum.users.domain.User;
import edu.mum.users.services.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;


@Service
public class UserServiceProxy implements IUserService {
    @Autowired
    private RestTemplate restTemplate;
    private final String userUrl = "http://localhost:8084/users/{id}";
    private final String usersUrl = "http://localhost:8084/users";

    @Override
    public List<User> getAll() {
        ResponseEntity<List<User>> response = restTemplate.exchange(usersUrl, HttpMethod.GET, null,
                new ParameterizedTypeReference<List<User>>() {});
        return response.getBody();
    }

    @Override
    public void addNew(User newUser) {
//        URI uri = restTemplate.postForLocation(usersUrl, newUser);
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);

        HttpEntity<User> httpEntity = new HttpEntity<>(newUser, headers);

        restTemplate.postForObject(usersUrl, httpEntity, User.class);
    }

    @Override
    public User getById(Long id) {
        return restTemplate.getForObject(userUrl, User.class, id);
    }

    @Override
    public void update(User user) {
        restTemplate.put(userUrl, user, user.getId());
    }

    @Override
    public void deleteById(Long id) {
        restTemplate.delete(userUrl, id);
    }
}
