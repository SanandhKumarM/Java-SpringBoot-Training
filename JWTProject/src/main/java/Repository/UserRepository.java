package Repository;

import Model.User;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.util.List;

public interface UserRepository extends MongoRepository<User, ObjectId> {
    @Query("{email:\"?0\"}")
    List<UserRepository> getUserByEmail(String email);
}
