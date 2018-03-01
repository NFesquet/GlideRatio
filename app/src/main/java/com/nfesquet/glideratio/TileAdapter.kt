package com.nfesquet.glideratio

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.ViewGroup

class TileAdapter(private val context: Context,
                  private val tiles: List<Int> = listOf())
    : RecyclerView.Adapter<TileAdapter.GameViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): GameViewHolder = GameViewHolder(TileView(context))

    override fun getItemCount() = tiles.size

    override fun onBindViewHolder(holder: GameViewHolder, position: Int) {
        (holder.itemView as TileView).bindTile(tiles[position])
    }

    class GameViewHolder(itemView: TileView) : RecyclerView.ViewHolder(itemView)
}