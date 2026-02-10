package org.satvik.moviebooking.Controller;

import org.satvik.moviebooking.Entity.User;
import org.satvik.moviebooking.Service.MovieBookingService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/users")
@CrossOrigin(origins = {"*"})  // We'll update this after deployment
public class UserController {

    private final MovieBookingService service;

    public UserController(MovieBookingService service) {
        this.service = service;
    }

    @PostMapping
    public User addUser(@RequestBody User user) {
        return service.saveUser(user);
    }

    @GetMapping
    public List<User> getAllUsers() {
        return service.getAllUsers();
    }
}
