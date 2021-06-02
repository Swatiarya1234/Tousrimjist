package com.example.example.ui.main

import android.content.Context
import android.provider.CallLog
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import com.example.example.Fragments.Guests
import com.example.example.Fragments.Hotels
import com.example.example.Fragments.Restrurants
import com.example.example.Fragments.Room
import com.example.example.R

private val TAB_TITLES = arrayOf(
    R.string.tab_text_1,
    R.string.tab_text_2
)

/**
 * A [FragmentPagerAdapter] that returns a fragment corresponding to
 * one of the sections/tabs/pages.
 */
class SectionsPagerAdapter(private val context: Context, fm: FragmentManager) :
    FragmentPagerAdapter(fm) {
    lateinit var fragment: Fragment
    override fun getItem(position: Int): Fragment {
        when (position){
            1 -> fragment = Guests()
            2 -> fragment = Hotels()
            3 -> fragment = Restrurants()
            4 -> fragment = Room()

        }
        return fragment
    }

    override fun getPageTitle(position: Int): CharSequence? {
        when(position){
            1 -> return "Guests"
            2 -> return "Hotels"
            3 -> return "Room"
            4 -> return "Hotels"

        }
        return  null
    }

    override fun getCount(): Int {
        // Show 2 total pages.
         return 5
    }

}