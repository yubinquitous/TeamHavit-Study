package org.sopt.havit_study

import android.view.View
import android.widget.ImageView
import androidx.databinding.BindingAdapter
import com.bumptech.glide.Glide

object BindingAdapters {

    /**
     * View의 visibility를 변경
     * @param view 속성을 사용하는 view
     * @param isVisible visibility를 변경시키는 기준이 되는 값
     */
    @JvmStatic
    @BindingAdapter("visible")
    fun setVisible(view: View, isVisible: Boolean){
        if (isVisible)
            view.visibility = View.VISIBLE
        else
            view.visibility = View.INVISIBLE
    }

    // Glide 라이브러리를 이용한 메소드
    @JvmStatic
    @BindingAdapter("imageUrl")
    fun loadImage(imageView: ImageView, imageUrl: String) {
        Glide.with(imageView.context)
            .load(imageUrl)
            .override(300, 300)
            .circleCrop()
            .into(imageView)
    }
}