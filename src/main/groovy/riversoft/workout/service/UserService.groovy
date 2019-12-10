package riversoft.workout.service

import groovy.util.logging.Slf4j
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import riversoft.workout.domain.User
import riversoft.workout.domain.Workout
import riversoft.workout.model.*
import riversoft.workout.repository.UserRepository

@Slf4j
@Service
class UserService {
    @Autowired
    UserRepository userRepository
    @Autowired
    WorkoutService workoutService

    def createUser(UserDTO userDTO){

        User user = userRepository
            .save(new User(
                    name: userDTO.name,
                    email: userDTO.email,
                    age: userDTO.age,
                    weight: userDTO.weight,
                    high: userDTO.high
            ))

        List<Workout> workouts = workoutService.crateWorkouts(user, userDTO.workouts)
        user.workouts.addAll(workouts)

        user
    }


    List<UserDTO> getUsers() {
        userRepository
                .findAll()
                .collect { it ->
                    new UserDTO(
                            name: it.name,
                            email: it.email,
                            age: it.age,
                            weight: it.weight,
                            high: it.high,
                    )
                }
    }

    List<UserWorkoutsDTO> getUserName(name) {
        userRepository
                .findUserByName(name)
                .collect {
                    new UserWorkoutsDTO(
                            name: it.name,
                            workouts: it.workouts.collect { w ->
                                new WorkoutDTO(
                                        name: w.name,
                                        duration: w.duration,
                                        exercises: w.exercises.collect { e ->
                                            new ExerciseDTO(
                                                    name: e.name,
                                                    duration: e.duration,
                                                    exerciseType: e.type
                                            )
                                        }
                                )
                            }
                    )
                }
    }


}