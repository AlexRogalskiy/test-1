package com.mesh.test.repository;

import com.mesh.test.repository.entity.Profile;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ProfileRepository extends JpaRepository<Profile, Long> {
    @Query(value = "SELECT a.* FROM profile a " +
                        "JOIN (SELECT max(created) from profile) b " +
                            "ON a.created = b.max", nativeQuery = true)
    Optional<Profile> findByLastDate();

    Optional<Profile> findById(int id);

    Optional<Profile> findByEmailIgnoreCase(String email);

}
