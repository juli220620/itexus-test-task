package com.github.juli220620.core.persistence;

import com.github.juli220620.core.model.UserEntity;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;
import java.util.function.Consumer;
import java.util.function.Function;

@Slf4j
@Component
@RequiredArgsConstructor
public class HibernateUserDao implements UserDao {

    private final SessionFactory sessionFactory;

    @Override
    public void persistUser(UserEntity user) {
        transactionalFunction(session -> session.merge(user));
    }

    @Override
    public List<UserEntity> listAll() {
        return transactionalFunction(session ->
                session.createQuery("from UserEntity", UserEntity.class)
                        .getResultList()
        );
    }

    @Override
    public List<UserEntity> findByEmail(String email) {
        return transactionalFunction(session ->
                session.createQuery("from UserEntity where email = :email", UserEntity.class)
                        .setParameter("email", email)
                        .getResultList()
        );
    }

    @Override
    public Optional<UserEntity> findById(Long id) {
        return transactionalFunction(session ->
                Optional.ofNullable(session.find(UserEntity.class, id))
        );
    }

    @Override
    public void removeUser(Long id) {
        transactionalConsumer(session -> findById(id).ifPresent(session::remove));
    }

    private void transactionalConsumer(Consumer<Session> block) {
        transactionalFunction(session -> {
            block.accept(session);
            return null;
        });
    }

    private <R> R transactionalFunction(Function<Session, R> block) {
        var session = sessionFactory.openSession();
        session.beginTransaction();
        try {
            var result = block.apply(session);
            session.getTransaction().commit();
            return result;
        } catch (Exception e) {
            session.getTransaction().rollback();
            throw e;
        } finally {
            session.close();
        }
    }
}
