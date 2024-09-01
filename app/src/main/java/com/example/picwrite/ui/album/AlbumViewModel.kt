import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.picwrite.R
import com.example.picwrite.ui.album.AlbumItem

class AlbumViewModel : ViewModel() {

    private val _items = MutableLiveData<List<AlbumItem>>()
    val items: LiveData<List<AlbumItem>> get() = _items

    init {
        val itemList = mutableListOf<AlbumItem>()
        itemList.add(AlbumItem(R.drawable.picwrite, "Text 1"))
        itemList.add(AlbumItem(R.drawable.picwrite, "Text 2"))
        itemList.add(AlbumItem(R.drawable.picwrite, "Text 3"))
        itemList.add(AlbumItem(R.drawable.picwrite, "Text 4"))
        itemList.add(AlbumItem(R.drawable.picwrite, "Text 5"))
        itemList.add(AlbumItem(R.drawable.picwrite, "Text 6"))
        itemList.add(AlbumItem(R.drawable.picwrite, "Text 7"))
        itemList.add(AlbumItem(R.drawable.picwrite, "Text 8"))
        itemList.add(AlbumItem(R.drawable.picwrite, "Text 9"))
        itemList.add(AlbumItem(R.drawable.picwrite, "Text 10"))
        itemList.add(AlbumItem(R.drawable.picwrite, "Text 11"))
        itemList.add(AlbumItem(R.drawable.picwrite, "Text 12"))

        _items.value = itemList
    }
}
