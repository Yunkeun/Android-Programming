package kr.ac.dankook.mobile.mop1124_2

import androidx.room.*

@Entity(tableName = "users")
data class User(
    @PrimaryKey val uid: Int,
    @ColumnInfo(name = "first_name") val firstName: String?,
    @ColumnInfo(name = "last_name") val lastName: String?
)

@Dao
interface UserDao {
    @Query("SELECT * FROM users")
    fun getAll(): List<User>

    @Query("SELECT * FROM users WHERE uid IN (:userIds)")
    fun loadAllByIds(userIds: IntArray): List<User>

    @Query("SELECT * FROM users WHERE first_name LIKE :first AND " +
    "last_name LIKE :last LIMIT 1")
    fun findByName(first: String, last: String): User

    @Insert
    fun insertAll(vararg user: User)

    @Delete
    fun delete(use: User)
}

@Database(entities = arrayOf(User::class), version=1)
abstract class UserDB : RoomDatabase() {
    abstract fun userDao(): UserDao
}