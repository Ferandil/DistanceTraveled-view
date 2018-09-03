package userservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.data.neo4j.repository.query.GraphRepositoryQuery;
import org.springframework.data.repository.Repository;
import org.springframework.data.repository.query.Param;
import userservice.model.User;

public interface UserRepository extends JpaRepository<User, Long> {
    User findByLogin(String login);
}
