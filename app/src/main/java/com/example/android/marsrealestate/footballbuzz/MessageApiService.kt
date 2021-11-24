package com.example.android.marsrealestate.footballbuzz
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.http.*

private const val BASE_URL = "https://jean.dev-hub.space/"
private const val endPointSendMessage = ""


/**
 * Build the Moshi object that Retrofit will be using, making sure to add the Kotlin adapter for
 * full Kotlin compatibility.
 */
private val moshi = Moshi.Builder()
    .add(KotlinJsonAdapterFactory())
    .build()

/**
 * Use the Retrofit builder to build a retrofit object using a Moshi converter with our Moshi
 * object.
 */
private val retrofit = Retrofit.Builder()
    .addConverterFactory(MoshiConverterFactory.create(moshi).asLenient())
    .baseUrl(BASE_URL)
    .build()

/**
 * A public interface that exposes the [get Messages] method
 */
interface MessageApiService {
    /**
     * Returns a Coroutine [List] of [MessageEntity] which can be fetched with await() if
     * in a Coroutine scope.
     * The @POST annotation indicates that the "message" endpoint will be requested with the POST
     * HTTP method
     */
    @POST()
    @FormUrlEncoded
    suspend fun seeAllChats(
        @FieldMap params : HashMap<String, String>
    ) : MessageEntity

    @POST(endPointSendMessage)
    @FormUrlEncoded
    suspend fun sendMessage(
        @Header("SessionToken") sessionToken: String,
        @Query("filter") UserID: String,
        @FieldMap params: HashMap<String, Any>

    ) : SendMessageEntity

}

/**
 * A public Api object that exposes the lazy-initialized Retrofit service
 */
object MessageApi {
    val retrofitService : MessageApiService by lazy { retrofit.create(MessageApiService::class.java) }
}
