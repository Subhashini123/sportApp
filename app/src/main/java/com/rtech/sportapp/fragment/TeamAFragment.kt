package com.rtech.sportapp.fragment

import android.app.AlertDialog
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.rtech.sportapp.R
import com.rtech.sportapp.SportsViewModel
import com.rtech.sportapp.databinding.FragmentTeamBinding
import com.rtech.sportapp.model.MatchDetailsModel

class TeamAFragment : Fragment()  {
    private lateinit var vm : SportsViewModel
    private lateinit var binding: FragmentTeamBinding
     var teamCaptain: Boolean = false
     var teamKeeper: Boolean = false

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?):View?{
        binding = FragmentTeamBinding.inflate(layoutInflater)
        vm = ViewModelProvider(this).get(SportsViewModel::class.java)
        vm.callMatchApi()
        vm.callTeamApi()
        observeData()

        return binding.root
    }

    private fun observeData() {
        vm.matchDataLiveData.observe(viewLifecycleOwner) {
            Log.d("Data - Main Activity", "match observeData: ${it}")
            showData(it)
            binding.tvCaptain.text = it.Teams.third?.Players?.player3632?.Iskeeper.toString()
            teamCaptain = it.Teams.third?.Players?.player3632?.Iskeeper!!
            teamKeeper =  it.Teams.third?.Players?.player3632?.Iscaptain

            binding.tvCaptain.text = it.Teams.third.Players.player3852?.Name_Full
            binding.tvKeeper.text = it.Teams.third.Players.player3632.Name_Full
            binding.tvPostion1.text = it.Teams.third.Players.player3852?.Name_Full
            binding.tvPostion2.text = it.Teams.third.Players.player3722?.Name_Full
            binding.tvPostion3.text = it.Teams.third.Players.player66818?.Name_Full
            binding.tvPostion4.text = it.Teams.third.Players.player4176?.Name_Full
            binding.tvPostion5.text = it.Teams.third.Players.player3632?.Name_Full
            binding.tvPostion6.text = it.Teams.third.Players.player4532?.Name_Full
            binding.tvPostion7.text = it.Teams.third.Players.player63751?.Name_Full
            binding.tvPostion8.text = it.Teams.third.Players.player63187?.Name_Full
            binding.tvPostion9.text = it.Teams.third.Players.player9844?.Name_Full
            binding.tvPostion10.text = it.Teams.third.Players.player5132?.Name_Full
            binding.tvPostion11.text = it.Teams.third.Players.player65867?.Name_Full

        }

    }

    private fun showData(matchDetailsModel: MatchDetailsModel?) {
        binding.tvPostion1.setOnClickListener {
            showDialog2(matchDetailsModel?.Teams?.third?.Players?.player3852)
        }
        binding.tvPostion2.setOnClickListener{
            showDialog2(matchDetailsModel?.Teams?.third?.Players?.player3722)
        }
        binding.tvPostion3.setOnClickListener{
            showDialog2(matchDetailsModel?.Teams?.third?.Players?.player66818)

        }
        binding.tvPostion4.setOnClickListener{
            showDialog2(matchDetailsModel?.Teams?.third?.Players?.player4176)

        }
        binding.tvPostion5.setOnClickListener{
            showDialog2(matchDetailsModel?.Teams?.third?.Players?.player3632)
        }
        binding.tvPostion6.setOnClickListener{
            showDialog2(matchDetailsModel?.Teams?.third?.Players?.player4532)
        }
        binding.tvPostion7.setOnClickListener{
            showDialog2(matchDetailsModel?.Teams?.third?.Players?.player63751)
        }
        binding.tvPostion8.setOnClickListener{
            showDialog2(matchDetailsModel?.Teams?.third?.Players?.player63187)
        }
        binding.tvPostion9.setOnClickListener{
            showDialog2(matchDetailsModel?.Teams?.third?.Players?.player9844)
        }
        binding.tvPostion10.setOnClickListener{
            showDialog2(matchDetailsModel?.Teams?.third?.Players?.player5132)
        }
        binding.tvPostion11.setOnClickListener{
            showDialog2(matchDetailsModel?.Teams?.third?.Players?.player65867)
        }



    }

    private fun showDialog2(player: com.rtech.sportapp.model.api_two_model.X3632?) {

        val alertDialogBuilder = AlertDialog.Builder(requireContext())
        alertDialogBuilder.setView(R.layout.custom_layout)
        val dialog = alertDialogBuilder.create()

        dialog.setCancelable(false)
        dialog.show()
        val name = dialog.findViewById(R.id.tv_detailname) as TextView
        val batting = dialog.findViewById(R.id.tv_battingstyle) as TextView
        val bowling = dialog.findViewById(R.id.tv_bowlingstyle) as TextView
        val imageClose = dialog.findViewById(R.id.img_close) as ImageView
        name.text = "${player?.Name_Full}"
        bowling.text = "Batting Style : ${player?.Batting?.Style}"
        batting.text = "Bowling Style : ${player?.Bowling?.Style}"
        imageClose.setOnClickListener {
            dialog.dismiss()
        }
        val yesBtn = dialog.findViewById(R.id.btn_done) as Button
        yesBtn.setOnClickListener {
            dialog.dismiss()
        }

    }
}
