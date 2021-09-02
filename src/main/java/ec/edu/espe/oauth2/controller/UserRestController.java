package ec.edu.espe.oauth2.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ec.edu.espe.oauth2.dto.UserDTO;
import ec.edu.espe.oauth2.service.IUserService;

@RestController
@RequestMapping("/api")
public class UserRestController {

	@Autowired
	private IUserService userService;

	@GetMapping("/user")
	public ResponseEntity<List<UserDTO>> findAll() {
		return new ResponseEntity<>(userService.findAll(), HttpStatus.OK);
	}

	@GetMapping("/user/{username}")
	public ResponseEntity<UserDTO> find(@PathVariable String username) {
		return new ResponseEntity<>(userService.findByUsername(username), HttpStatus.OK);
	}
}
