import com.example.firebaseauthmvvm.data.remote.auth.AuthService
import com.example.firebaseauthmvvm.domain.model.User
import com.google.firebase.auth.FirebaseAuth
import kotlinx.coroutines.tasks.await
import javax.inject.Inject

class FirebaseAuthService @Inject constructor(
    private val firebaseAuth: FirebaseAuth
): AuthService {
    override suspend fun login(
        email: String,
        password: String
    ): User {
        val result = firebaseAuth.signInWithEmailAndPassword(email, password).await()

        val user = result.user ?: throw Exception("User not found")

        return User(
            id = user.uid,
            email = user.email
        )
    }

    override suspend fun register(
        email: String,
        password: String
    ): User {
        val result = firebaseAuth.createUserWithEmailAndPassword(email, password).await()

        val registeredUser = result.user ?: throw Exception("User not registered")

        return User(
            id = registeredUser.uid,
            email = registeredUser.email
        )
    }

    override fun logout() {
        firebaseAuth.signOut()
    }

    override fun getCurrentUser(): User? {
        val user = firebaseAuth.currentUser ?: return null

        return User(id = user.uid, user.email)
    }

}