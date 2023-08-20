package com.example.shoecollection

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.shoecollection.databinding.ActivityMainBinding
import com.squareup.picasso.Picasso

private lateinit var bind : ActivityMainBinding

data class Shoe(val shoeName : String, val shoePrice : Double, val shoeImg : String )
private val nikeLogolink = "https://upload.wikimedia.org/wikipedia/commons/thumb/a/a6/Logo_NIKE.svg/800px-Logo_NIKE.svg.png"
private const val url  = "https://stat4.bollywoodhungama.in/wp-content/uploads/2022/08/Jailer-322x504.jpg"

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        bind = ActivityMainBinding.inflate(layoutInflater)
        setContentView(bind.root)

        Picasso.get().load(nikeLogolink).into(bind.avImg)

        val shoeCollection = createShoeModel()

        /*
        1. add in recycler View Library in dependency (gradle module : app) or either drag and drop or manual do
        2. Define a model class to use as the data source
        3. Add the recycler view to the activity
        4. Custom the xml file for recylcer view
        5. Create RecyclerView.Adapter and ViewHolder to render the item
        6. bind the values - Layout manager
         */

        bind.rvContext.adapter = ShoeCollectionAdapter(this,shoeCollection)


bind.rvContext.layoutManager = LinearLayoutManager(this)

    }

    private fun createShoeModel():List<Shoe>{
        val shoeCollection = mutableListOf<Shoe>()
        var nikeShoeList = mutableListOf<String>()

        for (i in 1..50){
            shoeCollection.add(Shoe("Nike $i",(i*i)+i.toDouble(),"https://static.nike.com/a/images/t_PDP_1280_v1/f_auto,q_auto:eco/99486859-0ff3-46b4-949b-2d16af2ad421/custom-nike-dunk-high-by-you-shoes.png"))
        }
        return shoeCollection

        /*
     top_nike_shoes = [
    "Air Jordan 1", "Air Force 1", "Nike Dunk", "Air Max 90", "Air Max 1", "Air Max 270",
    "Air Presto", "Roshe Run", "Vapormax", "Zoom Pegasus", "Zoom Fly", "Nike Blazer",
    "Kyrie 7", "Kyrie 8", "LeBron 19", "KD 15", "PG 6", "Dame 7", "Air Zoom Alphafly Next% 2",
    "Air Zoom Tempo Next%", "NikeCourt Zoom Vapor Cage 4", "Air Zoom Vapor Pro", "Air Zoom Infinity Tour",
    "Air Zoom Pegasus 39", "Nike Metcon 7", "Nike Air Zoom Structure 24", "Nike Air Zoom Vomero 16",
    "Nike Air Zoom Terra Kiger 8", "Nike Air Zoom Pegasus Trail 3", "Nike Air Zoom Wildhorse 7",
    "Nike Air Zoom Tempo NEXT% Flyknit", "Nike Air Zoom Pegasus 39 Trail", "Nike Air Zoom Infinity Tour NXT"
]
         */
    }
}