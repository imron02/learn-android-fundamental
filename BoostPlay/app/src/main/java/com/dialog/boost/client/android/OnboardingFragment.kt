package com.dialog.boost.client.android


import android.graphics.Color
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.ramotion.paperonboarding.PaperOnboardingFragment
import com.ramotion.paperonboarding.PaperOnboardingPage
import com.ramotion.paperonboarding.listeners.PaperOnboardingOnRightOutListener



class OnboardingFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val onBoardingFragment = PaperOnboardingFragment.newInstance(getDataForOnboarding())

        val fragmentTransaction = fragmentManager!!.beginTransaction()
        fragmentTransaction.add(R.id.fragment_container, onBoardingFragment)
        fragmentTransaction.commit()

//        onBoardingFragment.setOnRightOutListener {
//            val fragmentTransaction = fragmentManager!!.beginTransaction()
//            val bf = BlankFragment()
//            fragmentTransaction.replace(R.id.fragment_container, bf)
//            fragmentTransaction.commit()
//        }

        return inflater.inflate(R.layout.fragment_onboarding, container, false)
    }

    private fun getDataForOnboarding(): ArrayList<PaperOnboardingPage> {
        // prepare data
        val scr1 = PaperOnboardingPage(
            "Hotels", "All hotels and hostels are sorted by hospitality rating",
            Color.parseColor("#678FB4"), R.drawable.hotels, R.drawable.key
        )
        val scr2 = PaperOnboardingPage(
            "Banks", "We carefully verify all banks before add them into the app",
            Color.parseColor("#65B0B4"), R.drawable.banks, R.drawable.wallet
        )
        val scr3 = PaperOnboardingPage(
            "Stores", "All local stores are categorized for your convenience",
            Color.parseColor("#9B90BC"), R.drawable.stores, R.drawable.shopping_cart
        )

        val elements = ArrayList<PaperOnboardingPage>()
        elements.add(scr1)
        elements.add(scr2)
        elements.add(scr3)
        return elements
    }
}
