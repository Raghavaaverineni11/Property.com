/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package real.estate.Controller;

/**
 *
 * @author ragha
 */



import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import real.estate.Entity.Property;
import real.estate.Repositories.PropertyRepository;

@RestController
@RequestMapping("/api/properties")
public class PropertyController {
    @Autowired
    private PropertyRepository propertyRepository;

    // ✅ Get All Available Properties (Accessible to Everyone)
    @GetMapping
    public List<Property> getAllProperties() {
        return propertyRepository.findAll();
    }
}
