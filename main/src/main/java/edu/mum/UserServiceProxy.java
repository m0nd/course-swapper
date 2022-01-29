package edu.mum;

import edu.mum.users.domain.User;
import edu.mum.users.services.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.net.URI;
import java.util.List;

@Service
public class UserServiceProxy implements IUserService {
    @Autowired
    private RestTemplate restTemplate;
    private final String userUrl = "http://localhost:8080/users/{id}";
    private final String usersUrl = "http://localhost:8080/users";

    @Override
    public List<User> getAll() {
        ResponseEntity<List<User>> response = restTemplate.exchange(usersUrl, HttpMethod.GET, null,
                new ParameterizedTypeReference<List<User>>() {});
        return response.getBody();
    }

    @Override
    public void addNew(User newUser) {
        URI uri = restTemplate.postForLocation(usersUrl, newUser);
    }

    @Override
    public User getById(Long id) {
        return null;
    }

    @Override
    public void update(User user) {

    }

    @Override
    public void deleteById(Long id) {

    }
}
