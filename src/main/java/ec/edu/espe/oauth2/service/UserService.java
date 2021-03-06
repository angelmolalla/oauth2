package ec.edu.espe.oauth2.service;


import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ec.edu.espe.oauth2.dto.UserDTO;

@Service
public class UserService implements IUserService, UserDetailsService {

	@Autowired
	private JdbcTemplate jdbcTemplate;

	@Override
	@Transactional(readOnly = true)
	public List<UserDTO> findAll() {
		String sql = "SELECT * FROM sys.uzituser";
		return jdbcTemplate.query(sql, (rs, rowNum) -> new UserDTO(rs.getInt("UZITUSER_CODE"),
				rs.getString("UZITUSER_NAME"), rs.getString("UZITUSER_PASSWORD"), rs.getString("UZITUSER_USERNAME")));

	}


	@Override
	@Transactional(readOnly = true)
	public UserDTO findByUsername(String username) {
		String sql = String.format("SELECT * FROM sys.uzituser where UZITUSER_USERNAME= '%s'", username);
		return  jdbcTemplate.queryForObject(sql, (rs, rowNum) -> new UserDTO(rs.getInt("UZITUSER_CODE"),
				rs.getString("UZITUSER_NAME"), rs.getString("UZITUSER_PASSWORD"), rs.getString("UZITUSER_USERNAME")));

	}


	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		UserDTO userDTO= findByUsername(username);
		return new User(userDTO.getUsername(), userDTO.getPassword(), true, true, true, true,
				new ArrayList<>());
	}

}
