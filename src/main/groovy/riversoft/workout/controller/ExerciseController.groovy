package riversoft.workout.controller

import groovy.util.logging.Slf4j
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import riversoft.workout.domain.Exercise
import riversoft.workout.model.ExerciseDTO
import riversoft.workout.service.ExerciseService

@Slf4j
@RestController
@RequestMapping('exercises')
class ExerciseController {
    @Autowired
    ExerciseService exerciseService


    @GetMapping
    List<ExerciseDTO> getExercises(){
        exerciseService
            .getAllExercises()
    }




}
