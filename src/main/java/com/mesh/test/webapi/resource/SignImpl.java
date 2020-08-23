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
    public Response postSign(@Valid UserDTO userDTO) {
        UserEntity user;

        try {
            user = userRepository.save(
                    new UserEntity(userDTO.getUsername(), passwordEncoder.encode(userDTO.getPassword())));
        } catch (DataIntegrityViolationException e) {
            throw new ForbiddenRestException("Пользователь с таким логином уже существует");
        }

        return Response.ok()
                .entity(new SignUserResponseDTO().userId(user.getId()))
                .build();
    }
}
