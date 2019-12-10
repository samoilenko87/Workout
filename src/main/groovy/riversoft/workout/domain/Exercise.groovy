package riversoft.workout.domain

import javax.persistence.Entity
import javax.persistence.EnumType
import javax.persistence.Enumerated
import javax.persistence.FetchType
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id
import javax.persistence.ManyToOne
import javax.persistence.Table

@Entity
@Table(name = 'exercises')

class Exercise {

    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    Long id

    String name

    String description

    BigInteger duration

    @Enumerated(EnumType.ORDINAL)
    ExerciseType type

    @ManyToOne (fetch = FetchType.LAZY)
    Workout workout
}
