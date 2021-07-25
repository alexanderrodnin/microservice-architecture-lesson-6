package ru.otus.microservicearchitecture.lesson6.rest.api;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.web.bind.annotation.ResponseBody;
import ru.otus.microservicearchitecture.lesson6.entity.UserEntity;
import ru.otus.microservicearchitecture.lesson6.mapper.UserMapper;
import ru.otus.microservicearchitecture.lesson6.repository.UserRepository;
import ru.otus.microservicearchitecture.lesson6.rest.model.User;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.enums.ParameterIn;
import io.swagger.v3.oas.annotations.media.Schema;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.io.IOException;

@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2021-07-24T17:36:43.343Z[GMT]")
@RestController
public class UserApiController implements UserApi {

    private static final Logger log = LoggerFactory.getLogger(UserApiController.class);

    private final ObjectMapper objectMapper;

    private final HttpServletRequest request;

    private final UserRepository userRepository;

    @org.springframework.beans.factory.annotation.Autowired
    public UserApiController(
            ObjectMapper objectMapper,
            HttpServletRequest request,
            UserRepository userRepository) {
        this.objectMapper = objectMapper;
        this.request = request;
        this.userRepository = userRepository;
    }

    public ResponseEntity<Void> createUser(@Parameter(in = ParameterIn.DEFAULT, description = "Created user object", required=true, schema=@Schema()) @Valid @RequestBody User body) {
        String accept = request.getHeader("Accept");
        userRepository.save(UserMapper.toEntity(body));

        return new ResponseEntity<Void>(HttpStatus.OK);
    }

    public ResponseEntity<Void> deleteUser(@Parameter(in = ParameterIn.PATH, description = "ID of user", required=true, schema=@Schema()) @PathVariable("userId") Long userId) {
        String accept = request.getHeader("Accept");
        userRepository.deleteById(userId);

        return new ResponseEntity<Void>(HttpStatus.OK);
    }

    public ResponseEntity<User> findUserById(@Parameter(in = ParameterIn.PATH, description = "ID of user", required=true, schema=@Schema()) @PathVariable("userId") Long userId) {
        String accept = request.getHeader("Accept");
        if (accept != null && accept.contains("application/json")) {
            return userRepository.findById(userId)
                    .map(item -> UserMapper.toDto(item))
                    .map(item -> ResponseEntity.ok(item))
                    .orElseGet(() -> ResponseEntity.notFound().build());
        }

        return new ResponseEntity<User>(HttpStatus.NOT_ACCEPTABLE);
    }

    public ResponseEntity<Void> updateUser(@Parameter(in = ParameterIn.PATH, description = "ID of user", required=true, schema=@Schema()) @PathVariable("userId") Long userId,@Parameter(in = ParameterIn.DEFAULT, description = "", schema=@Schema()) @Valid @RequestBody User body) {
        String accept = request.getHeader("Accept");

        UserEntity entity = userRepository.findById(userId).orElse(null);
        if (entity != null) {
            body.setId(entity.getId());
            userRepository.save(UserMapper.toEntity(body));

            return new ResponseEntity<Void>(HttpStatus.OK);
        }
        return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
    }

}
