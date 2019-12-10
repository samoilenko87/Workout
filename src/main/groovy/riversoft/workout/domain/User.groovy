package riversoft.workout.domain

import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.FetchType
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id
import javax.persistence.OneToMany
import javax.persistence.Table

@Entity
@Table(name = 'users')

class User {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    Long id

    String name

    @Column(unique = true)
    String email

    String password

    @OneToMany (fetch = FetchType.EAGER, mappedBy = 'user')
    List<Workout> workouts = []

    Integer age

    BigDecimal weight

    Integer high


}
