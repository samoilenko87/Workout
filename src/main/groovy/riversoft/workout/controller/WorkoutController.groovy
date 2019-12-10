package riversoft.workout.controller

import groovy.util.logging.Slf4j
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import riversoft.workout.model.WorkoutDTO
import riversoft.workout.service.WorkoutService

@Slf4j
@RestController
@RequestMapping('workouts')
class WorkoutController {
    @Autowired
    WorkoutService workoutService

    @GetMapping
    List<WorkoutDTO> getAllWorkouts(){
        workoutService
                .getWorkouts()
    }
    @PostMapping ('create')
    void createWorkout(@RequestBody WorkoutDTO workoutDTO){
     workoutService
        .createW(workoutDTO)
    }
}
