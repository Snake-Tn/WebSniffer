package websniffer.Repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import websniffer.Model.Link;

public interface LinkRepository extends MongoRepository<Link, String> {

}
