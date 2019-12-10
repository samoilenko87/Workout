package riversoft.workout.controller

import groovy.util.logging.Slf4j
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.*

import riversoft.workout.model.UserDTO
import riversoft.workout.model.UserWorkoutsDTO
import riversoft.workout.service.UserService

@Slf4j
@RestController
@RequestMapping ('users')
class UserController {
    @Autowired
    UserService userService

    @PostMapping('create')
    void registerNewUser(@RequestBody UserDTO userDTO){
        userService
            .createUser(userDTO)
    }


    @GetMapping
    List<UserDTO> getAllUsers(){
        userService
            .getUsers()
    }
    @GetMapping('{name}')
    List<UserWorkoutsDTO> getUserByName(@PathVariable name){
        userService
            .getUserName(name)
    }

}
