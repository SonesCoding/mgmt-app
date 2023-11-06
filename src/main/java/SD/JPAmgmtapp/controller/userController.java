package SD.JPAmgmtapp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import SD.JPAmgmtapp.repository.userRepository;
import jakarta.validation.Valid;
import SD.JPAmgmtapp.entity.user;

@RestController
public class userController {
   
    @Autowired
    private userRepository UserRepository;


@GetMapping("/user")
    public List<user> getUsers(){
        return UserRepository.findAll();
    }

@GetMapping("/user/{id}")
    User desireduser(@PathVariable("id") long id){
        return UserRepository.findById(id)
            .orElseThrow(() -> new EmployeeNotFoundException(id));
	}

@DeleteMapping("/user/{id}")
  void deleteuser(@PathVariable Long id) {
    UserRepository.deleteById(id);
  }
	
@PostMapping("/createuser")
    public User createUser(@Valid @RequestBody User user) {
        return UserRepository.save(user);
}

@PutMapping("/updateuser/{id}")
    User overwriteUser(@RequestBody User userDetails, @PathVariable Long id) {
        User user= UserRepository.findById(userId)
            .orElseThrow(() -> new ResourceNotFoundException("No User of this ID >>>" + userId));

        user.setfname(userDetails.getfname());
        user.setlname(userDetails.getlname());
        user.setusername(userDetails.getusername());
        user.setpasswrd(userDetails.getpasswrd());
        user.setinfo(userDetails.getinfo());
        user.setrole(userDetails.getrole());

        final User updateduser = userRepository.save(user);
        return ResponseEntity.ok(updateduser);
    }

}