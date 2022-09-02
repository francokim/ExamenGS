package com.baz.controller;



import org.springframework.web.bind.annotation.RestController;



@RestController
public class UserController {
/*
	@PostMapping("login")
	public UserEntity login(@RequestParam("usuario") String username, @RequestParam("password") String pass) {

		System.err.println(username + "\n" +pass);
		
		String token = getToken(username);
		UserEntity user = new UserEntity();
		user.setUser(username);
		user.setToken(token);
		
		return user;

	}

	private String getToken(String username) {

		String secretKey = "mySecretKey";
		List<GrantedAuthority> grantedAuthorities = AuthorityUtils.commaSeparatedStringToAuthorityList("ROLE_USER");

		String token = Jwts.builder().setId("softtekJWT").setSubject(username)
				.claim("authorities",
						grantedAuthorities.stream().map(GrantedAuthority::getAuthority).collect(Collectors.toList()))
				.setIssuedAt(new Date(System.currentTimeMillis()))
				.setExpiration(new Date(System.currentTimeMillis() + 60000))
				.signWith(SignatureAlgorithm.HS512, secretKey.getBytes()).compact();

		return "Bearer " + token;

	}
*/
}
