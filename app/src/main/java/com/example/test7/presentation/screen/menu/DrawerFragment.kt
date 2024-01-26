//package com.example.test7.presentation.screen.menu
//
//import androidx.recyclerview.widget.LinearLayoutManager
//import com.example.test7.databinding.NavHeaderBinding
//import com.example.test7.presentation.base.BaseFragment
//import com.example.test7.presentation.screen.main.ItemRecyclerAdapter
//import com.example.test7.presentation.screen.module.main.Item
//
//class DrawerFragment: BaseFragment<NavHeaderBinding>(NavHeaderBinding::inflate) {
//    private lateinit var itemRecyclerAdapter: ItemRecyclerAdapter
//
//    override fun bind() {
//        setRecyclerAdapter()
//    }
//
//    override fun bindListeners() {}
//
//    private fun setRecyclerAdapter() {
//        itemRecyclerAdapter = ItemRecyclerAdapter()
//        binding.apply {
//            rvRecycler.layoutManager = LinearLayoutManager(requireContext())
//            rvRecycler.adapter = itemRecyclerAdapter
//        }
//        itemRecyclerAdapter.submitList(title)
//        itemRecyclerAdapter.onItemClick = {item ->
//            when(item.id) {
//                1 -> {}
//                2 -> {}
//                3 -> {}
//                4 -> {}
//                5 -> {}
//                6 -> {}
//            }
//        }
//    }
//
//    val title = listOf<Item>(
//        Item(1, "Dashboard", "dsadsa"),
//        Item(2, "Email", "dsadsa"),
//        Item(3, "Notification", "dsadsa"),
//        Item(4, "Calender", "dsadsa"),
//        Item(5, "Statistics", "dsadsa"),
//        Item(6, "Settings", "dsadsa")
//    )
//}