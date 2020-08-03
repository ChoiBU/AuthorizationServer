package com.example.springbootoauth2server.OAuth.dao;

import com.example.springbootoauth2server.OAuth.entity.RefreshToken;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RefreshTokenRepository extends JpaRepository<RefreshToken, String>, com.byeongukchoi.oauth2.server.repository.RefreshTokenRepository {
    RefreshToken findByRefreshTokenAndClientId(String refreshToken, String clientId);
}