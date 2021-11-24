package com.example.android.marsrealestate.footballbuzz

import com.squareup.moshi.Json


data class MessageEntity(

    @Json(name = "StatusCode") var StatusCode: Int,
    @Json(name = "Message") var Message: String,
    @Json(name = "page") var page: Int,
    @Json(name = "results") var results: List<Results>,
    @Json(name = "total_pages") var totalPages: Int,
    @Json(name = "total_results") var totalResults: Int

)


data class Results(

    @Json(name = "userSent") var userSent: UserSent,
    @Json(name = "UserIdSent") var UserIdSent: Int,
    @Json(name = "userReceived") var userReceived: UserReceived,
    @Json(name = "UserIdReceived") var UserIdReceived: Int,
    @Json(name = "ConversationKey") var ConversationKey: String,
    @Json(name = "MessageContent") var MessageContent: String,
    @Json(name = "MessageMedia") var MessageMedia: String,
    @Json(name = "TimeStamp") var TimeStamp: String,
    @Json(name = "Seen") var Seen: Boolean,
    @Json(name = "SendByThisUser") var SendByThisUser: String,
    @Json(name = "ID") var ID: Int

)

data class UserSent(

    @Json(name = "Notifications") var Notifications: List<String>,
    @Json(name = "Posts") var Posts: String,
    @Json(name = "ShortVideoStories") var ShortVideoStories: List<ShortVideoStories>,
    @Json(name = "Team") var Team: String,
    @Json(name = "UserFollowers") var UserFollowers: String,
    @Json(name = "UserFollowings") var UserFollowings: String,
    @Json(name = "UserName") var UserName: String,
    @Json(name = "FullName") var FullName: String,
    @Json(name = "Password") var Password: String,
    @Json(name = "Email") var Email: String,
    @Json(name = "PhoneNumber") var PhoneNumber: String,
    @Json(name = "ProfilePhoto") var ProfilePhoto: String,
    @Json(name = "isProfileLocked") var isProfileLocked: Boolean,
    @Json(name = "notificationToken") var notificationToken: String,
    @Json(name = "isOnline") var isOnline: Boolean,
    @Json(name = "isVerified") var isVerified: Boolean,
    @Json(name = "NewEmailToken") var NewEmailToken: String,
    @Json(name = "NewEmailID") var NewEmailID: String,
    @Json(name = "NewPhoneOTP") var NewPhoneOTP: String,
    @Json(name = "NewPhone") var NewPhone: String,
    @Json(name = "SessionToken") var SessionToken: String,
    @Json(name = "FollowersCount") var FollowersCount: Int,
    @Json(name = "FollowingCount") var FollowingCount: Int,
    @Json(name = "PostCount") var PostCount: Int,
    @Json(name = "FollowingMe") var FollowingMe: Boolean,
    @Json(name = "FollowedByMe") var FollowedByMe: Boolean,
    @Json(name = "ID") var ID: Int
)

data class ShortVideoStories(

    @Json(name = "UserId") var UserId: Int,
    @Json(name = "MediaURL") var MediaURL: String,
    @Json(name = "Engagement") var Engagement: Int,
    @Json(name = "Reach") var Reach: Int,
    @Json(name = "Shares") var Shares: Int,
    @Json(name = "ProfileClicks") var ProfileClicks: Int,
    @Json(name = "AddedDateAndTime") var AddedDateAndTime: String,
    @Json(name = "MimeType") var MimeType: String,
    @Json(name = "Caption") var Caption: String,
    @Json(name = "Color") var Color: String,
    @Json(name = "Font") var Font: String,
    @Json(name = "SeenStatus") var SeenStatus: Boolean,
    @Json(name = "DateTimeForDb") var DateTimeForDb: String,
    @Json(name = "UserViewModel") var UserViewModel: String,
    @Json(name = "ID") var ID: Int

)

data class UserReceived(

    @Json(name = "Notifications") var Notifications: List<String>,
    @Json(name = "Posts") var Posts: String,
    @Json(name = "ShortVideoStories") var ShortVideoStories: List<ShortVideoStories>,
    @Json(name = "Team") var Team: Team,
    @Json(name = "UserFollowers") var UserFollowers: String,
    @Json(name = "UserFollowings") var UserFollowings: String,
    @Json(name = "UserName") var UserName: String,
    @Json(name = "FullName") var FullName: String,
    @Json(name = "Password") var Password: String,
    @Json(name = "Email") var Email: String,
    @Json(name = "PhoneNumber") var PhoneNumber: String,
    @Json(name = "ProfilePhoto") var ProfilePhoto: String,
    @Json(name = "isProfileLocked") var isProfileLocked: Boolean,
    @Json(name = "notificationToken") var notificationToken: String,
    @Json(name = "isOnline") var isOnline: Boolean,
    @Json(name = "isVerified") var isVerified: Boolean,
    @Json(name = "NewEmailToken") var NewEmailToken: String,
    @Json(name = "NewEmailID") var NewEmailID: String,
    @Json(name = "NewPhoneOTP") var NewPhoneOTP: String,
    @Json(name = "NewPhone") var NewPhone: String,
    @Json(name = "SessionToken") var SessionToken: String,
    @Json(name = "FollowersCount") var FollowersCount: Int,
    @Json(name = "FollowingCount") var FollowingCount: Int,
    @Json(name = "PostCount") var PostCount: Int,
    @Json(name = "FollowingMe") var FollowingMe: Boolean,
    @Json(name = "FollowedByMe") var FollowedByMe: Boolean,
    @Json(name = "ID") var ID: Int
)


data class Team (

    @Json(name = "team_key") var teamKey : String,
    @Json(name = "team_name") var teamName : String,
    @Json(name = "team_badge") var teamBadge : String,
    @Json(name = "team_country") var teamCountry : String,
    @Json(name = "ID") var ID : Int

)












