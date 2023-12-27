package Services;

import Model.User;
import Repository.UserRepository;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Optional;

public class UserService {
    private UserRepository userRepository;

    private TokenService tokenService;

    @Autowired
    public UserService(UserRepository userRepository, TokenService tokenService){
        this.userRepository = userRepository;
        this.tokenService = tokenService;
    }

    //Get a user
    public User getUser(ObjectId id){
        Optional<User> optionalUser = userRepository.findById(id);

        return optionalUser.orElseGet(optionalUser::get);

    }

    //List Users
    public List<User> getUsers(){
        List<User> getUsers = userRepository.findAll();
        return getUsers;
    }

    //SignUp an User
    public String signup(User user){
        User savedUser = userRepository.save(user);
        return
                "{" +
                        "\"message\":"+"Successfully Created user\", \n"+
                        "\"data\":"+savedUser+",\n"+
                "}";
    }

    //Login
    public String login(String email, String password){
        List<User> foundUsers = userRepository.getUserByEmail(email);
        if(foundUsers.isEmpty()){
            return "Authentication Failed, User NOT Found";
        }else if(!foundUsers.get(0).getPassword().equals(password)){
            "{\n" +
                    "\"message\":"+"\" Successfully Logged-in\",\n"+
                    "\"data\": {\n"+" Name : "+foundUsers.get(0).getName()+",\n"+
                    "Email : "+foundUsers.get(0).getEmail()+"\n"+
                    "\"token\":\""+tokenService.createToken(foundUsers.get(0).getId())+"\"" +
                    "}";
        }
    }
}
