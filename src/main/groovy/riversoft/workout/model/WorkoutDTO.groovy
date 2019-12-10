package riversoft.workout.model

class WorkoutDTO {
    String name

    BigInteger duration

    List<ExerciseDTO> exercises

    //ToDo Добавить id юзера после подключения SpringSecurity

}
