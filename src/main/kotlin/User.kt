private const val MIN_PASSWORD_LENGTH = 8

class User(private val username: String?, private val password: String?) {
    fun hasStrongPassword(): Boolean {
        return password != null && password.length >= MIN_PASSWORD_LENGTH
    }

    fun hasValidUsername(): Boolean {
        return !username.isNullOrBlank()
    }

    val isValid: Boolean
        get() = hasValidUsername() && hasStrongPassword()

}