package com.example.kotlincountrylist.adapter

import android.content.Intent
import android.content.IntentSender
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import androidx.fragment.app.Fragment
import com.example.kotlincountrylist.R
import com.example.kotlincountrylist.databinding.FragmentCountryBinding

class MailFragment : Fragment() {
    private lateinit var hesap: EditText
    private lateinit var konu: EditText
    private lateinit var icerik: EditText
    private lateinit var send: Button
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        hesap = view.findViewById(R.id.mail_hesabı)
        konu = view.findViewById(R.id.mail_konusu)
        icerik = view.findViewById(R.id.mail_icerigi)
        send = view.findViewById(R.id.sendMail)

        send.setOnClickListener {
            val intent=Intent(Intent.ACTION_SEND)
            //intent.putExtra

        }
        hesap.text.toString()
    }


}