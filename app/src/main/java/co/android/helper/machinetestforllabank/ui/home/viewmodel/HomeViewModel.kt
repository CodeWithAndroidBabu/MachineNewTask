package co.android.helper.machinetestforllabank.ui.home.viewmodel

import androidx.lifecycle.ViewModel
import co.android.helper.machinetestforllabank.ui.home.adapter.HomeListAdapter
import co.android.helper.machinetestforllabank.ui.home.adapter.TopCarouselAdapter

class HomeViewModel: ViewModel() {
    var topCarouselAdapter = TopCarouselAdapter()
    var homeListAdapter = HomeListAdapter()
}