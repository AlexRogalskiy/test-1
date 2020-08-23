package com.mesh.test.webapi.resource;

import com.mesh.test.service.DateTimeService;
import com.mesh.test.model.ProfilesGetRequestDTO;
import com.mesh.test.model.ProfilesSetRequestDTO;
import com.mesh.test.model.ProfilesSetResponseDTO;
import com.mesh.test.repository.ProfileRepository;
import com.mesh.test.repository.entity.Profile;
import com.mesh.test.webapi.ProfilesApi;
import com.mesh.test.webapi.exception.ForbiddenRestException;
import com.mesh.test.webapi.exception.NotFoundRestException;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Component;

import javax.validation.Valid;
import javax.ws.rs.core.Response;

@Component
public class ProfilesApiImpl implements ProfilesApi {
    ProfileRepository profileRepository;

    public ProfilesApiImpl(ProfileRepository profileRepository) {
        this.profileRepository = profileRepository;
    }

    @Override
    public Response getProfiles() {
        return Response.ok()
                .entity(profileRepository.findAll())
                .build();
    }

    @Override
    public Response postProfilesSet(@Valid ProfilesSetRequestDTO profileDTO) {
        Profile profile;

        profileDTO.setEmail(profileDTO.getEmail().toLowerCase());
        profileDTO.setName(profileDTO.getName().toLowerCase());

        try {
            profile = profileRepository.save(new Profile(profileDTO, DateTimeService.getCurrent()));
        } catch (DataIntegrityViolationException e) {
            throw new ForbiddenRestException("Запись с таким email уже создана");
        }

        return Response.ok()
                .entity(new ProfilesSetResponseDTO().idUser(profile.getId()))
                .build();
    }

    @Override
    public Response getProfilesLast() {
        Profile profile = profileRepository.findByLastDate()
                .orElseThrow(() -> new NotFoundRestException("Профилей не найдено"));

        return Response.ok()
                .entity(profile)
                .build();
    }

    @Override
    public Response getProfilesId(Integer id) {
        Profile profile = profileRepository.findById(id)
                .orElseThrow(() -> new NotFoundRestException("Запись с таким ID не найдена"));

        return Response.ok()
                .entity(profile)
                .build();
    }

    @Override
    public Response postProfilesGet(@Valid ProfilesGetRequestDTO profilesGetRequestDTO) {
        String email = profilesGetRequestDTO.getEmail().toLowerCase();
        Profile profile = profileRepository.findByEmail(email)
                .orElseThrow(() -> new NotFoundRestException("Запись с таким email не найдена"));

        return Response.ok()
                .entity(profile)
                .build();
    }

}
