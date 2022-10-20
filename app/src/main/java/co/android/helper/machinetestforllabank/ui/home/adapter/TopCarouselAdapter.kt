package co.android.helper.machinetestforllabank.ui.home.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.viewpager.widget.PagerAdapter
import androidx.viewpager.widget.ViewPager
import co.android.helper.machinetestforllabank.data.CarouselDataSource
import co.android.helper.machinetestforllabank.data.model.TopCarouselModel
import co.android.helper.machinetestforllabank.databinding.LayoutCarouselViewHolderBinding

class TopCarouselAdapter(private val images: List<TopCarouselModel> = CarouselDataSource.getCarouselImages()) :
    PagerAdapter() {

    private lateinit var context: Context

    override fun getCount(): Int = images.size

    override fun getPageWidth(position: Int): Float {
        return .9f
    }

    override fun instantiateItem(container: ViewGroup, position: Int): Any {
        context = container.context
        val layoutInflater =
            context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
        val binding = LayoutCarouselViewHolderBinding.inflate(layoutInflater)
        binding.ivCarousel.setImageDrawable(ContextCompat.getDrawable(context, images[position].imgRes))
        container.addView(binding.root)
        return binding.root
    }

    override fun isViewFromObject(view: View, `object`: Any): Boolean =
        view === `object`

    override fun destroyItem(container: ViewGroup, position: Int, `object`: Any) {
        (container as ViewPager).removeView(`object` as View?)
    }
}