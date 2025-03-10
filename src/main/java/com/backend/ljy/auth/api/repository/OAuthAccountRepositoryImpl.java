package com.backend.ljy.auth.api.repository;

import com.backend.ljy.auth.api.entity.OAuthAccount;
import com.backend.ljy.auth.config.security.oauth.enums.OAuthProvider;
import com.querydsl.jpa.impl.JPAQueryFactory;
import jakarta.persistence.EntityManager;

import java.util.Optional;

import static com.backend.ljy.api.entity.QOAuthAccount.*;

public class OAuthAccountRepositoryImpl implements OAuthAccountRepositoryCustom {

    private final JPAQueryFactory queryFactory;

    public OAuthAccountRepositoryImpl(EntityManager entityManager) {
        this.queryFactory = new JPAQueryFactory(entityManager);
    }

    @Override
    public Optional<OAuthAccount> getOAuthAccountByProviderAndProviderUserId(OAuthProvider provider, String providerUserId) {

        OAuthAccount account = queryFactory
                .selectFrom(oAuthAccount)
                .join(oAuthAccount.user).fetchJoin()
                .where(
                        oAuthAccount.provider.eq(provider),
                        oAuthAccount.providerUserId.eq(providerUserId)
                )
                .fetchOne();

        return Optional.ofNullable(account);
    }
}
