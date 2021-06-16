package org.d3if4131.magang.barang

import android.os.Bundle
import android.text.TextUtils
import android.view.*
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import org.d3if4131.magang.R
import org.d3if4131.magang.databinding.FragmentBarangBinding
import org.d3if4131.magang.db.BarangDb

class BarangFragment : Fragment() {

    private val viewModel : BarangViewModel by lazy {
        val db = BarangDb.getInstance(requireContext())
        val factory = BarangViewModelFactory(db.dao)
        ViewModelProvider(this, factory).get(BarangViewModel::class.java)
    }
    private lateinit var binding: FragmentBarangBinding

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        super.onCreateOptionsMenu(menu, inflater)
        inflater.inflate(R.menu.menu, menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when(item.itemId) {
            R.id.menu_about -> {
                return true
            }
            R.id.menu_history -> {
                findNavController().navigate(R.id.action_barangFragment_to_historiFragment)
                return true
            }
        }
        return super.onOptionsItemSelected(item)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?): View? {

            binding = FragmentBarangBinding.inflate(layoutInflater, container, false)

            binding.hitungBtn.setOnClickListener { hitungBarang() }

            setHasOptionsMenu(true)
            return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel.getHasilBarang().observe(viewLifecycleOwner, {
            if (it == null) return@observe
            binding.apply {
                //Text View Jumlah
            }
        })
    }

    private fun hitungBarang() {
        binding.apply {
            val bawang = bawangEt.text.toString()
            if (TextUtils.isEmpty(bawang)) {
                Toast.makeText(context, "Bawang Tidak Boleh Kosong", Toast.LENGTH_LONG).show()
                return
            }
            val kobis = kobisEt.text.toString()
            if (TextUtils.isEmpty(kobis)) {
                Toast.makeText(context, "Kobis Tidak Boleh Kosong", Toast.LENGTH_LONG).show()
                return
            }
            viewModel.hitungBarang(bawang, kobis)
        }
    }
}