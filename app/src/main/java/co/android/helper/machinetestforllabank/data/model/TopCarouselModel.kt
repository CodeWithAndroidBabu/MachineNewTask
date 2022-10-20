package co.android.helper.machinetestforllabank.data.model

import androidx.annotation.DrawableRes

data class TopCarouselModel(
    @DrawableRes var imgRes: Int,
    val carouselSubList: MutableList<CarouselSubListModel>
)