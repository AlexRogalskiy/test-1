package com.mesh.test.webapi.resource;

import com.mesh.test.service.DateTimeManager;
import com.mesh.test.service.ExceptionManager;
import com.mesh.test.model.ProfilesGetRequestDTO;
import com.mesh.test.model.ProfilesSetRequestDTO;
import com.mesh.test.model.ProfilesSetResponseDTO;
import com.mesh.test.repository.ProfileRepository;
import com.mesh.test.repository.entity.Profile;
import com.mesh.test.webapi.ProfilesApi;
import com.mesh.test.webapi.exception.BadRequestRestException;
import com.mesh.test.webapi.exception.ForbiddenRestException;
import com.mesh.test.webapi.exception.NotFoundRestException;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Component;

import javax.validation.Valid;
import javax.ws.rs.core.Response;

@Component
public class ProfilesApiImpl implements ProfilesApi {
    ProfileRepository profileRepository;
    DateTimeManager dateTimeManager;
    ExceptionManager exceptionManager;

    public ProfilesApiImpl(ProfileRepository profileRepository, DateTimeManager dateTimeManager, ExceptionManager exceptionManager) {
        this.profileRepository = profileRepository;
        this.dateTimeManager = dateTimeManager;
        this.exceptionManager = exceptionManager;
    }

    @Override
    public Response getProfiles() {
        return Response.ok()
                .entity(profileRepository.findAll())
                .build();
    }

    @Override
    public Response postProfilesSet(@Valid ProfilesSetRequestDTO profile) {
        ProfilesSetResponseDTO profilesSetResponseDTO = new ProfilesSetResponseDTO();

        //isValid(profile.getEmail());
        profile.setEmail(profile.getEmail().toLowerCase());
        profile.setName(profile.getName().toLowerCase());

        try {
            profilesSetResponseDTO.setIdUser(
                    profileRepository.save(
                            new Profile(profile, dateTimeManager.getCurrent()))
                            .getId());
        } catch (DataIntegrityViolationException e) {
            exceptionManager.doThrow(new ForbiddenRestException("Запись с таким email уже создана"));
        }

        return Response.ok()
                .entity(profilesSetResponseDTO)
                .build();
    }

    @Override
    public Response getProfilesLast() {
        return Response.ok()
                .entity(profileRepository.findByLastDate())
                .build();
    }

    @Override
    public Response getProfilesId(Integer id) {
        Profile profile = profileRepository.findById(id);

        if (profile == null)
            exceptionManager.doThrow(new NotFoundRestException("Запись с таким ID не найдена"));

        return Response.ok()
                .entity(profile)
                .build();
    }

    @Override
    public Response postProfilesGet(@Valid ProfilesGetRequestDTO profilesGetRequestDTO) {
        String email = profilesGetRequestDTO.getEmail().toLowerCase();
        Profile profile = profileRepository.findByEmail(email);

        if (profile == null)
            exceptionManager.doThrow(new NotFoundRestException("Запись с таким email не найдена"));

        return Response.ok()
                .entity(profile)
                .build();
    }

    //Добавил проверку на валидность прямо в поле в api.yaml
    private void isValid(String email) {
        if (!email.matches("^\\w+@[a-zA-Z_]+?\\.[a-zA-Z]{2,3}$"))
            exceptionManager.doThrow(new BadRequestRestException("Email не корректен"));
    }

}
