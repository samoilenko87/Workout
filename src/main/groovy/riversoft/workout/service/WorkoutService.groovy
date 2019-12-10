package riversoft.workout.service

import groovy.util.logging.Slf4j
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import riversoft.workout.domain.User
import riversoft.workout.domain.Workout
import riversoft.workout.model.ExerciseDTO
import riversoft.workout.model.WorkoutDTO
import riversoft.workout.repository.WorkoutRepository

@Slf4j
@Service
class WorkoutService {
    @Autowired
    WorkoutRepository workoutRepository

    def createW(WorkoutDTO workout) {
        workoutRepository
                .save(new Workout(
                        name: workout.name,
                        duration: workout.duration,
                        exercises: []
                        //ToDo Добавить id юзера после подключения SpringSecurity
                )
                )

    }

    List<WorkoutDTO> getWorkouts() {
        workoutRepository
                .findAll()
                .collect { it ->
                    new WorkoutDTO(
                            name: it.name,
                            duration: it.duration,
                            exercises: it.exercises.collect { e ->
                                new ExerciseDTO(
                                        id: e.id,
                                        name: e.name,
                                        duration: e.duration,
                                        exerciseType: e.type
                                )
                            }
                    )
                }
    }

    List<Workout> crateWorkouts(User user, List<WorkoutDTO> workoutDTOS) {
        if (workoutDTOS && workoutDTOS.size() > 0) {
            //todo: Доделать когда будет приходить от клиента спсиок
            return []
        }
        Workout workout = workoutRepository.save(
                new Workout(
                        name: 'My first workout',
                        user: user,
                        exercises: []

                )
        )
        return [workout]


    }
}


