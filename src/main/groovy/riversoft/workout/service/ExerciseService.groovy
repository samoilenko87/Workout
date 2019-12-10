package riversoft.workout.service

import groovy.util.logging.Slf4j
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import riversoft.workout.domain.Exercise
import riversoft.workout.model.ExerciseDTO
import riversoft.workout.repository.ExerciseRepository

@Slf4j
@Service
class ExerciseService {
    @Autowired
    ExerciseRepository exerciseRepository

        List<ExerciseDTO> getAllExercises() {
        exerciseRepository
                .findAll()
                .collect{
                    new ExerciseDTO(
                            id: it.id,
                            name: it.name,
                            description: it.description,
                            duration: it.duration,
                            exerciseType: it.type,
                    )
                }
    }
}
