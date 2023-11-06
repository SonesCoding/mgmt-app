package SD.JPAmgmtapp.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
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
        return (List<user>) UserRepository.findAll();
    }

@GetMapping("/user/{id}")
    Optional<user> desireduser(@PathVariable("id") long id){
        return UserRepository.findById(id);
	}

@DeleteMapping("/user/{id}/delete")
  void deleteuser(@PathVariable Long id) {
    UserRepository.deleteById(id);
  }
	
@PostMapping("/createuser")
    public user createUser(@Valid @RequestBody user User) {
        return UserRepository.save(User);
}
@PutMapping("/user/{id}/update")
public ResponseEntity < user > overwriteUser(@PathVariable("id") long id, @RequestBody user User){

    Optional<user> userDetails = UserRepository.findById(id);

    if (userDetails.isPresent()){
        user newUser = userDetails.get();
        user.setFirstName(user.getFirstName());
        user.setLastName(user.getLastName());
        user.setUsername(user.getUsername());
        user.setUserPassword(user.getUserPassword());
        user.setMobileNumber(user.getMobileNumber());
        user.setEmailAddress(user.getEmailAddress());
        user.setInfoBio(user.getInfoBio());
        user.setUserRole(user.getUserRole());

        return new ResponseEntity<user>(UserRepository.save(newUser), HttpStatus.OK);
    }
    else{
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    }
}

