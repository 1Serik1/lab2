package com.example.lab2

import android.graphics.Movie
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.lab2.databinding.FragmentFirstBinding

class FirstFragment : Fragment(), Adapter.Listener {

    private var _binding: FragmentFirstBinding? = null
    private val binding get() = _binding!!
    var Movies = ArrayList<Movie_DataClass>()
    lateinit var adapter: Adapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        var First_Movie = Movie_DataClass("Peaky blinders", "Steven Knight","\"Peaky Blinders\" is a British period crime drama television series set in the aftermath of World War I in Birmingham, England. The series follows the exploits of the Shelby family, a notorious gangster family led by the charismatic and ruthless Tommy Shelby (played by Cillian Murphy).\n" +
                "\n" +
                "The series takes its name from the real-life \"Peaky Blinders,\" a criminal gang that operated in Birmingham in the late 19th and early 20th centuries. The Shelbys, like their real-life counterparts, are known for their distinctive style of dress, which includes peaked caps with razor blades sewn into the brim.\n" +
                "\n" +
                "The show is known for its stylish cinematography, evocative music, and strong performances from its cast. The series also explores themes of family, loyalty, and power, as the Shelbys navigate the treacherous world of organized crime and struggle to maintain their dominance in the face of rival gangs, corrupt police officers, and other dangerous adversaries.\n" +
                "\n" +
                "Throughout the show's five seasons, the Shelbys become embroiled in a variety of criminal activities, including smuggling, gambling, and political intrigue. The series also features a number of historical figures, including Winston Churchill and Al Capone, as well as a range of complex and compelling characters who bring the world of the \"Peaky Blinders\" to life.",
            "https://images.liverpoolmuseums.org.uk/styles/dynamic/public/2021-12/Peaky%20Blinders.jpg")

        var Second_Movie = Movie_DataClass("I Am Legend", "Francis Lawrence", "\"I Am Legend\" is a post-apocalyptic science fiction film that tells the story of Dr. Robert Neville, a brilliant scientist who is the last survivor in New York City after a man-made virus wipes out most of humanity and turns the rest into vampire-like creatures. Neville spends his days scavenging for supplies and his nights barricaded in his home, working on a cure for the virus that killed his family and friends.\n" +
                "\n" +
                "As the last human on earth, Neville is constantly haunted by the loss of his loved ones and the desperation of his situation. He is also haunted by the vampire-like creatures, who are highly intelligent and have learned to hunt in packs. Neville must use all his scientific knowledge and survival skills to stay alive, fend off the creatures, and find a cure before he succumbs to the virus himself.\n" +
                "\n" +
                "The film explores themes of isolation, survival, and the human condition, as Neville struggles to maintain his sanity and his humanity in a world that has been turned upside down. Will Smith delivers a powerful performance as Neville, and the film's stunning visuals and intense action sequences make for a thrilling and thought-provoking viewing experience.",
            "https://e0.pxfuel.com/wallpapers/745/221/desktop-wallpaper-i-am-legend-2007-phone.jpg")

        var Third_Movie = Movie_DataClass("Knockin' on Heaven's Door", "Thomas Jahn", "The German film \"Knockin' on Heaven's Door\" is a comedy-drama that tells the story of two terminally ill men, Martin and Rudi, who meet in a hospital and decide to break out and live their remaining days to the fullest.\n" +
                "\n" +
                "After stealing a luxury car and a bag full of money, the unlikely duo embark on a road trip across Germany, encountering a range of characters along the way. They are pursued by a group of criminals who want their money back, leading to a series of comedic and dramatic moments.\n" +
                "\n" +
                "As they travel, Martin and Rudi form a close bond and reflect on their lives, their regrets, and their hopes for the future. The film is a poignant exploration of the human experience, with themes of friendship, mortality, and the importance of living life to the fullest.\n" +
                "\n" +
                "\"Knockin' on Heaven's Door\" was directed by Thomas Jahn and stars Til Schweiger and Jan Josef Liefers in the lead roles. The film was a commercial success in Germany and has gained a cult following over the years. It is often cited as one of the best German films of the 1990s.",
            "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQ8265xzUpRj3S9AdWCL4u6HaCQHYJNLLuJCw&usqp=CAU")

        var Fourth_Movie = Movie_DataClass("8 Mile", "Curtis Hanson","\"8 Mile\" is a 2002 American drama film directed by Curtis Hanson and starring rapper Eminem in his acting debut. The film is set in 1995 in Detroit, Michigan and follows the story of Jimmy \"B-Rabbit\" Smith Jr. (played by Eminem), a young aspiring rapper who lives in a trailer park with his alcoholic mother and younger sister.\n" +
                "\n" +
                "The film revolves around B-Rabbit's struggles to make it as a rapper in the underground hip-hop scene of Detroit. He faces numerous challenges, including a difficult home life, poverty, and the racism and violence of the predominantly black hip-hop community.\n" +
                "\n" +
                "B-Rabbit's primary goal is to win a rap battle competition at a local club called The Shelter, which is seen as the most important event in the Detroit hip-hop scene. Along the way, he forms close relationships with fellow aspiring rappers, including his love interest, Alex, and his best friend, Future.\n" +
                "\n" +
                "As B-Rabbit prepares for the competition, he confronts his own insecurities and inner demons, ultimately learning to overcome them through his music. The film culminates in an intense rap battle between B-Rabbit and his arch-nemesis, Papa Doc, where B-Rabbit ultimately triumphs and solidifies his place as a respected member of the Detroit hip-hop community.",
            "https://resizing.flixster.com/-IdcBE941j6n8baRLqqE1NtlQcY=/300x300/v2/https://flxt.tmsimg.com/assets/p29400_v_v10_ae.jpg")

        Movies.add(First_Movie)
        Movies.add(Second_Movie)
        Movies.add(Third_Movie)
        Movies.add(Fourth_Movie)
        adapter = Adapter(this, Movies, this)
    }


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        _binding = FragmentFirstBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val layoutManager = LinearLayoutManager(context)
        binding.Rv.layoutManager = layoutManager
        binding.Rv.adapter = adapter
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }

    override fun onClick(itemView: Int) {
        val bundle = bundleOf(
            SecondFragment.number to itemView,
            SecondFragment.name to Movies[itemView].titles,
            SecondFragment.creator to Movies[itemView].detail,
            SecondFragment.description to Movies[itemView].screen2,
            SecondFragment.url to Movies[itemView].URL)
        findNavController().navigate(R.id.action_firstFragment_to_secondFragment,bundle)
    }

}