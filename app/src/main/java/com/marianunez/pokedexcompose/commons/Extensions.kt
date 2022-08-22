package com.marianunez.pokedexcompose.commons

import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.widget.ImageView
import com.bumptech.glide.Glide

fun ImageView.loadImageByUrl(url: String?) =
    Glide.with(context)
        .load(url)
        .centerCrop()
        .placeholder(ColorDrawable(Color.LTGRAY))
        .into(this)