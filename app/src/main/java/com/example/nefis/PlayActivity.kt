package com.example.nefis

import android.os.Bundle
import androidx.fragment.app.FragmentActivity
import android.net.Uri
import android.util.Log
import android.widget.MediaController
import android.widget.VideoView

class PlayActivity : FragmentActivity() {

    companion object{
        const val MOVIE_EXTRA="extra:movie"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_play)

        val videoView = findViewById<VideoView>(R.id.videoView)
        val titleView = findViewById<android.widget.TextView>(R.id.videoTitle)
        val descriptionView = findViewById<android.widget.TextView>(R.id.videoDescription)
        val overlay = findViewById<android.view.View>(R.id.gradient_overlay)
        val detailsContainer = findViewById<android.view.View>(R.id.details_container)

        val video: Video? = intent.getParcelableExtra<Video>(PlayActivity.MOVIE_EXTRA)

        var path = ""
        if (video != null) {
            path = "android.resource://" + packageName + "/" + video.video
            titleView.text = video.title
            descriptionView.text = video.description
        }

        val uri = Uri.parse(path)

        val mediaController = MediaController(this)
        mediaController.setAnchorView(videoView)
        videoView.setMediaController(mediaController)

        videoView.setVideoURI(uri)
        videoView.requestFocus()
        videoView.start()

        // Hide details after a few seconds
        detailsContainer.postDelayed({
            detailsContainer.animate().alpha(0f).setDuration(1000).start()
            overlay.animate().alpha(0f).setDuration(1000).start()
        }, 5000)

        // Show details when player is touched/clicked
        videoView.setOnClickListener {
            detailsContainer.animate().alpha(1f).setDuration(500).start()
            overlay.animate().alpha(1f).setDuration(500).start()
            detailsContainer.postDelayed({
                detailsContainer.animate().alpha(0f).setDuration(1000).start()
                overlay.animate().alpha(0f).setDuration(1000).start()
            }, 5000)
        }
    }
}