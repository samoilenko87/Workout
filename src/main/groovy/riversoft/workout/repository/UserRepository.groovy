package riversoft.workout.repository

import org.springframework.data.jpa.repository.JpaRepository
import riversoft.workout.domain.User


interface UserRepository extends JpaRepository<User, Long> {

    List<User> findAll()

    List<User> findUserByName(name)
}