package com.example.loginfeature.api

import android.net.Uri

/**
 * Provides api for login to reddit
 */
interface RedditLoginRestApi {


    companion object {
        private const val AUTH_ENDPOINT = "https://www.reddit.com/api/v1/authorize"
        private const val client_id = "client_id"
        private const val response_type = "response_type"
        private const val response_type_token = "token"
        private const val state = "state"
        private const val redirect_uri = "redirect_uri"
        private const val scope = "scope"
        private const val scope_content = "mysubreddits read identity"

        fun getAuthUrl(
            clientId: String,
            UID: String,
            redirectUrl: String
        ): String {
            return Uri.parse(AUTH_ENDPOINT)
                .buildUpon()
                .appendQueryParameter(client_id, clientId)
                .appendQueryParameter(response_type, response_type_token)
                .appendQueryParameter(state, UID)
                .appendQueryParameter(redirect_uri, redirectUrl)
                .appendQueryParameter(scope, scope_content)
                .build().toString()
        }

    }
}