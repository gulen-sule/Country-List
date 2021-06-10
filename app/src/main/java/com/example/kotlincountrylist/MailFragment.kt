package com.example.kotlincountrylist

import android.content.Intent
import android.content.IntentSender
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
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
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.mail_fragment, container, false)
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        konu = view.findViewById(R.id.mail_konusu)
        icerik = view.findViewById(R.id.mail_icerigi)
        send = view.findViewById(R.id.sendMail)

        send.setOnClickListener (View.OnClickListener {
            val intent=Intent(Intent.ACTION_SEND)
          //  intent.setType("text/html")
            intent.putExtra(Intent.EXTRA_EMAIL,"gulensule@gmail.com")
            intent.putExtra(Intent.EXTRA_SUBJECT,konu.text.toString())
            intent.putExtra(Intent.EXTRA_TEXT,icerik.text.toString())
            intent.setType("message/rfc822")
            Intent.createChooser(intent, "Send Email using:")
        })
    }


}