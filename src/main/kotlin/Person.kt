class Person(personName: String?, personAge: Int) {
    // Do not change this part
    companion object {
        const val DEFAULT_NAME = "Unknown"
        const val MAX_AGE = 130
        const val MIN_AGE = 0
    }

    // Fix this to make its code pass the unit tests
    val name: String
    val age: Int

    init {
        age = when {
            personAge < MIN_AGE -> MIN_AGE
            personAge > MAX_AGE -> MAX_AGE
            else -> personAge
        }
        name = if (personName.isNullOrBlank()) DEFAULT_NAME else personName
    }

}