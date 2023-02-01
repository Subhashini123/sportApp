package com.rtech.sportapp.activities
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.lifecycle.ViewModelProvider
import com.rtech.sportapp.SportsViewModel
import com.rtech.sportapp.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var vm : SportsViewModel
    private lateinit var binding: ActivityMainBinding
    lateinit var teamName: String
    lateinit var teamName2: String
    lateinit var teamName3: String
    lateinit var teamName4: String
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        vm = ViewModelProvider(this).get(SportsViewModel::class.java)

        vm.callMatchApi()
        vm.callTeamApi()
        observeData()
    }

    private fun observeData() {
        vm.matchDataLiveData.observe(this) {
            binding.tvTeam1.text = it.Teams.third?.Name_Short
            teamName = it.Teams.third!!.Name_Full
            teamName2 = it.Teams.fourth!!.Name_Full
            binding.tvTeam2.text = it.Teams.fourth?.Name_Short
            binding.tvDate.text = it.Matchdetail.Match.Date
            binding.tvAddresss.text = it.Matchdetail.Venue.Name
            binding.tvAddresss.setOnClickListener{
                val intent = Intent(this, DetailActivity::class.java)
                intent.putExtra("teamName",teamName)
                intent.putExtra("teamName2",teamName2)
                startActivity(intent)
            }
        }

        vm.teamDataLiveData.observe(this) {
            teamName3 = it.Teams.third!!.Name_Full
            teamName4 = it.Teams.fourt!!.Name_Full
            binding.tvTeam3.text = it.Teams.third?.Name_Short
            binding.tvTeam4.text = it.Teams.fourt.Name_Short
            binding.tvDate1.text = it.Matchdetail.Match.Date
            binding.tvAddresss1.text = it.Matchdetail.Venue.Name
            binding.tvAddresss1.setOnClickListener{
                val intent = Intent(this, DetailActivity::class.java)
                intent.putExtra("teamName",teamName3)
                intent.putExtra("teamName2",teamName4)
                intent.putExtra("sharedvalue","sharedValue")
                startActivity(intent)
            }
        }
    }
}