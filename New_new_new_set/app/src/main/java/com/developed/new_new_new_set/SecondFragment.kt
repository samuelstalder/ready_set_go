package com.developed.new_new_new_set

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.developed.new_new_new_set.databinding.FragmentSecondBinding


/**
 * A simple [Fragment] subclass as the second destination in the navigation.
 */
class SecondFragment : Fragment(), CardAdapter.OnItemClickListener {

    private var _binding: FragmentSecondBinding? = null
    private val binding get() = _binding!!

    private var layoutManager: RecyclerView.LayoutManager? = null
    private var adapter: CardAdapter?=null

    val text_score: TextView?=null

    //game stats
    private var points = 0
    private var time = 0
    private var foundSets = 0

    var score = 0

    var cardsOnTable: MutableList<Card> = mutableListOf()
    var discardPile: MutableList<Card> = mutableListOf()

    var cardDeck: MutableList<Card> = mutableListOf(
        Card(1, 1, MainActivity.Shape.RECTANGLE, MainActivity.Shading.EMPTY, MainActivity.Color.RED, false, R.drawable.pic_1)
        ,Card(2, 2, MainActivity.Shape.RECTANGLE, MainActivity.Shading.EMPTY, MainActivity.Color.RED, false, R.drawable.pic_2)
        ,Card(3, 3, MainActivity.Shape.RECTANGLE, MainActivity.Shading.EMPTY, MainActivity.Color.RED, false, R.drawable.pic_3)

        ,Card(4, 1, MainActivity.Shape.TRIANGLE, MainActivity.Shading.EMPTY, MainActivity.Color.RED, false, R.drawable.pic_4)
        ,Card(5, 2, MainActivity.Shape.TRIANGLE, MainActivity.Shading.EMPTY, MainActivity.Color.RED, false, R.drawable.pic_5)
        ,Card(6, 3, MainActivity.Shape.TRIANGLE, MainActivity.Shading.EMPTY, MainActivity.Color.RED, false, R.drawable.pic_6)

        ,Card(7, 1, MainActivity.Shape.OVAL, MainActivity.Shading.EMPTY, MainActivity.Color.RED, false, R.drawable.pic_7)
        ,Card(8, 2, MainActivity.Shape.OVAL, MainActivity.Shading.EMPTY, MainActivity.Color.RED, false, R.drawable.pic_8)
        ,Card(9, 3, MainActivity.Shape.OVAL, MainActivity.Shading.EMPTY, MainActivity.Color.RED, false, R.drawable.pic_9)

        ,Card(10, 1, MainActivity.Shape.RECTANGLE, MainActivity.Shading.TRANSPARENT, MainActivity.Color.RED, false, R.drawable.pic_10)
        ,Card(11, 2, MainActivity.Shape.RECTANGLE, MainActivity.Shading.TRANSPARENT, MainActivity.Color.RED, false, R.drawable.pic_11)
        ,Card(12, 3, MainActivity.Shape.RECTANGLE, MainActivity.Shading.TRANSPARENT, MainActivity.Color.RED, false, R.drawable.pic_12)

        ,Card(13, 1, MainActivity.Shape.TRIANGLE, MainActivity.Shading.TRANSPARENT, MainActivity.Color.RED, false, R.drawable.pic_13)
        ,Card(14, 2, MainActivity.Shape.TRIANGLE, MainActivity.Shading.TRANSPARENT, MainActivity.Color.RED, false, R.drawable.pic_14)
        ,Card(15, 3, MainActivity.Shape.TRIANGLE, MainActivity.Shading.TRANSPARENT, MainActivity.Color.RED, false, R.drawable.pic_15)

        ,Card(16, 1, MainActivity.Shape.OVAL, MainActivity.Shading.TRANSPARENT, MainActivity.Color.RED, false, R.drawable.pic_16)
        ,Card(17, 2, MainActivity.Shape.OVAL, MainActivity.Shading.TRANSPARENT, MainActivity.Color.RED, false, R.drawable.pic_17)
        ,Card(18, 3, MainActivity.Shape.OVAL, MainActivity.Shading.TRANSPARENT, MainActivity.Color.RED, false, R.drawable.pic_18)

        ,Card(19, 1, MainActivity.Shape.RECTANGLE, MainActivity.Shading.FULL, MainActivity.Color.RED, false, R.drawable.pic_19)
        ,Card(20, 2, MainActivity.Shape.RECTANGLE, MainActivity.Shading.FULL, MainActivity.Color.RED, false, R.drawable.pic_20)
        ,Card(21, 3, MainActivity.Shape.RECTANGLE, MainActivity.Shading.FULL, MainActivity.Color.RED, false, R.drawable.pic_21)

        ,Card(22, 1, MainActivity.Shape.TRIANGLE, MainActivity.Shading.FULL, MainActivity.Color.RED, false, R.drawable.pic_22)
        ,Card(23, 2, MainActivity.Shape.TRIANGLE, MainActivity.Shading.FULL, MainActivity.Color.RED, false, R.drawable.pic_23)
        ,Card(24, 3, MainActivity.Shape.TRIANGLE, MainActivity.Shading.FULL, MainActivity.Color.RED, false, R.drawable.pic_24)

        ,Card(25, 1, MainActivity.Shape.OVAL, MainActivity.Shading.FULL, MainActivity.Color.RED, false, R.drawable.pic_25)
        ,Card(26, 2, MainActivity.Shape.OVAL, MainActivity.Shading.FULL, MainActivity.Color.RED, false, R.drawable.pic_26)
        ,Card(27, 3, MainActivity.Shape.OVAL, MainActivity.Shading.FULL, MainActivity.Color.RED, false, R.drawable.pic_27)

        ,Card(28, 1, MainActivity.Shape.RECTANGLE, MainActivity.Shading.EMPTY, MainActivity.Color.GREEN, false, R.drawable.pic_28)
        ,Card(29, 2, MainActivity.Shape.RECTANGLE, MainActivity.Shading.EMPTY, MainActivity.Color.GREEN, false, R.drawable.pic_29)
        ,Card(30, 3, MainActivity.Shape.RECTANGLE, MainActivity.Shading.EMPTY, MainActivity.Color.GREEN, false, R.drawable.pic_30)

        ,Card(31, 1, MainActivity.Shape.TRIANGLE, MainActivity.Shading.EMPTY, MainActivity.Color.GREEN, false, R.drawable.pic_31)
        ,Card(32, 2, MainActivity.Shape.TRIANGLE, MainActivity.Shading.EMPTY, MainActivity.Color.GREEN, false, R.drawable.pic_32)
        ,Card(33, 3, MainActivity.Shape.TRIANGLE, MainActivity.Shading.EMPTY, MainActivity.Color.GREEN, false, R.drawable.pic_33)

        ,Card(34, 1, MainActivity.Shape.OVAL, MainActivity.Shading.EMPTY, MainActivity.Color.GREEN, false, R.drawable.pic_34)
        ,Card(35, 2, MainActivity.Shape.OVAL, MainActivity.Shading.EMPTY, MainActivity.Color.GREEN, false, R.drawable.pic_35)
        ,Card(36, 3, MainActivity.Shape.OVAL, MainActivity.Shading.EMPTY, MainActivity.Color.GREEN, false, R.drawable.pic_36)

        ,Card(37, 1, MainActivity.Shape.RECTANGLE, MainActivity.Shading.TRANSPARENT, MainActivity.Color.GREEN, false, R.drawable.pic_37)
        ,Card(38, 2, MainActivity.Shape.RECTANGLE, MainActivity.Shading.TRANSPARENT, MainActivity.Color.GREEN, false, R.drawable.pic_38)
        ,Card(39, 3, MainActivity.Shape.RECTANGLE, MainActivity.Shading.TRANSPARENT, MainActivity.Color.GREEN, false, R.drawable.pic_39)

        ,Card(40, 1, MainActivity.Shape.TRIANGLE, MainActivity.Shading.TRANSPARENT, MainActivity.Color.GREEN, false, R.drawable.pic_40)
        ,Card(41, 2, MainActivity.Shape.TRIANGLE, MainActivity.Shading.TRANSPARENT, MainActivity.Color.GREEN, false, R.drawable.pic_41)
        ,Card(42, 3, MainActivity.Shape.TRIANGLE, MainActivity.Shading.TRANSPARENT, MainActivity.Color.GREEN, false, R.drawable.pic_42)

        ,Card(43, 1, MainActivity.Shape.OVAL, MainActivity.Shading.TRANSPARENT, MainActivity.Color.GREEN, false, R.drawable.pic_43)
        ,Card(44, 2, MainActivity.Shape.OVAL, MainActivity.Shading.TRANSPARENT, MainActivity.Color.GREEN, false, R.drawable.pic_44)
        ,Card(45, 3, MainActivity.Shape.OVAL, MainActivity.Shading.TRANSPARENT, MainActivity.Color.GREEN, false, R.drawable.pic_45)

        ,Card(46, 1, MainActivity.Shape.RECTANGLE, MainActivity.Shading.FULL, MainActivity.Color.GREEN, false, R.drawable.pic_46)
        ,Card(47, 2, MainActivity.Shape.RECTANGLE, MainActivity.Shading.FULL, MainActivity.Color.GREEN, false, R.drawable.pic_47)
        ,Card(48, 3, MainActivity.Shape.RECTANGLE, MainActivity.Shading.FULL, MainActivity.Color.GREEN, false, R.drawable.pic_48)

        ,Card(49, 1, MainActivity.Shape.TRIANGLE, MainActivity.Shading.FULL, MainActivity.Color.GREEN, false, R.drawable.pic_49)
        ,Card(50, 2, MainActivity.Shape.TRIANGLE, MainActivity.Shading.FULL, MainActivity.Color.GREEN, false, R.drawable.pic_50)
        ,Card(51, 3, MainActivity.Shape.TRIANGLE, MainActivity.Shading.FULL, MainActivity.Color.GREEN, false, R.drawable.pic_51)

        ,Card(52, 1, MainActivity.Shape.OVAL, MainActivity.Shading.FULL, MainActivity.Color.GREEN, false, R.drawable.pic_52)
        ,Card(53, 2, MainActivity.Shape.OVAL, MainActivity.Shading.FULL, MainActivity.Color.GREEN, false, R.drawable.pic_53)
        ,Card(54, 3, MainActivity.Shape.OVAL, MainActivity.Shading.FULL, MainActivity.Color.GREEN, false, R.drawable.pic_54)

        ,Card(55, 1, MainActivity.Shape.RECTANGLE, MainActivity.Shading.EMPTY, MainActivity.Color.BlUE, false, R.drawable.pic_55)
        ,Card(56, 2, MainActivity.Shape.RECTANGLE, MainActivity.Shading.EMPTY, MainActivity.Color.BlUE, false, R.drawable.pic_56)
        ,Card(57, 3, MainActivity.Shape.RECTANGLE, MainActivity.Shading.EMPTY, MainActivity.Color.BlUE, false, R.drawable.pic_57)

        ,Card(58, 1, MainActivity.Shape.TRIANGLE, MainActivity.Shading.EMPTY, MainActivity.Color.BlUE, false, R.drawable.pic_58)
        ,Card(59, 2, MainActivity.Shape.TRIANGLE, MainActivity.Shading.EMPTY, MainActivity.Color.BlUE, false, R.drawable.pic_59)
        ,Card(60, 3, MainActivity.Shape.TRIANGLE, MainActivity.Shading.EMPTY, MainActivity.Color.BlUE, false, R.drawable.pic_60)

        ,Card(61, 1, MainActivity.Shape.OVAL, MainActivity.Shading.EMPTY, MainActivity.Color.BlUE, false, R.drawable.pic_61)
        ,Card(62, 2, MainActivity.Shape.OVAL, MainActivity.Shading.EMPTY, MainActivity.Color.BlUE, false, R.drawable.pic_62)
        ,Card(63, 3, MainActivity.Shape.OVAL, MainActivity.Shading.EMPTY, MainActivity.Color.BlUE, false, R.drawable.pic_63)

        ,Card(64, 1, MainActivity.Shape.RECTANGLE, MainActivity.Shading.TRANSPARENT, MainActivity.Color.BlUE, false, R.drawable.pic_64)
        ,Card(65, 2, MainActivity.Shape.RECTANGLE, MainActivity.Shading.TRANSPARENT, MainActivity.Color.BlUE, false, R.drawable.pic_65)
        ,Card(66, 3, MainActivity.Shape.RECTANGLE, MainActivity.Shading.TRANSPARENT, MainActivity.Color.BlUE, false, R.drawable.pic_66)

        ,Card(67, 1, MainActivity.Shape.TRIANGLE, MainActivity.Shading.TRANSPARENT, MainActivity.Color.BlUE, false, R.drawable.pic_67)
        ,Card(68, 2, MainActivity.Shape.TRIANGLE, MainActivity.Shading.TRANSPARENT, MainActivity.Color.BlUE, false, R.drawable.pic_68)
        ,Card(69, 3, MainActivity.Shape.TRIANGLE, MainActivity.Shading.TRANSPARENT, MainActivity.Color.BlUE, false, R.drawable.pic_69)

        ,Card(70, 1, MainActivity.Shape.OVAL, MainActivity.Shading.TRANSPARENT, MainActivity.Color.BlUE, false, R.drawable.pic_70)
        ,Card(71, 2, MainActivity.Shape.OVAL, MainActivity.Shading.TRANSPARENT, MainActivity.Color.BlUE, false, R.drawable.pic_71)
        ,Card(72, 3, MainActivity.Shape.OVAL, MainActivity.Shading.TRANSPARENT, MainActivity.Color.BlUE, false, R.drawable.pic_72)

        ,Card(73, 1, MainActivity.Shape.RECTANGLE, MainActivity.Shading.FULL, MainActivity.Color.BlUE, false, R.drawable.pic_73)
        ,Card(74, 2, MainActivity.Shape.RECTANGLE, MainActivity.Shading.FULL, MainActivity.Color.BlUE, false, R.drawable.pic_74)
        ,Card(75, 3, MainActivity.Shape.RECTANGLE, MainActivity.Shading.FULL, MainActivity.Color.BlUE, false, R.drawable.pic_75)

        ,Card(76, 1, MainActivity.Shape.TRIANGLE, MainActivity.Shading.FULL, MainActivity.Color.BlUE, false, R.drawable.pic_76)
        ,Card(77, 2, MainActivity.Shape.TRIANGLE, MainActivity.Shading.FULL, MainActivity.Color.BlUE, false, R.drawable.pic_77)
        ,Card(78, 3, MainActivity.Shape.TRIANGLE, MainActivity.Shading.FULL, MainActivity.Color.BlUE, false, R.drawable.pic_78)

        ,Card(79, 1, MainActivity.Shape.OVAL, MainActivity.Shading.FULL, MainActivity.Color.BlUE, false, R.drawable.pic_79)
        ,Card(80, 2, MainActivity.Shape.OVAL, MainActivity.Shading.FULL, MainActivity.Color.BlUE, false, R.drawable.pic_80)
        ,Card(81, 3, MainActivity.Shape.OVAL, MainActivity.Shading.FULL, MainActivity.Color.BlUE, false, R.drawable.pic_81)
    )

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        newGame()
        _binding = FragmentSecondBinding.inflate(inflater, container, false)

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {

        super.onViewCreated(view, savedInstanceState)
        adapter = CardAdapter(cardsOnTable, this)
        binding.recyclerView.adapter = adapter
        binding.recyclerView.layoutManager = GridLayoutManager(context, 3)
        binding.recyclerView.setHasFixedSize(true)

        binding.txtScore.text = score.toString()

    }

    override fun onItemClick(position: Int) {
        cardsOnTable[position].selected = true
        checkSET()
        updateUI()
        val settings = context?.getSharedPreferences("prefsfile", Context.MODE_PRIVATE)
        val editor = settings?.edit()
        editor?.putString("SCORE", score.toString())
        editor?.commit()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }


    fun newGame() {
        cardDeck.shuffle()
        cardsOnTable = cardDeck.subList(0,12)
        cardDeck = cardDeck.subList(12,81)
        updateUI()
    }

    fun updateUI() {
        adapter?.updateDataSet()
    }

    fun checkSET() {
        var indexList: MutableList<Int> = mutableListOf()
        for (i in 0..11) {
            if(cardsOnTable[i].selected) indexList.add(i)
        }

        if(indexList.size == 3) {
            if (check3Cards(cardsOnTable[indexList[0]], cardsOnTable[indexList[1]], cardsOnTable[indexList[2]])) {
                placeNewSetOnTable(indexList[0], indexList[1], indexList[2])
                Toast.makeText(context, "Set found", Toast.LENGTH_SHORT).show()
            }
            else {
                cardsOnTable[indexList[0]].selected = false
                cardsOnTable[indexList[1]].selected = false
                cardsOnTable[indexList[2]].selected = false
                Toast.makeText(context, "Set not found", Toast.LENGTH_SHORT).show()
            }
        }
    }

    fun check3Cards(card1: Card, card2: Card, card3: Card): Boolean {
        var match = 0
        if(card1.shape == card2.shape && card1.shape == card3.shape) match++
        if(card1.shape != card2.shape && card1.shape != card3.shape && card2.shape != card3.shape) match++

        if(card1.number == card2.number && card1.number == card3.number) match++
        if(card1.number != card2.number && card1.number != card3.number && card2.number != card3.number) match++

        if(card1.shading == card2.shading && card1.shading == card3.shading) match++
        if(card1.shading != card2.shading && card1.shading != card3.shading && card2.shading != card3.shading) match++

        if(card1.color == card2.color && card1.color == card3.color) match++
        if(card1.color != card2.color && card1.color != card3.color && card2.color != card3.color) match++

        return match == 4
    }

    fun placeNewSetOnTable(index1: Int, index2: Int, index3: Int) {
        cardsOnTable[index1] = cardDeck[0]
        cardsOnTable[index2] = cardDeck[1]
        cardsOnTable[index3] = cardDeck[2]
        cardDeck = cardDeck.subList(3,cardDeck.size)
        adapter?.update(cardsOnTable)
        adapter?.updateDataSet()
        score+=1
    }

}