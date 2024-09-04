import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.picwrite.R
import com.example.picwrite.ui.album.AlbumItem

class AlbumViewModel : ViewModel() {

    private val _items = MutableLiveData<List<AlbumItem>>()
    val items: LiveData<List<AlbumItem>> get() = _items

    private val _items2 = MutableLiveData<List<AlbumItem>>()
    val items2: LiveData<List<AlbumItem>> get() = _items2

    init {
        val itemList = mutableListOf<AlbumItem>()
        itemList.add(AlbumItem(R.drawable.picwrite, "1월"))
        itemList.add(AlbumItem(R.drawable.picwrite, "2월"))
        itemList.add(AlbumItem(R.drawable.picwrite, "3월"))
        itemList.add(AlbumItem(R.drawable.picwrite, "4월"))
        itemList.add(AlbumItem(R.drawable.picwrite, "5월"))
        itemList.add(AlbumItem(R.drawable.picwrite, "6월"))
        itemList.add(AlbumItem(R.drawable.picwrite, "7월"))
        itemList.add(AlbumItem(R.drawable.picwrite, "8월"))
        itemList.add(AlbumItem(R.drawable.picwrite, "9월"))
        itemList.add(AlbumItem(R.drawable.picwrite, "10월"))
        itemList.add(AlbumItem(R.drawable.picwrite, "11월"))
        itemList.add(AlbumItem(R.drawable.picwrite, "12월"))

        _items.value = itemList

        val itemList2 = mutableListOf<AlbumItem>()
        itemList2.add(AlbumItem(R.drawable.picwrite, "1월"))
        itemList2.add(AlbumItem(R.drawable.picwrite, "2월"))
        itemList2.add(AlbumItem(R.drawable.picwrite, "3월"))
        itemList2.add(AlbumItem(R.drawable.picwrite, "4월"))
        itemList2.add(AlbumItem(R.drawable.picwrite, "5월"))
        itemList2.add(AlbumItem(R.drawable.picwrite, "6월"))
        itemList2.add(AlbumItem(R.drawable.picwrite, "7월"))
        itemList2.add(AlbumItem(R.drawable.picwrite, "8월"))
        itemList2.add(AlbumItem(R.drawable.picwrite, "9월"))
        itemList2.add(AlbumItem(R.drawable.picwrite, "10월"))
        itemList2.add(AlbumItem(R.drawable.picwrite, "11월"))
        itemList2.add(AlbumItem(R.drawable.picwrite, "12월"))

        _items2.value = itemList
    }
}
