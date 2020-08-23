package com.mesh.test.webapi.resource;

import com.mesh.test.model.SignUserResponseDTO;
import com.mesh.test.model.UserDTO;
import com.mesh.test.repository.UserEntityRepository;
import com.mesh.test.repository.entity.UserEntity;
import com.mesh.test.webapi.SignApi;
import com.mesh.test.webapi.exception.ForbiddenRestException;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import javax.validation.Valid;
import javax.ws.rs.core.Response;

@Component
public class SignImpl implements SignApi {
    UserEntityRepository userRepository;
    PasswordEncoder passwordEncoder;

    public SignImpl(UserEntityRepository userRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }


    @Override
    public Response postSign(@Valid UserDTO user) {
        SignUserResponseDTO signUserResponseDTO = new SignUserResponseDTO();

        try {
            signUserResponseDTO.setUserId(
                    userRepository.save(
                            new UserEntity(user.getUsername(), passwordEncoder.encode(user.getPassword())))
                            .getId());
        } catch (DataIntegrityViolationException e) {
            throw new ForbiddenRestException("Пользователь с таким логином уже существует");
        }

        return Response.ok()
                .entity(signUserResponseDTO)
                .build();
    }
}
