package ikemura.com.simanchu_takara_sagashi_android.ui.favorite

import androidx.lifecycle.ViewModelProviders
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import ikemura.com.simanchu_takara_sagashi_android.R
import ikemura.com.simanchu_takara_sagashi_android.SpotRepository
import ikemura.com.simanchu_takara_sagashi_android.ui.list.SimpleItemRecyclerViewAdapter
import ikemura.com.simanchu_takara_sagashi_android.ui.list.SpotListViewModel
import kotlinx.android.synthetic.main.spot_list_view.*

class FavoriteListFragment : Fragment() {

    companion object {
        fun newInstance() = FavoriteListFragment()
    }

    private lateinit var viewModel: SpotListViewModel

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.favorite_list_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProviders.of(this).get(SpotListViewModel::class.java)
        setupRecyclerView(item_list)
    }
    private fun setupRecyclerView(recyclerView: RecyclerView) {

        val data = SpotRepository(activity!!).fetchList()
        recyclerView.adapter = SimpleItemRecyclerViewAdapter(activity!!, data.spots,false)
    }

}