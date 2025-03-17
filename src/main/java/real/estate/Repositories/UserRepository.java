/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */

package real.estate.Repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import real.estate.Entity.User;

/**
 *
 * @author ragha
 */
public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByEmail(String email);
}
