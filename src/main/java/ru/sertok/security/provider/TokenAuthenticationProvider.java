package ru.sertok.security.provider;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Component;
import ru.sertok.exceptions.TokenException;
import ru.sertok.exceptions.UserException;
import ru.sertok.models.Token;
import ru.sertok.repositories.TokenRepository;
import ru.sertok.security.token.TokenAuthentication;

@Component
public class TokenAuthenticationProvider implements AuthenticationProvider {

   @Autowired
   private TokenRepository tokenRepository;
   @Autowired
   private UserDetailsService userDetailsService;

    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        return tokenRepository.findByValue(authentication.getName()).map(Token::getUser).map(token->{
            ((TokenAuthentication)authentication).setUserDetails(userDetailsService.loadUserByUsername(token.getName()));
            authentication.setAuthenticated(true);
            return authentication;
        }).orElseThrow(TokenException::new);
    }

    @Override
    public boolean supports(Class<?> aClass) {
        return TokenAuthentication.class.equals(aClass);
    }
}
