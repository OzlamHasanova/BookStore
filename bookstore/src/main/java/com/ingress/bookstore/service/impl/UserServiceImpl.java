package com.ingress.bookstore.service.impl;

import com.ingress.bookstore.dto.request.RequestToken;
import com.ingress.bookstore.dto.request.RequestUser;
import com.ingress.bookstore.dto.response.Response;
import com.ingress.bookstore.dto.response.ResponseStatus;
import com.ingress.bookstore.dto.response.ResponseToken;
import com.ingress.bookstore.dto.response.ResponseUser;
import com.ingress.bookstore.entity.Token;
import com.ingress.bookstore.entity.User;
import com.ingress.bookstore.enums.EnumAvailableStatus;
import com.ingress.bookstore.enums.UserRole;
import com.ingress.bookstore.respository.TokenRepository;
import com.ingress.bookstore.respository.UserRepository;
import com.ingress.bookstore.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final TokenRepository tokenRepository;

    @Override
    public Response<ResponseUser> saveUserWithRole(RequestUser requestUser) {
        Response response=new Response();
        ResponseUser responseUser=new ResponseUser();
        User user=User.builder()
                .role(requestUser.getRole())
                .username(requestUser.getUsername())
                .password(requestUser.getPassword())
                .build();
        String token= UUID.randomUUID().toString();
        Token userToken=new Token();
        userToken.setToken(token);
        userToken.setUser(user);
        tokenRepository.save(userToken);
        userRepository.save(user);
        responseUser.setUsername(requestUser.getUsername());
        responseUser.setRole(requestUser.getRole());
        responseUser.setResponseToken(new ResponseToken(user.getUserId(),token));
        response.setT(responseUser);
        response.setResponseStatus(ResponseStatus.getSuccessMessage());
        return response;
    }

    @Override
    public Response<ResponseUser> login(RequestUser requestUser) {
        Response<ResponseUser> response=new Response<>();
        ResponseUser responseUser=new ResponseUser();

        String username=requestUser.getUsername();
        String password=requestUser.getPassword();
        UserRole role=requestUser.getRole();
        if(username==null||password==null||role==null){
            //throw new Exception();
        }
        User user= userRepository.findUserByUsernameAndPasswordAndRoleAndActive(username,password,role, EnumAvailableStatus.ACTIVE.value);

        String token=UUID.randomUUID().toString();
        Token userToken=new Token();
        userToken.setToken(token);
        userToken.setUser(user);
        tokenRepository.save(userToken);
        responseUser.setUsername(user.getUsername());
        responseUser.setRole(user.getRole());
        responseUser.setResponseToken(new ResponseToken(user.getUserId(),token));
        response.setT(responseUser);
        response.setResponseStatus(ResponseStatus.getSuccessMessage());
        return response;
    }

    @Override
    public Response logout(RequestToken requestToken) {
        Response response =new Response();
        Long userId=requestToken.getUserId();
        String token=requestToken.getUserToken();

        User user=userRepository.findUserByUserIdAndActive(userId, EnumAvailableStatus.ACTIVE.value);

        Token userToken=tokenRepository.findTokenByUserAndTokenAndActive(user,token,EnumAvailableStatus.ACTIVE.value);


        tokenRepository.save(userToken);
        response.setResponseStatus(ResponseStatus.getSuccessMessage());

        return response;
    }


}
