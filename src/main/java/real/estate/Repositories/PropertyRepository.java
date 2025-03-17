/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */

package real.estate.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import real.estate.Entity.Property;

/**
 *
 * @author ragha
 */
public interface PropertyRepository extends JpaRepository<Property, Long> {
         
}