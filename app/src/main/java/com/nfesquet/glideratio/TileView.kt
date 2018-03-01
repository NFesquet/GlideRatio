package com.nfesquet.glideratio

import android.content.Context
import android.graphics.drawable.Drawable
import android.support.v4.view.ViewCompat
import android.support.v7.widget.CardView
import android.util.AttributeSet
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.bumptech.glide.Glide
import com.bumptech.glide.load.DataSource
import com.bumptech.glide.load.engine.GlideException
import com.bumptech.glide.request.RequestListener
import com.bumptech.glide.request.target.Target
import kotlinx.android.synthetic.main.item_tile.view.*

class TileView : CardView {

    constructor(context: Context) : this(context, null)
    constructor(context: Context, attrs: AttributeSet?) : this(context, attrs, 0)
    constructor(context: Context, attrs: AttributeSet?, defStyleAttr: Int) : super(context, attrs, defStyleAttr) {
        init()
    }

    private fun init() {
        val root = LayoutInflater.from(context).inflate(R.layout.item_tile, this, true)

        (root as CardView).radius = context.resources.getDimension(R.dimen.radius_tile_cardview)
        ViewCompat.setElevation(this, context.resources.getDimension(R.dimen.elevation_tile_cardview))
    }

    override fun onAttachedToWindow() {
        super.onAttachedToWindow()

        val margin = context.resources.getDimensionPixelOffset(R.dimen.margin_tile_cardview)
        val marginLayoutParams = this.layoutParams as ViewGroup.MarginLayoutParams?
        marginLayoutParams?.setMargins(margin, margin, margin, margin)
                ?.let { layoutParams = marginLayoutParams }
    }

    fun bindTile(resourceId: Int) {
        Glide.with(context)
                .load(resourceId)
//                .listener(object : RequestListener<Drawable> {
//                    override fun onLoadFailed(e: GlideException?,
//                                              model: Any?,
//                                              target: Target<Drawable>?,
//                                              isFirstResource: Boolean): Boolean = false
//
//                    override fun onResourceReady(resource: Drawable?,
//                                                 model: Any?,
//                                                 target: Target<Drawable>?,
//                                                 dataSource: DataSource?,
//                                                 isFirstResource: Boolean): Boolean {
//                        tileView.visibility = View.VISIBLE
//                        return false
//                    }
//                })
                .into(tilePicture)
    }
}