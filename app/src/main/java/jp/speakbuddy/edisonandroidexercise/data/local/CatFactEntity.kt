import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity(tableName = "cat_fact")
data class CatFactEntity(
    @PrimaryKey val id: Int = 1, // Single record for latest fact
    val fact: String,
    val length: Int
)