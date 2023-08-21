package com.practicas.fetchtest.ui.adapters

import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.practicas.fetchtest.ui.FirstGroup
import com.practicas.fetchtest.ui.FourthGroup
import com.practicas.fetchtest.ui.SecondGroup
import com.practicas.fetchtest.ui.ThirdGroup

class ViewPagerAdapter(fragmentManager: Fragment): FragmentStateAdapter(fragmentManager) {
    override fun getItemCount(): Int {
        return 4
    }

    override fun createFragment(position: Int): Fragment {
        return when(position){
            0 -> FirstGroup()
            1 -> SecondGroup()
            2 -> ThirdGroup()
            3 -> FourthGroup()

            else -> {FirstGroup()}
        }
    }
}