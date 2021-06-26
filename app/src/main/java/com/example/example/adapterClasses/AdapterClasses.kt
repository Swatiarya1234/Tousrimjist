package com.example.example.adapterClasses

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import java.util.ArrayList

class AdapterClasses(fm: FragmentManager) : FragmentPagerAdapter(fm)  {

    private val MfragemntList = ArrayList<Fragment>()
    private val mFragmentList = ArrayList<String>()
    override fun getCount(): Int {
        return mFragmentList.size
    }

    override fun getItem(position: Int): Fragment {
        return MfragemntList[position]
    }
    override fun getPageTitle(position: Int): CharSequence? {
        return super.getPageTitle(position)
    }
   fun addFragment(fragment: Fragment,title:String){
       MfragemntList.add(fragment)
       mFragmentList.add(title)
   }

}