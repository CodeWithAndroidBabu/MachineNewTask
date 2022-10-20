package co.android.helper.machinetestforllabank.ui.home

import android.os.Bundle
import android.view.LayoutInflater
import androidx.core.widget.doOnTextChanged
import androidx.lifecycle.ViewModelProvider
import co.android.helper.machinetestforllabank.base.BaseActivity
import co.android.helper.machinetestforllabank.data.CarouselDataSource
import co.android.helper.machinetestforllabank.databinding.ActivityMainBinding
import co.android.helper.machinetestforllabank.extensions.makeVisible
import co.android.helper.machinetestforllabank.ui.home.viewmodel.HomeViewModel
import co.android.helper.machinetestforllabank.utils.ViewPagerOnChangeListener

class MainActivity : BaseActivity<ActivityMainBinding>() {

    private lateinit var viewModel: HomeViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel = ViewModelProvider(this)[HomeViewModel::class.java]
        setupTopCarousel()
        setupHomeList()

        binding.etSearch.doOnTextChanged { text, start, before, count ->
            text?.let {
                viewModel.homeListAdapter.filter.filter(it.toString())
            }
            if(viewModel.homeListAdapter.itemCount>0){
                binding.tvNoDataFound.makeVisible(false)
                binding.recyclerView.makeVisible(true)
            }else{
                binding.tvNoDataFound.makeVisible(true)
                binding.recyclerView.makeVisible(false)
            }
        }

        binding.viewPager.addOnPageChangeListener(ViewPagerOnChangeListener { position ->
            viewModel.homeListAdapter.updateList(CarouselDataSource.getCarouselImages()[position].carouselSubList)
        })
    }

    private fun setupTopCarousel() {
        binding.viewPager.adapter = viewModel.topCarouselAdapter
        binding.tabLayout.setupWithViewPager(binding.viewPager)
        binding.viewPager.pageMargin = -60
    }

    private fun setupHomeList() {
        binding.recyclerView.adapter = viewModel.homeListAdapter
    }

    override fun inflateLayout(layoutInflater: LayoutInflater) =
        ActivityMainBinding.inflate(layoutInflater)
}