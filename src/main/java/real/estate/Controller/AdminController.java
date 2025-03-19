/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package real.estate.Controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import real.estate.Entity.Property;
import real.estate.Entity.User;
import real.estate.Repositories.PropertyRepository;
import real.estate.Repositories.UserRepository;

/**
 *
 * @author ragha
 */
@RestController
@RequestMapping("/api/admin")
public class AdminController {
    @Autowired
    private PropertyRepository propertyRepository;

    @Autowired
    private UserRepository userRepository;

    // ✅ Create a New Property Listing (Admin Only)
    @PostMapping("/property")
    public ResponseEntity<String> createProperty(@RequestBody Property property, Authentication authentication) {
        String adminEmail = authentication.getName();
        Optional<User> adminUser = userRepository.findByEmail(adminEmail);

        if (adminUser.isPresent()) {
            property.setAdmin(adminUser.get());
            propertyRepository.save(property);
            return ResponseEntity.ok("Property listed successfully!");
        }
        return ResponseEntity.badRequest().body("Unauthorized!");
    }

    // ✅ Update a Property Listing (Admin Only)
    @PutMapping("/property/{id}")
    public ResponseEntity<String> updateProperty(@PathVariable Long id, @RequestBody Property updatedProperty) {
        Optional<Property> existingProperty = propertyRepository.findById(id);

        if (existingProperty.isPresent()) {
            Property property = existingProperty.get();
            property.setTitle(updatedProperty.getTitle());
            property.setPrice(updatedProperty.getPrice());
            property.setLocation(updatedProperty.getLocation());
            property.setDescription(updatedProperty.getDescription());
            property.setImageUrl(updatedProperty.getImageUrl());
            propertyRepository.save(property);
            return ResponseEntity.ok("Property updated successfully!");
        }
        return ResponseEntity.badRequest().body("Property not found!");
    }

    // ✅ Delete a Property Listing (Admin Only)
    @DeleteMapping("/property/{id}")
    public ResponseEntity<String> deleteProperty(@PathVariable Long id) {
        propertyRepository.deleteById(id);
        return ResponseEntity.ok("Property deleted successfully!");
    }
}
