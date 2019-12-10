package riversoft.workout.repository

import org.springframework.data.jpa.repository.JpaRepository
import riversoft.workout.domain.Workout

interface WorkoutRepository extends JpaRepository< Workout, Long> {


}