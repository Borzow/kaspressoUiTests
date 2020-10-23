package com.isaiahvonrundstedt.fokus.features.attachments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.FragmentManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.isaiahvonrundstedt.fokus.R
import com.isaiahvonrundstedt.fokus.databinding.LayoutSheetOptionsBinding
import com.isaiahvonrundstedt.fokus.features.shared.abstracts.BaseBottomSheet
import com.isaiahvonrundstedt.fokus.features.shared.adapters.MenuAdapter

class AttachmentOptionSheet(manager: FragmentManager): BaseBottomSheet<Int>(manager),
    MenuAdapter.MenuItemListener {

    private var _binding: LayoutSheetOptionsBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        _binding = LayoutSheetOptionsBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.menuTitleView.text = getString(R.string.dialog_new_attachment)

        with(binding.recyclerView) {
            layoutManager = LinearLayoutManager(context)
            adapter = MenuAdapter(activity, R.menu.menu_attachment,
                this@AttachmentOptionSheet)
        }
    }

    override fun onItemSelected(id: Int) {
        receiver?.onReceive(id)
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }
}