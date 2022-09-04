package IETI.Lab1User.repository;

import IETI.Lab1User.entities.User;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface UserRepository extends MongoRepository<User, String>
{}
