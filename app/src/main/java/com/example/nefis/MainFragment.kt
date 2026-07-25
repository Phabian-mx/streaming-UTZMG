package com.example.nefis

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.TextView
import androidx.core.content.ContextCompat
import androidx.leanback.app.BrowseSupportFragment
import androidx.leanback.widget.ArrayObjectAdapter
import androidx.leanback.widget.HeaderItem
import androidx.leanback.widget.ListRow
import androidx.leanback.widget.ListRowPresenter
import androidx.leanback.widget.OnItemViewClickedListener
import androidx.leanback.widget.OnItemViewSelectedListener
import androidx.core.app.ActivityOptionsCompat
import androidx.leanback.widget.ImageCardView

class MainFragment: BrowseSupportFragment() {
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        title = "Stremming UTZMG"
        

        brandColor = ContextCompat.getColor(requireContext(), R.color.netflix_black)
        

        val backgroundManager = androidx.leanback.app.BackgroundManager.getInstance(requireActivity())
        if (!backgroundManager.isAttached) {
            backgroundManager.attach(requireActivity().window)
        }
        backgroundManager.color = ContextCompat.getColor(requireContext(), R.color.netflix_black)

        val categoriesAdapter = ArrayObjectAdapter(ListRowPresenter())

        val categoryNames = listOf("Acción", "Comedia", "Drama", "Terror", "Documentales")
        val videoResources = listOf(R.raw.uno, R.raw.dos)
        val imageResources = listOf(R.mipmap.mishito, R.mipmap.mandarino)

        for (i in 0 until 5) {
            val categoryTitle = categoryNames[i]
            val videosAdapter = ArrayObjectAdapter(Card())
            
            if (categoryTitle == "Acción") {

                videosAdapter.add(Video(
                    "Dos policías rebeldes",
                    "1995 • Acción",
                    R.mipmap.polis,
                    "Dos detectives de narcóticos de Miami tienen 72 horas para recuperar 100 millones de dólares en heroína robada.",
                    R.raw.diez
                ))
                videosAdapter.add(Video(
                    "Una pareja explosiva",
                    "1998 • Acción",
                    R.mipmap.pareja,
                    "Un inspector de Hong Kong y un policía de Los Ángeles se unen para rescatar a la hija de un diplomático.",
                    R.raw.nueve
                ))
                videosAdapter.add(Video(
                    "Infiltrados en la clase",
                    "2012 • Acción",
                    R.mipmap.clase,
                    "Dos policías novatos se infiltran como estudiantes en una preparatoria para desmantelar una red de narcotráfico.",
                    R.raw.ocho
                ))
                videosAdapter.add(Video(
                    "Tren bala",
                    "2022 • Acción",
                    R.mipmap.tren,
                    "Mariquita, un asesino con mala suerte, debe recuperar un maletín a bordo del tren más rápido del mundo.",
                    R.raw.seis
                ))
                videosAdapter.add(Video(
                    "Profesión peligro",
                    "2024 • Acción",
                    R.mipmap.profesion,
                    "Un doble de acción debe resolver el misterio de la desaparición de una estrella de cine.",
                    R.raw.siete
                ))
            } else if (categoryTitle == "Comedia") {

                videosAdapter.add(Video(
                    "¿Dónde están las rubias?",
                    "2004 • Comedia",
                    R.mipmap.donde,
                    "Dos agentes del FBI se disfrazan de chicas millonarias para evitar un secuestro en los Hamptons.",
                    R.raw.uno
                ))
                videosAdapter.add(Video(
                    "Scary Movie",
                    "2000 • Comedia",
                    R.mipmap.movie,
                    "Un grupo de adolescentes es perseguido por un asesino en serie en esta parodia de cine de terror.",
                    R.raw.dos
                ))
                videosAdapter.add(Video(
                    "Chicas pesadas",
                    "2004 • Comedia",
                    R.mipmap.chicas,
                    "Cady Heron entra a una preparatoria pública y se enfrenta a 'Las Plásticas' en una guerra de reputación.",
                    R.raw.tres
                ))
                videosAdapter.add(Video(
                    "Son como niños",
                    "2010 • Comedia",
                    R.mipmap.ninos,
                    "Cinco amigos de la infancia se reúnen tras años para revivir viejos tiempos tras la muerte de su entrenador.",
                    R.raw.cuatro
                ))
                videosAdapter.add(Video(
                    "¿Y dónde está el policía?",
                    "1988 • Comedia",
                    R.mipmap.poli,
                    "El torpe teniente Frank Drebin debe evitar un complot para asesinar a la Reina Isabel II.",
                    R.raw.cinco
                ))
            } else if (categoryTitle == "Terror") {

                videosAdapter.add(Video(
                    "Háblame",
                    "2023 • Terror",
                    R.mipmap.hablame,
                    "Un grupo de amigos descubre cómo conjurar espíritus usando una mano embalsamada, desatando fuerzas aterradoras.",
                    R.raw.hablame
                ))
                videosAdapter.add(Video(
                    "Huye",
                    "2017 • Terror",
                    R.mipmap.huye,
                    "Un joven afroamericano visita a la familia de su novia blanca y descubre un secreto siniestro detrás de su hospitalidad.",
                    R.raw.huye
                ))
                videosAdapter.add(Video(
                    "Sonríe",
                    "2022 • Terror",
                    R.mipmap.sonrie,
                    "Tras presenciar un incidente traumático, una doctora empieza a experimentar sucesos aterradores que no puede explicar.",
                    R.raw.sonrie
                ))
                videosAdapter.add(Video(
                    "Un lugar en silencio",
                    "2018 • Terror",
                    R.mipmap.lugar,
                    "Una familia debe vivir en silencio absoluto para evitar ser cazada por criaturas que cazan mediante el sonido.",
                    R.raw.lugar
                ))
                videosAdapter.add(Video(
                    "El Conjuro",
                    "2013 • Terror",
                    R.mipmap.conjuro,
                    "Investigadores paranormales trabajan para ayudar a una familia aterrorizada por una presencia oscura en su granja.",
                    R.raw.conjuro
                ))
            } else if (categoryTitle == "Drama") {

                videosAdapter.add(Video(
                    "Sueños de libertad",
                    "1994 • Drama",
                    R.mipmap.sueno,
                    "Andy Dufresne, un banquero reservado, es condenado injustamente a cadena perpetua por el asesinato de su esposa. En la dura e implacable prisión de Shawshank, establece una entrañable amistad con Red, un recluso veterano. A lo largo de las décadas, Andy demuestra que la esperanza y la dignidad humana pueden sobrevivir incluso en el entorno más sombrío.",
                    R.raw.nueva
                ))
                videosAdapter.add(Video(
                    "El pianista",
                    "2002 • Drama",
                    R.mipmap.pianista,
                    "Basada en la historia real del músico judío polaco Władysław Szpilman, la película relata su angustiosa lucha por sobrevivir en el gueto de Varsovia durante la ocupación nazi en la Segunda Guerra Mundial. Es un retrato desolador sobre la resiliencia, la pérdida y el poder salvador del arte en medio de la tragedia.",
                    R.raw.pianista
                ))
                videosAdapter.add(Video(
                    "Whiplash",
                    "2014 • Drama",
                    R.mipmap.whiplash,
                    "Un joven y ambicioso baterista de jazz ingresa al conservatorio de música más exigente de Estados Unidos. Allí se enfrenta a Terence Fletcher, un instructor de renombre cuyos métodos de enseñanza sobrepasan el rigor para convertirse en manipulación y abuso psicológico, llevando al alumno al límite de su cordura y capacidad física",
                    R.raw.whiplash
                ))
                videosAdapter.add(Video(
                    "Historia de un matrimonio",
                    "2019 • Drama",
                    R.mipmap.historia,
                    "Un director de teatro y una actriz intentan superar un proceso de divorcio que evoluciona de un acuerdo pacífico a una desgastante batalla legal entre Nueva York y Los Ángeles. La película explora de forma íntima, realista y desgarradora la complejidad de las relaciones, el desamor y la reconstrucción personal.",
                    R.raw.historia
                ))
                videosAdapter.add(Video(
                    "Parásito",
                    "2019 • Drama",
                    R.mipmap.parasito,
                    "Una familia desempleada y de escasos recursos logra infiltrarse paulatinamente en la vida y la residencia de una adinerada familia de Seúl, ofreciendo sus servicios bajo identidades falsas. Este drama con elementos de comedia negra y thriller ofrece una brillante y feroz crítica a la brecha de clases sociales.",
                    R.raw.parasito
                ))
            } else if (categoryTitle == "Documentales") {

                videosAdapter.add(Video(
                    "pez",
                    "2023 • Documental",
                    R.mipmap.pez,
                    "Vertebrados acuáticos adaptados para vivir bajo el agua. Respiran mediante branquias, se desplazan usando aletas y, en su mayoría, tienen el cuerpo cubierto de escamas. Habitan casi cualquier rincón acuático de la Tierra, desde pequeños arroyos hasta las fosa más profundas del océano.",
                    R.raw.pez
                ))
                videosAdapter.add(Video(
                    "mono",
                    "2017 • Documental",
                    R.mipmap.mono,
                    "Primates conocidos por su alta inteligencia, agilidad y vida social. La mayoría vive en las copas de los árboles, utilizando sus manos, pies (y en el caso de las especies americanas, sus colas prensiles) para desplazarse con soltura. Tienen estructuras familiares complejas y formas muy variadas de comunicación.",
                    R.raw.mono
                ))
                videosAdapter.add(Video(
                    "colibri",
                    "2022 • Documental",
                    R.mipmap.colibri,
                    "Las verdaderas «joyas voladoras» del reino animal. Son las aves más pequeñas del mundo y las únicas capaces de volar hacia atrás o mantenerse suspendidas en el aire gracias al rapidísimo aleteo de sus alas (de 50 a 80 veces por segundo). Se alimentan del néctar de las flores y son polinizadores clave.",
                    R.raw.colibri
                ))
                videosAdapter.add(Video(
                    "ave",
                    "2018 • Documental",
                    R.mipmap.ave,
                    "Vertebrados de sangre caliente caracterizados por sus cuerpos cubiertos de plumas, picos sin dientes y huesos ligeros adaptados en su mayoría para el vuelo (aunque algunas, como los pingüinos o avestruces, prefieren el agua o la tierra). Son los grandes músicos e ingenieros del aire.",
                    R.raw.ave
                ))
                videosAdapter.add(Video(
                    "naturaleza",
                    "2013 • Documental",
                    R.mipmap.natu,
                    "El gran sistema dinámico y viviente del planeta. Engloba a todos los seres vivos junto con los elementos no vivos (el agua, la tierra, el aire y el clima) que existen sin intervención humana. Es la red interconectada que sostiene la vida y equilibra nuestro entorno.",
                    R.raw.naturaleza
                ))
            } else {

                for (j in 0 until 5) {
                    val videoIdx = (i * 5 + j) % videoResources.size
                    val imageIdx = (i * 5 + j) % imageResources.size
                    
                    videosAdapter.add(
                        Video(
                            "Video ${i + 1}-${j + 1}",
                            "Categoría: $categoryTitle",
                            imageResources[imageIdx],
                            "Esta es la descripción detallada del Video ${j + 1} de la categoría $categoryTitle.",
                            videoResources[videoIdx]
                        )
                    )
                }
            }

            val header = HeaderItem(i.toLong(), categoryTitle)
            categoriesAdapter.add(ListRow(header, videosAdapter))
        }

        adapter = categoriesAdapter

        onItemViewClickedListener = OnItemViewClickedListener { itemViewHolder, video, _, _ ->
            val intent = Intent(requireContext(), PlayActivity::class.java).apply {
                putExtra(PlayActivity.MOVIE_EXTRA, video as Video)
            }


            val cardView = itemViewHolder.view as? ImageCardView
            val imageView = cardView?.mainImageView

            if (imageView != null) {

                val options = ActivityOptionsCompat.makeSceneTransitionAnimation(
                    requireActivity(),
                    imageView,
                    "poster_transition"
                )
                startActivity(intent, options.toBundle())
            } else {

                startActivity(intent)
            }
        }
        // ... justo debajo de tu onItemViewClickedListener ...

        onItemViewSelectedListener = OnItemViewSelectedListener { _, video, _, _ ->
            if (video is Video) {
                // Actualizar sección Hero (Detalles arriba)
                val activity = requireActivity()
                activity.findViewById<TextView>(R.id.hero_title)?.text = video.title
                activity.findViewById<TextView>(R.id.hero_description)?.text = video.description
                // Metadata estática para el ejemplo (Año, etc)
                activity.findViewById<TextView>(R.id.hero_metadata)?.text = "2025 • TV-MA • Película"

                // Cambiar el fondo
                val backgroundManager = androidx.leanback.app.BackgroundManager.getInstance(activity)
                if (!backgroundManager.isAttached) {
                    backgroundManager.attach(activity.window)
                }
                backgroundManager.setDrawable(requireContext().getDrawable(video.image))
            }
        }
    }
}