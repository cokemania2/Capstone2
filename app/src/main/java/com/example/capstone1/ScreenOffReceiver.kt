package com.example.capstone1

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import com.example.capstone1.QuizLockerActivity

class ScreenOffReceiver : BroadcastReceiver() {
    override fun onReceive(context: Context?, intent: Intent?) {
        when {
            intent?.action == Intent.ACTION_SCREEN_OFF -> {
                // 화면이 꺼지면 QuizLockerActivity 를 실행한다.
                val intent = Intent(context, QuizLockerActivity::class.java)
                // 새로운 Activity 로 실행
                intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
                // 기존의 Activity 스택을 제거
                intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP)
                context?.startActivity(intent)
            }
        }
    }
}