package co.android.helper.machinetestforllabank.ui.home.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.Filter
import android.widget.Filterable
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import co.android.helper.machinetestforllabank.data.HomeImagesDataSource
import co.android.helper.machinetestforllabank.data.model.CarouselSubListModel
import co.android.helper.machinetestforllabank.databinding.LayoutHomeViewHolderBinding


class HomeListAdapter(private var images: MutableList<CarouselSubListModel> = HomeImagesDataSource.getFlavoursImages()) :
    RecyclerView.Adapter<HomeListAdapter.HomeViewHolder>(),
    Filterable {
    private lateinit var context: Context
    private var filteredImages: MutableList<CarouselSubListModel> =
        mutableListOf<CarouselSubListModel>().apply {
            addAll(images)
        }

    inner class HomeViewHolder(private val binding: LayoutHomeViewHolderBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(data: CarouselSubListModel) {
            binding.ivNature.setImageDrawable(ContextCompat.getDrawable(context, data.imgRes))
            binding.tvItemName.text = data.name
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HomeViewHolder {
        context = parent.context
        val inflater = LayoutInflater.from(context)
        val binding = LayoutHomeViewHolderBinding.inflate(inflater, parent, false)
        return HomeViewHolder(binding)
    }

    override fun onBindViewHolder(holder: HomeViewHolder, position: Int) {
        holder.bind(filteredImages[position])
    }

    override fun getItemCount(): Int = filteredImages.size

    override fun getFilter(): Filter = FilterData()


    inner class FilterData : Filter() {
        override fun performFiltering(constraint: CharSequence?): FilterResults {

            filteredImages = if (constraint == null || constraint.isEmpty()) {
                images
            } else {
                val newList = mutableListOf<CarouselSubListModel>()
                images.filter {
                    it.name.lowercase().contains(constraint.toString().lowercase())
                }.forEach {
                    newList.add(it)
                }
                newList
            }

            return FilterResults().apply { values = filteredImages }
        }

        override fun publishResults(constraint: CharSequence?, results: FilterResults?) {
            filteredImages =
                if (results?.values == null) mutableListOf() else results.values as MutableList<CarouselSubListModel>
            notifyDataSetChanged()
        }
    }

    fun updateList(newImages: MutableList<CarouselSubListModel>) {
        images.clear()
        filteredImages.clear()
        images.addAll(newImages)
        filteredImages.addAll(images)
        notifyDataSetChanged()
    }
}