package ec.edu.espe.oauth2.service;

import java.util.List;

import ec.edu.espe.oauth2.dto.UserDTO;

public interface IUserService {

	public List<UserDTO> findAll();
	
	public UserDTO findByUsername(String username);
}
