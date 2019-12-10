package riversoft.workout.repository

import org.springframework.data.jpa.repository.JpaRepository
import riversoft.workout.domain.Exercise

interface ExerciseRepository extends JpaRepository<Exercise, Long> {

}