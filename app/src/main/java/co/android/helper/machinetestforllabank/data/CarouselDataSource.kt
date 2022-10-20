package co.android.helper.machinetestforllabank.data

import co.android.helper.machinetestforllabank.R
import co.android.helper.machinetestforllabank.data.HomeImagesDataSource.getBikeImages
import co.android.helper.machinetestforllabank.data.HomeImagesDataSource.getFlavoursImages
import co.android.helper.machinetestforllabank.data.HomeImagesDataSource.getFoodsImages
import co.android.helper.machinetestforllabank.data.HomeImagesDataSource.getPizzaImages
import co.android.helper.machinetestforllabank.data.HomeImagesDataSource.getTourPlacesImages
import co.android.helper.machinetestforllabank.data.model.TopCarouselModel

object CarouselDataSource {

    fun getCarouselImages() = mutableListOf<TopCarouselModel>().apply {
        add(TopCarouselModel(R.drawable.img_flower, getFlavoursImages()))
        add(TopCarouselModel(R.drawable.img_tour_place, getTourPlacesImages()))
        add(TopCarouselModel(R.drawable.img_food, getFoodsImages()))
        add(TopCarouselModel(R.drawable.img_pizza, getPizzaImages()))
        add(TopCarouselModel(R.drawable.img_bike, getBikeImages()))
    }
}