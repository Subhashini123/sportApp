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

class TeamDFragment : Fragment(){
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

            binding.tvCaptain.text = it.Teams.fourt?.Players?.player28891?.Name_Full
            binding.tvKeeper.text = it.Teams.fourt?.Players?.player59736?.Name_Full

            binding.tvPostion1.text = it.Teams.fourt?.Players?.player3667?.Name_Full
            binding.tvPostion2.text = it.Teams.fourt?.Players?.player4356?.Name_Full
            binding.tvPostion3.text = it.Teams.fourt?.Players?.player12518?.Name_Full
            binding.tvPostion4.text = it.Teams.fourt?.Players?.player28891?.Name_Full
            binding.tvPostion5.text = it.Teams.fourt?.Players?.player5313?.Name_Full
            binding.tvPostion6.text = it.Teams.fourt?.Players?.player59736?.Name_Full
            binding.tvPostion7.text = it.Teams.fourt?.Players?.player64221?.Name_Full
            binding.tvPostion8.text = it.Teams.fourt?.Players?.player63611?.Name_Full
            binding.tvPostion9.text = it.Teams.fourt?.Players?.player24669?.Name_Full
            binding.tvPostion10.text = it.Teams.fourt?.Players?.player48191?.Name_Full
            binding.tvPostion8.text = it.Teams.fourt?.Players?.player57458?.Name_Full
        }

    }
    private fun showData1(teamDetailsModel: TeamDetailsModel?) {
        binding.tvPostion1.setOnClickListener {
            showDialog2(teamDetailsModel?.Teams?.fourt?.Players?.player3667)
        }
        binding.tvPostion2.setOnClickListener{
            showDialog2(teamDetailsModel?.Teams?.fourt?.Players?.player4356)
        }
        binding.tvPostion3.setOnClickListener{
            showDialog2(teamDetailsModel?.Teams?.fourt?.Players?.player12518)

        }
        binding.tvPostion4.setOnClickListener{
            showDialog2(teamDetailsModel?.Teams?.fourt?.Players?.player28891)

        }
        binding.tvPostion5.setOnClickListener{
            showDialog2(teamDetailsModel?.Teams?.fourt?.Players?.player5313)
        }
        binding.tvPostion6.setOnClickListener{
            showDialog2(teamDetailsModel?.Teams?.fourt?.Players?.player59736)
        }
        binding.tvPostion7.setOnClickListener{
            showDialog2(teamDetailsModel?.Teams?.fourt?.Players?.player64221)
        }
        binding.tvPostion8.setOnClickListener{
            showDialog2(teamDetailsModel?.Teams?.fourt?.Players?.player63611)
        }
        binding.tvPostion9.setOnClickListener{
            showDialog2(teamDetailsModel?.Teams?.fourt?.Players?.player24669)
        }
        binding.tvPostion10.setOnClickListener{
            showDialog2(teamDetailsModel?.Teams?.fourt?.Players?.player48191)
        }
        binding.tvPostion11.setOnClickListener{
            showDialog2(teamDetailsModel?.Teams?.fourt?.Players?.player57458)
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