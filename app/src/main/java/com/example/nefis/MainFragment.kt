package com.example.nefis

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.leanback.app.BrowseSupportFragment
import androidx.leanback.widget.ArrayObjectAdapter
import androidx.leanback.widget.HeaderItem
import androidx.leanback.widget.ListRow
import androidx.leanback.widget.ListRowPresenter
import androidx.leanback.widget.OnItemViewClickedListener
import androidx.leanback.widget.OnItemViewSelectedListener

class MainFragment: BrowseSupportFragment() {
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        title = "Nefis - Streaming"

        val categoriesAdapter = ArrayObjectAdapter(ListRowPresenter())

        val categoryNames = listOf("Acción", "Comedia", "Drama", "Terror", "Documentales")
        val videoResources = listOf(R.raw.nutella, R.raw.utzmg)
        val imageResources = listOf(R.mipmap.mishito, R.mipmap.mandarino)

        for (i in 0 until 5) {
            val categoryTitle = categoryNames[i]
            val videosAdapter = ArrayObjectAdapter(Card())
            
            for (j in 0 until 5) {
                val videoIdx = (i * 5 + j) % videoResources.size
                val imageIdx = (i * 5 + j) % imageResources.size
                
                videosAdapter.add(
                    Video(
                        "Video ${i + 1}-${j + 1}",
                        "Categoría: $categoryTitle",
                        imageResources[imageIdx],
                        "Esta es la descripción detallada del Video ${j + 1} de la categoría $categoryTitle. Disfruta de este contenido especial.",
                        videoResources[videoIdx]
                    )
                )
            }

            val header = HeaderItem(i.toLong(), categoryTitle)
            categoriesAdapter.add(ListRow(header, videosAdapter))
        }

        adapter = categoriesAdapter

        onItemViewClickedListener = OnItemViewClickedListener { _, video, _, _ ->
            val intent = Intent(requireContext(), PlayActivity::class.java).apply {
                putExtra(PlayActivity.MOVIE_EXTRA, video as Video)
            }
            startActivity(intent)
        }
    }
}