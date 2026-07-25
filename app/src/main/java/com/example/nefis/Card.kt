package com.example.nefis

import android.view.ViewGroup
import android.widget.ImageView
import androidx.core.content.ContextCompat
import androidx.leanback.widget.ImageCardView
import androidx.leanback.widget.Presenter

class Card: Presenter(){
    override fun onCreateViewHolder(parent: ViewGroup): ViewHolder {
        val card=ImageCardView(parent.context)
        card.isFocusable = true
        card.isFocusableInTouchMode = true
        
        // Estilo moderno: Fondo oscuro para la info
        card.infoAreaBackground = ContextCompat.getDrawable(parent.context, R.color.netflix_dark_grey)
        card.setBackgroundColor(ContextCompat.getColor(parent.context, R.color.netflix_black))

        card.setOnFocusChangeListener { view, hasFocus ->
            // Efecto Zoom mucho más grande (1.25x) para resaltar como en la imagen
            val scale = if (hasFocus) 1.25f else 1.0f
            val translationZ = if (hasFocus) 20f else 0f
            
            view.animate()
                .scaleX(scale)
                .scaleY(scale)
                .translationZ(translationZ)
                .setDuration(300)
                .start()
                
            if (view is ImageCardView) {
                // En el estilo Netflix Hero, la info suele estar arriba, 
                // así que mantenemos el área de info discreta o la resaltamos
                val color = if (hasFocus) {
                    ContextCompat.getColor(parent.context, R.color.netflix_red)
                } else {
                    ContextCompat.getColor(parent.context, R.color.netflix_dark_grey)
                }
                view.infoAreaBackground = android.graphics.drawable.ColorDrawable(color)
            }
        }
        return ViewHolder(card)
    }

    override fun onBindViewHolder(viewHolder: ViewHolder, item: Any?) {
        val video = item as Video
        val card = viewHolder.view as ImageCardView
        
        card.titleText = video.title
        card.contentText = video.subtitle
        
        // Estilo Netflix Moderno: Dimensiones de póster más grandes
        card.setMainImageDimensions(400, 225) // Ratio 16:9 más grande
        card.mainImageView.scaleType = ImageView.ScaleType.CENTER_CROP
        card.mainImageView.setImageResource(video.image)
    }

    override fun onUnbindViewHolder(viewHolder: ViewHolder) {

    }

}