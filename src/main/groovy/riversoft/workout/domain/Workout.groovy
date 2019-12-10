package riversoft.workout.domain

import org.hibernate.annotations.CreationTimestamp

import javax.persistence.*

@Entity
@Table(name='workouts')

class Workout {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    Long id

    String name

    @CreationTimestamp
    Date created_date

    BigInteger duration

    @ManyToOne(fetch = FetchType.LAZY)
    User user

    @OneToMany (fetch = FetchType.LAZY, mappedBy = 'workout')
    List<Exercise> exercises = []
}
