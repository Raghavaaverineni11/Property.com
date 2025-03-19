/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */

package real.estate.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import real.estate.Entity.Property;

/**
 *
 * @author ragha
 */
@Repository
public interface PropertyRepository extends JpaRepository<Property, Long> {
         
}