package com.example.springbootoauth2server.OAuth.entity;

import javax.persistence.Id;

/**
 * CREATE TABLE oauth_access_tokens (
 *   token             VARCHAR(400)    NOT NULL PRIMARY KEY,
 *   client_id         VARCHAR(32)     NOT NULL,
 *   member_id         BIGINT          NOT NULL,
 *   expired_at        TIMESTAMP       NOT NULL,
 *   created_at        TIMESTAMP       NOT NULL,
 * );
 */
public class AccessToken implements com.byeongukchoi.oauth2.server.entity.AccessToken {
    @Id
    private String token;
    private String clientId;
    private long memberId;
    private int expiredAt;
    private int createdAt;

    @Override
    public String getToken() {
        return null;
    }

    @Override
    public Boolean isExpired() {
        return null;
    }
}
