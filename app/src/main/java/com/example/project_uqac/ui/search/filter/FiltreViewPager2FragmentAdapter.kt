package com.example.project_uqac.ui.search.filter

import androidx.annotation.StringRes
import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.example.project_uqac.R
import com.example.project_uqac.ui.my_account.tabs.MyAccountTabInformations

class FiltreViewPager2FragmentAdapter (fa: Fragment): FragmentStateAdapter(fa) {

    private lateinit var dialogueContext : DialogueFragmentFilter

    override fun createFragment(position: Int): Fragment {
        return when (position) {
            0 -> FilterTabPosition(dialogueContext)
            1 -> FIlterTabCalendar(dialogueContext)
            else -> MyAccountTabInformations()
        }

    }

    override fun getItemCount(): Int {
        return TAB_TITLES.size
    }

    fun getPageTitle(position: Int): CharSequence {
        return "Tab " + (position + 1)
    }

    companion object {
        @StringRes
        private val TAB_TITLES = intArrayOf(R.string.tab_my_acc_1, R.string.tab_my_acc_2)

    }

    fun setData (context: DialogueFragmentFilter) {
         dialogueContext = context
    }
}