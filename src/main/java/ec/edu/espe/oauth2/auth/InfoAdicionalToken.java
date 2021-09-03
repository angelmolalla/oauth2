package ec.edu.espe.oauth2.auth;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.oauth2.common.DefaultOAuth2AccessToken;
import org.springframework.security.oauth2.common.OAuth2AccessToken;
import org.springframework.security.oauth2.provider.OAuth2Authentication;
import org.springframework.security.oauth2.provider.token.TokenEnhancer;
import org.springframework.stereotype.Component;
import ec.edu.espe.oauth2.dto.UserDTO;
import ec.edu.espe.oauth2.service.IUserService;

@Component
public class InfoAdicionalToken implements TokenEnhancer {

	@Autowired
	private IUserService userService;


	@Override
	public OAuth2AccessToken enhance(OAuth2AccessToken accessToken, OAuth2Authentication authentication) {
	
		Map<String, Object> info = new HashMap<>();
		UserDTO userModel = userService.findByUsername(authentication.getName());
		
		info.put("internalUser", false);
		info.put("name", userModel.getName());
		((DefaultOAuth2AccessToken) accessToken).setAdditionalInformation(info);
		return accessToken;
	}
}