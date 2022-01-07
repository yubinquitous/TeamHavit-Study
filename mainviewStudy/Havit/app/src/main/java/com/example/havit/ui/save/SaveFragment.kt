package com.example.havit.ui.save

import android.app.Dialog
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.google.android.material.bottomsheet.BottomSheetBehavior
import com.google.android.material.bottomsheet.BottomSheetDialog
import com.google.android.material.bottomsheet.BottomSheetDialogFragment

import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import androidx.constraintlayout.widget.ConstraintLayout

import androidx.coordinatorlayout.widget.CoordinatorLayout
import com.example.havit.R
import com.google.android.material.snackbar.Snackbar


class SaveFragment : BottomSheetDialogFragment() {



    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        /*dialog?.setOnShowListener {

            val bottomSheet = dialog?.findViewById<View>(com.google.android.material.R.id.design_bottom_sheet)
            val behavior = BottomSheetBehavior.from<ConstraintLayout>((dialog as BottomSheetDialog).findViewById(com.example.havit.R.id.design_bottom_sheet)!!)
            behavior.state = BottomSheetBehavior.STATE_EXPANDED
            behavior.skipCollapsed=true

        }*/


        return inflater.inflate(com.example.havit.R.layout.fragment_save, container, false)
    }

    override fun getTheme(): Int {
        return R.style.AppBottomSheetDialogTheme
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        // 팝업 생성 시 전체화면으로 띄우기

        //behavior.maxWidth=500
        //behavior.expandedOffset=500
        //behavior.isGestureInsetBottomIgnored=true

       /* behavior.addBottomSheetCallback(object : BottomSheetBehavior.BottomSheetCallback() {
            override fun onStateChanged(bottomSheet: View, newState: Int) {
                *//*if (newState == BottomSheetBehavior.STATE_DRAGGING) {
                    behavior.state = BottomSheetBehavior.STATE_EXPANDED
                }*//*
            }

            override fun onSlide(bottomSheet: View, slideOffset: Float) {}
        })*/


        // 드래그해도 팝업이 종료되지 않도록

    }

   /* override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        val dialog = super.onCreateDialog(savedInstanceState)
        *//*if (dialog != null) {
            val bottomSheet = dialog.findViewById<View>(com.example.havit.R.id.design_bottom_sheet)
            bottomSheet.layoutParams.height = ViewGroup.LayoutParams.MATCH_PARENT
        }*//*
        dialog.setOnShowListener {


        }
        return dialog


    }
*/

}