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
import com.rtech.sportapp.model.api_two_model.TeamDetailsModel

class TeamCFragment : Fragment(){
    private lateinit var vm : SportsViewModel
    private lateinit var binding: FragmentTeamBinding
    var teamCaptain: Boolean = false
    var teamKeeper: Boolean = false
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?): View?{
        binding = FragmentTeamBinding.inflate(layoutInflater)
//        val rootView =    inflater.inflate(R.layout.fragment_team, container, false)!!
        vm = ViewModelProvider(this).get(SportsViewModel::class.java)
        vm.callTeamApi()
        observeDetailData()


        return binding.root
    }
    private fun observeDetailData() {
        vm.teamDataLiveData.observe(viewLifecycleOwner) {
            Log.d("Data - Main Activity", "match observeData: ${it}")
            showData1(it)
            binding.tvCaptain.text = it.Teams.third?.Players?.player3632?.Iskeeper.toString()
            teamCaptain = it.Teams.third?.Players?.player4038?.Iskeeper!!
            teamKeeper =  it.Teams.third?.Players?.player4038?.Iscaptain

            binding.tvCaptain.text = it.Teams.third.Players.player4038?.Name_Full
            binding.tvKeeper.text = it.Teams.third.Players.player4038?.Name_Full
            binding.tvPostion1.text = it.Teams.third.Players.player63084?.Name_Full
            binding.tvPostion2.text = it.Teams.third.Players.player57492?.Name_Full
            binding.tvPostion3.text = it.Teams.third.Players.player59429?.Name_Full
            binding.tvPostion4.text = it.Teams.third.Players.player3472?.Name_Full
            binding.tvPostion5.text = it.Teams.third.Players.player2734?.Name_Full
            binding.tvPostion6.text = it.Teams.third.Players.player4038?.Name_Full
            binding.tvPostion7.text = it.Teams.third.Players.player65739?.Name_Full
            binding.tvPostion8.text = it.Teams.third.Players.player64073?.Name_Full
            binding.tvPostion9.text = it.Teams.third.Players.player64321?.Name_Full
            binding.tvPostion10.text = it.Teams.third.Players.player64306?.Name_Full
            binding.tvPostion11.text = it.Teams.third.Players.player66833?.Name_Full







        }
    }
    private fun showData1(teamDetailsModel: TeamDetailsModel?) {
        binding.tvPostion1.setOnClickListener {
            showDialog2(teamDetailsModel?.Teams?.third?.Players?.player63084)
        }
        binding.tvPostion2.setOnClickListener{
            showDialog2(teamDetailsModel?.Teams?.third?.Players?.player57492)
        }
        binding.tvPostion3.setOnClickListener{
            showDialog2(teamDetailsModel?.Teams?.third?.Players?.player59429)

        }
        binding.tvPostion4.setOnClickListener{
            showDialog2(teamDetailsModel?.Teams?.third?.Players?.player3472)

        }
        binding.tvPostion5.setOnClickListener{
            showDialog2(teamDetailsModel?.Teams?.third?.Players?.player2734)
        }
        binding.tvPostion6.setOnClickListener{
            showDialog2(teamDetailsModel?.Teams?.third?.Players?.player4038)
        }
        binding.tvPostion7.setOnClickListener{
            showDialog2(teamDetailsModel?.Teams?.third?.Players?.player65739)
        }
        binding.tvPostion8.setOnClickListener{
            showDialog2(teamDetailsModel?.Teams?.third?.Players?.player64073)
        }
        binding.tvPostion9.setOnClickListener{
            showDialog2(teamDetailsModel?.Teams?.third?.Players?.player64321)
        }
        binding.tvPostion10.setOnClickListener{
            showDialog2(teamDetailsModel?.Teams?.third?.Players?.player64306)
        }
        binding.tvPostion11.setOnClickListener{
            showDialog2(teamDetailsModel?.Teams?.third?.Players?.player66833)
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