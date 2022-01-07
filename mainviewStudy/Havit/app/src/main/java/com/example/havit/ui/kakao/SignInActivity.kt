package com.example.havit.ui.kakao

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.activity.viewModels
import com.example.havit.MainActivity
import com.example.havit.R
import com.example.havit.databinding.ActivitySignInBinding
import com.example.havit.ui.base.BaseBindingActivity
import com.kakao.sdk.auth.LoginClient
import com.kakao.sdk.auth.model.OAuthToken
import com.kakao.sdk.common.model.AuthErrorCause
import com.kakao.sdk.user.UserApiClient

class SignInActivity : BaseBindingActivity<ActivitySignInBinding>(R.layout.activity_sign_in) {

    //private lateinit var callback :SessionCallback

    private val viewModel :SignInViewModel by viewModels()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding.vm = viewModel

       /* callback = SessionCallback()
        Session.getCurrentSession().addCallback(callback)
        Session.getCurrentSession().checkAndImplicitOpen()

        binding.kakaoLoginButton.setOnClickListener {
            callback = SessionCallback()
            Session.getCurrentSession().addCallback(callback)
            Session.getCurrentSession().checkAndImplicitOpen()
        }*/

        binding.kakaoLoginButton.setOnClickListener {
            sign()
        }
        UserApiClient.instance.accessTokenInfo { tokenInfo, error ->
            if (error != null) {
                Toast.makeText(this, "토큰 정보 보기 실패", Toast.LENGTH_SHORT).show()

            } else if (tokenInfo != null) {
                Toast.makeText(this, "토큰 정보 보기 성공", Toast.LENGTH_SHORT).show()
                val intent = Intent(this, MainActivity::class.java)
                startActivity(intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP))
                finish()
            }
        }

    }


    private fun sign(){
        if(LoginClient.instance.isKakaoTalkLoginAvailable(this)){
            LoginClient.instance.loginWithKakaoTalk(this, callback = callback)
        } else{
        LoginClient.instance.loginWithKakaoAccount(this, callback = callback) }
    }

    private val callback: (OAuthToken?, Throwable?) -> Unit = { token, error ->
        if (error != null) {
            when {
                error.toString() == AuthErrorCause.AccessDenied.toString() -> {
                    Toast.makeText(this, "접근이 거부 됨(동의 취소)", Toast.LENGTH_SHORT).show()
                }
                error.toString() == AuthErrorCause.InvalidClient.toString() -> {
                    Toast.makeText(this, "유효하지 않은 앱", Toast.LENGTH_SHORT).show()
                }
                error.toString() == AuthErrorCause.InvalidGrant.toString() -> {
                    Toast.makeText(this, "인증 수단이 유효하지 않아 인증할 수 없는 상태", Toast.LENGTH_SHORT).show()
                }
                error.toString() == AuthErrorCause.InvalidRequest.toString() -> {
                    Toast.makeText(this, "요청 파라미터 오류", Toast.LENGTH_SHORT).show()
                }
                error.toString() == AuthErrorCause.InvalidScope.toString() -> {
                    Toast.makeText(this, "유효하지 않은 scope ID", Toast.LENGTH_SHORT).show()
                }
                error.toString() == AuthErrorCause.Misconfigured.toString() -> {
                    Toast.makeText(this, "설정이 올바르지 않음(android key hash)", Toast.LENGTH_SHORT).show()
                }
                error.toString() == AuthErrorCause.ServerError.toString() -> {
                    Toast.makeText(this, "서버 내부 에러", Toast.LENGTH_SHORT).show()
                }
                error.toString() == AuthErrorCause.Unauthorized.toString() -> {
                    Toast.makeText(this, "앱이 요청 권한이 없음", Toast.LENGTH_SHORT).show()
                }
                else -> { // Unknown
                    Toast.makeText(this, "기타 에러", Toast.LENGTH_SHORT).show()
                }
            }
        }
        else if (token != null) {
            Toast.makeText(this, "로그인에 성공하였습니다.", Toast.LENGTH_SHORT).show()
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP))
            finish()
        }
    }




        // 카카오톡으로 로그인





    /*override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?)
    {
        if (Session.getCurrentSession().handleActivityResult(requestCode, resultCode, data))
        {
            Log.e(ContentValues.TAG, "onActivityResult()에서 세션 획득!!")

            return
        }
        super.onActivityResult(requestCode, resultCode, data)
    }

    override fun onDestroy()
    {
        super.onDestroy()
        Session.getCurrentSession().removeCallback(callback)
    }

    inner class SessionCallback : ISessionCallback {
        override fun onSessionOpenFailed(exception: KakaoException?) {
            Log.e("Log", "Session Call back :: onSessionOpenFailed: ${exception?.message}")
        }

        override fun onSessionOpened() {
            UserManagement.getInstance().me(object : MeV2ResponseCallback() {

                override fun onFailure(errorResult: ErrorResult?) {
                    val result = errorResult?.errorCode
                    if (result == ApiErrorCode.CLIENT_ERROR_CODE) {
                        Toast.makeText(
                            this@SignInActivity,
                            "네트워크 연결이 불안정합니다. 다시 시도해 주세요",
                            Toast.LENGTH_SHORT
                        ).show()
                        finish()
                    } else {
                        Toast.makeText(
                            this@SignInActivity,
                            "로그인 도중 오류가 발생했습니다 : ${errorResult?.errorMessage}",
                            Toast.LENGTH_SHORT
                        ).show()
                    }
                }

                override fun onSessionClosed(errorResult: ErrorResult?) {
                    Toast.makeText(this@SignInActivity, "세션이 닫혔습니다. 다시 시도해 주세요", Toast.LENGTH_SHORT)
                        .show()
                }

                override fun onSuccess(result: MeV2Response?) {
                    Log.e("카카오 로그인", "결과 : $result")
                    Log.e("카카오 로그인", "아이디 : ${result!!.id}")
                    Log.e("카카오 로그인", "이메일 : ${result.kakaoAccount.email}")
                    Log.e("카카오 로그인", "프로필 이미지 : ${result.profileImagePath}")
                    val intent = Intent(this@SignInActivity, MainActivity::class.java)
                    startActivity(intent)
                    finish()
                }
            })
        }
    }*/
}