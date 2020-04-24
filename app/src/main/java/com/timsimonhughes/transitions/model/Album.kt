package com.timsimonhughes.transitions.model

data class Album(
    val id: Long,
    val artistTitle: String,
    val albumTitle: String,
    val genre: String,
    val description: String,
    val albumUrl: String
)

val albums = listOf(
    Album(
        id = 1,
        artistTitle = "Kyle",
        albumTitle = "Beautiful Loser",
        genre = "Rap",
        description = "",
        albumUrl = "https://i1.sndcdn.com/artworks-000054327392-ems47c-t500x500.jpg"
    ),
    Album(
        id = 2,
        artistTitle = "Hoodie Allen",
        albumTitle = "Happy Camper",
        genre = "Rap",
        description = "",
        albumUrl = "https://i1.sndcdn.com/artworks-000144085492-enwyj3-t500x500.jpg"
    ),
    Album(
        id = 3,
        artistTitle = "Hoodie Allen",
        albumTitle = "Come Around",
        genre = "Rap",
        description = "",
        albumUrl = "https://i1.sndcdn.com/avatars-000646305318-9q49v0-t500x500.jpg"
    ),
    Album(
        id = 4,
        artistTitle = "Avicii",
        albumTitle = "Tim",
        genre = "Electronic Dance",
        description = "",
        albumUrl = "https://i1.sndcdn.com/artworks-000533593500-m1qwc7-t500x500.jpg"
    ),
    Album(
        id = 5,
        artistTitle = "Galant",
        albumTitle = "Ology",
        genre = "",
        description = "",
        albumUrl = "https://i1.sndcdn.com/artworks-000156855594-srtail-t500x500.jpg"
    ),
    Album(
        id = 6,
        artistTitle = "Dance Gavin Dance",
        albumTitle = "Mothership",
        genre = "",
        description = "",
        albumUrl = "https://img.discogs.com/VqABBo3mA8Xb8W-J7dDGFy1HEdI=/fit-in/600x600/filters:strip_icc():format(jpeg):mode_rgb():quality(90)/discogs-images/R-9138107-1475428893-2244.jpeg.jpg"
    ),
    Album(
        id = 7,
        artistTitle = "Brian Fresca",
        albumTitle = "Casanova",
        genre = "",
        description = "",
        albumUrl = "https://i1.sndcdn.com/artworks-000207769836-ijwzk7-t500x500.jpg"
    )

)

