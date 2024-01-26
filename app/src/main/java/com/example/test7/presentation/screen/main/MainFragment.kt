package com.example.test7.presentation.screen.main

import android.view.GestureDetector
import android.view.MotionEvent
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.core.view.GravityCompat
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.test7.R
import com.example.test7.databinding.FragmentMainBinding
import com.example.test7.presentation.base.BaseFragment
import com.example.test7.presentation.screen.module.main.Item

class MainFragment : BaseFragment<FragmentMainBinding>(FragmentMainBinding::inflate) {
    private lateinit var toggle: ActionBarDrawerToggle
    private lateinit var gestureDetector: GestureDetector
    private lateinit var itemRecyclerAdapter: ItemRecyclerAdapter

    override fun bind() {
        binding.apply {
            toggle = ActionBarDrawerToggle(
                requireActivity(),
                mainFragment,
                R.string.open,
                R.string.close
            )
            mainFragment.addDrawerListener(toggle)

            toggle.syncState()

            navView.menu.clear()

//            navView.menu.add(0, R.id.firstItem, 0, "Dashboard")
//            navView.menu.add(0, R.id.firstItem, 0, "Email")
//            navView.menu.add(0, R.id.firstItem, 0, "Notification")
//            navView.menu.add(0, R.id.firstItem, 0, "Calender")
//            navView.menu.add(0, R.id.firstItem, 0, "Statistics")
//            navView.menu.add(0, R.id.firstItem, 0, "Settings")

            navView.setNavigationItemSelectedListener { menuItem ->
                when (menuItem.itemId) {
                    R.id.firstItem -> {
                        true
                    }

                    R.id.secondItem -> {
                        true
                    }

                    R.id.thirdItem -> {
                        true
                    }

                    else -> {
                        false
                    }
                }
            }
        }
        setRecyclerAdapter()
    }

    override fun bindListeners() {
        gestureDetector =
            GestureDetector(requireContext(), object : GestureDetector.SimpleOnGestureListener() {
                override fun onFling(
                    e1: MotionEvent?,
                    e2: MotionEvent,
                    velocityX: Float,
                    velocityY: Float
                ): Boolean {
                    if ((e1?.x ?: 0f) < (e2.x ?: 0f)) {
                        openDrawerMenu()
                        return true
                    }
                    if ((e1?.x ?: 0f) > (e2.x ?: 0f)) {
                        closeDrawer()
                        return true
                    }
                    return false
                }
            })

        binding.mainFragment.setOnTouchListener { _, event ->
            gestureDetector.onTouchEvent(event)
            true
        }

    }

    private fun openDrawerMenu() {
        if (!binding.mainFragment.isDrawerOpen(GravityCompat.START)) {
            binding.mainFragment.openDrawer(GravityCompat.START)
        }
    }

    private fun closeDrawer() {
        if (binding.mainFragment.isDrawerOpen(GravityCompat.START)) {
            binding.mainFragment.closeDrawer(GravityCompat.START)
        }
    }

    private fun setRecyclerAdapter() {
        itemRecyclerAdapter = ItemRecyclerAdapter()
        binding.apply {
            rvRecycler.layoutManager = LinearLayoutManager(requireContext())
            rvRecycler.adapter = itemRecyclerAdapter
        }
        itemRecyclerAdapter.submitList(title)
        itemRecyclerAdapter.onItemClick = {item ->
            when(item.id) {
                1 -> {}
                2 -> {}
                3 -> {}
                4 -> {}
                5 -> {}
                6 -> {}
            }
        }
    }

    val title = listOf<Item>(
        Item(1, "Dashboard", "dsadsa"),
        Item(2, "Email", "dsadsa"),
        Item(3, "Notification", "dsadsa"),
        Item(4, "Calender", "dsadsa"),
        Item(5, "Statistics", "dsadsa"),
        Item(6, "Settings", "dsadsa")
    )

}
