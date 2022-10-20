package co.android.helper.machinetestforllabank.utils

import androidx.viewpager.widget.ViewPager

class ViewPagerOnChangeListener(private val onPageSelected: (Int) -> Unit) :
    ViewPager.OnPageChangeListener {
    override fun onPageScrolled(position: Int, positionOffset: Float, positionOffsetPixels: Int) {}

    override fun onPageSelected(position: Int) {
        onPageSelected.invoke(position)
    }

    override fun onPageScrollStateChanged(state: Int) {}
}