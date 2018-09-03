package userservice.repository;

import org.springframework.data.neo4j.repository.Neo4jRepository;
import userservice.model.Coordinate;

/**
 * repository for Coordinate Node Entity
 */
public interface CoordinateRepository extends Neo4jRepository<Coordinate, Long> {

}
